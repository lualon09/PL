package ast.Instructions;

import ast.ASTNode;
import ast.Program;
import ast.Expressions.E;
import ast.Types.T;
import exc.BindingException;
import exc.TypingException;

public class IDeclaration extends I{
    public T type;
    public String name;
    private E exp;

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
        Program.getTableStack().insertId(name, this);
        if(exp != null){ exp.bind(); }
        type.bind(); //por si acaso es un struct
        //this.bindNode = node;
    }

    public T getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public void type() throws TypingException {
        if(exp != null) {
            exp.type();//tipamos la expresion en caso de que exista
            if(!exp.getType().equals(type)){
                throw new TypingException(exp.toString() + " and " + name + " do not have the same type.");
            }
        } 
        setType(type); //las declaraciones tienen por defecto el tipo de lo que se está asignando.
    }
}
