package com.datastructures.collection.impl;

import com.datastructures.collection.Entry;
import com.datastructures.collection.api.Map;
import com.datastructures.collection.api.Set;

public class HashMapOpenAddressingImpl <K, V> implements Map<K, V> {

    private Entry<K, V>[] hashTable;

    private final float LOAD_FACTOR = 0.75f;

    private int size;

    @Override
    public V put(K key, V value) {

        if(isLoadFactorExceeded())
            resizeTable();

        return addToTable(key, value);
    }

    private V addToTable(K key, V value){

        int index = getHash(key);

        while(hashTable[index] != null){
            index = (index + 1) % hashTable.length;
        }

        hashTable[index] = new Entry<>(key, value);
        size++;

        return hashTable[index].getValue();
    }

    private void resizeTable(){
        Entry<K, V>[] oldHashTable = hashTable;

        hashTable = new Entry[hashTable.length * 2];
        size = 0;

        for(Entry<K, V> entry: oldHashTable){
            if(entry == null)
                continue;

            addToTable(entry.getKey(), entry.getValue());
        }
    }


    private int getHash(K key){
        return Math.abs(key.hashCode()) % hashTable.length;
    }

    private boolean isLoadFactorExceeded() {
        return (double) size / hashTable.length > LOAD_FACTOR;
    }

    public V get(K key) {
        int index = getHash(key);

        while (hashTable[index] != null) {
            if (hashTable[index].getKey().equals(key)) {
                return hashTable[index].getValue();
            }
            index = (index + 1) % hashTable.length;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int index = getHash(key);

        while (hashTable[index] != null) {
            if (hashTable[index].getKey().equals(key)) {
                V value = hashTable[index].getValue();
                hashTable[index] = null;
                size--;
                return value;
            }
            index = (index + 1) % hashTable.length;
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {

        int index = getHash(key);

        while(hashTable[index] != null){

            if(hashTable[index].getKey().equals(key))
                return true;

            index = (index + 1) % hashTable.length;
        }

        return false;

    }

    @Override
    public boolean containsValue(V value) {

        for(Entry<K, V> entry: hashTable){

            if(entry != null && entry.getValue().equals(value))
                return true;
        }

        return false;

    }

    @Override
    public Set<K> keySet() {

        Set<K> keySet = new HashSetOpenAddressingImpl<>(size);

        for(Entry<K, V> entry: hashTable){

            if(entry == null) continue;

            keySet.add(entry.getKey());
        }

        return keySet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K, V>> entrySet = new HashSetOpenAddressingImpl<>(size);

        for(Entry<K, V> entry: hashTable){

            if(entry == null) continue;

            entrySet.add(entry);
        }

        return entrySet;
    }

    @Override
    public int size() {
        return size;
    }
}
