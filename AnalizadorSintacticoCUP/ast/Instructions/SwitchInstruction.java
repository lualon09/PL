package ast.Instructions;

import java.util.List;

import ast.Program;
import ast.Expressions.*;
import exc.BindingException;
import exc.TypingException;

public class SwitchInstruction extends IBlock{

    private E exp;
    private boolean breakCond;
    
    public SwitchInstruction(List<I> inst, E exp, boolean breakCond){
       super(inst);
        this.exp = exp;
        this.breakCond = breakCond;
    }

    public SwitchInstruction(List<I> inst){ //CASO DEFAULT
        super(inst);
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
        super.bind();
        Program.getTableStack().closeBlock();
    }

    public void type() throws TypingException{
        if(exp != null){
            exp.type();
            setType(exp.getType());
        }
    }

    
}
