package ast.Instructions;

import java.util.List;
import exc.BindingException;
import exc.TypingException;
import exc.GCodingException;
import ast.Expressions.E;
import ast.ASTNode;
import ast.Program;
import ast.Types.*;

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

    @Override
    public void bind() throws BindingException {
        Program.getTableStack().openBlock();
        cond.bind();
        super.bind();
        Program.getTableStack().closeBlock();
    }

    public void type() throws TypingException {
        cond.type();
        if(!cond.getType().kind().equals(KindT.BOOL)){
            throw new TypingException("The condition of the while is not a boolean.");
        }
        super.type();
    }

    public int setDelta(int delta) {
        return super.setDelta(delta);
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" block");
        Program.getCode().println(" loop");
        cond.generateCode();
        Program.getCode().println(" i32.eqz");
        Program.getCode().println(" br_if 1");
        super.generateCode();
        Program.getCode().println(" br 0");
        Program.getCode().println(" end"); //loop
        Program.getCode().println(" end"); //block
    }
}
