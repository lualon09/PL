package ast.Expressions;

import ast.Types.*;

public class ENew extends E{

    private T type;

    public ENew(T t){
        this.type = t; //El puntero es de tipo t
        // this.type = new Pointer(typeP); //creamos el puntero de tipo typeP
    }

    @Override
    public KindE kindExp() {
        return KindE.NEW;
    }

    public String toString(){
        return "new " + type.toString();
    }

    public void bind(){}
}
