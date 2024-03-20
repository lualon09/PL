package ast.Expressions.Accesses;

public class AVariable extends A {

    private String var;

    public AVariable(String v){
        this.var = v;
    }

    @Override
    public String toString(){
        return "AVar(" + var + ")";
    }
}
