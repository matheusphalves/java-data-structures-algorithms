package com.datastructures.collection.playground;

import com.datastructures.collection.api.Map;
import com.datastructures.collection.impl.HashMapOpenAddressingImpl;

public class HashMapOpenAddressingTest {

    public static void main(String[] args) {
        Map<Integer, String> pessoas = new HashMapOpenAddressingImpl<>(8);


        pessoas.put(1, "Matheus");
        pessoas.put(2, "João");
        pessoas.put(3, "Maria");
        pessoas.put(4, "Alfredo");
        pessoas.put(5, "Juan");
        pessoas.put(6, "Fernanda");
        pessoas.put(7, "Christiane");
        pessoas.put(8, "Carlos");

        int x = 0;

    }

}
