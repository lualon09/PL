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
        // comprobamos que los casos del switch van en orden creciente
        int aux;
        if(cases.size() > 0){
            aux = cases.get(0).getCaseInt();
            for(int i = 1; i < cases.size(); i++){
                if(cases.get(i).getCaseInt() <= aux){
                    throw new TypingException("Error. Switch cases must be in ascendant order.");
                }
                aux = cases.get(i).getCaseInt();
            }
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
                Program.getCode().println(" br " + (range-i));
                Program.getCode().println(" end");
            }
            else{
                Program.getCode().println(" br " + (range - i - 1));
                Program.getCode().println(" end");
            }
           
        }

        if(defaultCase != null){
            defaultCase.generateCode();
        }

        Program.getCode().println(" end");

        Program.getCode().println(" ;;end generating code for switch");
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

    public void typedef(List<DTypedef> typedefs){
        for(SwitchInstruction s: cases){
            s.typedef(typedefs);
        }
        if(defaultCase != null){
            defaultCase.typedef(typedefs);
        }
    }
}
