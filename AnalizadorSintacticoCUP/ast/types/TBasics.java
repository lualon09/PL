package ast.Types;

public class TBasics extends T{

    private KindT tipo;

    public TBasics(KindT tipo){
        this.tipo = tipo;
    }

    @Override
    public KindT kind() {
        return this.tipo;
    }

    public String toString(){
        return tipo.toString();
    }

    public int getSize(){
        if(tipo.equals(KindT.VOID)){
            return 0; //si es void no ocupa
        }
        else return 4; //si es bool o int son 4
    }
    
}
