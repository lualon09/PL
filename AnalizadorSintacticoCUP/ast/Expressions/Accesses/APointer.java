package ast.Expressions.Accesses;
import exc.BindingException;
import exc.TypingException;
import ast.Program;
import ast.Types.*;
import exc.GCodingException;

public class APointer extends A {

    private A access;

    public APointer(A ac){
        this.access = ac;
    }

    @Override
    public String toString(){
        return "APointer(*" +  access.toString() + ")";
    }
    @Override
    public void bind() throws BindingException {
        access.bind(); 
        this.bindNode = access.bindNode;
    }

    public void type() throws TypingException {
        access.type();
        if(!access.getType().kind().equals(KindT.POINTER)){
            throw new TypingException(access.toString() + " is not a pointer.");
        }
        setType(access.getType().getT());
    }

    public void calculateAddress(){
        Program.getCode().println(" ;;generating code for APointer " + access.toString());
        access.calculateAddress(); 
        Program.getCode().println("i32.load"); //cargamos la direccion de donde está el puntero.
    
    }

    public KindA kindA(){
        return KindA.POINTER;
    }
}
