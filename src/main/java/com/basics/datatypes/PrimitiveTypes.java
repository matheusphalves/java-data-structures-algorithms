package com.basics.datatypes;

import java.util.HashMap;

public class PrimitiveTypes {

    public static void main(String[] args) {

        // Lógicos
        boolean isStudent = true;

        // Literais
        char letter = 'Z';

        // Inteiros
        byte mathGrade = 127;
        short numberOfClasses = 25 + 50;
        int studentAge = 20 * 10;
        long dollars = 1000L;

        // Reais
        float moneyAmount = 1.50f;
        double bookPrice = 199.0;

        System.out.println("Lógico: ");
        System.out.println("boolean: " + (isStudent && letter=='Z'));
        System.out.println("Inteiros: ");
        System.out.println("char: " + letter);
        System.out.println("byte: " + mathGrade);
        System.out.println("short: " + numberOfClasses);
        System.out.println("int: " + studentAge);
        System.out.println("long: " + dollars);
        System.out.println("Reais: ");
        System.out.println("float: " + moneyAmount);
        System.out.println("double: " + bookPrice);


    }
}
