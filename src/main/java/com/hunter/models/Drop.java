package com.hunter.models;

public class Drop {
    private Objeto objeto;
    private double probabilidad;

    public Objeto getObjeto() { return objeto; }
    public void setObjeto(Objeto objeto) { this.objeto = objeto; }

    public double getProbabilidad() { return probabilidad; }
    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }
}
