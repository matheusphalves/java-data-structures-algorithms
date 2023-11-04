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

//        System.out.println("Pre Order: " + numbers.preOrder());
//        System.out.println("In Order: " + numbers.inOrder());
//        System.out.println("Post Order: " + numbers.postOrder());
//        System.out.println("Search (6): " + numbers.search(6).getInfo());
//        System.out.println("Search (14): " + numbers.search(14));
//        System.out.println("Search (20): " + numbers.search(20));

        System.out.println("NodeDepth (6): " + numbers.nodeDepth(6));
        System.out.println("NodeDepth (8): " + numbers.nodeDepth(8));
        System.out.println("NodeDepth (14): " + numbers.nodeDepth(14));
        System.out.println("NodeDepth (13): " + numbers.nodeDepth(13));
        System.out.println("NodeDepth (20): " + numbers.nodeDepth(20));
        int x = 0;
    }
}
