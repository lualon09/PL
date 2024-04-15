package ast.Instructions;

import java.util.List;

import ast.Program;
import ast.Expressions.*;
import exc.BindingException;

public class SwitchInstruction extends I{

    private List<I> inst;
    private E exp;
    private boolean breakCond;
    
    public SwitchInstruction(List<I> inst, E exp, boolean breakCond){
        this.inst = inst;
        this.exp = exp;
        this.breakCond = breakCond;
    }

    public SwitchInstruction(List<I> inst){ //CASO DEFAULT
        this.inst = inst;
        this.exp = null;
        this.breakCond = true; //interpretamos que como es default, ya no va a seguir haica abajo
    }

    @Override
    public KindI kind() {
        return KindI.CASE;
    }

    public String toString(){
        if(breakCond){
            if(exp == null){
                return "default:" + inst.toString();
            }
            return "case" + exp.toString() + ":" + inst.toString() + "(break)";
        }
        return "case" + exp.toString() + ":" + inst.toString();
    }

    public void bind() throws BindingException{
        if(exp != null){
            exp.bind();
        }
        Program.getTableStack().openBlock();
        for(I i: inst){
            i.bind();
        }
        Program.getTableStack().closeBlock();
    }
    
}
