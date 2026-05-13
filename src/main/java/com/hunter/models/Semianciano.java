package com.hunter.models;

public class Semianciano extends Monstruo {

    private boolean variantes;

    public Semianciano(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Semianciano", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
