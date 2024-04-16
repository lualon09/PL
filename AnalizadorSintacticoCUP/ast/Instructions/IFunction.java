package ast.Instructions;

import ast.Expressions.EFunction;
import ast.ASTNode;
import exc.*;


public class IFunction extends I{

    private EFunction exp;

    public IFunction(EFunction e){
        this.exp = e;
    }

    @Override
    public KindI kind() {
        return KindI.FUNCTION;
    }

    public String toString(){
        return "Instruction " + exp.toString();
    }

    @Override
    public void bind() throws BindingException {
        exp.bind();
    }

    public void type() throws TypingException {
        exp.type(); 
        setType(exp.getType()); //le asignamos el tipo que devuelve
    }
}
