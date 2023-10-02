package com.datastructures.collection;

public class TreeNode <T extends Comparable<T>>{

    private  T info;

    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    public TreeNode(T info){
        this.info = info;
    }

    public TreeNode(T info, TreeNode<T> leftNode, TreeNode<T> rightNode){
        this.info = info;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }
}
