#!/bin/bash

cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd ..   
javac -cp "../cup.jar:." */*.java

# java -cp "../cup.jar:." asint.Main  ../examples/00_basic.txt
java -cp "../cup.jar:." asint.Main  examples/26_imports.txt

# cd code
# wat2wasm code.wat
# node main.js
# cd .. 