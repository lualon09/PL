package ast.Definitions;

import ast.Types.T;
import exc.BindingException;

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

    public void bind(){
        // aqui que hay que hacer
    }
    
}
