package ast.Expressions;

import ast.Types.T;

public class EConst extends E{ //Expresion Constante
    private T type;
    private String value;

    public EConst(String value, T t){ //cuando es el tamaño de un array
        this.type = t;
        this.value = value;
    }

    @Override
    public KindE kindExp() {
        return KindE.CONST;
    }

    public String toString(){
        return "const(" + type.toString() + ")" + "=" + value; //las constantes no tienen tipo porque solo pueden ser enteras
    }
}
