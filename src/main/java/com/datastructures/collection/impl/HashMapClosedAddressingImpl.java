package com.datastructures.collection.impl;

import com.datastructures.collection.Entry;
import com.datastructures.collection.api.Map;
import com.datastructures.collection.api.Set;

public class HashMapClosedAddressingImpl <K, V> implements Map<K, V> {


    private final int DEFAULT_CAPACITY = 5;

    private LinkedListImpl<Entry<K, V>>[] hashTable;

    private final float LOAD_FACTOR = 0.75f;

    private int size;

    public HashMapClosedAddressingImpl(){
        initHashMap();
    }


    private boolean isLoadFactorExceeded() {
        return (double) size / hashTable.length > LOAD_FACTOR;
    }


    @Override
    public V put(K key, V value) {

        if(isLoadFactorExceeded())
            resizeTable();

        return addOrUpdateToTable(key, value);

    }

    private int getHash(K key){
        return Math.abs(key.hashCode()) % hashTable.length;
    }

    private V addOrUpdateToTable(K key, V value){

        int index = getHash(key);

        while(hashTable[index] != null){
            index = (index + 1) % hashTable.length;
        }

        Entry<K, V> entry = new Entry<>(key, value);

        if(hashTable[index].contains(entry))
            hashTable[index].remove(entry);

        hashTable[index].add(entry);
        size++;

        return entry.getValue();
    }

    private void resizeTable(){
        LinkedListImpl<Entry<K, V>>[] oldHashTable = hashTable;

        hashTable = new LinkedListImpl[hashTable.length * 2];
        size = 0;

        for(LinkedListImpl<Entry<K, V>> entries: oldHashTable){
            if(entries == null)
                continue;

            for(Entry<K, V> element: entries.toArray()){
                addOrUpdateToTable(element.getKey(), element.getValue());
            }
        }
    }

    @Override
    public V get(K key) {

        int index = getHash(key);

        for(Entry<K, V> entry: hashTable[index].toArray()){

            if(entry != null && entry.getKey().equals(key))
                return entry.getValue();
        }

        return null;
    }

    @Override
    public V remove(K key) {

        int index = getHash(key);

        for(Entry<K, V> entry: hashTable[index].toArray()){

            if(entry != null && entry.getKey().equals(key)){
                hashTable[index].remove(entry);
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {

        int index = getHash(key);

        for(Entry<K, V> entry: hashTable[index].toArray()) {

            if(entry != null && entry.getKey().equals(key))
                return true;
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {

        for(LinkedListImpl<Entry<K, V>> tableItems: hashTable){
            for(Entry<K, V> entry: tableItems.toArray()){

                if(entry != null && entry.getValue().equals(value))
                    return true;
            }
        }

        return false;
    }

    @Override
    public Set<K> keySet() {

        Set<K> set = new HashSetClosedAddressingImpl<>();

        for(LinkedListImpl<Entry<K, V>> tableItems: hashTable){

            for(Entry<K, V> entry: tableItems.toArray()){
                if(entry != null)
                    set.add(entry.getKey());
            }
        }

        return set;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K, V>> set = new HashSetClosedAddressingImpl<>();

        for(LinkedListImpl<Entry<K, V>> tableItems: hashTable){

            for(Entry<K, V> entry: tableItems.toArray()){
                if(entry != null)
                    set.add(entry);
            }
        }

        return set;
    }

    @Override
    public int size() {
        return size;
    }

    private void initHashMap(){

        hashTable = new LinkedListImpl[DEFAULT_CAPACITY];

        for(int index = 0; index< hashTable.length; index++){
            hashTable[index] = new LinkedListImpl<>();
        }

        size = 0;
    }
}
