package ast.Types;

public class BasicTypes extends Type{

    private KindTypes tipo;

    public BasicTypes(KindTypes tipo){
        this.tipo = tipo;
    }

    @Override
    public KindTypes kind() {
        return this.tipo;
    }

    public String toString(){
        return tipo.toString();
    }
    
}
