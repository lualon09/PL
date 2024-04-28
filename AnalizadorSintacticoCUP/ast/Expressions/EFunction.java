package ast.Expressions;

import java.util.ArrayList;

import ast.ASTNode;
import ast.NodeKind;
import ast.Program;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Definitions.*;
import ast.Types.KindT;

import java.util.List;

public class EFunction extends E{

    private String functionName;
    private ArrayList<E> p; //lista de parámetros de la funcion
    private List<Parameter> params;

    public EFunction(String f, ArrayList<E> p){
        this.functionName = f; 
        this.p = p;
    }

    @Override
    public KindE kindExp() {
        return KindE.FUNCTION;
    }

    public String toString(){
        return "call:" + functionName + "(" + p.toString() + ")";
    }
    @Override
    public void bind() throws BindingException {
        ASTNode node = Program.getTableStack().findId(functionName); //search the function
        if(node == null){
            throw new BindingException("Function " + functionName + " not in stack.");
        }
        else{
            this.bindNode = node;
            for(E arg : p){
                arg.bind();
            }
        }
    }

    public void type() throws TypingException {
        params = ((DFunction) bindNode).getParameters();
        if(params.size() != p.size()){
            throw new TypingException("Different number of arguments than expected in " + functionName + " function.");
        }
        for(int i = 0; i< params.size(); i++){
            p.get(i).type();
            if(!p.get(i).getType().equals(params.get(i).getType())){
                throw new TypingException("Type does not match. Expected " + params.get(i).getType().toString() + " and got " + p.get(i).getType().toString() + " in " + functionName + ".");
            }
            if(params.get(i).isRef() && !p.get(i).kindExp().equals(KindE.ACCESS)){// si es por referencia y no es un acceso
                throw new TypingException("Parameter by reference cannot be an expression.");
            }

            if(params.get(i).isRef() && p.get(i).bindNode.nodeKind().equals(NodeKind.DEFINITION) && ((D) p.get(i).bindNode).kindD().equals(KindD.CONST)){
                throw new TypingException("Error. Parameter by reference cannot be a const");
            }
        }
        setType(((DFunction) bindNode).getReturnType());
    }

    public void calculateAddressParam(int delta) {
        Program.getCode().println(" i32.const " + delta); //el delta del parametro
        Program.getCode().println(" local.get $temp"); // cogemos el inicio de los parametros en la funcion a la que vamos a llamar
        Program.getCode().println(" i32.add");
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" global.get $SP"); //cogemos la posicion del puntero a la pila
        Program.getCode().println(" i32.const " + 8); //+4 seria el MP de la funcion, +8 ya apunta al primer parametro
        Program.getCode().println(" i32.add");
        Program.getCode().println(" local.set $temp");//guarda el comienzo de memoria de la funcion. MP de la funcion
        
        for(int i = 0; i < p.size(); i++){
            Parameter auxP = params.get(i); //esto es el parametro
            E auxA = p.get(i); //esto es el argumento
            Program.getCode().println(";; Treating the argument " + auxA.toString());   
            
            if(auxP.getType().kind().equals(KindT.ARRAY) || auxP.getType().kind().equals(KindT.STRUCT)){
                auxA.calculateAddress(); //cogemos donde empieza el array o el struct
                calculateAddressParam(auxP.getDelta());
                Program.getCode().println(" i32.const " + auxP.getSize()/4); //cuantos vamos a copiar
                Program.getCode().println(" call $copyn"); //copiamos de uno a otro
            }
            if(auxP.isRef() || auxP.getType().kind().equals(KindT.POINTER)){ // si es por referencia o es un puntero, se deja la direccion de memoria
                calculateAddressParam(auxP.getDelta());
                auxA.calculateAddress();
                Program.getCode().println(" i32.store");
            }
            else{
                calculateAddressParam(auxP.getDelta());
                auxA.generateCode();
                Program.getCode().println(" i32.store");
            }
        }

        Program.getCode().println(" ;; end copying arguments");
        Program.getCode().println(" call $" + functionName);  
    }

}
