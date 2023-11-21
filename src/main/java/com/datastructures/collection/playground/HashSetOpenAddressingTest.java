package com.datastructures.collection.playground;

import com.datastructures.collection.api.Set;
import com.datastructures.collection.impl.HashSetOpenAddressingImpl;

public class HashSetOpenAddressingTest {

    public static void main(String[] args) {
        Set<Integer> elementos = new HashSetOpenAddressingImpl<>(8);


        elementos.add(8);
        elementos.add(12);
        elementos.add(45);
        elementos.add(11);
        elementos.add(19);
        elementos.add(12);

        elementos.add(9);
        elementos.add(-20);
        elementos.add(35);

        elementos.remove(45);
        elementos.remove(-1);
        elementos.remove(19);

        int x = 0;

    }
}
