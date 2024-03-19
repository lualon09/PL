package ast.Definitions;

import java.util.List;

import ast.Instructions.Declaration;

public class Struct extends D{
    private String name;
    private List<Declaration> fields;
    
    public Struct(String name, List<Declaration> fields){
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
