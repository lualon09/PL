package ast.Types;

import ast.Expressions.EConst;

public class TArray extends T{

    protected EConst size;
    
    public TArray(T t, EConst tam){
        this.type = t;
        this.size = tam;
    }

    public TArray(T t){
        this.type = t;
    }

    @Override
    public KindT kind() {
        return KindT.ARRAY;
    }

    public String toString(){
        return "List" + "<" + type.toString() + ">[" + size.toString() + "]";
    }
    
}
