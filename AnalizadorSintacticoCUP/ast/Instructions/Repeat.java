package ast.Instructions;

import java.util.List;

import ast.Expressions.E;

public class Repeat extends Block {
    private E cond;

    public Repeat(E exp, List<I> inst) {
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
