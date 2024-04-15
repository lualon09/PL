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
    }

    public void type() throws TypingException {
        for(IDeclaration d: fields){
            d.type();
        }
    }
}
