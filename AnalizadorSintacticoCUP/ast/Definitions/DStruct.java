package ast.Definitions;

import java.util.List;

import javax.naming.Binding;

import ast.ASTNode;
import ast.Program;
import ast.Instructions.IDeclaration;
import exc.BindingException;

public class DStruct extends D{
    private String name;
    private List<IDeclaration> fields;
    
    public DStruct(String name, List<IDeclaration> fields){
        this.name = name;
        this.fields = fields;
    }
    @Override
    public KindD kindD() {
        return KindD.STRUCT;
    }
    public String toString(){
        return "struct " + name.toString() + "{" + fields.toString() + "}";
    }

    public void bind() throws BindingException {
        ASTNode node = Program.getTableStack().findId(name);
        if(node != null){
            throw new BindingException("Struct " + name + " already declared");
        }
        else{
            Program.getTableStack().insertId(name, this);
            Program.getTableStack().openBlock();
            for(IDeclaration f: fields){
                f.bind();
            }
            Program.getTableStack().closeBlock();
        }
    }
}
