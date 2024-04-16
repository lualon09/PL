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
        if(!bindNode.getType().kind().equals(KindT.POINTER)){
            throw new TypingException(access.toString() + " is not a pointer.");
        }
        setType(bindNode.getType().getT()); //el tipo de *tipo es tipo.
    }
}
