package ast.Instructions;

import java.util.List;

import ast.Program;
import ast.Expressions.*;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

public class SwitchInstruction extends IBlock{

    private E exp;
    private boolean breakCond;
    private String nextLabel;
    
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

    public int setDelta(int delta) {
        return super.setDelta(delta);
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" local.get $temp"); //dejamos $temp en la cima de la pila para no perderlo
        if(exp != null){
            exp.generateCode();
            Program.getCode().println(" local.get $temp");
            Program.getCode().println(" i32.eq"); //comparamos los valores
            Program.getCode().println(" i32.eqz");
            Program.getCode().println(" br_if 0" + nextLabel);
        }
        super.generateCode();
        Program.getCode().println(" br $break"); //siempre tenemos break
    }

    public void setNextLabel(String label){
        nextLabel = label;
    }

    
}
