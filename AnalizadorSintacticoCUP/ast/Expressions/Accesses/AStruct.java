package ast.Expressions.Accesses;

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
    public void bind(){
        access.bind();
        this.bindNode = access.bindNode;
    }
}
