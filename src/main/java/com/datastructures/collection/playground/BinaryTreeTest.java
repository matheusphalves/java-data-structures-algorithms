package com.datastructures.collection.playground;

import com.datastructures.collection.api.Tree;
import com.datastructures.collection.impl.BinaryTreeImpl;

public class BinaryTreeTest {

    public static void main(String[] args) {
        Tree<Integer> numeros = new BinaryTreeImpl<>();

        numeros.add(8);
        numeros.add(3);
        numeros.add(10);
        numeros.add(1);
        numeros.add(6);
        numeros.add(14);
        numeros.add(4);
        numeros.add(7);
        numeros.add(13);
        numeros.add(12);
        numeros.add(5);

        System.out.println(numeros.search(50));
        System.out.println("Altura da árvore: " + numeros.getTreeHeight());
        System.out.println("Profundidade do nó: " + numeros.getNodeDepth(5));
        System.out.println(numeros.inOrder().toString());
        System.out.println(numeros.preOrder());
        System.out.println(numeros.postOrder());
    }
}
