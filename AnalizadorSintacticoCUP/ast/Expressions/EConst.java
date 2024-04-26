package ast.Expressions;

import ast.Program;
import ast.Types.T;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

public class EConst extends E{ //Expresion Constante
    private T type;
    private String value;

    public EConst(String value, T t){ //cuando es el tamaño de un array
        this.type = t;
        this.value = value;
        // setType(t);
    }

    @Override
    public KindE kindExp() {
        return KindE.CONST;
    }

    public String toString(){
        return "(" + type.toString() + ":" + value.toString() + ")";
    }

    public String getValue(){
        return value;
    }

    @Override
    public void bind() throws BindingException{
    }

    public void type() throws TypingException {
        setType(type);
    }
    @Override
    public boolean equals(Object e){
        return ((E) e).kindExp().equals(KindE.CONST) && type.equals(((EConst) e).getType()) && value.equals(((EConst) e).getValue());
    }

    public String transformValue(){
        if(value.equals("True")){
            return "1";
        }
        else if (value.equals("False")){
            return "0";
        }
        return value;
    }

    @Override
    public void generateCode() throws GCodingException {
        Program.getCode().println("i32.const " + transformValue());
    }
}
