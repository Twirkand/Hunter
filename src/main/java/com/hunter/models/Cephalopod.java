package com.hunter.models;

public class Cephalopod extends Monstruo {

    private boolean variantes;

    public Cephalopod(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Cephalopod", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
