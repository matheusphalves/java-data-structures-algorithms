package com.datastructures.collection.playground;

import com.datastructures.collection.api.Stack;
import com.datastructures.collection.impl.StaticStack;

public class StaticStackTest {
    public static void main(String[] args) {
        Stack<Integer> numeros = new StaticStack<>(5);

//        System.out.println("Peek: " + numeros.peek());
//        System.out.println("IsEmpty: " + numeros.empty());

        System.out.println("Elemento adicionado: " + numeros.push(1));
        System.out.println("Elemento adicionado: " + numeros.push(2));
        System.out.println("Elemento adicionado: " + numeros.push(3));

//        System.out.println("Elemento removido: " + numeros.pop());
//        System.out.println("Elemento removido: " + numeros.pop());
//        System.out.println("Elemento removido: " + numeros.pop());
//        System.out.println("Elemento removido: " + numeros.pop());

        System.out.println("Search 1: " + numeros.search(1));
        System.out.println("Search 2: " + numeros.search(2));
        System.out.println("Search 3: " + numeros.search(3));
        System.out.println("Search 45: " + numeros.search(45));

    }
}
