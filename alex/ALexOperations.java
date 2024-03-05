package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IDEN,
                                         alex.lexema()); 
  } 
  public UnidadLexica unidadEvalua() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EVALUA); 
  } 
  public UnidadLexica unidadDonde() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DONDE); 
  } 
  public UnidadLexica unidadEnt() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ENT,alex.lexema()); 
  } 
  public UnidadLexica unidadReal() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.REAL,alex.lexema()); 
  } 
  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAS); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOS); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.POR); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIV); 
  } 
  public UnidadLexica unidadPAp() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PAP); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PCIERRE); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IGUAL); 
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.COMA); 
  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EOF); 
  }
  public UnidadLexica unidadBinario(){
   int aux = Integer.parseInt(alex.lexema().substring(2), 2);
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ENT, String.valueOf(aux));
  }
  public UnidadLexica unidadHexadecimal(){
   int aux = Integer.parseInt(alex.lexema().substring(2), 16);
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ENT, String.valueOf(aux));
  }
  public UnidadLexica unidadPalabra(){
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PAL, alex.lexema());
  }
  public UnidadLexica unidadPatron(){
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PAT, alex.lexema());
  }
  public UnidadLexica unidadOtro(){
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.OTRO, alex.lexema());
  }
  public void error() {
    System.err.println("***"+alex.fila()+", "+alex.columna()+" Caracter inesperado: "+alex.lexema());
  }
}
