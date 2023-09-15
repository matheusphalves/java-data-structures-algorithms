package com.datastructures.collection.impl;

import com.datastructures.collection.Node;
import com.datastructures.collection.api.List;

public class LinkedList <T> implements List<T> {

    private Node<T> head;
    private int size;

    @Override
    public void add(T element) {

        Node<T> newNode = new Node<>(element);

        if(head == null)
            head = newNode;
        else{

            Node<T> auxNode = head;

            while(auxNode.getNext() != null){
                auxNode = auxNode.getNext();
            }
            auxNode.setNext(newNode);
        }

        size++;
    }

    @Override
    public void remove(T element) {

        if(head == null)
            return;

        if(head.getInfo().equals(element)){

            head = head.getNext();
            size--;
        }else{

            Node<T> auxNode = head;

            while(auxNode.getNext() != null) {

                Node<T> nextNode = auxNode.getNext();

                if(nextNode.getInfo().equals(element)){
                    auxNode.setNext(nextNode.getNext());
                    size--;
                    break;
                }

                auxNode = auxNode.getNext();

            }
        }
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }
}
