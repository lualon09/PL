package ast.Definitions;

import java.util.List;

import javax.naming.Binding;

import ast.ASTNode;
import ast.Program;
import ast.Instructions.IDeclaration;
import exc.BindingException;
import exc.TypingException;

public class DStruct extends D{
    private String name;
    private List<IDeclaration> fields;
    
    public DStruct(String name, List<IDeclaration> fields){
        this.name = name;
        this.fields = fields;
        Program.addType(name);
    }
    @Override
    public KindD kindD() {
        return KindD.STRUCT;
    }
    public String toString(){
        return "struct " + name.toString() + "{" + fields.toString() + "}";
    }

    public String getName(){
        return this.name;
    }

    public List<IDeclaration> getFields() {
        return fields;
    }

    public void bind() throws BindingException {  
        Program.getTableStack().insertId(name, this); 
        Program.getTableStack().openBlock(); //comprobamos que no haya dos campos que se llamen igual en la declaracion del struct
        for(IDeclaration i: fields){
            i.bind();
        }
        Program.getTableStack().closeBlock();
    }

    public void type() throws TypingException {
        System.out.println("Estoy tipando los campos del struct");
        for(IDeclaration d: fields){
            d.type();
            System.out.println("campo de tipo " + d.getType());
        }
    }
}
