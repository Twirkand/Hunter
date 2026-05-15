package com.hunter.services;

import com.hunter.models.Monstruo;

import java.util.List;

public interface IMonstruoService {
    /**
     * Obtiene todos los monstruos
     * @return lista de monstruos
     */
    List<Monstruo> obtenerTodos();
    /**
     * Obtiene un monstruo por su id
     * @param id el id del monstruo
     * @return el monstruo
     */
    Monstruo obtenerPorId(int id);
    /**
     * Crea un monstruo
     * @param monstruo el monstruo a crear
     * @return true si se creó correctamente, false si no
     */
    boolean crear(Monstruo monstruo);
    /**
     * Actualiza un monstruo
     * @param monstruo el monstruo a actualizar
     * @return true si se actualizó correctamente, false si no
     */
    boolean actualizar(Monstruo monstruo);
    /**
     * Elimina un monstruo por su id
     * @param id el id del monstruo a eliminar
     * @return true si se eliminó correctamente, false si no
     */
    boolean eliminar(int id);
    /**
     * Obtiene un monstruo por su nombre
     * @param nombre el nombre del monstruo
     * @return el monstruo
     */
    Monstruo obtenerPorNombre(String nombre);
    /**
     * Obtiene los monstruos por su tipo
     * @param tipo el tipo del monstruo
     * @return lista de monstruos
     */
    List<Monstruo> obtenerPorTipo(String tipo);
}