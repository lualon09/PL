package ast.Expressions;

import ast.types.T;

public class EConst extends E{
    private String name; //nombre de la constante
    private T type;
    private String value;

    public EConst(String c, String value, T t){
        this.name = c; 
        this.type = t; 
        this.value = value;
    }

    public EConst(String value, T t){ //cuando es el tamaño de un array
        this.type = t;
        this.value = value;
    }

    @Override
    public KindE kindExp() {
        return KindE.CONST;
    }

    public String toString(){
        return "const(" + type.toString() + ")" + name + "=" + value; //las constantes no tienen tipo porque solo pueden ser enteras
    }
}
