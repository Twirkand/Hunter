package com.hunter;

import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;

import com.hunter.repositories.SqliteConnectionManager;
import com.hunter.repositories.IMonstruoRepository;
import com.hunter.repositories.IObjetoRepository;
import com.hunter.repositories.IDropRepository;

import com.hunter.repositories.sqlite.MonstruoSqliteRepository;
import com.hunter.repositories.sqlite.ObjetoSqliteRepository;
import com.hunter.repositories.sqlite.DropSqliteRepository;

import com.hunter.services.IMonstruoService;
import com.hunter.services.IObjetoService;
import com.hunter.services.IDropService;

import com.hunter.services.impl.MonstruoService;
import com.hunter.services.impl.ObjetoService;
import com.hunter.services.impl.DropService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {

        SqliteConnectionManager manager = new SqliteConnectionManager();

        IMonstruoRepository monstruoRepo = new MonstruoSqliteRepository(manager);
        IObjetoRepository objetoRepo = new ObjetoSqliteRepository(manager);
        IDropRepository dropRepo = new DropSqliteRepository(manager);

        IMonstruoService monstruoService = new MonstruoService(monstruoRepo);
        IObjetoService objetoService = new ObjetoService(objetoRepo);
        IDropService dropService = new DropService(dropRepo);

        Scanner sc = new Scanner(System.in);

        System.out.println(PURPLE + "🐲 SISTEMA HUNTER INICIADO" + RESET);

        while (true) {

            System.out.println(BLUE + "\n==============================" + RESET);
            System.out.println(YELLOW + "1. Ver monstruos" + RESET);
            System.out.println(YELLOW + "2. Buscar / Explorar monstruos" + RESET);
            System.out.println(YELLOW + "3. Ver drops por nombre monstruo" + RESET);
            System.out.println(YELLOW + "4. Simular drops aleatorios" + RESET);
            System.out.println(RED + "0. Salir" + RESET);
            System.out.print(CYAN + "> " + RESET);

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                // =====================================================
                // 🐉 LISTAR TODOS
                // =====================================================
                case 1 -> {
                    List<Monstruo> lista = monstruoService.obtenerTodos();

                    System.out.println(GREEN + "\n🐉 MONSTRUOS:" + RESET);

                    for (Monstruo m : lista) {
                        System.out.println(
                                CYAN + m.getId() + RESET + " - " +
                                WHITE + m.getNombre() + RESET + " (" +
                                PURPLE + m.getTipo() + RESET + ")"
                        );
                    }
                }

                // =====================================================
                // 📜 CASE 2: COMBINADO (ANTIGUO + NUEVO)
                // =====================================================
                case 2 -> {

                    System.out.println(PURPLE + "\n📜 EXPLORACIÓN DE MONSTRUOS" + RESET);
                    System.out.println(YELLOW + "1. Buscar por tipo (selector)" + RESET);
                    System.out.println(YELLOW + "2. Buscar por nombre" + RESET);
                    System.out.print(CYAN + "> " + RESET);

                    int sub = sc.nextInt();
                    sc.nextLine();

                    switch (sub) {

                        // =================================================
                        // 🧭 NUEVO: SELECTOR DE TIPOS
                        // =================================================
                        case 1 -> {

                            List<Monstruo> todos = monstruoService.obtenerTodos();

                            List<String> tipos = todos.stream()
                                    .map(Monstruo::getTipo)
                                    .distinct()
                                    .sorted()
                                    .toList();

                            System.out.println(PURPLE + "\n📜 TIPOS DISPONIBLES:" + RESET);

                            for (int i = 0; i < tipos.size(); i++) {
                                System.out.println(CYAN + (i + 1) + ". " + RESET + tipos.get(i));
                            }

                            System.out.print(YELLOW + "\nElige tipo: " + RESET);
                            int opcion = sc.nextInt();
                            sc.nextLine();

                            if (opcion < 1 || opcion > tipos.size()) {
                                System.out.println(RED + "❌ Tipo inválido" + RESET);
                                break;
                            }

                            String tipoElegido = tipos.get(opcion - 1);

                            List<Monstruo> lista = monstruoService.obtenerPorTipo(tipoElegido);

                            System.out.println(PURPLE + "\n🐉 MONSTRUOS DEL TIPO: " + RESET + tipoElegido);

                            for (Monstruo m : lista) {
                                System.out.println(
                                        CYAN + m.getId() + RESET + " - " +
                                        WHITE + m.getNombre() + RESET + " (" +
                                        YELLOW + m.getElemento() + RESET + ")"
                                );
                            }
                        }

                        // =================================================
                        // 🔎 ANTIGUO: BUSCAR POR NOMBRE (SE MANTIENE)
                        // =================================================
                        case 2 -> {
                            System.out.print("Nombre monstruo: ");
                            String nombre = sc.nextLine().trim();

                            Monstruo m = monstruoService.obtenerPorNombre(nombre);

                            if (m == null) {
                                System.out.println(RED + "❌ No existe ese monstruo" + RESET);
                                break;
                            }

                            System.out.println(GREEN + "\n🐉 RESULTADO:" + RESET);
                            System.out.println(
                                    m.getId() + " - " +
                                    m.getNombre() + " (" +
                                    m.getTipo() + ")"
                            );
                        }

                        default -> System.out.println(RED + "❌ Opción inválida" + RESET);
                    }
                }

                // =====================================================
                // 💎 DROPS POR NOMBRE
                // =====================================================
                case 3 -> {
                    System.out.print("Nombre monstruo: ");
                    String nombre = sc.nextLine().trim();

                    var drops = dropService.obtenerDropsPorMonstruo(nombre);

                    System.out.println(GREEN + "\n💎 DROPS:" + RESET);

                    if (drops.isEmpty()) {
                        System.out.println(RED + "❌ No existe ese monstruo o no tiene drops" + RESET);
                        break;
                    }

                    for (var d : drops) {
                        System.out.println(
                                YELLOW + "- " + RESET +
                                WHITE + d.getObjeto().getNombre() + RESET +
                                " | " +
                                RED + d.getProbabilidad() + RESET
                        );
                    }
                }

                // =====================================================
                // 🎲 SIMULACIÓN
                // =====================================================
                case 4 -> {
                    System.out.print("ID monstruo: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Monstruo m = monstruoService.obtenerPorId(id);

                    if (m == null) {
                        System.out.println(RED + "❌ Monstruo no encontrado" + RESET);
                        break;
                    }

                    List<Objeto> drops = dropService.generarDropsAleatorios(m);

                    System.out.println(PURPLE + "\n🎲 DROPS OBTENIDOS:" + RESET);

                    for (Objeto o : drops) {
                        System.out.println(GREEN + "✨ " + RESET + o.getNombre());
                    }
                }

                // =====================================================
                // ❌ SALIDA
                // =====================================================
                case 0 -> {
                    System.out.println(PURPLE + "👋 Cerrando sistema..." + RESET);
                    return;
                }

                default -> System.out.println(RED + "❌ Opción inválida" + RESET);
            }
        }
    }
}