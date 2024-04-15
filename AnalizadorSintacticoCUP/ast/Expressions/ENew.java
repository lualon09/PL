package ast.Expressions;

import ast.Types.*;
import exc.BindingException;

public class ENew extends E{

    private T type;

    public ENew(T t){
        this.type = t; //El puntero es de tipo t
    }

    @Override
    public KindE kindExp() {
        return KindE.NEW;
    }

    public String toString(){
        return "new " + type.toString();
    }

    public void bind() throws BindingException{
        // hay que hacer algo en el binding??
        type.bind();
    }
}
