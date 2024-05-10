package ast.Instructions;

import ast.ASTNode;
import ast.Program;
import ast.Definitions.DTypedef;
import ast.Expressions.E;
import ast.Types.T;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Types.TBasics;
import ast.Types.KindT;
import ast.Expressions.KindE;
import java.util.ArrayList;
import java.util.List;

import ast.Expressions.EArray;
import ast.Expressions.Accesses.KindA;
import ast.Expressions.Accesses.A;

public class IDeclaration extends I{
    public T type;
    public String name;
    private E exp;
    protected int delta;
    private boolean isGlobal;

    public IDeclaration(T t, String name){ 
        this.name = name;
        this.type = t;
        this.exp = null;
    }

    public IDeclaration(T t, String name, E exp){ 
        this.type = t;
        this.name = name;
        this.exp = exp;
    }

    public KindI kind() {
       return KindI.DECLARATION;
    }

    @Override
    public String toString() {
        if (exp == null){
            return "dec:" + name.toString() + "(type:" + type.toString() + ")";
        }
        return "dec:" + name.toString() + "(type:" + type.toString() + ")=" + exp.toString();
    }

    @Override
    public void bind() throws BindingException {

        type.bind(); //por si acaso es un struct
        Program.getTableStack().insertId(name, this);
        if(exp != null){ exp.bind(); }

        // nos falta asignar a este nodo, como binding node el de la declaracion del struct
        this.bindNode = type.bindNode;
    }

    public T getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public void type() throws TypingException {
        type.type();
        setType(type); //las declaraciones tienen por defecto el tipo de lo que se está asignando.
        if(exp != null) {
            exp.type();//tipamos la expresion en caso de que exista
            // en el caso de que sea con expresión va a fallar porque 2+3 != 5 (sin evaluar)
            if(exp.kindExp().equals(KindE.READ) && !type.equals(new TBasics(KindT.INT)) && !type.equals(new TBasics(KindT.BOOL))){
                throw new TypingException("Error. Cannot read something different than Int or Bool. Got " + type.toString() + ".");
            }
            if(!exp.kindExp().equals(KindE.READ)){
                if(!exp.getType().toString().equals(type.toString())){ //lo comprobamos con el toString por si acaso es de tipo array
                    throw new TypingException(exp.toString() + " and " + name + " do not have the same type.");
                }
            }
        }
    }

    public int getSize(){
        return type.getSize();
    }

    public int setDelta(int delta){
        this.delta = delta;
        return delta + getType().getSize();
    }

    public int getDelta(){
        return delta;
    }

    public void setGlobal(){
        isGlobal = true;
    }

    public boolean getGlobal(){
        return isGlobal;
    }

    public void calculateAddress() {
        Program.getCode().println(" i32.const " + delta); //si es global su direccion es el delta
        if(!isGlobal){ //si no es global, su direccion es localsStart + delta
            Program.getCode().println(" local.get $localsStart"); //esto es el MP + cosas
            Program.getCode().println(" i32.add"); // lo sumamos para sacar la direccion de la variable
        }
    }

    public void generateCodeArray(E expr, int pos) throws GCodingException{
        if(expr.kindExp().equals(KindE.ARRAY)){
            ArrayList<E> expArray = ((EArray) expr).getExpArray();
            for(int i = 0; i< expArray.size(); i++){
                generateCodeArray(expArray.get(i), pos + i*expArray.get(i).getType().getSize());
            }
        }
        else{
            calculateAddress();
            Program.getCode().println(" i32.const " + pos);
            Program.getCode().println(" i32.add");
            expr.generateCode();
            Program.getCode().println(" i32.store");
        }
    }
    public void generateCode() throws GCodingException {
        Program.getCode().println(" ;;generating code for declaration " + toString());
        if(exp != null){
            if(exp.kindExp().equals(KindE.ARRAY)){
                ArrayList<E> expArray = ((EArray) exp).getExpArray();
                for(int i = 0; i< expArray.size(); i++){
                    generateCodeArray(expArray.get(i), i*expArray.get(i).getType().getSize());
                }
            }
            else if(exp.kindExp().equals(KindE.ACCESS) && !((A) exp).kindA().equals(KindA.ADDRESS)){
                exp.calculateAddress(); //es un acceso
                this.calculateAddress();
                Program.getCode().println(" i32.const " + exp.getType().getSize()/4);
                Program.getCode().println(" call $copyn"); //copiamos de una direccion a otra de tamaño exp.getType().getSize()/4
            }
            else if(exp.kindExp().equals(KindE.FUNCTION) && (this.getType().kind().equals(KindT.ARRAY) || this.getType().kind().equals(KindT.STRUCT))){
                exp.generateCode(); //que 
                this.calculateAddress(); //donde 
                Program.getCode().println(" i32.const " + exp.getType().getSize()/4);
                Program.getCode().println(" call $copyn"); //copiamos de una direccion a otra de tamaño exp.getType().getSize()/4
            }
            else if(exp.kindExp().equals(KindE.READ) && this.getType().kind().equals(KindT.BOOL)){ //si es booleano y se está leyendo 
                
                exp.generateCode();
                //0 es false y 1 es true. Si es cualquier otro valor, lo transformamos a false.
                Program.getCode().println(" i32.const 1");
                Program.getCode().println(" i32.ne");
                Program.getCode().println(" if");
                this.calculateAddress();
                Program.getCode().println(" i32.const 0");
                Program.getCode().println(" i32.store");
                Program.getCode().println(" else");
                this.calculateAddress();
                Program.getCode().println(" i32.const 1"); //dejamos el uno en la pila
                Program.getCode().println(" i32.store");
                Program.getCode().println(" end");
            }   
            else{
                this.calculateAddress();
                exp.generateCode();
                Program.getCode().println(" i32.store");
            }
        }
        Program.getCode().println(" ;;end generating code for declaration");
    }

    public void typedef(List<DTypedef> typedefs){
        DTypedef found = findTypedef(typedefs, type);
        if(found != null) { //la constante es de tipo typedef
            type = found.getType();
        }
    }
}
