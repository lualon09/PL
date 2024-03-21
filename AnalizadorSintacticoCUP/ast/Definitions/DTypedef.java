package ast.Definitions;

import ast.Types.T;

public class DTypedef extends D {
    
    private T t;
    private String name;

    public DTypedef(String name, T t){
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
