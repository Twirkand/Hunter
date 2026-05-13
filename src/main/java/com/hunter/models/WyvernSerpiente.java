package com.hunter.models;

public class WyvernSerpiente extends Monstruo {

    private boolean variantes;

    public WyvernSerpiente(int id, String nombre, String elemento, int vida, String primeraAparicion,
            boolean variantes) {
        super(id, nombre, "Wyvern Serpiente", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
