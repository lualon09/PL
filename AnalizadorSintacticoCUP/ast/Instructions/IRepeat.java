package ast.Instructions;

import java.util.List;

import ast.Program;
import ast.Expressions.E;
import ast.Expressions.KindE;
import exc.*;
import ast.Types.*;

public class IRepeat extends IBlock {
    private E cond;
    private IFor forAux;

    public IRepeat(E exp, List<I> inst) {
        super(inst);
        this.cond = exp;
        convertFor();

    }

    public void convertFor(){
        IDeclaration dec = new IDeclaration(new TBasics(KindT.INT), "var_aux", exp);
        E cond = new EBin("var_aux", exp, KindE.LESS, new TBasics(KindT.BOOL));
        IAssignation assign = new IAssignation("var_aux", "var_aux + 1");
        forAux = new IFor(dec, cond, assign);
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
        Program.getTableStack().openBlock();
        super.bind();
        Program.getTableStack().closeBlock();
    }
    public void type() throws TypingException {
        cond.type();
        if(!cond.getType().kind().equals(KindT.INT)){
            throw new TypingException("The condition of the repeat is not an Int");
        }
        super.type();
    }
    
    public int setDelta(int delta) {
        return forAux.setDelta(delta);
    }

    public void generateCode() throws GCodingException {
        forAux.generateCode();
    }


}
