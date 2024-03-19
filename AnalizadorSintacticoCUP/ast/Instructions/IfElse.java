package ast.Instructions;

import ast.Expressions.*;

import java.util.List;

public class IfElse extends Block{

    private E cond;
    private List<I> inst_else;

    public IfElse(E exp, List<I> inst_if) {
        super(inst_if);
        this.cond = exp;
        this.inst_else = null;
    }

    public IfElse(E exp, List<I> inst_if, List<I> inst_else) {
        super(inst_if);
        this.cond = exp;
        this.inst_else = inst_else;
    }
    

    public KindI kind() {
        return KindI.IFELSE;
    }

    public String toString(){
        if(inst_else == null){
            return "if(" + cond.toString() + "){" + this.inst.toString() + "}";
        }
        return "if(" + cond.toString() + "){" + this.inst.toString() + "} else {" + inst_else.toString() + "}";
    }
    
}
