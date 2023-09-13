package com.basics.objects;

import java.util.Objects;

public class Dog {

    private String breed;
    private int age;
    private String color;

    public Dog(String breed, int age, String color){
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(breed, dog.breed) && Objects.equals(color, dog.color);
    }
}
