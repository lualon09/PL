package ast.Instructions;

import ast.Program;
import ast.Expressions.*;

import java.util.List;
import exc.BindingException;

public class IIfElse extends IBlock{

    private E cond;
    private List<I> inst_else;

    public IIfElse(E exp, List<I> inst_if) {
        super(inst_if);
        this.cond = exp;
        this.inst_else = null;
    }

    public IIfElse(E exp, List<I> inst_if, List<I> inst_else) {
        super(inst_if);
        this.cond = exp;
        this.inst_else = inst_else;
    }
    

    public KindI kind() {
        return KindI.IFELSE;
    }

    public String toString(){
        if(inst_else == null){
            return "if(" + cond.toString() + "){" + this.inst.toString() + "}";
        }
        return "if(" + cond.toString() + "){" + this.inst.toString() + "} else {" + inst_else.toString() + "}";
    }

    @Override
    public void bind() throws BindingException {
        Program.getTableStack().openBlock();
        cond.bind();
        super.bind();
        if(inst_else != null){
            for (I i : inst_else) {
                i.bind();
            }
        }
        Program.getTableStack().closeBlock();
    }
    
}
