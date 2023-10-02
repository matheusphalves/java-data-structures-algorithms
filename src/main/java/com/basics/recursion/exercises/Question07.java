package com.basics.recursion.exercises;

import java.util.Arrays;

public class Question07 {


    public static int[] inverseSequence(int[] elements, int currentIndex){
        if(currentIndex == elements.length)
            return new int[elements.length];

        int[] invertedSequence = inverseSequence(elements, currentIndex + 1);

        invertedSequence[(elements.length -1) - currentIndex] = elements[currentIndex];

        return invertedSequence;
    }

    public static void main(String[] args) {

        int[] elements = {1, 2, 3, -5};
        Arrays.stream(inverseSequence(elements, 0)).forEach(System.out::println);

    }
}
