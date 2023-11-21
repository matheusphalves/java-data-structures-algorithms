package com.datastructures.collection.playground;

import com.datastructures.collection.api.Set;
import com.datastructures.collection.impl.HashSetClosedAddressingImpl;

public class HashSetClosedAddressingTest {

    public static void main(String[] args) {
        Set<Integer> elementos = new HashSetClosedAddressingImpl<>();

        elementos.add(8);
        elementos.add(45);
        elementos.add(11);
        elementos.add(21);
        elementos.add(93);

        elementos.add(100);
        elementos.add(20);
        elementos.add(-2);
        elementos.add(5);

        int x = 0;
    }
}
