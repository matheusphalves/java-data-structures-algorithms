package com.datastructures.collection.playground;

import com.datastructures.collection.api.List;
import com.datastructures.collection.impl.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        List<Integer> numeros = new LinkedList<>();

        numeros.add(3);
        numeros.add(2);
        numeros.add(1);

        System.out.println("Tamanho da lista antes da remoção: " + numeros.size());
        numeros.remove(10);

        System.out.println("Tamanho da lista após remoção: " + numeros.size());

    }
}
