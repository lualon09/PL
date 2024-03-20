#!/bin/bash

# Ejecutar JFlex
java -cp jflex.jar jflex.Main AnalizadorLexicoTiny.l

# Ejecutar CUP
java -cp cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup

# Cambiar al directorio del analizador sintáctico CUP
cd AnalizadorSintacticoCUP

# Mover los archivos generados a las carpetas correspondientes
mv ../AnalizadorSintacticoTiny.java asint/
mv ../ClaseLexica.java asint/
mv ../AnalizadorLexicoTiny.java alex/

# Compilar archivos java generados por CUP
javac -cp "../cup.jar" */*.java

# Ejecutar el analizador sintáctico
java -cp ".:../cup.jar" asint.Main ../ejemplos/06_punteros.txt
