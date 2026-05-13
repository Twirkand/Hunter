package com.hunter.services.impl;

import com.hunter.models.Monstruo;
import com.hunter.repositories.interfaces.IMonstruoRepository;

import java.util.List;

public class MonstruoService implements IMonstruoService {

    private final IMonstruoRepository repository;

    public MonstruoService(IMonstruoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Monstruo> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Monstruo obtenerPorId(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean crear(Monstruo monstruo) {

        if (monstruo.getNombre() == null || monstruo.getNombre().isBlank()) {
            return false;
        }

        return repository.save(monstruo);
    }

    @Override
    public boolean actualizar(Monstruo monstruo) {

        if (monstruo.getId() <= 0) {
            return false;
        }

        return repository.update(monstruo);
    }

    @Override
    public boolean eliminar(int id) {
        return repository.delete(id);
    }
}