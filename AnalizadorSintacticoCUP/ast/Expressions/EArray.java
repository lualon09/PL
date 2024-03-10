package ast.Expressions;

import java.util.ArrayList;

public class EArray extends E{
    
    public ArrayList<E> arr;

    public EArray(ArrayList<E> arr){
        this.arr = arr;
    }

    @Override
    public KindE kindExp() {
        return KindE.ARRAY;
    }
    
}
