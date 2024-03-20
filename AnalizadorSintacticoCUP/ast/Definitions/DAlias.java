package ast.Definitions;

import ast.Types.Type;

public class DAlias extends D {
    
    private Type t;
    private String name;

    public DAlias(String name, Type t){
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
