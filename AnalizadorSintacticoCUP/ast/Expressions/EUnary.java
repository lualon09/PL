package ast.Expressions;

import ast.Types.*;
import exc.BindingException;
import exc.TypingException;
import exc.GCodingException;
import ast.Program;

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

  public void generateCodeSumL() throws GCodingException {
      TArray typeList = opnd.getType();
      EConst sizeList = typeList.getSizeArray();
      T typeElems = typeList.getT();

      Program.getCode().println(" i32.const 0");

      for(int i = 0; i < Integer.parseInt(sizeList.getValue()); i++){
        Program.getCode().println(" i32.const 0");
      }

  }

  public void generateCode() throws GCodingException {
    
    opnd.generateCode();

    switch(tExp){
      case SUML:
        generateCodeSumL();
        break;
      case PRODL:
       // generateCodeProdL();
        break;
      case NOT:
        Program.getCode().println("i32.eqz");
        break;  
      default:
    }

  }
}
