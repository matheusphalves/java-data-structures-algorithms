package com.datastructures.collection.impl;

import com.datastructures.collection.api.Map;
import com.datastructures.collection.api.Set;
import com.datastructures.collection.internal.map.Entry;

public class HashMapClosedAddressingImpl <K, V> implements Map<K, V> {


    private final int DEFAULT_CAPACITY = 8;

    private LinkedListImpl<Entry<K, V>>[] table;

    private final float LOAD_FACTOR = 0.75f;

    private int size;

    public HashMapClosedAddressingImpl() {
        clearHashMap(DEFAULT_CAPACITY);
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private boolean isLoadFactorExceeded(){
        return (double) size / table.length > LOAD_FACTOR;
    }

    @Override
    public V put(K key, V value) {

        if(isLoadFactorExceeded())
            resizeTable();

        return addOrUpdateToTable(key, value);
    }

    private void resizeTable(){

        LinkedListImpl<Entry<K, V>> [] oldTable = table;
        clearHashMap(table.length * 2);

        for(LinkedListImpl<Entry<K, V>> entries: oldTable){

            if(entries == null)
                continue;

            for(Entry<K, V> entry: entries.toArray()){
                addOrUpdateToTable(entry.getKey(), entry.getValue());
            }
        }
    }

    private V addOrUpdateToTable(K key, V value) {
        int index = getHash(key);

        Entry<K, V> entry = new Entry<>(key, value);
        LinkedListImpl<Entry<K, V>> slot = table[index];

        if(slot.contains(entry))
            slot.remove(entry);
        else
            size++;

        slot.add(entry);

        return entry.getValue();
    }

    @Override
    public V get(K key) {

        int index = getHash(key);

        for(Entry<K, V> entry: table[index].toArray(Entry.class)) {

            if(entry!= null && entry.getKey().equals(key))
                return entry.getValue();
        }

        return null;
    }

    @Override
    public V remove(K key) {

        int index = getHash(key);

        for(Entry<K, V> entry: table[index].toArray(Entry.class)) {

            if(entry!= null && entry.getKey().equals(key)){
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

        for(Entry<K, V> entry: table[index].toArray(Entry.class)) {

            if(entry!= null && entry.getKey().equals(key))
                return true;
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {

        for (LinkedListImpl<Entry<K, V>> tableItems: table) {

            for(Entry<K, V> entry: tableItems.toArray(Entry.class)){
                if(entry != null && entry.getValue().equals(value))
                    return true;
            }
        }

        return false;
    }

    @Override
    public Set<K> keySet() {

        Set<K> keySet = new HashSetOpenAddressingImpl<>(size);

        for (LinkedListImpl<Entry<K, V>> tableItems: table) {

            for(Entry<K, V> entry: tableItems.toArray(Entry.class)){
                if(entry != null)
                    keySet.add(entry.getKey());
            }

        }

        return keySet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K, V>> entrySet = new HashSetOpenAddressingImpl<>(size);

        for (LinkedListImpl<Entry<K, V>> tableItems: table) {

            for(Entry<K, V> entry: tableItems.toArray(Entry.class)) {
                if (entry != null)
                    entrySet.add(entry);
            }
        }

        return entrySet;
    }

    @Override
    public int size() {
        return size;
    }

    private void clearHashMap(int tableSize) {

        table = new LinkedListImpl[tableSize];
        size = 0;

        for(int index=0; index < table.length; index++)
            table[index] = new LinkedListImpl<>();

    }
}
