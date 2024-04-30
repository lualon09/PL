package ast.Definitions;

import ast.Program;
import ast.Types.T;
import exc.BindingException;
import exc.TypingException;

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

    public void type() throws TypingException {}

    public T getTypedefType() { return t; }

    public String getName() { return name;}
    
}
