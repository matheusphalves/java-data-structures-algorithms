package com.datastructures.collection.api;

public interface Queue <T> {

    void enqueue(T element);
    T dequeue();
    T peek();
    int size();

}
