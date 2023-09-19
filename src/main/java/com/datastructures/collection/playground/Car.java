package com.datastructures.collection.playground;

public class Car {

    private int size;

    public Car(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Car car)) return false;
        return size == car.size;
    }
}
