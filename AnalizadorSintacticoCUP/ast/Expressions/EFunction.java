package ast.Expressions;

import java.util.ArrayList;

import ast.ASTNode;
import ast.Program;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Definitions.*;
import java.util.List;

public class EFunction extends E{

    private String functionName;
    private ArrayList<E> p; //lista de parámetros de la funcion
    private ArrayList<Parameter> params;

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
        }
        setType(((DFunction) bindNode).getReturnType());
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println("global.get $SP"); //cogemos la posicion del puntero a la pila
        Program.getCode().println("i32.const " + 8); //???
        Program.getCode().println("i32.add");
        Program.getCode().println("local.set $temp");//guarda el comienzo de memoria de la funcion
        
        int delta = 0;
        for(int i = 0; i < p.size(); i++){
            Parameter auxP = params.get(i); //esto es el parametro
            E auxA = p.get(i); //esto es el argumento
            Program.getCode().println(";; Treating the argument " + auxA.toString());   
            //no me cuadra
        }

    }

}
