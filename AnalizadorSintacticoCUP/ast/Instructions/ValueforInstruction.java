package ast.Instructions;

import ast.Expressions.*;

public class ValueforInstruction extends I{

    private E value;
    private E exp;
    private boolean breakCond;
    
    public ValueforInstruction(E exp, E value, boolean breakCond){
        this.value = value;
        this.exp = exp;
        this.breakCond = breakCond;
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
                return "default case " + exp.toString() + "=" + value.toString() + "(break)";
            }
            return "case" + exp.toString() + "=" + value.toString() + "(break)";
        }
        return "case" + exp.toString() + "=" + value.toString();
    }
    
}
