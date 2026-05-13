package com.hunter.models;

public class Neopteron extends Monstruo {

    private boolean variantes;

    public Neopteron(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Neopteron", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
