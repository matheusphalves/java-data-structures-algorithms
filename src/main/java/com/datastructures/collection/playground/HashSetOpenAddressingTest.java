package com.datastructures.collection.playground;

import com.datastructures.collection.api.Set;
import com.datastructures.collection.impl.HashSetOpenAddressingImpl;

public class HashSetOpenAddressingTest {

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSetOpenAddressingImpl<>(0);

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(-30);

        hashSet.remove(-30);

        hashSet.clear();

        hashSet.add(4);
        hashSet.add(5);

        int x =0;

    }

}
