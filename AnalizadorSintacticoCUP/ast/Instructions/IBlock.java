package ast.Instructions;

import java.util.List;
import ast.ASTNode;
import exc.BindingException;

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
}
