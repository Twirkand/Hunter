package com.hunter.services;

import com.hunter.models.Monstruo;

import java.util.List;

public interface IMonstruoService {

    List<Monstruo> obtenerTodos();

    Monstruo obtenerPorId(int id);

    boolean crear(Monstruo monstruo);

    boolean actualizar(Monstruo monstruo);

    boolean eliminar(int id);
}