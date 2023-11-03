package com.datastructures.collection.playground;

import com.datastructures.collection.api.Tree;
import com.datastructures.collection.impl.BinaryTreeImpl;

public class BinaryTreeTest {

    public static void main(String[] args) {

        Tree<Integer> numbers = new BinaryTreeImpl<>();

        numbers.add(8);
        numbers.add(3);
        numbers.add(10);
        numbers.add(1);
        numbers.add(6);
        numbers.add(14);
        numbers.add(4);
        numbers.add(7);
        numbers.add(13);
        int x = 0;
    }
}
