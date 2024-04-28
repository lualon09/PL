package ast.Instructions;

import java.util.List;

import ast.Program;
import ast.Expressions.E;
import ast.Expressions.KindE;
import ast.Expressions.Accesses.AVariable;
import exc.*;
import ast.Types.*;
import ast.Expressions.EBin;
import ast.Instructions.IAssignation;
import ast.Expressions.Accesses.A;
import ast.Expressions.EConst;

public class IRepeat extends IBlock {
    private E cond;
    private IFor forAux;

    public IRepeat(E exp, List<I> inst) {
        super(inst);
        this.cond = exp;
        convertFor();

    }

    public void convertFor(){
        IDeclaration dec = new IDeclaration(new TBasics(KindT.INT), "var_aux", cond);
        A access = new AVariable("var_aux");
        E exp = new EBin(access, cond, KindE.LESS, new TBasics(KindT.BOOL));
        IAssignation assign = new IAssignation(access, new EBin(access, new EConst("1", new TBasics(KindT.INT)), KindE.SUM, new TBasics(KindT.INT)));
        forAux = new IFor(dec, exp, assign,super.inst);
    }
    public KindI kind() {
        return KindI.REPEAT;
    }

    public String toString(){
        return "repeat(" + cond.toString() + "){" + this.inst.toString() + "}";
    }

    @Override
    public void bind() throws BindingException {
        forAux.bind();
    }
    public void type() throws TypingException {
        cond.type();
        if(!cond.getType().kind().equals(KindT.INT)){
            throw new TypingException("The condition of the repeat is not an Int");
        }
        forAux.type();
    }
    
    public int setDelta(int delta) {
        return forAux.setDelta(delta);
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" ;;generating code for IRepeat");
        forAux.generateCode();
    }

    public int maxMemory(){
        return forAux.maxMemory();
    }


}
