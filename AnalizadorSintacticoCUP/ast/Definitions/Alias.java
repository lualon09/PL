package ast.Definitions;

import ast.Types.Type;

public class Alias extends D {
    
    private Type t;
    private String name;

    public Alias(String name, Type t){
        this.name = name;
        this.t = t;
    }

    @Override
    public String toString() {
        return "alias "+ name.toString() + "=" + t.toString();
    }

    @Override
    public KindD kindD() {
        return KindD.ALIAS;
    }
    
}
