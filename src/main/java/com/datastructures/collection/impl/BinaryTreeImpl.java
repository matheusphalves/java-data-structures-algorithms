package com.datastructures.collection.impl;

import com.datastructures.collection.TreeNode;
import com.datastructures.collection.api.List;
import com.datastructures.collection.api.Tree;

public class BinaryTreeImpl
        <T extends Comparable<T>> implements Tree<T> {

    private TreeNode<T> rootNode;


    @Override
    public void add(T element) {

        TreeNode<T> newNode = new TreeNode<>(element);

        if(rootNode==null){
            this.rootNode = newNode;

        }else{

            TreeNode<T> auxNode = this.rootNode;

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

                }else {
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
    public List<T> inOrder() {

        List<T> inOrderList = new LinkedListImpl<>();

        inOrderNavigator(rootNode, inOrderList);

        return inOrderList;
    }

    private void inOrderNavigator(TreeNode<T> rootNode, List<T> elements){

        if(rootNode == null)
            return;

        inOrderNavigator(rootNode.getLeftNode(), elements);

        elements.add(rootNode.getInfo());

        inOrderNavigator(rootNode.getRightNode(), elements);

    }

    @Override
    public List<T> preOrder() {

        List<T> preOrderList = new LinkedListImpl<>();

        preOrderNavigator(rootNode, preOrderList);

        return preOrderList;
    }

    private void preOrderNavigator(TreeNode<T> rootNode, List<T> elements){

        if(rootNode == null)
            return;

        elements.add(rootNode.getInfo());

        preOrderNavigator(rootNode.getLeftNode(), elements);

        preOrderNavigator(rootNode.getRightNode(), elements);

    }

    @Override
    public List<T> postOrder() {

        List<T> postOrderList = new LinkedListImpl<>();

        postOrderNavigator(rootNode, postOrderList);

        return postOrderList;
    }

    private void postOrderNavigator(TreeNode<T> rootNode, List<T> elements){

        if(rootNode == null)
            return;

        postOrderNavigator(rootNode.getLeftNode(), elements);

        postOrderNavigator(rootNode.getRightNode(), elements);

        elements.add(rootNode.getInfo());

    }

    @Override
    public boolean isEmpty() {
        return this.rootNode == null;
    }

    @Override
    public TreeNode<T> search(T element) {
        return null;
    }

    @Override
    public int nodeDepth(T element) {
        return 0;
    }

    @Override
    public int getTreeHeight() {
        return 0;
    }


}
