package ast.Expressions.Accesses;

import exc.BindingException;
import exc.TypingException;

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
        // aqui algo mas?
    }
}
