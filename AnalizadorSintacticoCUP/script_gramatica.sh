#!/bin/bash

cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd ..   
javac -cp "../cup.jar:." */*.java

java -cp "../cup.jar:." asint.Main  ../ejemplos/25_producto_matrices.txt

cd code
wat2wasm 1.wat
node main.js
cd .. 