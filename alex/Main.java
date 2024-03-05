package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;



public class Main {

  public static boolean isMatch(String word1, String word2) {

    if(word2.length() == 1 && word1.length() > 2){ return false;}
    
    int posAsterisco = 0, i = 0;
    while(i < word1.length()) {
      if(word1.charAt(i) == '*'){
        posAsterisco = i;
        break;
      }
      i++;
    }

    int prefix = 0;
    while(prefix < posAsterisco){
      if(word1.charAt(prefix) == word2.charAt(prefix)){
        prefix++;
      }
      else return false;
    }

    int suffix1 = word1.length()-1;
    int suffix2 = word2.length()-1;
    while(suffix1 > posAsterisco){
      if(word1.charAt(suffix1) == word2.charAt(suffix2)){
        suffix2--;
        suffix1--;
      }
      else return false;
    }

    return true;

}
   public static void main(String[] args) throws FileNotFoundException, IOException {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
     AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
     UnidadLexica[] palabras = new UnidadLexica[100];
     UnidadLexica[] patrones = new UnidadLexica[100];
     UnidadLexica unidad;
     int cont = 0, cont2 = 0;
     do {
       unidad = al.yylex();
       System.out.println(unidad);
       if(unidad.clase() == 17) {
        palabras[cont] = unidad;
        cont++;
       }
       else if(unidad.clase() == 18){
         patrones[cont2] = unidad;
         cont2++;
       }
     }
     while (unidad.clase() != ClaseLexica.EOF);
     System.out.println("PALABRAS:");
     for(int i = 0; i< cont; i++){
       System.out.println(palabras[i].lexema());
     }
     System.out.println("PATRONES:");
     for(int i = 0; i < cont2; i++){
      int coinciden = 0;
       for(int j = 0; j < cont; j++){
         if(isMatch(patrones[i].lexema(), palabras[j].lexema())){
           coinciden++;
         }
       }
       System.out.println(patrones[i].lexema() +": " + coinciden);
     }
    }        
} 
