package com.datastructures.collection.playground;

import com.datastructures.collection.api.Map;
import com.datastructures.collection.impl.HashMapClosedAddressingImpl;

public class HashMapClosedAddressingTest {
    public static void main(String[] args) {
        Map<Integer, String> pessoas = new HashMapClosedAddressingImpl<>();


        pessoas.put(1, "Matheus");
        pessoas.put(2, "Phelipe");
        pessoas.put(3, "Maria");
        pessoas.put(4, "Claudia");


        pessoas.put(11, "Matheus A");
        pessoas.put(12, "Phelipe A");
        pessoas.put(13, "Maria A ");
        pessoas.put(15, "Claudia A");


        pessoas.containsValue("Matheus");

        int x =0;

    }
}
