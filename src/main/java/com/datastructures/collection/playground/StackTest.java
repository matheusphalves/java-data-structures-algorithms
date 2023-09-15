package com.datastructures.collection.playground;

import com.datastructures.collection.api.Stack;
import com.datastructures.collection.impl.StackImpl;

public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> notas = new StackImpl<>();

        notas.push(1);
        notas.push(2);
        notas.push(3);
        notas.push(4);

        // 4 -> 3 -> 2 -> 1 -> null

//        System.out.println("Elemento do topo: " + notas.peek());

//        System.out.println("Removendo do topo: " + notas.pop());
//        System.out.println("Removendo do topo: " + notas.pop());
//        System.out.println("Removendo do topo: " + notas.pop());
//        System.out.println("Removendo do topo: " + notas.pop());


        System.out.println("Procurando elemento 1: " + notas.search(1));
        System.out.println("Procurando elemento 2: " + notas.search(2));
        System.out.println("Procurando elemento 3: " + notas.search(3));
        System.out.println("Procurando elemento 4: " + notas.search(4));
        System.out.println("Procurando elemento 5: " + notas.search(5));

    }
}
