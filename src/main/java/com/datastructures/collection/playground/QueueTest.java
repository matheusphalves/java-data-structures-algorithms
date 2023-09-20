package com.datastructures.collection.playground;

import com.datastructures.collection.api.Queue;
import com.datastructures.collection.impl.QueueImpl;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> numbers = new QueueImpl<>();

        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);
        numbers.enqueue(4);

        System.out.println("Dequeue: " + numbers.dequeue());
        System.out.println("Dequeue: " + numbers.dequeue());
        System.out.println("Dequeue: " + numbers.dequeue());
        System.out.println("Dequeue: " + numbers.dequeue());
        System.out.println("Dequeue: " + numbers.dequeue());


        numbers.enqueue(2023);
        numbers.enqueue(2024);
        System.out.println("Dequeue: " + numbers.dequeue());


    }
}
