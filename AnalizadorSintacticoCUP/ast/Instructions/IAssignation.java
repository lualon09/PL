package ast.Instructions;

import java.util.ArrayList;

import ast.NodeKind;
import ast.Program;
import ast.Definitions.KindD;
import ast.Expressions.*;
import ast.Expressions.Accesses.*;
import ast.Types.KindT;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Types.TBasics;
import ast.Definitions.D;

public class IAssignation extends I{

    private A access;
    private E exp;
    public IAssignation(A a, E e){ //access para acceder a la variable, E es la expresion de la variable
        this.access = a;
        this.exp = e;
    }

    public KindI kind() {
       return KindI.ASSIGNATION;
    }

    @Override
    public String toString() {
        return "assign:" + access.toString() + "=" + exp.toString();
    }
    @Override
    public void bind() throws BindingException {
        access.bind();
        exp.bind();
    }

    public void type() throws TypingException {
        access.type();
        exp.type();
        if(access.bindNode.nodeKind().equals(NodeKind.DEFINITION) && ((D) access.bindNode).kindD().equals(KindD.CONST)){
            throw new TypingException("Error. Constant can't be modified.");
        }
        if(exp.kindExp().equals(KindE.READ) && !access.getType().equals(new TBasics(KindT.BOOL)) && !access.getType().equals(new TBasics(KindT.INT))){
            throw new TypingException("Error. Cannot read something different than Int or Bool. Got " + access.toString() + ".");
        }
        if(!exp.kindExp().equals(KindE.READ)){
            if(!access.getType().kind().equals(exp.getType().kind())){ //en el caso de que sea el read 
                throw new TypingException("Error. " + access.toString() + " and " + exp.toString() + " have different types.");
            }
            setType(exp.getType()); //para comprobar el bucle for
        }
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" ;;generating code for assignation " + toString());
        if(exp.kindExp().equals(KindE.ARRAY)){
            ArrayList<E> expArray = ((EArray) exp).getExpArray();
            for(int i = 0; i< expArray.size(); i++){
                access.calculateAddress(); //calculamos direccion de comienzo del array
                Program.getCode().println(" i32.const " + i*expArray.get(i).getType().getSize());
                Program.getCode().println(" i32.add");
                expArray.get(i).generateCode();
                Program.getCode().println(" i32.store");
            }
        }
        else if(exp.kindExp().equals(KindE.ACCESS) && !((A) exp).kindA().equals(KindA.ADDRESS)){
            exp.calculateAddress(); //es un acceso
            access.calculateAddress();
            Program.getCode().println(" i32.const " + exp.getType().getSize()/4);
            Program.getCode().println(" call $copyn"); //copiamos de una direccion a otra de tamaño exp.getType().getSize()/4
        }
        else if(exp.kindExp().equals(KindE.FUNCTION) && (access.getType().kind().equals(KindT.ARRAY) || access.getType().kind().equals(KindT.STRUCT))){
            exp.generateCode(); //que 
            access.calculateAddress(); //donde 
            Program.getCode().println(" i32.const " + exp.getType().getSize()/4);
            Program.getCode().println(" call $copyn"); //copiamos de una direccion a otra de tamaño exp.getType().getSize()/4
        }
        else{
            access.calculateAddress(); //donde 
            exp.generateCode(); //que 
            Program.getCode().println(" i32.store"); //guardamos
        }
        Program.getCode().println(" ;;end generating code for assignation " + toString());
    }
}
