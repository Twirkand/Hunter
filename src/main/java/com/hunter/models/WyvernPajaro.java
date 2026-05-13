package com.hunter.models;

public class WyvernPajaro extends Monstruo {

    private boolean variantes;

    public WyvernPajaro(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Wyvern Pájaro", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
