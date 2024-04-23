package ast.Instructions;

import java.util.List;
import ast.ASTNode;
import exc.BindingException;
import exc.TypingException;

public class IBlock extends I{
    protected List<I> inst;

    public IBlock() {}

    public IBlock(List<I> inst){ 
        this.inst = inst;
    }

    public KindI kind() {
       return KindI.BLOCK;
    }

    @Override
    public String toString() {
        return "block {" + inst.toString() + "}";
    }

    @Override
    public void bind() throws BindingException {
        for (I i : inst) {
            i.bind();
        }
    }

    public void type() throws TypingException {
        for (I i : inst) {
            i.type(); //tipamos todas las instrucciones
        }
    }

    public int setDelta(int delta) {
        int aux = delta;
        for (I i : inst) {
            aux = i.setDelta(aux); //tipamos todas las instrucciones
        }
        return delta;
    }
}
