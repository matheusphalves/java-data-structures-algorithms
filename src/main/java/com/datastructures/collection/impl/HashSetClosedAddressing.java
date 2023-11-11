package com.datastructures.collection.impl;

import com.datastructures.collection.api.Set;

public class HashSetClosedAddressing <T> implements Set<T> {

    private final int DEFAULT_CAPACITY = 5;

    private LinkedListImpl<T>[] table;
    private final float LOAD_FACTOR = 0.75f;

    private int size;

    public HashSetClosedAddressing() {
        clear();
    }

    private boolean isLoadFactorExceeded() {
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

    private void addToTable(T element){
        int index = getHash(element);

        if(table[index] == null)
            table[index] = new LinkedListImpl<>();

        table[index].add(element);
        size++;
    }

    private void resizeTable(){

        Object[] oldTable = table;

        table = new LinkedListImpl[table.length * 2];

        size=0;

        for(Object entry: oldTable) {

            if(entry == null)
                continue;

            LinkedListImpl<T> elements = (LinkedListImpl<T>) entry;

            for(T element: elements.toArray()) addToTable(element);

        }
    }

    @Override
    public boolean remove(T element) {

        int index = getHash(element);

        if(table[index] == null)
            return false;

        table[index].remove(element);
        size--;

        return table[index].contains(element);
    }

    private int getHash(T element){
        return Math.abs(element.hashCode()) % table.length;
    }

    @Override
    public void clear() {

        table = new LinkedListImpl[DEFAULT_CAPACITY];

        for(int index=0; index< table.length; index++){
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
