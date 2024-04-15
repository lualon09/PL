package ast.Expressions;

import ast.Types.*;
import exc.BindingException;
import exc.TypingException;
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
  public void bind() throws BindingException{
      opnd.bind();
  }

  public void type() throws TypingException {
    opnd.type();
    if((tExp.equals(KindE.PRODL) ||tExp.equals(KindE.SUML)) && !opnd.getType().kind().equals(KindT.ARRAY)){
      throw new TypingException("Operator " + tExp.toString() + " is not compatible with " +  opnd.getType().toString());
    }
    else if(tExp.equals(KindE.NOT) && !opnd.getType().equals(new TBasics(KindT.BOOL))){
      throw new TypingException("Operator " + tExp.toString() + " is not compatible with " +  opnd.getType().toString());
    }
    setType(type); //hacemos setType para saber que la expresión es de tipo type.
  }
}
