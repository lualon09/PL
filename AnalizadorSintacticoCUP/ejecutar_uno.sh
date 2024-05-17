#!/bin/bash

cd alex
java -cp ../../jflex.jar jflex.Main AnalizadorLexicoTiny.l

cd ..

cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd ..   
javac -cp "../cup.jar:." */*.java

java -cp "../cup.jar:." asint.Main "examples/07_arrays.txt"