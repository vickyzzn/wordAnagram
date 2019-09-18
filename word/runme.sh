#!/bin/bash
javac Main.java
java Main input1.txt > output1.txt
if ["$(diff -w output1.txt output_1.txt)" = ""]
then
	echo "test 1 passed!"
fi
java Main input2.txt > output2.txt
if ["$(diff -w output2.txt output_2.txt)" = ""]
then
        echo "test 2 passed!"
fi
java Main input3.txt > output3.txt
if ["$(diff -w output3.txt output_3.txt)" = ""]
then
        echo "test 3 passed!"
fi


