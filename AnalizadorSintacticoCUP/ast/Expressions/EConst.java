package ast.Expressions;

import ast.Types.T;
import exc.BindingException;
import exc.TypingException;

public class EConst extends E{ //Expresion Constante
    private T type;
    private E exp;
    private String value;

    public EConst(E exp, T t){ //cuando es el tamaño de un array
        this.type = t;
        this.exp = exp;
        this.value = "";
    }

    public EConst(String value, T t){ //cuando es el tamaño de un array
        this.type = t;
        this.value = value;
        this.exp = null;
    }

    @Override
    public KindE kindExp() {
        return KindE.CONST;
    }

    public String toString(){
        if(exp != null) {
            return "(" + type.toString() + ":" + exp.toString() + ")"; //las constantes no tienen tipo porque solo pueden ser enteras
        }
        return "(" + type.toString() + ":" + value.toString() + ")";
    }
    @Override
    public void bind() throws BindingException{
        if(exp != null) exp.bind();
    }

    public void type() throws TypingException {
        if(exp != null) {
            exp.type();
            if(!exp.getType().equals(type)){
                throw new TypingException("Error. Type in size of the list. It has to be an integer.");
            }
        }
        setType(type);
    }
}
