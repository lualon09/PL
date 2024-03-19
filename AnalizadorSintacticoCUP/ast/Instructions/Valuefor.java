package ast.Instructions;

import java.util.List;

import ast.Expressions.E;

public class Valuefor extends Block {
    private E cond;
    private List<ValueforInstruction> cases;
    private E defaultCase;

    public Valuefor(E exp, List<ValueforInstruction> cases) {
        super();
        this.cases = cases;
        this.cond = exp;
        this.defaultCase = null;
    }
    public Valuefor(E exp, List<ValueforInstruction> cases, E defaultCase) {
        super();
        this.cases = cases;
        this.cond = exp;
        this.defaultCase = defaultCase;
    }

    public KindI kind() {
        return KindI.VALUEFOR;
    }

    public String toString(){
        if(defaultCase == null){
            return "valuefor(" + cond.toString() + ")" + cases.toString();
        }
        return "valuefor(" + cond.toString() + ")" + cases.toString() + "default:" + defaultCase.toString();
    }
}
