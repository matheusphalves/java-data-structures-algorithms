package com.datastructures.collection.playground;

import com.datastructures.collection.api.Set;
import com.datastructures.collection.impl.HashSetClosedAddressingImpl;

public class HashSetClosedAddressingTest {

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSetClosedAddressingImpl<>();

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(20);

        hashSet.remove(20);

        int x = 0;
    }
}
