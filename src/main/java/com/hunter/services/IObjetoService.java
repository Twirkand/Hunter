package com.hunter.services;

import com.hunter.models.Objeto;

import java.util.List;

public interface IObjetoService {
    /**
     * Obtiene todos los objetos
     * @return lista de objetos
     */
    List<Objeto> obtenerTodosLosObjetos();
    /**
     * Obtiene un objeto por su id
     * @param id el id del objeto
     * @return el objeto
     */
    Objeto obtenerObjetoPorId(int id);
    /**
     * Crea un objeto
     * @param objeto el objeto a crear
     * @return true si se creó correctamente, false si no
     */
    boolean crearObjeto(Objeto objeto);
    /**
     * Actualiza un objeto
     * @param objeto el objeto a actualizar
     * @return true si se actualizó correctamente, false si no
     */
    boolean actualizarObjeto(Objeto objeto);
    /**
     * Elimina un objeto por su id
     * @param id el id del objeto a eliminar
     * @return true si se eliminó correctamente, false si no
     */
    boolean eliminarObjeto(int id);
}