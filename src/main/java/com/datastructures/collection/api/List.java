package com.datastructures.collection.api;

public interface List <T> {

    void add(T element);

    boolean remove(T element);

    boolean contains(T element);

    int indexOf(T element);

    int size();

    T get(int index);

    void clear();

}
