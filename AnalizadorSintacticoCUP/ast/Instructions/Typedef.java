package ast.Instructions;

import ast.Types.Type;

public class Typedef extends I{

    private String reType;
    private Type type;
    
    public Typedef(String name, Type t){
        this.reType = name;
        this.type = t;
    }

    public KindI kind() {
       return KindI.TYPEDEF;
    }

    @Override
    public String toString() {
        return "typedef: " + reType + " / " + type.toString();
    }
    
}
