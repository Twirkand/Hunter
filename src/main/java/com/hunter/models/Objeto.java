package com.hunter.models;

public class Objeto {

    private Integer id;
    private String nombre;
    private int rareza;
    private String descripcion;

    public Objeto() {
    }

    public Objeto(Integer id, String nombre, int rareza, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.rareza = rareza;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRareza() {
        return rareza;
    }

    public void setRareza(int rareza) {
        this.rareza = rareza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}