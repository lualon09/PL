package ast.Expressions.Accesses;
import exc.BindingException;
import exc.TypingException;

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
        throw new TypingException("El type de punteros no está hecho!!!!");
    }
}
