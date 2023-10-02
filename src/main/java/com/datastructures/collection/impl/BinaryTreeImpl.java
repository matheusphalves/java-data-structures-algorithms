package com.datastructures.collection.impl;

import com.datastructures.collection.TreeNode;
import com.datastructures.collection.api.Tree;

public class TreeImpl<T extends Comparable<T>> implements Tree<T> {

    private TreeNode<T> rootNode;
    @Override
    public void add(T element) {

        TreeNode<T> newNode = new TreeNode<>(element);

        if(rootNode==null){
            this.rootNode = newNode;
        }else{

        }

    }
}
