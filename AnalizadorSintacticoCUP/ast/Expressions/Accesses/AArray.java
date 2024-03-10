package ast.Expressions.Accesses;

import ast.Expressions.E;

public class AArray extends A{
    private A access;
    private E exp;

    public AArray(A ac, E e){
        this.access = ac;
        this.exp = e;   
    }

    @Override
    public String toString(){
        return "AArray (" + access + "[" + exp.toString() + "])";
    }
}
