package ast.Expressions;

import ast.Types.T;
import exc.BindingException;
import exc.TypingException;
import ast.Types.KindT;
import ast.Types.TBasics;

public class EBin extends E {
   private E opnd1;
   private E opnd2;
   private KindE tExp;
   private T type;

   public EBin(E opnd1, E opnd2,  KindE tExp, T t) { //opnd1 es el operando 1, opnd2 es el operando 2, tExp es el tipo de operador, t es el tipo que devuelve.
     this.opnd1 = opnd1;
     this.opnd2 = opnd2;
     this.type = t;
     this.tExp = tExp;
   }
   public E opnd1() {return opnd1;}
   public E opnd2() {return opnd2;}

  @Override
  public KindE kindExp() {
    return tExp;
  }    
  public String toString(){
    return tExp.toString() + "("+opnd1().toString()+","+opnd2().toString()+")";  
  }
  @Override
  public void bind() throws BindingException{
    opnd1.bind();
    opnd2.bind();
  }

  public void type() throws TypingException {
    opnd1.type();
    opnd2.type();
    //debemos comprobar que que tanto opnd1 como opnd2 tienen el mismo tipo y además que se pueden aplicar a ese operador.
    if(!opnd1.getType().equals(opnd2.getType())){
      throw new TypingException("Terms " + opnd1.toString() + " and " + opnd2.toString() + " do not have the same type.");
    }
    if((tExp.equals(KindE.AND) ||tExp.equals(KindE.OR)) && !opnd1.getType().equals(type)){
      throw new TypingException("Operator " + tExp.toString() + " is not compatible with " +  opnd1.getType().toString());
    }
    else if((tExp.equals(KindE.SUM) ||tExp.equals(KindE.SUB) ||tExp.equals(KindE.MUL) ||tExp.equals(KindE.DIV) ||tExp.equals(KindE.MOD) ||tExp.equals(KindE.LESS) ||tExp.equals(KindE.LEQ)
    ||tExp.equals(KindE.GREATER) ||tExp.equals(KindE.GREQ)) && !opnd1.getType().equals(new TBasics(KindT.INT))){
      throw new TypingException("Operator " + tExp.toString() + " is not compatible with " +  opnd1.getType().toString());
    }
    else{ //por si es el igual o el distinto y no es ni == ni != 
      if(!opnd1.getType().equals(new TBasics(KindT.INT)) && !opnd1.getType().equals(new TBasics(KindT.BOOL))){
        throw new TypingException("Operator " + tExp.toString() + " is not compatible with " +  opnd1.getType().toString());
      }
    }
    setType(type); //hacemos setType para saber que la expresión es de tipo type.
  }
}
