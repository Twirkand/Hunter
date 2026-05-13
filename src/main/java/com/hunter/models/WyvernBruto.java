package com.hunter.models;

public class WyvernBruto extends Monstruo {

    private boolean variantes;

    public WyvernBruto(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Wyvern Bruto", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
