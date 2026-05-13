package com.hunter.models;

public class DragonAnciano extends Monstruo {

    private boolean variantes;

    public DragonAnciano(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Dragon Anciano", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
