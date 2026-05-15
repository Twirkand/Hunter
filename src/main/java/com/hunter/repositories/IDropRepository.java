package com.hunter.repositories;

import com.hunter.models.Drop;
import com.hunter.models.Objeto;

import java.util.List;

public interface IDropRepository {

    List<Drop> findDropsByMonstruoId(int id);

    List<Drop> findDropsByMonstruoNombre(String nombre);

    boolean crearDrop(int idMonstruo, int idObjeto, double probabilidad);
}