package com.hunter.services.impl;

import com.hunter.models.Objeto;
import com.hunter.repositories.IObjetoRepository;
import com.hunter.services.IObjetoService;

import java.util.List;

public class ObjetoService implements IObjetoService {

    private final IObjetoRepository objetoRepository;

    public ObjetoService(IObjetoRepository objetoRepository) {
        this.objetoRepository = objetoRepository;
    }

    @Override
    public List<Objeto> obtenerTodosLosObjetos() {
        return objetoRepository.findAll();
    }

    @Override
    public Objeto obtenerObjetoPorId(int id) {
        return objetoRepository.findById(id);
    }

    @Override
    public boolean crearObjeto(Objeto objeto) {
        if (objeto.getNombre() == null || objeto.getNombre().isBlank()) {
            return false;
        }

        return objetoRepository.save(objeto);
    }

    @Override
    public boolean actualizarObjeto(Objeto objeto) {
        if (objeto.getId() == null) {
            return false;
        }

        return objetoRepository.update(objeto);
    }

    @Override
    public boolean eliminarObjeto(int id) {
        return objetoRepository.delete(id);
    }
}