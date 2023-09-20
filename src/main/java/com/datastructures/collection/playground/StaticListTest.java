package com.datastructures.collection.playground;

import com.datastructures.collection.api.List;
import com.datastructures.collection.impl.StaticList;

public class StaticListTest {
    public static void main(String[] args) {
        List<Integer> numeros = new StaticList<>(5);

        numeros.add(1);
        numeros.add(2);
        numeros.add(6);
        numeros.add(3);
        numeros.add(4);


//        System.out.println("Index of: " + numeros.indexOf(1));
//        System.out.println("Index of: " + numeros.indexOf(3));
//        System.out.println("Index of: " + numeros.indexOf(6));
//        System.out.println("Index of: " + numeros.indexOf(4));
//        System.out.println("Contains: " + numeros.contains(4));
//        System.out.println("Contains: " + numeros.contains(1000));
//        System.out.println("Contains: " + numeros.contains(2));

        numeros.remove(1);
        numeros.remove(2);
        numeros.remove(6);
        numeros.remove(3);
        numeros.remove(4);

        numeros.add(20);

        int x = 0;


    }
}
