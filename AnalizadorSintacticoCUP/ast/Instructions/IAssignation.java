package ast.Instructions;

import ast.Expressions.*;
import ast.Expressions.Accesses.*;
import exc.BindingException;
import exc.TypingException;

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
        if(!access.getType().kind().equals(exp.getType().kind())){
            throw new TypingException("Error. " + access.toString() + "and " + exp.toString() + " have different types.");
        }
        System.out.println("Soy la expresión completa" + access.toString() + "=" + exp.toString());
        setType(exp.getType()); //para comprobar el bucle for
    }
}
