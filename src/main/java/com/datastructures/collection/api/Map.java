package com.datastructures.collection.api;

import com.datastructures.collection.Entry;

public interface Map <K, V> {

    V put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

    Set<K> keySet();

    Set<Entry<K, V>> entrySet();

    int size();

}
