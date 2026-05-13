package com.hunter.repositories;

import com.hunter.models.Objeto;

import java.util.List;

public interface IDropRepository {

    List<Objeto> findDropsByMonstruo(int idMonstruo);
}