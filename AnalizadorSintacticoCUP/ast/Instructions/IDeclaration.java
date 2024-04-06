package ast.Instructions;

import ast.ASTNode;
import ast.Program;
import ast.Expressions.E;
import ast.Types.T;
import exc.BindingException;

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
            return "dec:" + name.toString() + "(type:" + type.toString() + ")";
        }
        return "dec:" + name.toString() + "(type:" + type.toString() + ")=" + exp.toString();
    }

    @Override
    public void bind() throws BindingException {
        ASTNode node = Program.getTableStack().findId(name);
        if(node != null){
            throw new BindingException("Variable " + name + " already in stack");
        }
        else{
            Program.getTableStack().insertId(name, this);
            if(exp != null){ exp.bind(); }
            // this.bindNode = node;
        }
    }
}
