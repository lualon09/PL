package ast.Types;

import java.util.List;

public class Struct extends Type {

    private String name;
    // private ASTNode campos;
    
    public Struct(String name, List<String> fields, List<Type> typeFields){
        this.name = name;
    }

    @Override
    public KindTypes kind() {
        return KindTypes.STRUCT;
    }

    public String toString(){
        return name;
    }
}
