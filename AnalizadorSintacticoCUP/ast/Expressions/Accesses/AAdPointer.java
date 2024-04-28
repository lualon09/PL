package ast.Expressions.Accesses;

import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Program;
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
        System.out.println("Mi binding node es" + this.bindNode.toString());
    }

    public void type() throws TypingException {
        access.type();
        setType(new TPointer(bindNode.getType()));
    }

    public void calculateAddress(){
        access.calculateAddress();
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" ;; generating code for address of " + access.toString());
        calculateAddress(); //dejamos en la cima de la pila la direccion de la variable
    }

    public KindA kindA(){
        return KindA.ADDRESS;
    }
}
