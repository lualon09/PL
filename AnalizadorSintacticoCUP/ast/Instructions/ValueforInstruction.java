package ast.Instructions;

import ast.Expressions.*;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Types.*;
import ast.Program;

public class ValueforInstruction extends I{

    private E value;
    private E exp;
    private boolean breakCond;
    private String nextLabel;
    
    public ValueforInstruction(E exp, E value, boolean breakCond){
        this.value = value;
        this.exp = exp;
        this.breakCond = true;
    }

    public ValueforInstruction(E value){
        this.value = value;
        this.exp = null;
        this.breakCond = true; 
    }


    @Override
    public KindI kind() {
        return KindI.CASE;
    }

    public String toString(){
        if(breakCond){
            if(exp == null){
                return "default" + "=" + value.toString() + "(break)";
            }
            return "case " + exp.toString() + "=" + value.toString() + "(break)";
        }
        return "case " + exp.toString() + "=" + value.toString();
    }

    public void bind() throws BindingException{
        value.bind();
        if(exp != null){
            exp.bind();
        }
    }

    public void type() throws TypingException {
        value.type();
        if(exp != null){
            exp.type();
        }
        setType(value.getType());
    }

    public void generateCode() throws GCodingException {

        Program.getCode().println(" end");
        if(exp != null){
            exp.generateCode(); //esto te pone un booleano
        }
        Program.getCode().println(" i32.eqz"); //veemos si la expresion es cierta o falsa
        Program.getCode().println(" br_if 0 "); //si es falso, salta a lo siguiente
        
        value.generateCode();

    }
    
    public void setNextLabel(String label){
        nextLabel = label;
    }

}
