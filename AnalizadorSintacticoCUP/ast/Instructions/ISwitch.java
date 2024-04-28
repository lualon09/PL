package ast.Instructions;

import java.util.List;

import ast.Program;
import ast.Expressions.E;
import exc.*;
import ast.Types.*;

public class ISwitch extends IBlock {
    private E cond;
    private List<SwitchInstruction> cases;
    private SwitchInstruction defaultCase;

    public ISwitch(E exp, List<SwitchInstruction> cases) {
        super();
        this.cases = cases;
        this.cond = exp;
        this.defaultCase = null;
    }
    public ISwitch(E exp, List<SwitchInstruction> cases, SwitchInstruction defaultCase) {
        super();
        this.cases = cases;
        this.cond = exp;
        this.defaultCase = defaultCase;
    }

    public KindI kind() {
        return KindI.SWITCH;
    }

    public String toString(){
        if(defaultCase == null){
            return "switch(" + cond.toString() + ")" + cases.toString();
        }
        return "switch(" + cond.toString() + ")" + cases.toString() + ", " + defaultCase.toString();
    }

    public void bind() throws BindingException{
        cond.bind();
        for(SwitchInstruction s: cases){
            s.bind();
        }
        if(defaultCase != null){
            defaultCase.bind();
        }
    }

    public void type() throws TypingException {
        cond.type();
        if(!cond.getType().kind().equals(KindT.BOOL) && !cond.getType().kind().equals(KindT.INT)){
            throw new TypingException("Switch only gets type Int or type Bool. It is getting " + cond.getType().toString());
        }

        for(SwitchInstruction s: cases){
            s.type();
            if(!s.getType().equals(cond.getType())){
                throw new TypingException("Switch case has not the expected type. Got " + s.getType().toString() + " and got " + cond.getType().toString());
            }
        }
        if(defaultCase != null){
            defaultCase.type();
        }
    }

    public int setDelta(int delta) {
        int auxDelta = delta;
        for(SwitchInstruction s: cases){
            auxDelta = s.setDelta(auxDelta);
        }
        if(defaultCase != null){
            auxDelta = defaultCase.setDelta(auxDelta);
        }
        return delta;
    }

    public void generateCode() throws GCodingException {
        // cond.generateCode();
        // Program.getCode().println(" local.set $temp"); //guardamos la condicion en variable temporal
        // for(int i = 0; i < cases.size(); i++){
        //     Program.getCode().println(" block $label" + i);
        //     if(i < cases.size() - 1){
        //         int next = i +1;
        //         cases.get(i).setNextLabel("$label" + next);
        //     }
        //     else{
        //         cases.get(i).setNextLabel("$default");
        //     }
        //     cases.get(i).generateCode();
        //     Program.getCode().println(" end");
        //     Program.getCode().println(" local.set $temp"); //mantenemos el valor en la pila
        // }
        // if(defaultCase != null){
        //     Program.getCode().println(" block $default"); 
        //     defaultCase.generateCode();
        //     Program.getCode().println(" end");
        //     Program.getCode().println(" local.set $temp"); //??
        // }
        // Program.getCode().println(" block $break"); //etiqueta para el break
        // Program.getCode().println(" end");

        // cond.generateCode();
        // Program.getCode().println(" local.set $temp"); //guardamos la condicion en variable temporal

        // Program.getCode().println(" block");
        // for(int i = 0; i < cases.size(); i++){
        //     Program.getCode().println(" block");
        //     if(i > 0){
        //         int next = cases.size() - i;
        //         cases.get(i).setNextLabel(next);
        //     }
        //     else{
        //         cases.get(i).setNextLabel(0);
        //     }
        // }
        // Program.getCode().println(" block");
        // Program.getCode().pritnln(" local.set $temp");
        // Program.getCode().print(" br_table ");
        // for(int i = 0; i < cases.size(); i++){
        //     Program.getCode().print(i + " ");
        // }
        // Program.getCode().println("");

        // for(int i = 0; i < cases.size(); i++){
        //     cases.get(i).generateCode();
        //     Program.getCode().println(" local.set $temp");
            
        // }

        // if(defaultCase != null){
        //     defaultCase.generateCode();
        // }
        // Program.getCode().println(" end");
        
        cond.generateCode();
        Program.getCode().println(" local.set $temp");
        Program.getCode().println(" block $break"); 
        for(int i = 0; i < cases.size(); i++){
            Program.getCode().println(" block");
        }
        if(defaultCase != null){
            Program.getCode().println(" block");
        }
        for(int i = 0; i < cases.size(); i++){
            cases.get(i).generateCode();
            Program.getCode().println(" local.set $temp");
        }

        if(defaultCase != null){
            defaultCase.generateCode();
            Program.getCode().println(" local.set $temp");
        }
        Program.getCode().println(" end");

    }

    public int maxMemory(){
        int max = 0;
        for(SwitchInstruction s: cases){
            int aux = s.maxMemory();
            if(aux > max){
                max = aux;
            }
        }
        return max;
    }
}
