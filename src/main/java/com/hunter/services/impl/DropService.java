package com.hunter.services.impl;

import com.hunter.models.Drop;
import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;
import com.hunter.repositories.interfaces.IDropRepository;
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
    public List<Objeto> obtenerDropsDeMonstruo(int idMonstruo) {
        return dropRepository.findDropsByMonstruo(idMonstruo);
    }

    @Override
    public List<Objeto> generarDropsAleatorios(Monstruo monstruo) {

        List<Objeto> posiblesDrops = dropRepository.findDropsByMonstruo(monstruo.getId());
        List<Objeto> obtenidos = new ArrayList<>();

        for (Objeto obj : posiblesDrops) {

            double probabilidad = switch (obj.getRareza()) {
                case 1 -> 0.80;
                case 2 -> 0.50;
                case 3 -> 0.30;
                case 4 -> 0.10;
                case 5 -> 0.03;
                default -> 0.00;
            };

            if (random.nextDouble() <= probabilidad) {
                obtenidos.add(obj);
            }
        }

        return obtenidos;
    }
}