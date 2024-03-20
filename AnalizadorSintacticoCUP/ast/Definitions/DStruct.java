package ast.Definitions;

import java.util.List;

import ast.Instructions.IDeclaration;

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
        return "struct" + name.toString() + "{" + fields.toString() + "}";
    }
}
