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
        Program.addType(name);
    }

    @Override
    public String toString() {
        return "typedef "+ name.toString() + "=" + t.toString();
    }

    @Override
    public KindD kindD() {
        return KindD.ALIAS;
    }

    public void bind() throws BindingException {
        Program.getTableStack().insertId(name, this);  
        // t.bind();  //hacemos esto para comprobar que el tipo . No lo hacemos, ya se habra comprobado antes
        this.bindNode = t.bindNode;
    }

    public void type() throws TypingException {}

    public T getTypedefType() { return t; }

    public String getName() { return name;}
    
}
