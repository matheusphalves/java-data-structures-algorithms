package com.basics.generics;

public class GenericWrapper <T> {

    private T element;

    public GenericWrapper(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
