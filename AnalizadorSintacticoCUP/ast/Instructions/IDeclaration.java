package ast.Instructions;

import ast.Expressions.E;
import ast.types.T;

public class IDeclaration extends I{
    public T type;
    public String name;
    private E exp;

    public IDeclaration(T t, String name){ 
        this.name = name;
        this.type = t;
        this.exp = null;
    }

    public IDeclaration(T t, String name, E exp){ 
        this.type = t;
        this.name = name;
        this.exp = exp;
    }

    public KindI kind() {
       return KindI.DECLARATION;
    }

    @Override
    public String toString() {
        if (exp == null){
            return "declaration:" + name.toString() + "(type: " + type.toString() + ")";
        }
        return "declaration:" + name.toString() + "(type: " + type.toString() + ")" + "(" + exp.toString() + ")";
    }
}
