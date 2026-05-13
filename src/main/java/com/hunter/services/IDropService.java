package com.hunter.services;

import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;

import java.util.List;

public interface IDropService {

    List<Objeto> obtenerDropsDeMonstruo(int idMonstruo);

    List<Objeto> generarDropsAleatorios(Monstruo monstruo);
}