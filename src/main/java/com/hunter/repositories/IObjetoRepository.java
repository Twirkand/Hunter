package com.hunter.repositories;

import com.hunter.models.Objeto;

import java.util.List;

public interface IObjetoRepository {

    List<Objeto> findAll();

    Objeto findById(int id);

    boolean save(Objeto objeto);

    boolean update(Objeto objeto);

    boolean delete(int id);
}