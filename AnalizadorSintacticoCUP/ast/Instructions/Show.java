package ast.Instructions;

import ast.Expressions.E;

public class Show extends I{

    private E exp;

    public Show(E exp){
        super();
        this.exp = exp;
    }
    @Override
    public KindI kind() {
       return KindI.SHOW;
    }

    public String toString(){
        return "show(" + exp.toString() + ")";
    }
    
}
