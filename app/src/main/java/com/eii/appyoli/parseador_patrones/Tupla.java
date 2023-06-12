package com.eii.appyoli.parseador_patrones;

public class Tupla<T,K> {
    private T clave;
    private K valor;

    public Tupla(T clave, K valor){
        this.clave=clave;
        this.valor=valor;
    }

    public T getClave() {
        return clave;
    }

    public K getValor() {
        return valor;
    }
}
