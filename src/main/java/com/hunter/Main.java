package com.hunter;

import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;

import com.hunter.repositories.ConnectionManager;
import com.hunter.repositories.interfaces.IMonstruoRepository;
import com.hunter.repositories.interfaces.IObjetoRepository;
import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.repositories.sqlite.ObjetoSqliteRepository;

import com.hunter.services.IMonstruoService;
import com.hunter.services.IObjetoService;
import com.hunter.services.MonstruoService;
import com.hunter.services.ObjetoService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ConnectionManager manager = new ConnectionManager();

        IMonstruoRepository monstruoRepo = new MonstruoSqliteRepository(manager);
        IObjetoRepository objetoRepo = new ObjetoSqliteRepository(manager);

        IMonstruoService monstruoService = new MonstruoService(monstruoRepo);
        IObjetoService objetoService = new ObjetoService(objetoRepo);

        System.out.println("SISTEMA INICIADO");

        List<Monstruo> monstruos = monstruoService.obtenerTodos();

        System.out.println("\nMONSTRUOS EN BD:");
        for (Monstruo m : monstruos) {
            System.out.println("- " + m.getNombre() + " (" + m.getTipo() + ")");
        }

        List<Objeto> objetos = objetoService.obtenerTodosLosObjetos();

        System.out.println("\nOBJETOS EN BD:");
        for (Objeto o : objetos) {
            System.out.println("- " + o.getNombre() + " (Rareza " + o.getRareza() + ")");
        }
    }
}