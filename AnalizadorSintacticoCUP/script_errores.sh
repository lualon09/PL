cd asint
java -cp ../../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
cd .. 
javac -cp "../cup.jar:." */*.java 

echo "Voy a correr ../ejemplos/22_errores_sintax.txt"
java -cp "../cup.jar:." asint.Main  ../ejemplos/22_errores_sintax.txt
