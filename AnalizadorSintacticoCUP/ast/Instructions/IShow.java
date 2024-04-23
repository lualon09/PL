package ast.Instructions;

import ast.Expressions.E;
import ast.Types.KindT;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

public class IShow extends I{

    private E exp;

    public IShow(E exp){
        super();
        this.exp = exp;
    }
    @Override
    public KindI kind() {
       return KindI.SHOW;
    }

    public String toString(){
        return "show(" + exp.toString() + ")";
    }

    @Override
    public void bind() throws BindingException{
        exp.bind();
    }

    public void type() throws TypingException {
        exp.type();
        if(!exp.getType().kind().equals(KindT.BOOL) && !exp.getType().kind().equals(KindT.INT)){
            throw new TypingException("Show function only gets type Int or type Bool. It is getting " + exp.getType().toString());
        }
    }

    public void generateCode() throws GCodingException {
        exp.generateCode();
        Program.getCode().println("call $print");
        // como se imprimen en web assembly los booleanos????????
    }
}
