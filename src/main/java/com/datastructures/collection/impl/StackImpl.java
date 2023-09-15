package com.datastructures.collection.impl;

import com.datastructures.collection.Node;
import com.datastructures.collection.api.Stack;

public class StackImpl <T> implements Stack<T> {

    private Node<T> top;

    @Override
    public T push(T element) {

        Node<T> auxNode = new Node<>(element);

        if(this.top == null){
            this.top = auxNode;
        } else{
            auxNode.setNext(top);
            top = auxNode;
        }

        return this.peek();
    }

    @Override
    public T pop() {

        if(this.top != null){
            T info = this.top.getInfo();
            this.top = this.top.getNext();
            return info;
        }

        return null;
    }

    @Override
    public int search(T element) {

        int indexOf = -1;
        Node<T> auxNode = top;

        while(auxNode != null){

            indexOf++;

            if(auxNode.getInfo().equals(element))
                return indexOf;

            auxNode = auxNode.getNext();
        }

        return -1;
    }

    @Override
    public boolean empty() {
        return this.top == null;
    }

    @Override
    public T peek() {

        if(this.top != null)
            return this.top.getInfo();

        return null;
    }
}
