package com.datastructures.collection.api;

import com.datastructures.collection.TreeNode;

public interface Tree <T extends Comparable<T>> {

    public void add(T element);

    public List<T> inOrder();

    public List<T> preOrder();

    public List<T> postOrder();

    public boolean isEmpty();

    public TreeNode<T> search(T element);

    public int nodeDepth(T element);

    public int getTreeHeight();


}
