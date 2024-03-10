package ast.Expressions;

import ast.Types.Type;

public class EUnary extends E {
   private E opnd;
   private KindE tExp;

   public EUnary(E opnd,  KindE tExp, Type t) {
     this.opnd = opnd;
     this.type = t;
     this.tExp = tExp;
   }

  @Override
  public KindE kindExp() {
    return tExp;
  }    
  public String toString(){
    return tExp.toString() + "("+opnd.toString()+")";  
  }
}
