package ast.Instructions;

import java.util.List;

import ast.Expressions.E;

public class For extends Block {
    private E cond;
    private Assignation assign;
    private Declaration dec;

    public For(Declaration dec, E exp, Assignation a, List<I> inst) {
        super(inst);
        this.assign = a;
        this.cond = exp;
        this.dec = dec;
    }
    public KindI kind() {
        return KindI.FOR;
    }

    public String toString(){
        return "for(" + dec.toString() + ";" + cond.toString() + ";" + assign.toString() + "){" + this.inst.toString() + "}";
    }
}

