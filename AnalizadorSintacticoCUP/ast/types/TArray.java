package ast.Types;

import ast.Expressions.EConst;

public class TArray extends T{

    protected EConst size;
    
    public TArray(T t, EConst tam){
        setT(t);
        this.size = tam;
    }

    public TArray(T t){
        setT(t);
    }

    @Override
    public KindT kind() {
        return KindT.ARRAY;
    }

    public String toString(){
        return "List" + "<" + this.getT().toString() + ">[" + size.toString() + "]";
    }

    public EConst getSizeArray()  {
        return size;
    }

    @Override
    public boolean equals(Object t){
        return super.equals(t) && ((TArray) t).getSizeArray() == this.size && ((T) t).getT().equals(this.getT());
    }
    
}
