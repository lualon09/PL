package ast.Types;

import ast.Expressions.EConst;
import exc.BindingException;
import exc.TypingException;

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
        return kind().equals(((T) t).kind()) && ((TArray) t).getSizeArray().equals(this.size) && ((T) t).getT().equals(this.getT());
    }

    // eso no tengo claro si va a aqui, pero habría que hacer binding del tipo de arriba
    public void bind() throws BindingException{
        if(getT().kind().equals(KindT.STRUCT)){ //en el caso de que sea struct hacemos binding con el struct
            getT().bind();
            bindNode = getT().bindNode;
        }
    }

    public int getSize(){
        return Integer.parseInt(size.getValue()) * getT().getSize();
    }

    public void type() throws TypingException {
        getT().type();
        size.type();
    }
}
