package com.hunter.services;

import com.hunter.models.Drop;
import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;

import java.util.List;

public interface IDropService {

    /**
     * Genera drops aleatorios
     * @param monstruo el monstruo
     * @return drops
     */
    List<Objeto> generarDropsAleatorios(Monstruo monstruo);
    /**
     * Obtiene los drops de un monstruo por su id
     * @param id el id del monstruo
     * @return drops
     */
    List<Drop> obtenerDropsPorMonstruo(int id);
    /**
     * Obtiene los drops de un monstruo por su nombre
     * @param nombre el nombre del monstruo
     * @return drops
     */
    List<Drop> obtenerDropsPorMonstruo(String nombre);
    boolean crearDrop(int idMonstruo, int idObjeto, double probabilidad);

}