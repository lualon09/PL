package ast.Instructions;

import java.util.List;

import ast.Expressions.E;

public class IRepeat extends IBlock {
    private E cond;

    public IRepeat(E exp, List<I> inst) {
        super(inst);
        this.cond = exp;
    }
    public KindI kind() {
        return KindI.REPEAT;
    }

    public String toString(){
        return "repeat(" + cond.toString() + "){" + this.inst.toString() + "}";
    }
}
