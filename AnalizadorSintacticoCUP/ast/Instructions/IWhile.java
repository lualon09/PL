package ast.Instructions;

import java.util.List;

import ast.Expressions.E;

public class IWhile extends IBlock {
    private E cond;

    public IWhile(E exp, List<I> inst) {
        super(inst);
        this.cond = exp;
    }
    public KindI kind() {
        return KindI.WHILE;
    }

    public String toString(){
        return "while(" + cond.toString() + "){" + this.inst.toString() + "}";
    }
}
