package ast.Definitions;

// import java.util.Collections;
import java.util.List;
import ast.Instructions.I;
import ast.Types.T;

public class DFunction extends D {

    private String name;
    private List<I> body;
    private List<Parameter> params;
    private T returnType;

    public DFunction(String name, List<I> body, List<Parameter> params, T returnType){
        this.name = name;
        // Collections.reverse(this.body);
        this.body = body;
        this.params = params;
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("func " + name.toString() + "(");
        if(!params.isEmpty()){
            s.append(params.toString());
        }
        s.append(")->" + returnType.toString() + "{" + body.toString() + "}");
        return s.toString();
    }

    @Override
    public KindD kindD() {
        return KindD.FUNCTION;
    }
    
}
