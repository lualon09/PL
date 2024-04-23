package ast.Expressions.Accesses;

import ast.Program;
import ast.Expressions.E;
import ast.Types.KindT;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Types.*;

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
        if(exp.getType().equals(new TBasics(KindT.INT)) && access.getType().kind().equals(KindT.ARRAY)) {
            setType(access.getType().getT()); //cogemos el tipo del array y decimos que aarray es de este tipo
        }
        else {
            throw new TypingException("Error typing in array "+ access.toString());
        }       
    }

    public void calculateAddress() {
        try{
            exp.generateCode();
            Program.getCode().println("i32.const " + getType().getSize());
            Program.getCode().println("i32.mul"); //multiplicamos el tamaño por el tipo para saber a cual accedemos

            access.calculateAddress(); //calculamos la direccion del accesso
            Program.getCode().println("i32.addcalculateAddress"); //lo sumamos
        }
        catch(GCodingException e){
            e.printStackTrace();
        }
        
    }
}
