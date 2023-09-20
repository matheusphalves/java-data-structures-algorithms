package com.datastructures.collection.impl;

import com.datastructures.collection.api.Stack;

public class StaticStack <T> implements Stack<T> {

    private T[] elements;
    private int size;
    private final int stackSize;

    public StaticStack(int stackSize){
        this.elements = (T[]) new Object[stackSize];
        this.stackSize = stackSize;
    }

    @Override
    public boolean empty() {
        return this.size == 0;
    }

    @Override
    public T pop() {

        if(this.empty())
            return null;

        T element = this.peek();

        this.elements[this.size - 1] = null;
        this.size--;

        return element;
    }

    @Override
    public T push(T element) {

        if(this.size == this.stackSize)
            throw new IndexOutOfBoundsException("The stack is already full: " + this.size);

        this.elements[this.size] = element;
        this.size++;

        return this.peek();
    }

    @Override
    public T peek() {

        if(this.size == 0)
            return null;

        return this.elements[this.size - 1];
    }

    @Override
    public int search(T element) {

        for(int index=0; index < this.size; index++){
            if(this.elements[index].equals(element))
                return index;
        }

        return -1;
    }
}
