package ast.Instructions;

import java.util.ArrayList;

import ast.Expressions.E;

public class IFunction extends I{

  private String name;
    public ArrayList<E> p; //lista de parámetros de la funcion

    public IFunction(String f, ArrayList<E> p){
        this.name = f; 
        this.p = p;
    }

    @Override
    public KindI kind() {
        return KindI.FUNCTION;
    }

    public String toString(){
        return "call to " + name + "(" + p.toString() + ")";
    }
}
