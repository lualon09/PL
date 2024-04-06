package ast.Instructions;

import java.util.List;
import ast.Expressions.Accesses.A;
import exc.BindingException;

public class IValuefor extends IBlock {
    private A var;
    private List<ValueforInstruction> cases;
    private ValueforInstruction defaultCase;

    public IValuefor(A exp, List<ValueforInstruction> cases) {
        super();
        this.cases = cases;
        this.var = exp;
        this.defaultCase = null;
    }
    public IValuefor(A exp, List<ValueforInstruction> cases, ValueforInstruction defaultCase) {
        super();
        this.cases = cases;
        this.var = exp;
        this.defaultCase = defaultCase;
    }

    public KindI kind() {
        return KindI.VALUEFOR;
    }

    public String toString(){
        if(defaultCase == null){
            return "valuefor(" + var.toString() + ")" + cases.toString();
        }
        return "valuefor(" + var.toString() + ")" + cases.toString() + ", " + defaultCase.toString();
    }

    public void bind() throws BindingException{
        var.bind();
        for(ValueforInstruction s: cases){
            s.bind();
        }
        if(defaultCase != null){
            defaultCase.bind();
        }
    }
}
