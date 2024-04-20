#!/bin/bash

cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd ..   
javac -cp "../cup.jar:." */*.java

java -cp "../cup.jar:." asint.Main  ../ejemplos/21_valor_referencia.txt