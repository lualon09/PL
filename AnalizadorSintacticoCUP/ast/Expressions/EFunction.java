package ast.Expressions;

import java.util.ArrayList;

public class EFunction extends E{

    private String functionName;
    public ArrayList<E> p; //lista de parámetros de la funcion

    public EFunction(String f, ArrayList<E> p){
        this.functionName = f; 
        this.p = p;
    }

    @Override
    public KindE kindExp() {
        return KindE.FUNCTION;
    }

    public String toString(){
        return "call to " + functionName + "(" + p.toString() + ")";
    }
}
