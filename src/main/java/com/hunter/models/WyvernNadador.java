package com.hunter.models;

public class WyvernNadador extends Monstruo {

    private boolean variantes;

    public WyvernNadador(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Wyvern Nadador", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
