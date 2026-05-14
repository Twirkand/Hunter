package com.hunter.factories;

import com.hunter.models.*;

public class MonstruoFactory {

    public static Monstruo crear(int id,
                                 String nombre,
                                 String tipo,
                                 String elemento,
                                 int vida,
                                 String primeraAparicion) {

        if (tipo == null) {
            return new Monstruo(id, nombre, "Desconocido", elemento, vida, primeraAparicion);
        }

        switch (tipo) {

            case "Dragon Anciano":
                return new DragonAnciano(id, nombre, elemento, vida, primeraAparicion);

            case "Wyvern Volador":
                return new WyvernVolador(id, nombre, elemento, vida, primeraAparicion);

            case "Wyvern Bruto":
                return new WyvernBruto(id, nombre, elemento, vida, primeraAparicion);

            case "Wyvern de Colmillos":
                return new WyvernDeColmillos(id, nombre, elemento, vida, primeraAparicion);

            case "Wyvern Nadador":
                return new WyvernNadador(id, nombre, elemento, vida, primeraAparicion);

            case "Wyvern Pajaro":
                return new WyvernPajaro(id, nombre, elemento, vida, primeraAparicion);

            case "Wyvern Serpiente":
                return new WyvernSerpiente(id, nombre, elemento, vida, primeraAparicion);

            case "Leviatan":
                return new Leviatan(id, nombre, elemento, vida, primeraAparicion);

            case "Anfibio":
                return new Anfibio(id, nombre, elemento, vida, primeraAparicion);

            case "Carapaceon":
                return new Carapaceon(id, nombre, elemento, vida, primeraAparicion);

            case "Cephalopodo":
                return new Cephalopodo(id, nombre, elemento, vida, primeraAparicion);

            case "Neopteron":
                return new Neopteron(id, nombre, elemento, vida, primeraAparicion);

            case "Semianciano":
                return new Semianciano(id, nombre, elemento, vida, primeraAparicion);

            case "Temnoceran":
                return new Temnoceran(id, nombre, elemento, vida, primeraAparicion);

            case "Bestia de Colmillos":
                return new BestiaDeColmillos(id, nombre, elemento, vida, primeraAparicion);

            default:
                return new Monstruo(id, nombre, tipo, elemento, vida, primeraAparicion);
        }
    }
}