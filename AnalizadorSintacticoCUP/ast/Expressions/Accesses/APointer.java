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
        // if(!bindNode.getType().kind().equals(KindT.POINTER)){
        //     throw new TypingException(access.toString() + " is not a pointer.");
        // }
        if(!access.getType().kind().equals(KindT.POINTER)){
            throw new TypingException(access.toString() + " is not a pointer.");
        }
        // setType(bindNode.getType().getT()); //el tipo de *tipo es tipo. ESTO FALLA
        setType(access.getType().getT());
    }

    public void calculateAddress(){
        try{
            Program.getCode().println(" ;;generating code for APointer " + access.toString());
            this.bindNode.generateCode(); //te va a dejar en la pila el valor de la direccion a la que apunta el puntero
        }catch(GCodingException e){
            e.printStackTrace();
        }
        
    }

    public KindA kindA(){
        return KindA.POINTER;
    }
}
