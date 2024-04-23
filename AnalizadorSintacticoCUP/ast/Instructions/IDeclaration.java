package ast.Instructions;

import ast.ASTNode;
import ast.Program;
import ast.Expressions.E;
import ast.Types.T;
import exc.BindingException;
import exc.TypingException;
import ast.Types.TBasics;
import ast.Types.KindT;
import ast.Expressions.KindE;

public class IDeclaration extends I{
    public T type;
    public String name;
    private E exp;
    private int delta;

    public IDeclaration(T t, String name){ 
        this.name = name;
        this.type = t;
        this.exp = null;
        setType(t);
    }

    public IDeclaration(T t, String name, E exp){ 
        this.type = t;
        this.name = name;
        this.exp = exp;
        setType(t);
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
        //this.bindNode = node;
    }

    public T getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public void type() throws TypingException {
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
            if(type.kind().equals(KindT.STRUCT)){
                throw new TypingException("Error. Struct cannot be initialized. Must be field by field.");
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
}
