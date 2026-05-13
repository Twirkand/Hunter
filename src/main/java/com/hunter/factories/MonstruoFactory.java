package com.hunter.factories;

import com.hunter.models.*;

public class MonstruoFactory {

    public static Monstruo crear(int id,
                                 String nombre,
                                 String tipo,
                                 String elemento,
                                 int vida,
                                 String primeraAparicion,
                                 int variantes) {

        if (tipo == null) {
            return new Monstruo(id, nombre, "Desconocido", elemento, vida, primeraAparicion);
        }

        switch (tipo) {

            case "Dragon Anciano":
                return new DragonAnciano(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Wyvern Volador":
                return new WyvernVolador(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Wyvern Bruto":
                return new WyvernBruto(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Wyvern de Colmillos":
                return new WyvernDeColmillos(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Wyvern Nadador":
                return new WyvernNadador(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Wyvern Pajaro":
                return new WyvernPajaro(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Wyvern Serpiente":
                return new WyvernSerpiente(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Leviatan":
                return new Leviatan(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Anfibio":
                return new Anfibio(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Carapaceon":
                return new Carapaceon(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Cephalopodo":
                return new Cephalopodo(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Neopteron":
                return new Neopteron(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Semianciano":
                return new Semianciano(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Temnoceran":
                return new Temnoceran(id, nombre, elemento, vida, primeraAparicion, variantes);

            case "Bestia de Colmillos":
                return new BestiaDeColmillos(id, nombre, elemento, vida, primeraAparicion, variantes);

            default:
                return new Monstruo(id, nombre, tipo, elemento, vida, primeraAparicion);
        }
    }
}