#!/bin/bash

cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd ..   
javac -cp "../cup.jar:." */*.java

# java -cp "../cup.jar:." asint.Main  ../examples/00_basic.txt
java -cp "../cup.jar:." asint.Main  examples/26_imports.txt

cd code/examplesCode
wat2wasm 26_imports.wat
cd ..
node main.js
# cd .. 