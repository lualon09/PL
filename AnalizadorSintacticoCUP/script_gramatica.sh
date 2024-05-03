#!/bin/bash

cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd ..   
javac -cp "../cup.jar:." */*.java

java -cp "../cup.jar:." asint.Main  ../ejemplos/00_basic.txt

# cd code
# wat2wasm code.wat
# node main.js
# cd .. 