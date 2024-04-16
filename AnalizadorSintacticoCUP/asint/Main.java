package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import ast.Program;
import exc.BindingException;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
	 AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	 AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
	 try {
	    Program p = (Program) asint.parse().value;
		System.out.println("TREE AST");
		System.out.println(p);
		try{
			System.out.println("*********************BINDING********************");
			p.bind(); // vinculacion
			try{
				System.out.println("************************TYPING********************");
				p.type(); //tipado
			}catch(TypingExcetion te){
				te.printStackTrace();
			}
		} catch(BindingException be){
			be.printStackTrace();
		}
	}
	catch(Exception e){
		System.out.println("Something went wrong with the parsing...");
	}
		
 }
}   
   
