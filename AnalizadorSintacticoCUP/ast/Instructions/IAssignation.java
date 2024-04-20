package ast.Instructions;

import ast.Expressions.*;
import ast.Expressions.Accesses.*;
import ast.Types.KindT;
import exc.BindingException;
import exc.TypingException;
import ast.Types.TBasics;

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
        System.out.println("soy el acceso " + access.toString());
        System.out.println("tipo : " + access.getType().toString());
        if(exp.kindExp().equals(KindE.READ) && !access.getType().equals(new TBasics(KindT.BOOL)) && !access.getType().equals(new TBasics(KindT.INT))){
            throw new TypingException("Error. Cannot read something different than Int or Bool. Got " + access.toString() + ".");
        }
        if(!exp.kindExp().equals(KindE.READ)){
            if(!access.getType().kind().equals(exp.getType().kind())){ //en el caso de que sea el read 
                throw new TypingException("Error. " + access.toString() + " and " + exp.toString() + " have different types.");
            }
            System.out.println("Soy la expresión completa" + access.toString() + "=" + exp.toString());
            setType(exp.getType()); //para comprobar el bucle for
        }
    }
}
