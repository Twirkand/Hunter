package com.hunter;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;

import com.hunter.repositories.ConnectionManager;
import com.hunter.repositories.interfaces.IMonstruoRepository;
import com.hunter.repositories.interfaces.IObjetoRepository;

import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.repositories.sqlite.ObjetoSqliteRepository;

import com.hunter.services.MonstruoService;
import com.hunter.services.ObjetoService;

import java.util.List;

/**
 * Unit test for Monster Hunter system
 */
public class SistemaTest {

    // 🧠 Helper para crear servicios (simula setup)
    private void inicializarDatos(MonstruoService monstruoService, ObjetoService objetoService) {

        // 🐲 Monstruos de prueba
        monstruoService.crear(new Monstruo(
                "Rathalos",
                "Wyvern Volador",
                "Fuego",
                5000,
                "MH"
        ));

        monstruoService.crear(new Monstruo(
                "Lagiacrus",
                "Leviatan",
                "Rayo",
                6000,
                "MH3"
        ));

        monstruoService.crear(new Monstruo(
                "Nergigante",
                "Dragon Anciano",
                "Oscuro",
                8000,
                "MHWorld"
        ));

        // 💎 Objetos de prueba
        objetoService.crearObjeto(new Objeto(
                "Escama Wyvern",
                2,
                "Material básico"
        ));

        objetoService.crearObjeto(new Objeto(
                "Colmillo Ancestral",
                4,
                "Raro"
        ));

        objetoService.crearObjeto(new Objeto(
                "Corona Negra",
                5,
                "Legendario"
        ));
    }

    @Test
    public void testSistemaCompleto() {

        // 🔌 Conexión y servicios
        ConnectionManager manager = new ConnectionManager();

        IMonstruoRepository monstruoRepo = new MonstruoSqliteRepository(manager);
        IObjetoRepository objetoRepo = new ObjetoSqliteRepository(manager);

        MonstruoService monstruoService = new MonstruoService(monstruoRepo);
        ObjetoService objetoService = new ObjetoService(objetoRepo);

        // 🧪 INSERTAR DATOS (setup manual)
        inicializarDatos(monstruoService, objetoService);

        // 🐲 TEST MONSTRUOS
        List<Monstruo> monstruos = monstruoService.obtenerTodos();

        assertNotNull(monstruos);
        assertTrue(monstruos.size() >= 3);

        System.out.println("\n🐲 MONSTRUOS:");
        for (Monstruo m : monstruos) {
            System.out.println("- " + m.getNombre() + " | " + m.getTipo());
        }

        // 💎 TEST OBJETOS
        List<Objeto> objetos = objetoService.obtenerTodosLosObjetos();

        assertNotNull(objetos);
        assertTrue(objetos.size() >= 3);

        System.out.println("\n💎 OBJETOS:");
        for (Objeto o : objetos) {
            System.out.println("- " + o.getNombre() + " | Rareza " + o.getRareza());
        }

        // 🎮 TEST FINAL
        assertFalse(monstruos.isEmpty());
        assertFalse(objetos.isEmpty());

        System.out.println("\n🎮 SISTEMA FUNCIONANDO CORRECTAMENTE");
    }
}