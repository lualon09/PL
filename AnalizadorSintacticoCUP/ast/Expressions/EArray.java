package ast.Expressions;

import java.util.ArrayList;
import exc.BindingException;

public class EArray extends E{
    
    public ArrayList<E> arr;

    public EArray(ArrayList<E> arr){
        this.arr = arr;
    }

    @Override
    public KindE kindExp() {
        return KindE.ARRAY;
    }

    public String toString(){
        return arr.toString();
    }
    @Override
    public void bind() throws BindingException {
        for(int i = 0; i < arr.size(); i++){
            arr.get(i).bind(); //vinculamos todos los elementos del array
        }
    }
    
}
