package com.hunter.factories;

import com.hunter.models.*;

public class MonstruoFactory {

    public static Monstruo crear(int id,
            String nombre,
            String tipo,
            String elemento,
            String primeraAparicion) {

        if (tipo == null) {
            return new Monstruo(id, nombre, "Desconocido", elemento, primeraAparicion);
        }

        /*
         * switch (tipo) {
         * 
         * case "Dragon Anciano":
         * return new DragonAnciano(id, nombre, elemento, primeraAparicion);
         * 
         * case "Wyvern Volador":
         * return new WyvernVolador(id, nombre, elemento, primeraAparicion);
         * 
         * case "Wyvern Bruto":
         * return new WyvernBruto(id, nombre, elemento, primeraAparicion);
         * 
         * case "Wyvern de Colmillos":
         * return new WyvernDeColmillos(id, nombre, elemento, primeraAparicion);
         * 
         * case "Wyvern Nadador":
         * return new WyvernNadador(id, nombre, elemento, primeraAparicion);
         * 
         * case "Wyvern Pajaro":
         * return new WyvernPajaro(id, nombre, elemento, primeraAparicion);
         * 
         * case "Wyvern Serpiente":
         * return new WyvernSerpiente(id, nombre, elemento, primeraAparicion);
         * 
         * case "Leviatan":
         * return new Leviatan(id, nombre, elemento, primeraAparicion);
         * 
         * case "Anfibio":
         * return new Anfibio(id, nombre, elemento, primeraAparicion);
         * 
         * case "Carapaceon":
         * return new Carapaceon(id, nombre, elemento, primeraAparicion);
         * 
         * case "Cephalopodo":
         * return new Cephalopodo(id, nombre, elemento, primeraAparicion);
         * 
         * case "Neopteron":
         * return new Neopteron(id, nombre, elemento, primeraAparicion);
         * 
         * case "Semianciano":
         * return new Semianciano(id, nombre, elemento, primeraAparicion);
         * 
         * case "Temnoceran":
         * return new Temnoceran(id, nombre, elemento, primeraAparicion);
         * 
         * case "Bestia de Colmillos":
         * return new BestiaDeColmillos(id, nombre, elemento, primeraAparicion);
         * 
         * default:
         */
        return new Monstruo(id, nombre, tipo, elemento, primeraAparicion);
    }
}
