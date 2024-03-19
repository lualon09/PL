package ast.Instructions;

import ast.Expressions.*;
import ast.Expressions.Accesses.*;

public class Assignation extends I{

    private A access;
    private E exp;
    public Assignation(A a, E e){ //access para acceder a la variable, E es la expresion de la variable
        this.access = a;
        this.exp = e;
    }

    public KindI kind() {
       return KindI.ASSIGNATION;
    }

    @Override
    public String toString() {
        return "assign:" + access.toString() + "(" + exp.toString() + ")";
    }
}
