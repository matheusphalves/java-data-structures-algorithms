package com.datastructures.collection.api;

public interface Set  <T> {

    void add(T element);

    boolean remove(T element);

    void clear();

    boolean contains(T element);

    int size();

    boolean isEmpty();

}
