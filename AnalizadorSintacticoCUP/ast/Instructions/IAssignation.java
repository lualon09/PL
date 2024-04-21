package ast.Instructions;

import ast.NodeKind;
import ast.Definitions.KindD;
import ast.Expressions.*;
import ast.Expressions.Accesses.*;
import ast.Types.KindT;
import exc.BindingException;
import exc.TypingException;
import ast.Types.TBasics;
import ast.Definitions.D;

public class IAssignation extends I{

    private A access;
    private E exp;
    public IAssignation(A a, E e){ //access para acceder a la variable, E es la expresion de la variable
        this.access = a;
        this.exp = e;
    }

    public KindI kind() {
       return KindI.ASSIGNATION;
    }

    @Override
    public String toString() {
        return "assign:" + access.toString() + "=" + exp.toString();
    }
    @Override
    public void bind() throws BindingException {
        access.bind();
        exp.bind();
    }

    public void type() throws TypingException {
        access.type();
        exp.type();
        if(access.bindNode.nodeKind().equals(NodeKind.DEFINITION) && ((D) access.bindNode).kindD().equals(KindD.CONST)){
            throw new TypingException("Error. Constant can't be modified.");
        }
        if(exp.kindExp().equals(KindE.READ) && !access.getType().equals(new TBasics(KindT.BOOL)) && !access.getType().equals(new TBasics(KindT.INT))){
            throw new TypingException("Error. Cannot read something different than Int or Bool. Got " + access.toString() + ".");
        }
        if(!exp.kindExp().equals(KindE.READ)){
            if(!access.getType().kind().equals(exp.getType().kind())){ //en el caso de que sea el read 
                throw new TypingException("Error. " + access.toString() + " and " + exp.toString() + " have different types.");
            }
            if(exp.getType().kind().equals(KindT.STRUCT)){
                throw new TypingException("Error. An struct cannot be equal to another one. Must go field by field.");
            }
            setType(exp.getType()); //para comprobar el bucle for
        }
    }
}
