#!/bin/bash

cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd ..   
javac -cp "../cup.jar:." */*.java

# Iterar sobre todos los archivos en la carpeta ejemplos/
for archivo in ../ejemplos/*; do
    # Verificar si el archivo es un archivo regular
    if [ -f "$archivo" ]; then
        echo "--------------------------------------"
        echo "Estoy probando ahora con el archivo $archivo"
        # Ejecutar el analizador sintáctico para el archivo actual
        java -cp "../cup.jar:." asint.Main "$archivo"
        cd code
        wat2wasm 1.wat
        node main.js
        cd ..
    fi
done