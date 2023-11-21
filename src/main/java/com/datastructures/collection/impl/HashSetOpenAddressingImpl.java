package com.datastructures.collection.impl;

import com.datastructures.collection.api.Set;

public class HashSetOpenAddressingImpl  <T> implements Set<T> {


    private Object[] table;

    private final float LOAD_FACTOR = 0.75f;

    private final int INITIAL_CAPACITY;

    private int size;

    public HashSetOpenAddressingImpl(int initialCapacity) {

        if(initialCapacity <= 0)
            throw new IllegalArgumentException("Table capacity should be greater than zero: " + initialCapacity);

        INITIAL_CAPACITY = initialCapacity;
        table = new Object[INITIAL_CAPACITY];
    }

    private boolean isLoadFactorExceeded(){
        return (double) size / table.length > LOAD_FACTOR;
    }

    private int getHash(T element) {
        return Math.abs(element.hashCode()) % table.length;
    }

    @Override
    public void add(T element) {

        if(contains(element))
            return;

        if(isLoadFactorExceeded())
            resizeTable();

        addToTable(element);

    }

    private void addToTable(T element) {
        int index = getHash(element);

        while(table[index] != null){
            index = (index + 1) % table.length;
        }

        table[index] = element;
        size++;
    }

    private void resizeTable(){

        Object[] oldTable = table;

        table = new Object[table.length * 2];

        for(Object entry: oldTable){

            if(entry == null)
                continue;

            T element = (T) entry;
            addToTable(element);
        }

    }

    @Override
    public boolean remove(T element) {

        int index = getHash(element);
        int checkedElements = 0;

        while(checkedElements < table.length) {

            if(table[index] !=null && table[index].equals(element)){
                table[index] = null;
                size--;
                return true;
            }

            index = (index + 1) % table.length;
            checkedElements++;
        }

        return false;
    }

    @Override
    public void clear() {
        table = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(T element) {

        int index = getHash(element);
        int checkedElements = 0;

        while(checkedElements < table.length){
            if(table[index] !=null && table[index].equals(element))
                return true;

            index = (index + 1) % table.length;
            checkedElements++;
        }

        return false;
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
