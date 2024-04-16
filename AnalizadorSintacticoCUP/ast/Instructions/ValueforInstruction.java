package ast.Instructions;

import ast.Expressions.*;
import exc.BindingException;
import exc.TypingException;
import ast.Types.*;

public class ValueforInstruction extends I{

    private E value;
    private E exp;
    private boolean breakCond;
    
    public ValueforInstruction(E exp, E value, boolean breakCond){
        this.value = value;
        this.exp = exp;
        this.breakCond = true;
    }

    public ValueforInstruction(E value){
        this.value = value;
        this.exp = null;
        this.breakCond = true; 
    }


    @Override
    public KindI kind() {
        return KindI.CASE;
    }

    public String toString(){
        if(breakCond){
            if(exp == null){
                return "default" + "=" + value.toString() + "(break)";
            }
            return "case " + exp.toString() + "=" + value.toString() + "(break)";
        }
        return "case " + exp.toString() + "=" + value.toString();
    }

    public void bind() throws BindingException{
        value.bind();
        if(exp != null){
            exp.bind();
        }
    }

    public void type() throws TypingException {
        value.type();
        if(exp != null){
            exp.type();
        }
        setType(value.getType());
    }
    
}
