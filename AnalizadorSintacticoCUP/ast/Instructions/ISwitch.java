package ast.Instructions;

import java.util.List;

import ast.Program;
import ast.Definitions.DTypedef;
import ast.Expressions.E;
import exc.*;
import ast.Types.*;

public class ISwitch extends IBlock {
    private E cond;
    private List<SwitchInstruction> cases;
    private SwitchInstruction defaultCase;
    private int min = Integer.MIN_VALUE;
    private int max = Integer.MAX_VALUE;

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

    // public void generateCode() throws GCodingException {
    //     // cond.generateCode();
    //     // Program.getCode().println(" local.set $temp"); //guardamos la condicion en variable temporal
    //     // for(int i = 0; i < cases.size(); i++){
    //     //     Program.getCode().println(" block $label" + i);
    //     //     if(i < cases.size() - 1){
    //     //         int next = i +1;
    //     //         cases.get(i).setNextLabel("$label" + next);
    //     //     }
    //     //     else{
    //     //         cases.get(i).setNextLabel("$default");
    //     //     }
    //     //     cases.get(i).generateCode();
    //     //     Program.getCode().println(" end");
    //     //     Program.getCode().println(" local.set $temp"); //mantenemos el valor en la pila
    //     // }
    //     // if(defaultCase != null){
    //     //     Program.getCode().println(" block $default"); 
    //     //     defaultCase.generateCode();
    //     //     Program.getCode().println(" end");
    //     //     Program.getCode().println(" local.set $temp"); //??
    //     // }
    //     // Program.getCode().println(" block $break"); //etiqueta para el break
    //     // Program.getCode().println(" end");

    //     // cond.generateCode();
    //     // Program.getCode().println(" local.set $temp"); //guardamos la condicion en variable temporal

    //     // Program.getCode().println(" block");
    //     // for(int i = 0; i < cases.size(); i++){
    //     //     Program.getCode().println(" block");
    //     //     if(i > 0){
    //     //         int next = cases.size() - i;
    //     //         cases.get(i).setNextLabel(next);
    //     //     }
    //     //     else{
    //     //         cases.get(i).setNextLabel(0);
    //     //     }
    //     // }
    //     // Program.getCode().println(" block");
    //     // Program.getCode().pritnln(" local.set $temp");
    //     // Program.getCode().print(" br_table ");
    //     // for(int i = 0; i < cases.size(); i++){
    //     //     Program.getCode().print(i + " ");
    //     // }
    //     // Program.getCode().println("");

    //     // for(int i = 0; i < cases.size(); i++){
    //     //     cases.get(i).generateCode();
    //     //     Program.getCode().println(" local.set $temp");
            
    //     // }

    //     // if(defaultCase != null){
    //     //     defaultCase.generateCode();
    //     // }
    //     // Program.getCode().println(" end");
        
    //     cond.generateCode();
    //     Program.getCode().println(" local.set $temp");
    //     Program.getCode().println(" block $break"); 
    //     for(int i = 0; i < cases.size(); i++){
    //         Program.getCode().println(" block");
    //     }
    //     if(defaultCase != null){
    //         Program.getCode().println(" block");
    //     }
    //     for(int i = 0; i < cases.size(); i++){
    //         cases.get(i).generateCode();
    //         Program.getCode().println(" local.set $temp");
    //     }

    //     if(defaultCase != null){
    //         defaultCase.generateCode();
    //         Program.getCode().println(" local.set $temp");
    //     }
    //     Program.getCode().println(" end");

    // }

    public void calculateMinMax() {
        if (cases.size() > 0) {
            max = cases.get(cases.size()-1).getCaseInt();
            min = cases.get(0).getCaseInt(); //suponemos que están ordenados
        }
    }

    public void generateCode() throws GCodingException{
        // Rango de los casos que no son otherwise
        int range = 0;
        if (cases.size() > 0) {
            calculateMinMax();
            range = max - min + 1;
        }

        Program.getCode().println(" ;;generating code for switch");
        for (int i = 0; i < range + 2; ++i) {
            Program.getCode().println(" block");
        }

        cond.generateCode();
        Program.getCode().println(" i32.const " + min);
        Program.getCode().println(" i32.sub");

        Program.getCode().print(" br_table ");
        for(int i = 0; i <= range; i++){
            Program.getCode().print(i + " ");
        }
        Program.getCode().println("");
        Program.getCode().println(" end");

        int j = 0;
        for(int i = 0; i < range; i++){
            SwitchInstruction s = cases.get(j);
            if(s.getCaseInt() == i + min){
                Program.getCode().println(" ;;generating code for case " + j);
                s.generateCode();
                j++;
            }
            Program.getCode().println(" br " + (range-i));
            Program.getCode().println(" end");
        }

        if(defaultCase != null){
            defaultCase.generateCode();
        }

        Program.getCode().println(" end");

        Program.getCode().println(" ;;end generating code for switch");
    }  

    // public void generateCode() throws GCodingException {

    //     /// Rango de los casos que no son otherwise
    //     int rango = 0;
    //     if (cases.size() > 0) {
    //         rango = cases.size(); //en realidad no es esto
    //     }

    //     /// El primer block es para poder salir del match
    //     /// El ultimo block es para poner br_table y la expresion a evaluar por dentro
    //     for (int i = 0; i < rango + 2; ++i) {
    //         Program.getCode().println(" block");
    //     }

    //     cond.generateCode();
       
    //     Program.getCode().println(" i32.const" + min);
    //     Program.getCode().println(" i32.sub");

    //     Program.getCode().print(" br_table ");
    //     for(int i = 0; i <= rango; i++){
    //         Program.getCode().print(i + " ");
    //     }
    //     Program.getCode().println("");
    //     Program.getCode().println(" end");

    //     out.br_table(rango);
    //     out.comment("Fin bloque n + 2");
    //     out.end();

    //     /// Ahora el caso min -> 0, el caso min + 1 -> 1, etc
    //     int j = 0; /// Indice por el que vamos en la lista de nonOtherwiseCases
    //     for (int i = 0; i < rango; ++i) {
    //         out.comment(String.format("Caso %d de br_table", i));

    //         Case c = nonOtherwiseCases.get(j);
    //         if (c.exprValue == i + min) {
    //             out.comment(String.format("Caso %d de match", c.exprValue));
    //             c.compileAsInstruction(out);
    //             ++j;
    //         }

    //         out.br(rango - i);
    //         out.end();
    //     }

    //     if (otherwiseCase != null) {
    //         out.comment("Caso otherwise");
    //         otherwiseCase.compileAsInstruction(out);
    //     }

    //     out.end();
    // }


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

    public void typedef(List<DTypedef> typedefs){
        for(SwitchInstruction s: cases){
            s.typedef(typedefs);
        }
        if(defaultCase != null){
            defaultCase.typedef(typedefs);
        }
    }
}
