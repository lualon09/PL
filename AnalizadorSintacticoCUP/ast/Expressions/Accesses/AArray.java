package ast.Expressions.Accesses;

import ast.Program;
import ast.Expressions.E;
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

    public void correctIndex() throws GCodingException {
        // Primero comprobamos que no se pasa el index del array
        Program.getCode().println(" ;;generating code for index of array" + exp.toString() + " to see if it's correct");
        exp.generateCode();
        Program.getCode().println("i32.const " + ((TArray) access.getType()).getSizeArray().getValue());
        Program.getCode().println("i32.ge_s");
        Program.getCode().println("if");
        Program.getCode().println("i32.const 3");
        Program.getCode().println("call $exception");
        Program.getCode().println("end");

        // tambien comprobamos que sea >= 0
        Program.getCode().println("i32.const 0");
        exp.generateCode();
        Program.getCode().println("i32.gt_s");
        Program.getCode().println("if");
        Program.getCode().println("i32.const 3");
        Program.getCode().println("call $exception");
        Program.getCode().println("end");

    }

    public void calculateAddress() {
        try{
        
            correctIndex();
            // ahora calculamos el acceso al array
            Program.getCode().println(" ;;generating code for index of array" + exp.toString());
            exp.generateCode();
            Program.getCode().println(" i32.const " + getType().getSize());
            Program.getCode().println(" i32.mul"); //multiplicamos el tamaño por el tipo para saber a cual accedemos

            Program.getCode().println(" ;;generating code for access array" + access.toString());
            access.calculateAddress(); //calculamos la direccion del accesso
            Program.getCode().println(" i32.add"); //lo sumamos

            Program.getCode().println(" ;;end of generating code for access to array");
        }
        catch(GCodingException e){
            e.printStackTrace();
        }
        
    }

    public KindA kindA(){
        return KindA.ARRAY;
    }
}
