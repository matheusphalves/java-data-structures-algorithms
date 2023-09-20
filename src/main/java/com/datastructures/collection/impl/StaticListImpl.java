package com.datastructures.collection.impl;

import com.datastructures.collection.api.List;

public class StaticListImpl <T> implements List<T> {

    private T[] elements;
    private int size;
    private final int listSize;

    public StaticListImpl(int listSize){
        this.listSize = listSize;
        this.clear();
    }

    @Override
    public void add(T element) {

        if(this.size == this.listSize){
            throw new IndexOutOfBoundsException("The list is already full: " + this.size);
        }

        this.elements[this.size] = element;

        this.size++;

    }

    @Override
    public void remove(T element) {
        int indexToRemove = this.indexOf(element);
        int lastIndex = this.size - 1;

        if(indexToRemove == -1)
            return;

        if(indexToRemove == lastIndex){
            this.elements[indexToRemove] = null;
        }else{
            for(int currentIndex = indexToRemove; currentIndex < this.size; currentIndex++){
                this.elements[currentIndex] = this.elements[currentIndex + 1];

                if(currentIndex + 1 == lastIndex){
                    this.elements[currentIndex + 1] = null;
                    break;
                }
            }
        }

        this.size--;
    }

    @Override
    public boolean contains(T element) {

        return this.indexOf(element) != -1;

    }

    @Override
    public int indexOf(T element) {

        for(int index=0; index < this.elements.length; index++){

            if(index == this.size)
                break;

            if(this.elements[index].equals(element))
                return index;
        }

        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {

        if(index >= 0 && index < this.size)
            return this.elements[index];

        throw new IndexOutOfBoundsException("index is out of bounds of list size: " + this.size);

    }

    @Override
    public void clear() {
        this.elements = (T[]) new Object[this.listSize];
        this.size = 0;
    }
}
