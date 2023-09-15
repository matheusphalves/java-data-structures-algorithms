package com.datastructures.collection.api;

public interface Stack <T> {

    boolean empty();

    T peek();

    T pop();

    T push(T element);

    int search(T element);
}
