package ast.Instructions;

import java.util.List;

import ast.Expressions.E;
import exc.*;
import ast.Types.*;

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

    @Override
    public void bind() throws BindingException {
        cond.bind();
        super.bind();
    }
    public void type() throws TypingException {
        cond.type();
        if(!cond.getType().kind().equals(KindT.INT)){
            throw new TypingException("The condition of the repeat is not an Int");
        }
        super.type();
        //setType???
    }
    


}
