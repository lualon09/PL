package ast.Types;

public class TStruct extends T {

    private String name;
    // private ASTNode campos;
    
    public TStruct(String name){
        this.name = name;
    }

    @Override
    public KindT kind() {
        return KindT.STRUCT;
    }

    public String toString(){
        return name;
    }
}
