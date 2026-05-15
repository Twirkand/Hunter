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

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
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

        Scanner scanner = new Scanner(System.in);

        System.out.println(PURPLE + "🐲 SISTEMA HUNTER INICIADO" + RESET);

        while (true) {

            System.out.println(BLUE + "\n==============================" + RESET);
            System.out.println(YELLOW + "1. Ver monstruos" + RESET);
            System.out.println(YELLOW + "2. Buscar monstruos" + RESET);
            System.out.println(RED + "0. Salir" + RESET);
            System.out.print(CYAN + "> " + RESET);

            int opciones = scanner.nextInt();
            scanner.nextLine();

            switch (opciones) {

                // =====================
                // LISTAR TODOS
                // =====================
                case 1 -> {
                    List<Monstruo> lista = monstruoService.obtenerTodos();

                    System.out.println(GREEN + "\n MONSTRUOS:" + RESET);

                    for (Monstruo m : lista) {
                        System.out.println(
                                CYAN + m.getId() + RESET + " - " +
                                        WHITE + m.getNombre() + RESET + " (" +
                                        PURPLE + m.getTipo() + RESET + ")");
                    }
                }

                case 2 -> {

                    System.out.println(PURPLE + "\n EXPLORACIÓN DE MONSTRUOS" + RESET);
                    System.out.println(YELLOW + "1. Buscar por tipo" + RESET);
                    System.out.println(YELLOW + "2. Buscar monstruo" + RESET);
                    System.out.print(CYAN + "> " + RESET);

                    int submenu = scanner.nextInt();
                    scanner.nextLine();

                    switch (submenu) {

                        // =====================
                        // SELECTOR DE TIPOS
                        // =====================
                        case 1 -> {

                            List<Monstruo> todos = monstruoService.obtenerTodos();

                            List<String> tipos = todos.stream()
                                    .map(Monstruo::getTipo)
                                    .distinct()
                                    .sorted()
                                    .toList();

                            System.out.println(PURPLE + "\n TIPOS DISPONIBLES:" + RESET);

                            for (int i = 0; i < tipos.size(); i++) {
                                System.out.println(CYAN + "[" + (i + 1) + "] " + RESET + tipos.get(i));
                            }

                            System.out.print(YELLOW + "\nElige tipo: " + RESET);

                            String entrada = scanner.nextLine().trim();

                            String tipoElegido = null;

                            if (entrada.matches("\\d+")) {

                                int opcion = Integer.parseInt(entrada);

                                if (opcion >= 1 && opcion <= tipos.size()) {
                                    tipoElegido = tipos.get(opcion - 1);
                                }

                            } else {

                                String entradaNormalizada = normalizar(entrada);

                                for (String tipo : tipos) {

                                    if (normalizar(tipo).equals(entradaNormalizada)) {
                                        tipoElegido = tipo;
                                        break;
                                    }
                                }
                            }

                            if (tipoElegido == null) {
                                System.out.println(RED + "Tipo inválido" + RESET);
                                break;
                            }

                            List<Monstruo> lista = monstruoService.obtenerPorTipo(tipoElegido);

                            System.out.println(PURPLE + "\n MONSTRUOS DEL TIPO: " + RESET + tipoElegido);

                            for (Monstruo monstruo : lista) {

                                System.out.println(
                                        PURPLE + "\n==============================" + RESET);

                                System.out.println(
                                        CYAN + "ID: " + RESET +
                                                WHITE + monstruo.getId() + RESET);

                                System.out.println(
                                        CYAN + "Nombre: " + RESET +
                                                WHITE + monstruo.getNombre() + RESET);

                                System.out.println(
                                        CYAN + "Tipo: " + RESET +
                                                PURPLE + monstruo.getTipo() + RESET);

                                System.out.println(
                                        CYAN + "Elemento: " + RESET +
                                                YELLOW + monstruo.getElemento() + RESET);


                                System.out.println(
                                        CYAN + "Primera aparición: " + RESET +
                                                WHITE + monstruo.getPrimeraAparicion() + RESET);

                                System.out.println(
                                        PURPLE + "==============================" + RESET);
                            }
                        }

                        // =====================
                        // BUSCAR MONSTRUO
                        // =====================
                        case 2 -> {

                            System.out.print("Nombre o ID monstruo: ");

                            String entrada = scanner.nextLine().trim();

                            Monstruo monstruo;

                            // =================================================
                            // SI ES ID
                            // =================================================
                            if (entrada.matches("\\d+")) {

                                int id = Integer.parseInt(entrada);

                                monstruo = monstruoService.obtenerPorId(id);

                            } else {

                                // =============================================
                                // SI ES NOMBRE
                                // =============================================
                                monstruo = monstruoService.obtenerPorNombre(entrada);
                            }

                            if (monstruo == null) {

                                System.out.println(
                                        RED + "No existe ese monstruo" + RESET);

                                break;
                            }

                            System.out.println(GREEN + "\n RESULTADO:" + RESET);

                            System.out.println(
                                    CYAN + "ID: " + RESET +
                                            WHITE + monstruo.getId() + RESET);

                            System.out.println(
                                    CYAN + "Nombre: " + RESET +
                                            WHITE + monstruo.getNombre() + RESET);

                            System.out.println(
                                    CYAN + "Tipo: " + RESET +
                                            PURPLE + monstruo.getTipo() + RESET);

                            System.out.println(
                                    CYAN + "Elemento: " + RESET +
                                            YELLOW + monstruo.getElemento() + RESET);


                            System.out.println(
                                    CYAN + "Primera aparición: " + RESET +
                                            WHITE + monstruo.getPrimeraAparicion() + RESET);
                        }

                        default -> System.out.println(RED + "Opción inválida" + RESET);
                    }
                }

                // ================
                // SALIDA
                // ===============
                case 0 -> {
                    System.out.println(PURPLE + "Hasta la siguiente caza..." + RESET);
                    return;
                }

                default -> System.out.println(RED + "Opción inválida" + RESET);
            }
        }
    }

    private static String normalizar(String texto) {

        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase(Locale.ROOT)
                .trim();
    }
}
