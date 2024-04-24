package ast.Instructions;

import java.util.List;
import ast.Expressions.E;
import ast.Types.KindT;
import ast.ASTNode;
import ast.Program;
import exc.BindingException;
import exc.TypingException;
import exc.GCodingException;

public class IFor extends IBlock {
    private E cond;
    private IAssignation assign;
    private IDeclaration dec;

    public IFor(IDeclaration dec, E exp, IAssignation a, List<I> inst) {
        super(inst);
        this.assign = a;
        this.cond = exp;
        this.dec = dec;
    }
    public KindI kind() {
        return KindI.FOR;
    }

    public String toString(){
        return "for(" + dec.toString() + ";" + cond.toString() + ";" + assign.toString() + "){" + this.inst.toString() + "}";
    }

    @Override
    public void bind() throws BindingException {
        Program.getTableStack().openBlock();
        
        dec.bind();
        cond.bind();
        assign.bind(); //esto va aqui??

        super.bind();

        Program.getTableStack().closeBlock();
    }

    public void type() throws TypingException {
        dec.type();
        // comprobamos que la declaracion es de booleano
        if(!dec.getType().kind().equals(KindT.INT)){
            throw new TypingException("The declaration of the for is not an Int.");
        }
        cond.type();
        //hay que comprobar que la condición es un booleano
        if(!cond.getType().kind().equals(KindT.BOOL)){
            throw new TypingException("The condition of the for is not a boolean.");
        }
        assign.type();
        if(!assign.getType().kind().equals(KindT.INT)){
            throw new TypingException("The assignation of the for is not an Int.");
        }
        super.type();
        // el setType de algo??
    }

    public int setDelta(int delta) {
        int aux = dec.setDelta(delta);
        super.setDelta(aux);
        return delta;
    }

    public void generateCode() throws GCodingException {
        dec.generateCode();
        Program.getCode().println("block");
        Program.getCode().println("loop");
        cond.generateCode();
        Program.getCode().println("i32.eqz");
        Program.getCode().println("br_if 1");
        super.generateCode();
        assign.generateCode(); //se suma al final del todo
        Program.getCode().println("br 0");
        Program.getCode().println("end"); //loop
        Program.getCode().println("end"); //block
    }
}

