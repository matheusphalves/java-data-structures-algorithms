package com.datastructures.collection.impl;

import com.datastructures.collection.api.Set;

import java.util.Iterator;

public class HashSetOpenAddressingImpl <T> implements Set<T> {

    private Object[] table;

    // TODO implement resize based on LOAD_FACTOR

    private final int MAX_CAPACITY;

    private int size;

    public HashSetOpenAddressingImpl(int capacity){
        MAX_CAPACITY = capacity;
        table = new Object[MAX_CAPACITY];
    }

    @Override
    public boolean add(T element) {

        int index = getHash(element);

        while(table[index] != null){
            index = (index + 1) % table.length;
        }

        table[index] = element;
        size++;

        return false;
    }

    private int getHash(T element){
        return Math.abs(element.hashCode()) % table.length;
    }

    @Override
    public boolean remove(T element) {

        int index = getHash(element);

        while(table[index] != null){

            if(table[index].equals(element)){
                table[index] = null;
                size--;
                return true;
            }
            index = (index + 1) % table.length;
        }

        return false;
    }

    @Override
    public void clear() {
        table = new Object[MAX_CAPACITY];
    }

    @Override
    public boolean contains(T element) {

        int index = getHash(element);

        while (table[index] != null) {
            if (table[index].equals(element)) {
                return true;
            }
            index = (index + 1) % table.length;
        }

        return false;
    }

    @Override
    public int size() {
        return table.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
