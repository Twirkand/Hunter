package com.hunter.models;

public class WyvernDeColmillos extends Monstruo {

    private boolean variantes;

    public WyvernDeColmillos(int id, String nombre, String elemento, int vida, String primeraAparicion,
            boolean variantes) {
        super(id, nombre, "Wyvern de Colmillos", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
