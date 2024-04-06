package ast.Instructions;

import ast.Expressions.E;
import exc.BindingException;

public class IReturn extends I{

    private E expReturn;

    public IReturn (E exp){
        this.expReturn = exp;
    }
    public IReturn (){
        this.expReturn = null;
    }

    @Override
    public KindI kind() {
        return KindI.RETURN;
    }
    
    public String toString(){
        if(expReturn == null){
            return "return VOID";
        }
        return "return " + expReturn.toString();
    }

    public void bind() throws BindingException {
        if(expReturn != null){ //Si tiene tipo de retorno
            expReturn.bind();
        }
    }
}
