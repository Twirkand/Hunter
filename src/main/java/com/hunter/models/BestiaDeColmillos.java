package com.hunter.models;

public class BestiaDeColmillos extends Monstruo {

    private boolean variantes;

    public BestiaDeColmillos(int id, String nombre, String elemento, int vida, String primeraAparicion,
            boolean variantes) {
        super(id, nombre, "Bestia de Colmillos", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
