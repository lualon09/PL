package ast.Types;


public class Struct extends Type {

    private String name;
    // private ASTNode campos;
    
    public Struct(String name){
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
