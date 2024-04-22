package ast.Expressions;

import java.util.ArrayList;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Types.KindT;
import ast.Types.TArray;
import ast.Expressions.EConst;
import ast.Types.TBasics;

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

    public void type() throws TypingException {
        arr.get(0).type();
        setType(new TArray(arr.get(0).getType(), new EConst(Integer.toString(arr.size()), new TBasics(KindT.INT)))); //decimos que lo de la derecha va a ser algo de tipo array de tamaño los argumentos.

        for(int i = 1; i < arr.size(); i++){
            arr.get(i).type();
            if(!arr.get(0).getType().equals(arr.get(i).getType())) {
                throw new TypingException("Not all values in array declaration have the same type. " + arr.get(0).getType().toString() + " and " + arr.get(i).getType());
            }
        }
    }
    
    public void generateCode() throws GCodingException {
        // aqui que hay que hacer
    }
}
