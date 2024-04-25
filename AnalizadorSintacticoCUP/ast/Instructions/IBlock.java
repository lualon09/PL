package ast.Instructions;

import java.util.List;
import ast.ASTNode;
import exc.BindingException;
import exc.GCodingException;
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
            aux = i.setDelta(aux); //calculamos deltas de todas las instrucciones
        }
        return delta;
    }

    public void generateCode() throws GCodingException {
        for (I i : inst) {
            i.generateCode(); //generamos codigo de todas las instrucciones
        }
    }

    public int maxMemory(){
        int c = 0;
        int max = 0;

        for(int i = 0; i < inst.size(); i++){
            if(inst.get(i).kind().equals(KindI.DECLARATION)){
                c += ((IDeclaration) inst.get(i)).getSize();
            }
            else if(inst.get(i) instanceof IBlock){
                int blockSize = ((IBlock) inst.get(i)).maxMemory();
                if(c + blockSize > max){
                    max = c + blockSize;
                }
            }
        }
        if(c > max){ //por si acaso lo del final han sido variables
            max = c;
        }
        return max;
    }


}
