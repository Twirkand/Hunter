package com.hunter.services;

import com.hunter.models.Drop;
import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;

import java.util.List;

public interface IDropService {


    List<Objeto> generarDropsAleatorios(Monstruo monstruo);

    List<Drop> obtenerDropsPorMonstruo(int id);

    List<Drop> obtenerDropsPorMonstruo(String nombre);

}