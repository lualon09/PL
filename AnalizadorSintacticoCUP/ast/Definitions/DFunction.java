package ast.Definitions;

import java.util.List;
import ast.Instructions.I;
import ast.types.T;

public class DFunction extends D {

    private String name;
    private List<I> body;
    private List<Parameter> params;
    private T returnType;

    public DFunction(String name, List<I> body, List<Parameter> params, T returnType){
        this.name = name;
        this.body = body;
        this.params = params;
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return "func" + name.toString() + "("+ params.toString() + ")->" + returnType.toString() + "{" + body.toString() + "}";
    }

    @Override
    public KindD kindD() {
        return KindD.FUNCTION;
    }
    
}
