package ast.Expressions.Accesses;
import exc.BindingException;

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
        access.bind(); //Aqui que hay que hacer
    }
}
