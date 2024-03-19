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

# Iterar sobre todos los archivos en la carpeta ejemplos/
for archivo in ../ejemplos/*; do
    # Verificar si el archivo es un archivo regular
    if [ -f "$archivo" ]; then
        echo "Estoy probando ahora con el archivo $archivo"
        # Ejecutar el analizador sintáctico para el archivo actual
        java -cp ".:../cup.jar" asint.Main "$archivo"
    fi
done
