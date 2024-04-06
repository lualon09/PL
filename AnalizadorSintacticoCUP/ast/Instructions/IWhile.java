package ast.Instructions;

import java.util.List;
import exc.BindingException;

import ast.Expressions.E;
import ast.ASTNode;
import ast.Program;

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
}
