package ast.Definitions;

import ast.Expressions.E;
import ast.Types.KindT;
import ast.Types.T;
import exc.BindingException;
import exc.TypingException;
import ast.Program;

public class DConst extends D{

    public T type;
    public String name;
    private E exp;
    public DConst(T t, String name, E exp){ 
        this.type = t;
        this.name = name;
        this.exp = exp;
        setType(type); //por gramatica va a ser siempre entera
    }

    @Override
    public String toString() {
        return "const:" + name.toString() + "(type: " + type.toString() + ")" + "(" + exp.toString() + ")";
    }

    @Override
    public KindD kindD() {
        return KindD.CONST;
    }

    @Override
    public void bind() throws BindingException{
        Program.getTableStack().insertId(name, this);
        exp.bind();
        setDelta();
    }

    @Override
    public void type() throws TypingException {
        exp.type();
        if(!type.equals(exp.getType())){
            throw new TypingException("Type not compatible in " + exp.toString() + " and " + type.toString());
        }
    }

    
}
