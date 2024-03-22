package ast.Definitions;

import ast.Expressions.E;
import ast.Types.T;

public class DConst extends D{

    public T type;
    public String name;
    private E exp;
    public DConst(T t, String name, E exp){ 
        this.type = t;
        this.name = name;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "const:" + name.toString() + "(type: " + type.toString() + ")" + "(" + exp.toString() + ")";
    }

    @Override
    public KindD kindD() {
        return KindD.CONST;
    }

    
}
