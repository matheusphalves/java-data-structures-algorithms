package com.basics.datatypes;

import java.util.ArrayList;
import java.util.List;

public class WrapperClasses {

    public static void main(String[] args) {


        List<Integer> prices = new ArrayList<>();


        int age = 5;

        byte studentClasses = 0;
        Byte studentClassesWrapper = null;

        studentClassesWrapper = Byte.valueOf("2");

        Integer ageWrapper = Integer.valueOf(age);

        System.out.println("Student Classes: " + studentClasses);
        System.out.println("Student Classes Wrapper: " + studentClassesWrapper);
//        System.out.println("Variável primitiva: " + age);
//        System.out.println("Variável wrapper: " + ageWrapper);
//        System.out.println("Comparação entre inteiros (-1): " + ageWrapper.compareTo(6));
//        System.out.println("Comparação entre inteiros (0): " + ageWrapper.compareTo(Integer.valueOf("5")));
//        System.out.println("Comparação entre inteiros (1): " + ageWrapper.compareTo(4));

//        -1 ageWrapper < 6
//        0 ageWrapper == 5
//        1 ageWrapper > 4
    }
}
