package com.datastructures.collection.impl;

import com.datastructures.collection.TreeNode;
import com.datastructures.collection.api.List;
import com.datastructures.collection.api.Tree;

public class BinaryTreeImpl
        <T extends Comparable<T>> implements Tree<T> {

    private TreeNode<T> root;

    @Override
    public void add(T element) {

        TreeNode<T> newNode = new TreeNode<>(element);

        if(root == null) {
            root = newNode;

        } else {

            TreeNode<T> auxNode = root;

            while(auxNode != null){

                T info = auxNode.getInfo();

                if(element.compareTo(info) == 0)
                    break;

                if(element.compareTo(info) > 0){
                    if(auxNode.getRightNode() == null){
                        auxNode.setRightNode(newNode);
                        break;
                    }

                    auxNode = auxNode.getRightNode();

                }else{

                    if(auxNode.getLeftNode() == null){
                        auxNode.setLeftNode(newNode);
                        break;
                    }

                    auxNode = auxNode.getLeftNode();
                }
            }
        }

    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getTreeHeight() {
        return evaluateTreeHeight(root, -1);
    }

    private int evaluateTreeHeight(TreeNode<T> node, int depthCounter){

        if(node == null)
            return depthCounter;

        int leftDepth = evaluateTreeHeight(node.getLeftNode(), depthCounter + 1);
        int rightDepth = evaluateTreeHeight(node.getRightNode(), depthCounter + 1);

        return Math.max(leftDepth, rightDepth);

    }

    @Override
    public int nodeDepth(T element) {
        return evaluateNodeDepth(root, element, 0);
    }

    private int evaluateNodeDepth(TreeNode<T> node, T element, int depthCounter){

        if(node == null)
            return -1;

        int comparingResult = element.compareTo(node.getInfo());

        if(comparingResult == 0)
            return depthCounter;
        else if (comparingResult > 0)
            return evaluateNodeDepth(node.getRightNode(), element, depthCounter + 1);
        else
            return evaluateNodeDepth(node.getLeftNode(), element, depthCounter + 1);

    }

    @Override
    public TreeNode<T> search(T element) {
        return binarySearch(root, element);
    }

    private TreeNode<T> binarySearch(TreeNode<T> node, T element) {

        if(node == null)
            return null;

        int comparingResult = element.compareTo(node.getInfo());

        if(comparingResult == 0)
            return node;
        else if (comparingResult > 0)
            return binarySearch(node.getRightNode(), element);
        else
            return binarySearch(node.getLeftNode(), element);

    }

    @Override
    public List<T> preOrder() {

        List<T> preOrderElements = new LinkedListImpl<>();

        preOrderNavigator(root, preOrderElements);

        return preOrderElements;
    }

    private void preOrderNavigator(TreeNode<T> rootNode, List<T> elements) {

        if(rootNode == null)
            return;

        elements.add(rootNode.getInfo());

        preOrderNavigator(rootNode.getLeftNode(), elements);

        preOrderNavigator(rootNode.getRightNode(), elements);

    }

    @Override
    public List<T> inOrder() {

        List<T> inOrderElements = new LinkedListImpl<>();

        inOrderNavigator(root, inOrderElements);

        return inOrderElements;
    }

    private void inOrderNavigator(TreeNode<T> rootNode, List<T> elements) {

        if(rootNode == null)
            return;

        inOrderNavigator(rootNode.getLeftNode(), elements);

        elements.add(rootNode.getInfo());

        inOrderNavigator(rootNode.getRightNode(), elements);

    }

    @Override
    public List<T> postOrder() {

        List<T> postOrderElements = new LinkedListImpl<>();

        postOrderNavigator(root, postOrderElements);

        return postOrderElements;
    }

    private void postOrderNavigator(TreeNode<T> rootNode, List<T> elements) {

        if(rootNode == null)
            return;

        postOrderNavigator(rootNode.getLeftNode(), elements);

        postOrderNavigator(rootNode.getRightNode(), elements);

        elements.add(rootNode.getInfo());

    }
}
