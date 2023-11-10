package com.datastructures.collection.api;

import java.util.Iterator;

public interface Set <T> {

    boolean add(T element);

    boolean remove(T element);

    void clear();

    boolean contains(T element);

    int size();

    boolean isEmpty();

}
