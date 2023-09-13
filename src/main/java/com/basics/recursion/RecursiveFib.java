package com.basics.recursion;

public class RecursiveFib {

    public static int fib(int n){
        if(n <= 1)
            return 1; // CAS0 BASE

        // PASSO RECURSIVO
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        // 1, 1, 2, 3, 5, 8, 13
        System.out.println("Fib(3)= " + fib(10000000));
    }
}
