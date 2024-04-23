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
        cond.bind();
        Program.getTableStack().openBlock();
        super.bind();
        Program.getTableStack().closeBlock();

        Program.getTableStack().openBlock();
        if(inst_else != null){
            for (I i : inst_else) {
                i.bind();
            }
        }
        Program.getTableStack().closeBlock();
    }

    public void type() throws TypingException {
        cond.type();
        if(!cond.getType().kind().equals(KindT.BOOL)){
            throw new TypingException("The condition of the if is not a boolean");
        }
        super.type();
        if(inst_else != null){
            for (I i : inst_else) {
                i.type();
            }
        }
    }

    public int setDelta(int delta){
        int aux = super.setDelta(delta);
        if(inst_else != null){
            for (I i : inst_else) {
                aux = i.setDelta(aux); //EL ELSE TIENE QUE EMPEZAR EN DELTA O EN LO DE DESPUES DEL IF?
            }
        }
        return delta;
    }

    public void generateCode() throws GCodingException {
        cond.generateCode();
        Program.getCode().println("if");
        super.generateCode();
        if(inst_else != null){
            Program.getCode().println("else");
            for (I i : inst_else) {
                i.generateCode();
            }
        }
        Program.getCode().println("end");
    }
    
}
