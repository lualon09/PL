package ast.Expressions.Accesses;

import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Types.*;

public class AAdPointer extends A{
    
    private A access;

    public AAdPointer(A ac){
          this.access = ac;
    }

    @Override
    public String toString(){
        return "AAdPointer(&" +  access.toString() + ")";
    }
    @Override
    public void bind() throws BindingException{
        access.bind(); 
        this.bindNode = access.bindNode;
    }

    public void type() throws TypingException {
        access.type();
        setType(new TPointer(bindNode.getType()));
    }

    public void calculateAddress(){
        ((A) this.bindNode).calculateAddress();
    }

    public void generateCode() throws GCodingException {
        calculateAddress(); //dejamos en la cima de la pila la direccion de la variable
    }
}
