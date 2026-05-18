package com.hunter;

import com.hunter.models.Monstruo;
import com.hunter.repositories.*;
import com.hunter.repositories.sqlite.*;
import com.hunter.services.*;
import com.hunter.services.impl.*;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    // ===== COLORES =====
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String GRAY = "\u001B[90m";

    public static void main(String[] args) {

        SqliteConnectionManager manager = new SqliteConnectionManager();

        IMonstruoService monstruoService =
                new MonstruoService(new MonstruoSqliteRepository(manager));

        Scanner scanner = new Scanner(System.in);

        System.out.println(PURPLE + "\n🐲 SISTEMA HUNTER INICIADO\n" + RESET);

        while (true) {

            System.out.println(BLUE + "══════════════════════════════" + RESET);
            System.out.println(YELLOW + " 1. Ver monstruos" + RESET);
            System.out.println(CYAN + " 2. Buscar monstruos" + RESET);
            System.out.println(RED + " 0. Salir" + RESET);
            System.out.println(BLUE + "══════════════════════════════" + RESET);

            System.out.print(GRAY + "> " + RESET);

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 -> {

                    System.out.println(GREEN + "\n══════ LISTA DE MONSTRUOS ══════\n" + RESET);

                    monstruoService.obtenerTodos()
                            .forEach(Main::mostrarMonstruo);
                }

                case 2 -> {

                    System.out.println(PURPLE + "\n══════ BUSCAR MONSTRUOS ══════" + RESET);
                    System.out.println(YELLOW + "1) Por tipo" + RESET);
                    System.out.println(CYAN + "2) Por nombre o ID" + RESET);

                    System.out.print(GRAY + "> " + RESET);

                    int sub = scanner.nextInt();
                    scanner.nextLine();

                    switch (sub) {

                        case 1 -> {

                            List<String> tipos = monstruoService.obtenerTodos()
                                    .stream()
                                    .map(Monstruo::getTipo)
                                    .distinct()
                                    .sorted()
                                    .toList();

                            System.out.println(BLUE + "\n── TIPOS DISPONIBLES ──" + RESET);

                            for (int i = 0; i < tipos.size(); i++) {
                                System.out.println(YELLOW + (i + 1) + ". " + RESET + tipos.get(i));
                            }

                            System.out.print(GRAY + "\nTipo: " + RESET);
                            String entrada = scanner.nextLine();

                            String tipoElegido = resolverTipo(entrada, tipos);

                            if (tipoElegido == null) {
                                System.out.println(RED + "\nTipo inválido\n" + RESET);
                                break;
                            }

                            System.out.println(GREEN + "\n══ RESULTADOS ══\n" + RESET);

                            monstruoService.obtenerPorTipo(tipoElegido)
                                    .forEach(Main::mostrarMonstruo);
                        }

                        case 2 -> {

                            System.out.print(GRAY + "\nBuscar: " + RESET);
                            String entrada = scanner.nextLine().trim();

                            List<Monstruo> lista;

                            if (entrada.matches("\\d+")) {

                                Monstruo m = monstruoService.obtenerPorId(Integer.parseInt(entrada));

                                if (m == null) {
                                    System.out.println(RED + "No encontrado\n" + RESET);
                                    break;
                                }

                                lista = List.of(m);

                            } else {

                                lista = monstruoService.obtenerPorNombre(entrada);

                                if (lista.isEmpty()) {
                                    System.out.println(RED + "No encontrado\n" + RESET);
                                    break;
                                }
                            }

                            System.out.println(GREEN + "\n══ RESULTADOS ══\n" + RESET);

                            lista.forEach(Main::mostrarMonstruo);
                        }
                    }
                }

                case 0 -> {
                    System.out.println(PURPLE + "\nHasta la próxima caza 🐲\n" + RESET);
                    return;
                }
            }
        }
    }

    // =========================
    // MONSTRUO CON COLORES
    // =========================
    private static void mostrarMonstruo(Monstruo m) {

        System.out.println(BLUE + "──────────────────────────────" + RESET);

        System.out.println(WHITE + "ID: " + CYAN + m.getId() + RESET);

        System.out.println(WHITE + "Nombre: " + YELLOW + m.getNombre() + RESET);

        System.out.println(WHITE + "Tipo: " + PURPLE + m.getTipo() + RESET);

        System.out.println(WHITE + "Elemento: " + RED + m.getElemento() + RESET);

        System.out.println(WHITE + "Aparición: " + GREEN + m.getPrimeraAparicion() + RESET);
    }

    // =========================
    // RESOLVER TIPO
    // =========================
    private static String resolverTipo(String entrada, List<String> tipos) {

        if (entrada.matches("\\d+")) {

            int i = Integer.parseInt(entrada);

            if (i >= 1 && i <= tipos.size()) {
                return tipos.get(i - 1);
            }
        }

        String norm = normalizar(entrada);

        for (String t : tipos) {
            if (normalizar(t).equals(norm)) {
                return t;
            }
        }

        return null;
    }

    private static String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase(Locale.ROOT)
                .trim();
    }
}