package ast.Expressions;

import ast.Types.*;

public class ENew extends E{

    Type typeP;

    public ENew(Type t){
        this.typeP = t; //El puntero es de tipo t
        this.type = new Pointer(typeP); //creamos el puntero de tipo typeP
    }

    @Override
    public KindE kindExp() {
        return KindE.NEW;
    }

    public String toString(){
        return "new " + typeP.toString();
    }
}
