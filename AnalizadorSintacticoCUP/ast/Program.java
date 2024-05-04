package ast;

import ast.Definitions.DFunction;
import ast.Definitions.DefinitionList;
import ast.Definitions.DImport;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.List;

import alex.AnalizadorLexicoTiny;
import asint.AnalizadorSintacticoTiny;
import ast.Definitions.DTypedef;
import exc.*;

public class Program extends ASTNode {

    private static DefinitionList definitionList;
    private static SymbolsTableStack stack;
    private static PrintWriter code;
    private String fileName;

    public Program(DefinitionList list) {
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

    public static SymbolsTableStack getTableStack() {
        return stack;
    }

    public void bind() throws BindingException {
        stack.openBlock();
        definitionList.bind();
        stack.closeBlock();
    }

    public void type() throws TypingException {
        definitionList.type();
    }

    @Override
    public int setDelta(int delta) {
        return definitionList.setDelta(delta);
    }

    public static void preFunction(int size) {
        code.println(" (local $temp i32)");
        code.println(" (local $localsStart i32)");
        code.println(" i32.const " + size);
        code.println(" call $reserveStack");
        code.println(" local.set $temp");
        code.println(" global.get $MP");
        code.println(" local.get $temp");
        code.println(" i32.store");
        code.println(" global.get $MP");
        code.println(" i32.const 4");
        code.println(" i32.add");
        code.println(" local.set $localsStart");
    }

    public static void endFunction() {
        code.println(" call $freeStack");
    }

    public void preMaingenerateCode() throws GCodingException {
        code.println("(func $preMain ");
        int size = definitionList.getMaxMemoryGlobal(); // cogemos el tamaño de las variables globales y constantes
        preFunction(size + 4);
        definitionList.generateCodeGlobal();
        code.println(" call $main");
        code.println(" drop");
        endFunction();
        code.println(")");
    }

    public void generateCode() throws GCodingException {
        try {
            code = new PrintWriter(new FileWriter("code/" + fileName)); // ya le cambiaremos el nombre
            FileReader prelude = new FileReader("code/prelude.wat");
            prelude.transferTo(code);
            prelude.close();

            // hacemos el premain
            preMaingenerateCode();

            // generamos el resto de funciones
            definitionList.generateCode();

            // aqui no sabemos muy bien que hay que poner

            FileReader epilogue = new FileReader("code/epilogue.wat");
            epilogue.transferTo(code);
            epilogue.close();

            code.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFileName(String file) {
        fileName = file;
    }

    public static DefinitionList getDefinitionList() {
        return definitionList;
    }

    public static PrintWriter getCode() {
        return code;
    }

    public void typedef(List<DTypedef> typedefs) {
        definitionList.typedefs();
    }

    public void imports() throws ImportException {
        List<DImport> imports = definitionList.getImports();
        try{
            for(int i = 0; i < imports.size(); i++){
                Reader input = new InputStreamReader(new FileInputStream(imports.get(i).getModuleName()));
                AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
                AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
                Program pImport = (Program) asint.parse().value; //con esto tenemos el nuevo arbol del archivo import
                if(pImport.getDefinitionList().thereIsMain()){
                    throw new ImportException("Error. There is a main in import file.");
                }
                definitionList.addAll(pImport.getDefinitionList());
            }   
        }catch(Exception e){
            throw new ImportException("Error in import.");
        }
    }
}
