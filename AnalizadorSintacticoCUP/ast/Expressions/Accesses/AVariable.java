package ast.Expressions.Accesses;

import ast.*;
import exc.BindingException;

public class AVariable extends A {

    private String var;

    public AVariable(String v){
        this.var = v;
    }

    @Override
    public String toString(){
        return "AVar(" + var + ")";
    }
    @Override
    public void bind() throws BindingException {
        ASTNode node = Program.getTableStack().findId(var);
        if(node == null){
            throw new BindingException("Variable " + var + " not in stack.");
        }
        else{
            this.bindNode = node;
        }
    }
}
