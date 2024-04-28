package ast.Instructions;

import ast.Program;
import ast.Expressions.*;
import ast.Types.KindT;

import java.util.List;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

public class IIfElse extends IBlock{

    private E cond;
    private List<I> inst_else;
    private IBlock else_block;

    public IIfElse(E exp, List<I> inst_if) {
        super(inst_if);
        this.cond = exp;
        this.inst_else = null;
    }

    public IIfElse(E exp, List<I> inst_if, List<I> inst_else) {
        super(inst_if);
        this.cond = exp;
        this.inst_else = inst_else;
        this.else_block = new IBlock(inst_else);
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
        cond.bind();
        Program.getTableStack().openBlock();
        super.bind();
        Program.getTableStack().closeBlock();

        if(inst_else != null){
            Program.getTableStack().openBlock();
            else_block.bind();
            Program.getTableStack().closeBlock();
        }
    }

    public void type() throws TypingException {
        cond.type();
        if(!cond.getType().kind().equals(KindT.BOOL)){
            throw new TypingException("The condition of the if is not a boolean");
        }
        super.type();
        if(inst_else != null){
            else_block.type();
        }
    }

    public int setDelta(int delta){
        int aux = super.setDelta(delta);
       
        if(inst_else != null){
            else_block.setDelta(aux);
        }
        return delta;
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" ;;generating code for ifElse");
        cond.generateCode();
        Program.getCode().println(" if");
        super.generateCode();
        if(inst_else != null){
            Program.getCode().println(" else");
            else_block.generateCode();
        }
        Program.getCode().println(" end");
    }

    public int maxMemory(){
        int maxIf = super.maxMemory();
        if(inst_else != null){
            int maxElse = else_block.maxMemory();
            if(maxElse > maxIf){
                maxIf = maxElse;
            }
        }
        return maxIf;
    }
    
}
