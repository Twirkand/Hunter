package com.hunter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;

import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.IMonstruoRepository;
import com.hunter.repositories.IObjetoRepository;

import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.repositories.sqlite.ObjetoSqliteRepository;

import com.hunter.services.impl.MonstruoService;
import com.hunter.services.impl.ObjetoService;

import java.util.List;

public class SistemaTest {

    private void inicializarDatos(MonstruoService monstruoService, ObjetoService objetoService) {

        // 🐲 Monstruos (id = 0 porque la BD lo autogenera)
        monstruoService.crear(new Monstruo(
                0,
                "Rathalos",
                "Wyvern Volador",
                "Fuego",
                5000,
                "MH"
        ));

        monstruoService.crear(new Monstruo(
                0,
                "Lagiacrus",
                "Leviatan",
                "Rayo",
                6000,
                "MH3"
        ));

        monstruoService.crear(new Monstruo(
                0,
                "Nergigante",
                "Dragon Anciano",
                "Oscuro",
                8000,
                "MHWorld"
        ));

        // 💎 Objetos
        objetoService.crearObjeto(new Objeto(
                null,
                "Escama Wyvern",
                2,
                "Material básico"
        ));

        objetoService.crearObjeto(new Objeto(
                null,
                "Colmillo Ancestral",
                4,
                "Raro"
        ));

        objetoService.crearObjeto(new Objeto(
                null,
                "Corona Negra",
                5,
                "Legendario"
        ));
    }

    @Test
    public void testSistemaCompleto() {

        SqliteConnectionManager manager = new SqliteConnectionManager();

        IMonstruoRepository monstruoRepo = new MonstruoSqliteRepository(manager);
        IObjetoRepository objetoRepo = new ObjetoSqliteRepository(manager);

        MonstruoService monstruoService = new MonstruoService(monstruoRepo);
        ObjetoService objetoService = new ObjetoService(objetoRepo);

        inicializarDatos(monstruoService, objetoService);

        List<Monstruo> monstruos = monstruoService.obtenerTodos();

        assertNotNull(monstruos);
        assertTrue(monstruos.size() >= 3);

        System.out.println("\n🐲 MONSTRUOS:");
        for (Monstruo m : monstruos) {
            System.out.println("- " + m.getNombre() + " | " + m.getTipo());
        }

        List<Objeto> objetos = objetoService.obtenerTodosLosObjetos();

        assertNotNull(objetos);
        assertTrue(objetos.size() >= 3);

        System.out.println("\n💎 OBJETOS:");
        for (Objeto o : objetos) {
            System.out.println("- " + o.getNombre() + " | Rareza " + o.getRareza());
        }

        assertFalse(monstruos.isEmpty());
        assertFalse(objetos.isEmpty());

        System.out.println("\n🎮 SISTEMA FUNCIONANDO CORRECTAMENTE");
    }
}