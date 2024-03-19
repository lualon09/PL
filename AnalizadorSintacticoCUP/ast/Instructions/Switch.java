package ast.Instructions;

import java.util.List;

import ast.Expressions.E;

public class Switch extends Block {
    private E cond;
    private List<SwitchInstruction> cases;
    private SwitchInstruction defaultCase;

    public Switch(E exp, List<SwitchInstruction> cases) {
        super();
        this.cases = cases;
        this.cond = exp;
        this.defaultCase = null;
    }
    public Switch(E exp, List<SwitchInstruction> cases, SwitchInstruction defaultCase) {
        super();
        this.cases = cases;
        this.cond = exp;
        this.defaultCase = defaultCase;
    }

    public KindI kind() {
        return KindI.SWITCH;
    }

    public String toString(){
        if(defaultCase == null){
            return "switch(" + cond.toString() + ")" + cases.toString();
        }
        return "switch(" + cond.toString() + ")" + cases.toString() + "default:" + defaultCase.toString();
    }
    
}
