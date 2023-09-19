package com.datastructures.collection.playground;

import com.datastructures.collection.api.List;
import com.datastructures.collection.impl.LinkedListImpl;

public class LinkedListTest {

    public static void main(String[] args) {
        List<Integer> numeros = new LinkedListImpl<>();

        numeros.add(3);
        numeros.add(2);
        numeros.add(1);

//        System.out.println("Tamanho da lista antes da remoção: " + numeros.size());
//        numeros.remove(10);
//
//        System.out.println("Tamanho da lista após remoção: " + numeros.size());

//        System.out.println("Tamanho da lista antes da limpeza: " + numeros.size());
//        numeros.clear();
//
//        System.out.println("Tamanho da lista após limpeza: " + numeros.size());
//
//        numeros.add(2023);

//        System.out.println("Usando o contains");
//
//        System.out.println(numeros.contains(3));
//        System.out.println(numeros.contains(2));
//        System.out.println(numeros.contains(1));
//        System.out.println(numeros.contains(20232));

//        System.out.println("Usando o indexOf");
//
//        System.out.println(numeros.indexOf(1));
//        System.out.println(numeros.indexOf(3));
//        System.out.println(numeros.indexOf(2));
//        System.out.println(numeros.indexOf(1));
//        System.out.println(numeros.indexOf(202302002));

//        System.out.println("Usando o get");
//
//        System.out.println(numeros.get(0));
//        System.out.println(numeros.get(1));
//        System.out.println(numeros.get(2));
//        System.out.println(numeros.get(3));
//        System.out.println(numeros.get(4));

//        int x = 0;

        List<Car> cars = new LinkedListImpl<>();

        Car carA = new Car(5);
        Car carB = new Car(5);

        cars.add(carA);

        System.out.println("Contains que funciona: " + cars.contains(carA));
        System.out.println("Contains que NÃO funciona: " + cars.contains(carB));

    }
}
