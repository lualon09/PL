package ast.Definitions;

import ast.Types.Type;

public class DTypedef extends D {
    
    private Type t;
    private String name;

    public DTypedef(String name, Type t){
        this.name = name;
        this.t = t;
    }

    @Override
    public String toString() {
        return "typedef "+ name.toString() + "=" + t.toString();
    }

    @Override
    public KindD kindD() {
        return KindD.ALIAS;
    }
    
}
