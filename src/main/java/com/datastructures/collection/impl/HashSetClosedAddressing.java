package com.datastructures.collection.impl;

import com.datastructures.collection.api.Set;

public class HashSetClosedAddressing <T> implements Set<T> {

    private final int DEFAULT_CAPACITY = 17;

    private int CURRENT_CAPACITY;

    private LinkedListImpl<T>[] table;

    private int size;

    public HashSetClosedAddressing(){
        CURRENT_CAPACITY = DEFAULT_CAPACITY;
        clear();
    }

    @Override
    public boolean add(T element) {

        int index = getHash(element);

        table[index].add(element);

        return true;
    }

    @Override
    public boolean remove(T element) {

        int index = getHash(element);

        if(table[index] == null)
            return false;

        table[index].remove(element);

        return table[index].contains(element);
    }

    private int getHash(T element){
        return Math.abs(element.hashCode()) % CURRENT_CAPACITY;
    }

    @Override
    public void clear() {

        table = new LinkedListImpl[CURRENT_CAPACITY];

        for(int index=0; index<CURRENT_CAPACITY; index++){
            table[index] = new LinkedListImpl<>();
        }

        size = 0;
    }

    @Override
    public boolean contains(T element) {

        int index = getHash(element);

        LinkedListImpl<T> linkedList = table[index];

        if(linkedList == null)
            return false;

        return table[index].contains(element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
