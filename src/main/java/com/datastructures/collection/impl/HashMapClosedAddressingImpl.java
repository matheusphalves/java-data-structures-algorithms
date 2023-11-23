package com.datastructures.collection.impl;

import com.datastructures.collection.api.Map;
import com.datastructures.collection.api.Set;
import com.datastructures.collection.internal.map.Entry;

public class HashMapClosedAddressingImpl <K, V> implements Map<K, V> {


    private final int DEFAULT_CAPACITY = 8;

    private LinkedListImpl<Entry<K, V>>[] table;

    private float LOAD_FACTOR = 0.75f;

    private int size;

    public HashMapClosedAddressingImpl(){
        initHashMap(DEFAULT_CAPACITY);
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private boolean isLoadFactorExceeded() {
        return (double) size / table.length > LOAD_FACTOR;
    }

    @Override
    public V put(K key, V value) {

        if(isLoadFactorExceeded())
            resizeTable();

        return addOrUpdateToTable(key, value);

    }

    private void resizeTable() {

        LinkedListImpl<Entry<K, V>>[] oldTable = table;
        initHashMap(table.length * 2);

        for(LinkedListImpl<Entry<K, V>> tableItems: oldTable) {
            if(tableItems == null)
                continue;

            for(Entry<K, V> entry: tableItems.toArray(Entry.class))
                addOrUpdateToTable(entry.getKey(), entry.getValue());
        }

    }

    private V addOrUpdateToTable(K key, V value) {

        int index = getHash(key);

        Entry<K, V> entry = new Entry<>(key, value);
        LinkedListImpl<Entry<K, V>> tableItems = table[index];

        if(tableItems.contains(entry))
            tableItems.remove(entry);
        else
            size++;

        tableItems.add(entry);

        return entry.getValue();
    }

    @Override
    public V get(K key) {

        int index = getHash(key);

        for(Entry<K, V > entry: table[index].toArray(Entry.class)) {

            if(entry != null && entry.getKey().equals(key))
                return entry.getValue();
        }

        return null;
    }

    @Override
    public V remove(K key) {

        int index = getHash(key);

        for(Entry<K, V > entry: table[index].toArray(Entry.class)) {

            if(entry != null && entry.getKey().equals(key)) {
                table[index].remove(entry);
                size--;
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {

        int index = getHash(key);

        for(Entry<K, V > entry: table[index].toArray(Entry.class)) {

            if(entry != null && entry.getKey().equals(key))
                return true;
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {

        for(LinkedListImpl<Entry<K, V >> tableItems: table) {

            for(Entry<K, V> entry: tableItems.toArray(Entry.class)) {

                if(entry != null && entry.getValue().equals(value))
                    return true;
            }
        }

        return false;
    }

    @Override
    public Set<K> keySet() {

        Set<K> keySet = new HashSetOpenAddressingImpl<>(size);

        for(LinkedListImpl<Entry<K, V>> tableItems: table) {
            for(Entry<K, V> entry: tableItems.toArray(Entry.class)) {
                if(entry != null)
                    keySet.add(entry.getKey());
            }
        }

        return keySet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSetOpenAddressingImpl<>(size);

        for(LinkedListImpl<Entry<K, V>> tableItems: table) {
            for(Entry<K, V> entry: tableItems.toArray(Entry.class)) {
                if(entry != null)
                    entrySet.add(entry);
            }
        }

        return entrySet;
    }

    @Override
    public int size() {
        return size;
    }

    private void initHashMap(int tableSize) {

        if(tableSize <= 0)
            throw new IllegalArgumentException("Table capacity should be greater than zero: " + tableSize);

        table = new LinkedListImpl[tableSize];
        size = 0;

        for(int index=0; index < table.length; index++)
            table[index] = new LinkedListImpl<>();

    }
}
