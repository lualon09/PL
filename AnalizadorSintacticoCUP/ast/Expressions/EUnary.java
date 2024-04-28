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
      T typeList = opnd.getType();
      EConst sizeList = ((TArray) typeList).getSizeArray();
      T typeElems = typeList.getT();

      Program.getCode().println(" i32.const 0");

      for(int i = 0; i < Integer.parseInt(sizeList.getValue()); i++){
          opnd.calculateAddress(); //calculamos la direccion de comienzo del array
          Program.getCode().println(" i32.const" + i*typeElems.getSize());
          Program.getCode().println(" i32.load");
          Program.getCode().println(" i32.add");
      }
  }

  public void generateCodeProdL() throws GCodingException {
    T typeList = opnd.getType();
    EConst sizeList = ((TArray) typeList).getSizeArray();
    T typeElems = typeList.getT();

    Program.getCode().println(" i32.const 1");

    for(int i = 0; i < Integer.parseInt(sizeList.getValue()); i++){
        opnd.calculateAddress(); //calculamos la direccion de comienzo del array
        Program.getCode().println(" i32.const" + i*typeElems.getSize());
        Program.getCode().println(" i32.load");
        Program.getCode().println(" i32.mul");
    }
}

  public void generateCode() throws GCodingException {

    Program.getCode().println(" ;; generating code for Unary expression");
    
    opnd.generateCode();

    switch(tExp){
      case SUML:
        generateCodeSumL();
        break;
      case PRODL:
        generateCodeProdL();
        break;
      case NOT:
        Program.getCode().println("i32.eqz");
        break;  
      default:
    }

  }
}
