package ast.Instructions;

import java.util.List;

import ast.Expressions.E;
import exc.*;
import ast.Types.*;

public class ISwitch extends IBlock {
    private E cond;
    private List<SwitchInstruction> cases;
    private SwitchInstruction defaultCase;

    public ISwitch(E exp, List<SwitchInstruction> cases) {
        super();
        this.cases = cases;
        this.cond = exp;
        this.defaultCase = null;
    }
    public ISwitch(E exp, List<SwitchInstruction> cases, SwitchInstruction defaultCase) {
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
        return "switch(" + cond.toString() + ")" + cases.toString() + ", " + defaultCase.toString();
    }

    public void bind() throws BindingException{
        cond.bind();
        for(SwitchInstruction s: cases){
            s.bind();
        }
        if(defaultCase != null){
            defaultCase.bind();
        }
    }

    public void type() throws TypingException {
        cond.type();
        if(!cond.getType().kind().equals(KindT.BOOL) && !cond.getType().kind().equals(KindT.INT)){
            throw new TypingException("Switch only gets type Int or type Bool. It is getting " + cond.getType().toString());
        }

        for(SwitchInstruction s: cases){
            s.type();
            if(!s.getType().equals(cond.getType())){
                throw new TypingException("Switch case has not the expected type. Got " + s.getType().toString() + " and got " + cond.getType().toString());
            }
        }
        if(defaultCase != null){
            defaultCase.type();
        }
    }
    
}
