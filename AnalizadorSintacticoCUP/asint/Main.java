package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import ast.Program;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

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
			System.out.println("Correct binding!");
			try{
				System.out.println("*********************TYPING********************");
				p.type(); //tipado
				System.out.println("Correct typing!");
				// try{
				// 	p.generateCode();
				// }catch(GCodingException ce){
				// 	ce.printStackTrace();
				// }
			}catch(TypingException te){
				te.printStackTrace();
			}
		} catch(BindingException be){
			be.printStackTrace();
		}
	}
	catch(Exception e){
		System.out.println("Something went wrong with the parsing...");
		e.printStackTrace();
	}
		
 }
}   
   
