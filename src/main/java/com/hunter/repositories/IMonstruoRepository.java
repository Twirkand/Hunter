package com.hunter.repositories;

import com.hunter.models.Monstruo;

import java.util.List;

public interface IMonstruoRepository {

    List<Monstruo> findAll();

    Monstruo findById(int id);

    boolean save(Monstruo monstruo);

    boolean update(Monstruo monstruo);

    boolean delete(int id);

    List<Monstruo> findByNombre(String nombre);

    List<Monstruo> findByTipo(String tipo);
}