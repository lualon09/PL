package ast.Instructions;

import java.util.List;
import ast.Expressions.*;

public class SwitchInstruction extends I{

    private List<I> inst;
    private E exp;
    private boolean breakCond;
    
    public SwitchInstruction(List<I> inst, E exp, boolean breakCond){
        this.inst = inst;
        this.exp = exp;
        this.breakCond = breakCond;
    }

    @Override
    public KindI kind() {
        return KindI.CASE;
    }

    public String toString(){
        if(breakCond){
            return "case" + exp.toString() + ":" + inst.toString() + "(break)";
        }
        return "case" + exp.toString() + ":" + inst.toString();
    }
    
}
