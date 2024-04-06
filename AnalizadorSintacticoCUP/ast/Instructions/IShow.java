package ast.Instructions;

import ast.Expressions.E;
import exc.BindingException;

public class IShow extends I{

    private E exp;

    public IShow(E exp){
        super();
        this.exp = exp;
    }
    @Override
    public KindI kind() {
       return KindI.SHOW;
    }

    public String toString(){
        return "show(" + exp.toString() + ")";
    }

    @Override
    public void bind() throws BindingException{
        exp.bind();
    }
    
}
