package com.datastructures.collection.impl;

import com.datastructures.collection.internal.node.Node;
import com.datastructures.collection.api.List;

import java.lang.reflect.Array;

public class LinkedListImpl <T> implements List<T> {

    private Node<T> head;
    private int size;

    @Override
    public void add(T element) {

        Node<T> newNode = new Node<>(element);

        if (head == null)
            head = newNode;
        else {

            Node<T> auxNode = head;

            while (auxNode.getNext() != null) {
                auxNode = auxNode.getNext();
            }
            auxNode.setNext(newNode);
        }

        size++;
    }

    @Override
    public void remove(T element) {

        if (head == null)
            return;

        if (head.getInfo().equals(element)) {

            head = head.getNext();
            size--;
        } else {

            Node<T> auxNode = head;

            while (auxNode.getNext() != null) {

                Node<T> nextNode = auxNode.getNext();

                if (nextNode.getInfo().equals(element)) {
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

        if (this.head == null)
            return false;

        Node<T> auxNode = this.head;

        while (auxNode != null) {
            if (auxNode.getInfo().equals(element))
                return true;

            auxNode = auxNode.getNext();
        }

        return false;
    }

    @Override
    public int indexOf(T element) {

        int indexOf = -1;

        if (this.head == null)
            return indexOf;

        Node<T> auxNode = this.head;

        while (auxNode != null) {

            indexOf++;

            if (auxNode.getInfo().equals(element))
                return indexOf;

            auxNode = auxNode.getNext();

        }

        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {

        if (index >= 0 && index <= this.size - 1) {

            int indexCounter = 0;
            Node<T> auxNode = this.head;

            while (auxNode != null) {

                if (indexCounter == index)
                    return auxNode.getInfo();

                auxNode = auxNode.getNext();
                indexCounter++;

            }
        }

        throw new IndexOutOfBoundsException("index is out of bounds of list size: " + this.size);
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public String toString(){
        Node<T> auxNode = this.head;

        StringBuilder stringBuffer = new StringBuilder();

        while(auxNode != null){
            stringBuffer.append(auxNode.getInfo()).append(", ");
            auxNode = auxNode.getNext();
        }

        return stringBuffer.toString();
    }

    @Override
    public T[] toArray(){
        T[] objects = (T[]) new Object[size];

        Node<T> auxNode = head;
        int index = 0;

        while(auxNode != null){
            objects[index] = auxNode.getInfo();
            auxNode = auxNode.getNext();
            index++;
        }

        return objects;

    }

    @Override
    public T[] toArray(Class<?> type) {

        @SuppressWarnings("unchecked")
        T[] objects = (T[]) Array.newInstance(type, size);

        Node<T> auxNode = head;
        int index = 0;

        while(auxNode != null){
            objects[index] = auxNode.getInfo();
            auxNode = auxNode.getNext();
            index++;
        }

        return objects;

    }

}
