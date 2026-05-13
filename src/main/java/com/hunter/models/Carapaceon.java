package com.hunter.models;

public class Carapaceon extends Monstruo {

    private boolean variantes;

    public Carapaceon(int id, String nombre, String elemento, int vida, String primeraAparicion, boolean variantes) {
        super(id, nombre, "Carapaceon", elemento, vida, primeraAparicion);
        this.variantes = variantes;
    }

    public boolean tieneVariante() {
        return variantes;
    }
}
