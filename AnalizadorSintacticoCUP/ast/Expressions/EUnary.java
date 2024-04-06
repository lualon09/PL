package ast.Expressions;

import ast.Types.*;
import exc.BindingException;

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
  public void bind() throws BindingException{
      opnd.bind();
  }
}
