package ast.Expressions.Accesses;

import ast.Expressions.E;
import ast.Types.KindT;
import exc.BindingException;
import exc.TypingException;

public class AArray extends A{
    private A access;
    private E exp;

    public AArray(A ac, E e){
        this.access = ac;
        this.exp = e;   
    }

    @Override
    public String toString(){
        return "AArray (" + access + "[" + exp.toString() + "])";
    }

    @Override
    public void bind() throws BindingException {
        access.bind();
        this.bindNode = access.bindNode;
        exp.bind();
    }

    public void type() throws TypingException {
        exp.type();
        access.type();
        // comprobamos si exp es de tipo entero y si access es de tipo array 
        if(exp.getType().kind().equals(KindT.INT) && access.getType().kind().equals(KindT.ARRAY)) {
            setType(access.getType().getT()); //cogemos el tipo del array y decimos que aarray es de este tipo
        }
        else {
            throw new TypingException("Error typing in array "+ access.toString());
        }       
    }
}
