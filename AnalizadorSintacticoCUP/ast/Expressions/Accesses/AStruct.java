package ast.Expressions.Accesses;
import exc.BindingException;
import exc.TypingException;
import ast.Types.KindT;
import java.util.ArrayList;
import ast.Instructions.IDeclaration;
import ast.Types.TStruct;

public class AStruct extends A {
    private A access;
    private String field;

    public AStruct(A ac, String f){
        this.access = ac;  
        this.field = f;
    }

    @Override
    public String toString(){
        return "AStruct(" + access.toString() + "." + field + ")";
    }
    @Override
    public void bind() throws BindingException {
        access.bind();
        this.bindNode = access.bindNode;
    }

    public void type() throws TypingException {
        access.type();
        // comprobamos si access es de tipo struct 
        if(access.getType().kind().equals(KindT.STRUCT)) {
            ArrayList<IDeclaration> fields = ((TStruct) access.getType()).getFields();
            // setType(access.getType().getT()); //cogemos el tipo del array y decimos que aarray es de este tipo
        }
        else {
            throw new TypingException("Error typing in array "+ access.toString());
        }     
    }
}
