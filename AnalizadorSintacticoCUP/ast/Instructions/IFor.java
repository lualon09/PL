package ast.Instructions;

import java.util.List;
import ast.Expressions.E;
import ast.Types.KindT;
import ast.ASTNode;
import ast.Program;
import exc.BindingException;
import exc.TypingException;

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
        cond.type();
        //hay que comprobar que la condición es un booleano
        if(!cond.getType().kind().equals(KindT.BOOL)){
            throw new TypingException("The condition of the for is not a boolean.");
        }
        assign.type();
        super.type();
        // el setType de algo??
    }
}

