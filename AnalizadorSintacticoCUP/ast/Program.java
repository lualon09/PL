package ast;

import ast.Definitions.DefinitionList;
import exc.BindingException;
import exc.TypingException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import exc.*;


public class Program extends ASTNode {

    private static DefinitionList definitionList;
    private static SymbolsTableStack stack;
    private static ArrayList<String> typeList = new ArrayList<String>(); //yo creo que esto puede sobrar
    private static PrintWriter code;


    public Program(DefinitionList list){
        this.definitionList = list;
        this.stack = new SymbolsTableStack();
    }

    @Override
    public NodeKind nodeKind() {
        return NodeKind.PROGRAM;
    }

    @Override
    public String toString() {
       return "program {" + definitionList.toString() + "}";
    }

    public static SymbolsTableStack getTableStack(){
        return stack;
    }

    public void bind() throws BindingException{
        stack.openBlock();
        definitionList.bind();
        stack.closeBlock();
    }

    public void type() throws TypingException {
        definitionList.type();
    }

    public void generateCode() throws GCodingException {
        try{
            code = new PrintWriter(new FileWriter("code/examples/1.wat")); //ya le cambiaremos el nombre
            FileReader prelude = new FileReader("code/prelude.wat");
            prelude.transferTo(code);
            prelude.close();

            // aqui no sabemos muy bien que hay que poner

            FileReader epilogue = new FileReader("code/epilogue.wat");
            epilogue.transferTo(code);
            epilogue.close();

            code.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void addType(String t) {
        typeList.add(t);
    }

    public static DefinitionList getDefinitionList() {
        return definitionList;
    }

    public static PrintWriter getCode(){
        return code;
    }
}
