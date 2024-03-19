package ast.Instructions;

import java.util.List;

public class Block extends I{
    public List<I> inst;

    public Block() {}

    public Block(List<I> inst){ 
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
