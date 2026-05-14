package com.hunter.services.impl;

import com.hunter.models.Drop;
import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;
import com.hunter.repositories.IDropRepository;
import com.hunter.services.IDropService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DropService implements IDropService {

    private final IDropRepository dropRepository;
    private final Random random = new Random();

    public DropService(IDropRepository dropRepository) {
        this.dropRepository = dropRepository;
    }

    @Override
    public List<Drop> obtenerDropsPorMonstruo(int id) {
        return dropRepository.findDropsByMonstruoId(id);
    }

    @Override
    public List<Drop> obtenerDropsPorMonstruo(String nombre) {
        return dropRepository.findDropsByMonstruoNombre(nombre);
    }

    @Override
    public List<Objeto> generarDropsAleatorios(Monstruo monstruo) {

        List<Drop> posiblesDrops = dropRepository.findDropsByMonstruoId(monstruo.getId());
        List<Objeto> obtenidos = new ArrayList<>();

        for (Drop drop : posiblesDrops) {

            if (random.nextDouble() <= drop.getProbabilidad()) {
                obtenidos.add(drop.getObjeto());
            }
        }

        return obtenidos;
    }
}