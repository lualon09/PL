package ast.Instructions;

import ast.Expressions.EFunction;

public class IFunction extends I{

    private EFunction exp;

    public IFunction(EFunction e){
        this.exp = e;
    }

    @Override
    public KindI kind() {
        return KindI.FUNCTION;
    }

    public String toString(){
        return "call to " + exp.toString();
    }
}
