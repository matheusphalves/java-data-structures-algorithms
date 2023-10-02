package com.basics.recursion.exercises;

public class Question05 {

    public static int sumArrayElements(int[] elements, int currentIndex){

        if(currentIndex == elements.length)
            return 0;

        return elements[currentIndex] + sumArrayElements(elements, currentIndex + 1);
    }

    public static void main(String[] args) {

        int[] elements = {2, 5, -20, 7, 100, 1, -14, 78, 30, 0};

        System.out.println("Soma dos elementos: " + sumArrayElements(elements, 0));

    }

}
