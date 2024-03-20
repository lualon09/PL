package ast.Instructions;

import java.util.List;

public class IBlock extends I{
    public List<I> inst;

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
}
