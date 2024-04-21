package ast.Expressions.Accesses;
import exc.BindingException;
import exc.TypingException;
import ast.Types.KindT;
import java.util.List;
import ast.Instructions.IDeclaration;
import ast.Types.TStruct;
import ast.Definitions.DStruct;
import ast.ASTNode;
import ast.Program;

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
        System.out.println("soy el acceso del struct " + access.toString());
        // comprobamos si access es de tipo struct 
        if(access.getType().kind().equals(KindT.STRUCT)) {
            boolean encontrado = false;
            System.out.println("Soy el tipo del bind node del struct " + (bindNode.getType()).toString());
            System.out.println("Soy el tipo del bind node del struct " + (bindNode.getType()).bindNode.toString());
            List<IDeclaration> fields = ((DStruct) bindNode.getType().bindNode).getFields();
            System.out.println("Los campos son: " + fields.toString() + " y voy a buscar " + field);
            for(IDeclaration f: fields){
                // if(f.getName().equals(field) && f.getType().kind().equals(KindT.STRUCT)){
                //     try{
                //         System.out.println("detecto que soy " + f.getName() + " y tengo el tipo " + f.getType().toString());
                //         f.getType().bind();
                //         this.bindNode = f.getType().bindNode;
                //         System.out.println("soy " + f.getName() + " y mi binding node ahora es " + this.bindNode.toString());
                //     }catch(BindingException b){
                //         throw new TypingException("Struct name not found");
                //     }
                // }
                if(f.getName().equals(field)) { //Comprobamos si es igual a algun campo                    
                    System.out.println("Soy el campo " + f.getName() + "y le estoy asignando tipo " + f.getType());
                    setType(f.getType());
                    encontrado = true;
                }
            }
            if(!encontrado){
                throw new TypingException("Struct field " + field + " doesn't exist in struct " + ((DStruct) bindNode.getType().bindNode).getName() + ".");
            }
        }
        else {
            throw new TypingException("Error typing in array "+ access.toString() + ".");
        }     
    }
}
