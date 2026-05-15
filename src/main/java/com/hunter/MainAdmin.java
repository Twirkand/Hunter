package com.hunter;

import com.hunter.models.Monstruo;
import com.hunter.models.Objeto;
import com.hunter.models.Drop;

import com.hunter.repositories.*;
import com.hunter.repositories.sqlite.*;

import com.hunter.services.*;
import com.hunter.services.impl.*;

import java.util.Scanner;

public class MainAdmin {

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

        System.out.println(PURPLE + "PANEL ADMIN HUNTER" + RESET);

        while (true) {

            System.out.println(BLUE + "\n==============================" + RESET);
            System.out.println(YELLOW + "1. Crear monstruo" + RESET);
            System.out.println(YELLOW + "2. Crear objeto" + RESET);
            System.out.println(YELLOW + "3. Añadir drop (monstruo -> objeto)" + RESET);
            System.out.println(YELLOW + "4. Ver drops de monstruo" + RESET);
            System.out.println(RED + "0. Salir" + RESET);
            System.out.print(CYAN + "> " + RESET);

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {

                // ==================
                // CREAR MONSTRUO
                // ==================
                case 1 -> {

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Elemento: ");
                    String elemento = scanner.nextLine();


                    System.out.print("Primera aparición: ");
                    String primeraAparicion = scanner.nextLine();

                    Monstruo m = new Monstruo(0,nombre, tipo, elemento, primeraAparicion);

                    boolean ok = monstruoService.crear(m);

                    System.out.println(ok
                            ? GREEN + "Monstruo creado" + RESET
                            : RED + "Error al crear monstruo" + RESET);
                }

                // =====================
                // CREAR OBJETO
                // =====================
                case 2 -> {

                    Objeto o = new Objeto();

                    System.out.print("Nombre: ");
                    o.setNombre(scanner.nextLine());

                    System.out.print("Rareza: ");
                    o.setRareza(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Descripción: ");
                    o.setDescripcion(scanner.nextLine());

                    boolean ok = objetoService.crearObjeto(o);

                    System.out.println(ok
                            ? GREEN + "Objeto creado" + RESET
                            : RED + "Error al crear objeto" + RESET);
                }

                // ==============
                // CREAR DROP
                // ==============
                case 3 -> {

                    System.out.print("ID monstruo: ");
                    int idMonstruo = scanner.nextInt();

                    System.out.print("ID objeto: ");
                    int idObjeto = scanner.nextInt();

                    System.out.print("Probabilidad (%): ");
                    double prob = scanner.nextDouble();
                    scanner.nextLine();

                    boolean ok = dropService.crearDrop(
                            idMonstruo,
                            idObjeto,
                            prob);

                    System.out.println(ok
                            ? GREEN + "Drop añadido" + RESET
                            : RED + "Error al añadir drop" + RESET);
                }

                // ==============
                // VER DROPS
                // ==============
                case 4 -> {

                    System.out.print("ID o nombre monstruo: ");
                    String input = scanner.nextLine().trim();

                    var drops = input.matches("\\d+")
                            ? dropService.obtenerDropsPorMonstruo(Integer.parseInt(input))
                            : dropService.obtenerDropsPorMonstruo(input);

                    if (drops.isEmpty()) {
                        System.out.println(RED + "Sin drops" + RESET);
                        break;
                    }

                    System.out.println(PURPLE + "\nDROPS:" + RESET);

                    for (Drop d : drops) {

                        System.out.println(
                                CYAN + "- " + RESET +
                                        WHITE + d.getObjeto().getNombre() + RESET +
                                        " | " +
                                        YELLOW + d.getProbabilidad() + "%" +
                                        RESET);
                    }
                }

                // =====================================================
                // SALIR
                // =====================================================
                case 0 -> {
                    System.out.println(PURPLE + "Saliendo..." + RESET);
                    return;
                }

                default -> System.out.println(RED + "Opción inválida" + RESET);
            }
        }
    }
}