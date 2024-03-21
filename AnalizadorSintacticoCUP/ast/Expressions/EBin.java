package ast.Expressions;

import ast.types.T;

public class EBin extends E {
   private E opnd1;
   private E opnd2;
   private KindE tExp;
   private T type;

   public EBin(E opnd1, E opnd2,  KindE tExp, T t) {
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
    return type.toString() + "("+opnd1().toString()+","+opnd2().toString()+")";  
  }
}
