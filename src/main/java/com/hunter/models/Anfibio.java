package com.hunter.models;

public class Anfibio extends Monstruo {

    private boolean variantes;

    public Anfibio(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Anfibio", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
