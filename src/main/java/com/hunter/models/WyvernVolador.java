package com.hunter.models;

public class WyvernVolador extends Monstruo {

    private boolean variantes;

    public WyvernVolador(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Wyvern Volador", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
