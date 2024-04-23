package ast.Expressions;

import ast.Types.*;
import exc.BindingException;
import exc.TypingException;
import exc.GCodingException;
import ast.Program;

public class ENew extends E{

    private T type;

    public ENew(T t){
        this.type = t; //El puntero es de tipo t
    }

    @Override
    public KindE kindExp() {
        return KindE.NEW;
    }

    public String toString(){
        return "new " + type.toString();
    }

    public void bind() throws BindingException{
        type.bind();
    }

    public void type() throws TypingException {
        setType(new TPointer(type));
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println("i32.const " + type.getSize());
        Program.getCode().println("call $reserveHeap ");
        Program.getCode().println("get_global $NP"); //investigar
    }
}
