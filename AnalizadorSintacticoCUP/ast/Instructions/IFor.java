package ast.Instructions;

import java.util.List;

import ast.Expressions.E;

public class IFor extends IBlock {
    private E cond;
    private IAssignation assign;
    private IDeclaration dec;

    public IFor(IDeclaration dec, E exp, IAssignation a, List<I> inst) {
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

