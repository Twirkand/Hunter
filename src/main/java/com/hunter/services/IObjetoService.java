package com.hunter.services;

import com.hunter.models.Objeto;

import java.util.List;

public interface IObjetoService {

    List<Objeto> obtenerTodosLosObjetos();

    Objeto obtenerObjetoPorId(int id);

    boolean crearObjeto(Objeto objeto);

    boolean actualizarObjeto(Objeto objeto);

    boolean eliminarObjeto(int id);
}