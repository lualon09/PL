package ast.Expressions;

import ast.Types.Type;;

public class EConst extends E{
    private String name; //nombre de la constante

    public EConst(String c, Type t){
        this.name = c;  
        this.type = t;
    }

    @Override
    public KindE kindExp() {
        return KindE.CONST;
    }

    public String toString(){
        return name;
    }
}
