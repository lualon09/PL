package ast.Types;

import ast.Expressions.EConst;

public class Array extends Type{

    protected EConst size;
    
    public Array(Type t, EConst tam){
        this.type = t;
        this.size = tam;
    }

    @Override
    public KindTypes kind() {
        return KindTypes.ARRAY;
    }

    public String toString(){
        return "List " + "<" + type.toString() + ">";
    }
    
}
