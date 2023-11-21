package com.datastructures.collection.impl;

import com.datastructures.collection.api.Map;
import com.datastructures.collection.api.Set;
import com.datastructures.collection.internal.map.Entry;

public class HashMapOpenAddressingImpl
        <K, V> implements Map<K, V> {


    private Entry<K, V>[] table;

    private final float LOAD_FACTOR = 0.75f;

    private final int INITIAL_CAPACITY;

    private int size;

    public HashMapOpenAddressingImpl(int initialCapacity) {

        if(initialCapacity <= 0)
            throw new IllegalArgumentException(
                    "Table capacity should be greater than zero: " + initialCapacity);

        this.INITIAL_CAPACITY = initialCapacity;
        table = new Entry[INITIAL_CAPACITY];

    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    @Override
    public V put(K key, V value) {

        if(isLoadFactorExceeded())
            resizeTable();

        return addOrUpdateToTable(key, value);
    }

    private boolean isLoadFactorExceeded(){
        return (double) size / table.length > LOAD_FACTOR;
    }

    private void resizeTable(){
        Entry<K, V>[] oldTable = table;

        table = new Entry[table.length * 2];
        size = 0;

        for(Entry<K, V> entry: oldTable) {
            if(entry != null)
                addOrUpdateToTable(entry.getKey(), entry.getValue());
        }

    }

    private V addOrUpdateToTable(K key, V value) {

        int index = getHash(key);
        Entry<K, V> entry = new Entry<>(key, value);

        while(table[index] != null) {

            if(table[index].getKey().equals(key)) {
                table[index] = entry;
                size++;
                return table[index].getValue();
            }

            index = (index + 1) % table.length;
        }

        table[index] = entry;
        size++;

        return table[index].getValue();

    }

    @Override
    public V get(K key) {

        int index = getHash(key);
        int checkedElements = 0;

        while(checkedElements < table.length){

            if(table[index] != null && table[index].getKey().equals(key))
                return table[index].getValue();

             index = (index + 1) % table.length;
             checkedElements++;
        }

        return null;
    }

    @Override
    public V remove(K key) {

        int index = getHash(key);
        int checkedElements = 0;

        while(checkedElements < table.length) {

            if(table[index] != null && table[index].getKey().equals(key)){
                Entry<K, V> entry = table[index];
                table[index] = null;
                size--;
                return entry.getValue();
            }

            index = (index + 1) % table.length;
            checkedElements++;
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {

        int index = getHash(key);
        int checkedElements = 0;

        while(checkedElements < table.length) {

            if(table[index] != null && table[index].getKey().equals(key))
                return true;

            index = (index + 1) % table.length;
            checkedElements++;
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {

        for (Entry<K, V> entry: table) {
            if(entry != null && entry.getValue().equals(value))
                return true;
        }

        return false;
    }

    @Override
    public Set<K> keySet() {

        Set<K> keySet = new HashSetOpenAddressingImpl<>(size);

        for(Entry<K, V> entry: table) {
            if(entry != null)
                keySet.add(entry.getKey());
        }

        return keySet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K, V>> entrySet = new HashSetOpenAddressingImpl<>(size);

        for(Entry<K, V> entry: table) {
            if(entry != null)
                entrySet.add(entry);
        }

        return entrySet;
    }

    @Override
    public int size() {
        return size;
    }
}
