package ast.Expressions;

import ast.Types.T;
import exc.BindingException;
import exc.TypingException;

public class EConst extends E{ //Expresion Constante
    private T type;
    private String value;

    public EConst(String value, T t){ //cuando es el tamaño de un array
        this.type = t;
        this.value = value;
    }

    @Override
    public KindE kindExp() {
        return KindE.CONST;
    }

    public String toString(){
        return "(" + type.toString() + ":" + value.toString() + ")";
    }
    @Override
    public void bind() throws BindingException{
    }

    public void type() throws TypingException {
        System.out.println("Soy " + value);
        setType(type);
    }
}
