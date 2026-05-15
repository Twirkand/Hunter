package com.hunter.models;

import java.util.ArrayList;
import java.util.List;

public class Monstruo {

    private final int id;
    private String nombre;
    private String tipo;
    private String elemento;
    private String primeraAparicion;
    private List<Drop> drops = new ArrayList<>();

    public Monstruo(int id, String nombre, String tipo, String elemento, String primeraAparicion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.elemento = elemento;
        this.primeraAparicion = primeraAparicion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getElemento() {
        return elemento;
    }


    public String getPrimeraAparicion() {
        return primeraAparicion;
    }

    public List<Drop> getDrops() {
        return drops;
    }

    public void setDrops(List<Drop> drops) {
        this.drops = drops;
    }
}