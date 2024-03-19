package ast.Instructions;

import ast.Expressions.*;

public class ValueforInstruction extends I{

    private E value;
    private E exp;
    private boolean breakCond;
    
    public ValueforInstruction(E value, E exp, boolean breakCond){
        this.value = value;
        this.exp = exp;
        this.breakCond = breakCond;
    }

    @Override
    public KindI kind() {
        return KindI.CASE;
    }

    public String toString(){
        if(breakCond){
            return "case" + exp.toString() + "=" + value.toString() + "(break)";
        }
        return "case" + exp.toString() + "=" + value.toString();
    }
    
}
