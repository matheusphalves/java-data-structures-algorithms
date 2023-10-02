package com.datastructures.collection;

public class NoArvore <T extends Comparable<T>>{

    private  T info;

    private NoArvore<T> esquerdo;
    private NoArvore<T> direito;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(NoArvore<T> esquerdo) {
        this.esquerdo = esquerdo;
    }

    public NoArvore<T> getDireito() {
        return direito;
    }

    public void setDireito(NoArvore<T> direito) {
        this.direito = direito;
    }
}
