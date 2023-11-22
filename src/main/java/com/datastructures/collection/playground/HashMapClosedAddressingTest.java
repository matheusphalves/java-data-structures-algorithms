package com.datastructures.collection.playground;

import com.datastructures.collection.api.Map;
import com.datastructures.collection.impl.HashMapClosedAddressingImpl;

public class HashMapClosedAddressingTest {

    public static void main(String[] args) {
        Map<Integer, String> pessoas = new HashMapClosedAddressingImpl<>();

        pessoas.put(1, "Matheus");
        pessoas.put(2, "João");
        pessoas.put(2, "João Alves");
        pessoas.put(3, "Maria");

        pessoas.get(3);

        int x =0;


    }
}
