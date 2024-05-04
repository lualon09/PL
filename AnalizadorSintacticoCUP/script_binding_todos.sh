#!/bin/bash

cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd ..   
javac -cp "../cup.jar:." */*.java

carpeta="code/examplesCode"

# Iterar sobre los archivos en la carpeta para borrar los wasm.
for archivo in "$carpeta"/*.wasm; do
    if [ -f "$archivo" ]; then
        # Eliminar el archivo
        rm "$archivo"
    fi
done

# Iterar sobre todos los archivos en la carpeta examples/
for archivo in examples/*; do
    # Verificar si el archivo es un archivo regular
    if [ -f "$archivo" ]; then
        echo "--------------------------------------"
        echo "Estoy probando ahora con el archivo $archivo"
        # Ejecutar el analizador sintáctico para el archivo actual
        java -cp "../cup.jar:." asint.Main "$archivo"
        cd code/examplesCode
        nombre_archivo_sin_extension=$(basename $archivo .txt)
        wat2wasm "$nombre_archivo_sin_extension".wat
        cd ..
        node main.js examplesCode/"$nombre_archivo_sin_extension".wasm
        cd ..

    fi
done
