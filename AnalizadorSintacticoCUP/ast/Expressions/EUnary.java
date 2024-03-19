package ast.Expressions;

public class EUnary extends E {
   private E opnd;
   private KindE tExp;

   public EUnary(E opnd,  KindE tExp) {
     this.opnd = opnd;
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
