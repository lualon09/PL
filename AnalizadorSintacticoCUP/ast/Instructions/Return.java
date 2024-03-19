package ast.Instructions;

import ast.Expressions.E;

public class Return extends I{

    private E expReturn;

    public Return (E exp){
        this.expReturn = exp;
    }
    public Return (){
        this.expReturn = null;
    }

    @Override
    public KindI kind() {
        return KindI.RETURN;
    }
    
    public String toString(){
        if(expReturn == null){
            return "return void";
        }
        return "return " + expReturn.toString();
    }
}
