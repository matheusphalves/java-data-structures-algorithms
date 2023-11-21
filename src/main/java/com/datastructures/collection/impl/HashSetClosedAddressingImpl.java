package com.datastructures.collection.impl;

import com.datastructures.collection.api.Set;

public class HashSetClosedAddressingImpl <T> implements Set<T> {

    private final int DEFAULT_CAPACITY = 8;

    private LinkedListImpl<T>[] table;

    private float LOAD_FACTOR = 0.75f;

    private int size;

    public HashSetClosedAddressingImpl(){
        clear();
    }

    private int getHash(T element){
        return Math.abs(element.hashCode()) % table.length;
    }

    private boolean isLoadFactorExceeded(){
        return (double) size / table.length > LOAD_FACTOR;
    }

    @Override
    public void add(T element) {

        if(contains(element))
            return;

        if(isLoadFactorExceeded())
            resizeTable();

        addToTable(element);

    }

    private void resizeTable() {

        Object[] oldTable = table;

        table = new LinkedListImpl[table.length * 2];

        size = 0;

        for(Object entry: oldTable){

            if(entry == null)
                continue;

            LinkedListImpl<T> elements = (LinkedListImpl<T>) entry;
            for(T element: elements.toArray()) addToTable(element);
        }

    }

    private void addToTable(T element) {

        int index = getHash(element);

        if(table[index] == null)
            table[index] = new LinkedListImpl<>();


        table[index].add(element);
        size++;
    }

    @Override
    public boolean remove(T element) {

        int index = getHash(element);

        if(table[index] == null)
            return false;

        if(table[index].contains(element)){
            table[index].remove(element);
            size--;
            return true;
        }

        return false;
    }

    @Override
    public void clear() {

        table = new LinkedListImpl[DEFAULT_CAPACITY];

        for(int index=0; index < table.length; index++) {
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

        return linkedList.contains(element);
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
