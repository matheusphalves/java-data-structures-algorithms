package com.datastructures.collection.playground;

import com.datastructures.collection.api.Queue;
import com.datastructures.collection.impl.StaticQueueImpl;

public class StaticQueueTest {

    public static void main(String[] args) {
        Queue<Integer> numeros = new StaticQueueImpl<>(5);

        numeros.enqueue(1);
        numeros.enqueue(2);
        numeros.enqueue(3);
        numeros.enqueue(4);
        numeros.enqueue(5);

        System.out.println("Dequeue: " + numeros.dequeue());
        System.out.println("Dequeue: " + numeros.dequeue());
        System.out.println("Dequeue: " + numeros.dequeue());
        System.out.println("Dequeue: " + numeros.dequeue());
        System.out.println("Dequeue: " + numeros.dequeue());
        System.out.println("Dequeue: " + numeros.dequeue());

        int x = 0;
    }
}
