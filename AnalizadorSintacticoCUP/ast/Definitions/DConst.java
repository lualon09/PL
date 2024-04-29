package ast.Definitions;

import ast.Expressions.E;
import ast.Expressions.KindE;
import ast.Expressions.Accesses.A;
import ast.Expressions.Accesses.KindA;
import ast.Types.KindT;
import ast.Types.T;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

import java.util.List;

import ast.Program;

public class DConst extends D{

    public T type;
    public String name;
    private E exp;
    private int delta;

    public DConst(T t, String name, E exp){ 
        this.type = t;
        this.name = name;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "const:" + name.toString() + "(type: " + type.toString() + ")" + "(" + exp.toString() + ")";
    }

    @Override
    public KindD kindD() {
        return KindD.CONST;
    }

    @Override
    public void bind() throws BindingException{
        Program.getTableStack().insertId(name, this);
        exp.bind();
    }

    @Override
    public void type() throws TypingException {
        exp.type();
        setType(type); //por gramatica va a ser siempre entera
        if(!type.equals(exp.getType())){
            throw new TypingException("Type not compatible in " + exp.toString() + " and " + type.toString());
        }
    }

    public int setDelta(int delta) {
        this.delta = delta;
        return delta + getType().getSize();
    }

    public void calculateAddress() {
        Program.getCode().println(" i32.const " + delta); //su direccion es el delta directamente
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" ;; generating code of const " + name);
        if(exp.kindExp().equals(KindE.ACCESS) && !((A) exp).kindA().equals(KindA.ADDRESS)){
            exp.calculateAddress(); //es un acceso
            this.calculateAddress();
            Program.getCode().println(" i32.const " + exp.getType().getSize()/4);
            Program.getCode().println(" call $copyn"); //copiamos de una direccion a otra de tamaño exp.getType().getSize()/4
        }
        else{
            this.calculateAddress();
            exp.generateCode();
            Program.getCode().println(" i32.store");
        }
    }

    public void typedef(List<DTypedef> typedefs){
        DTypedef found = findTypedef(typedefs, type);
        if(found != null) { //la constante es de tipo typedef
            type = found.getType();
        }
    }

    
}
