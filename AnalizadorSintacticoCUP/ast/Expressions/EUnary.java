package ast.Expressions;

import ast.Types.*;

public class EUnary extends E {
   private E opnd;
   private KindE tExp;
   private T type;

   public EUnary(E opnd,  KindE tExp, T t) {
     this.opnd = opnd;
     this.tExp = tExp;
     this.type = t;
   }

  @Override
  public KindE kindExp() {
    return tExp;
  }    
  public String toString(){
    return tExp.toString() + "("+opnd.toString()+")";  
  }
  @Override
  public void bind(){
      opnd.bind();
  }
}
