import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class testPrograma {

    public static void main(String[] args) {
        // Declaracion de variables
        Scanner sc = new Scanner(System.in);
        int opcion, sinHorario = 0, distMin, distMax, cantAsientosNueA, cantVuelosNueA;
        String idVuelo, idAvion, dia, nuevoIdA, modeloNuevoA, idAnuevoV, idRnuevoV, diaNuevoV, horaNuevoV,
                nuevoNroVuelo;
        boolean idValido = false, idAvueValido = false, rutaValida = false, diaValido = false, horaValida = false,
                idAVuelo = false, nroVueloValido = false;
        double cantKmRecoNueA;

        // Creando listas de arreglo de los tipos correspondientes:
        List<Avion> avion = new ArrayList<>();
        List<Ruta> ruta = new ArrayList<>();
        List<Vuelo> vuelo = new ArrayList<>();

        // Cargo las listas creadas
        cargarAvion(avion);
        cargarRuta(ruta);
        cargarVuelo(vuelo);
        Vuelo[][] matVuelo = new Vuelo[7][15];// defino matriz de vuelo
        matVuelo = cargaMatVuelo(matVuelo, vuelo);

        // llamo al sout para ver mi matriz de vuelo
        // mostrarMatVuelo(matVuelo);
        // llamo sout para ver si lee bien los txt
        // mostrarDatosCargados(avion, ruta, vuelo);

        do {
            // Menu de opciones
            System.out.println("Ingresar opcion ");
            // Punto 2
            System.out.println("1-Agregar nuevo avion.");
            // Punto 3
            System.out.println("2-Agregar nuevo vuelo");
            // Punto 4
            System.out.println("3-Marcar aterrizaje de vuelo.");
            // Punto 5
            System.out.println("4-Ver promedio de pasajeros.");
            // Punto 6
            System.out.println("5-Mostrar lista de vuelos ordenada.");
            // Punto 7
            System.out.println("6-Mostrar datos de un avion.");
            // Punto 8
            System.out.println("7-Ver vuelos en una determinada distancaia.");
            // Punto 9
            System.out.println("8-Cantidad de vuelos sin horarios. ");
            // Punto 10
            System.out.println("9-Ver primer vuelo internacional.");
            System.out.println("0-Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo.");
                    break;
                case 1:
                    System.out.println("---------Ingresar un nuevo avion--------------");

                    do {
                        System.out.println("Ingrese un id valido para el nuevo avion:");
                        nuevoIdA = sc.nextLine();
                        idValido = validarFormatoIdA(nuevoIdA);
                        if (idValido) {
                            idValido = validarIdA(nuevoIdA, avion);
                        }
                    } while (!idValido);
                    System.out.println("Ingrese el modelo del Avion:");
                    modeloNuevoA = sc.nextLine();
                    System.out.println("Ingrese la cantidad de asientos del Avion:");
                    cantAsientosNueA = sc.nextInt();
                    System.out.println("Ingrese la cantidad de vuelos que realizo el Avion: ");
                    cantVuelosNueA = sc.nextInt();
                    System.out.println("Ingrese la cantidad de kilometros recorridos por el Avion:");
                    cantKmRecoNueA = sc.nextDouble();
                    avion.add(new Avion(nuevoIdA, modeloNuevoA, cantAsientosNueA, cantVuelosNueA, cantKmRecoNueA));
                    break;
                case 2:
                    System.out.println("---------Ingresar un nuevo vuelo--------------");
                    do {
                        System.out.println("Ingrese el numero de vuelo no existente:");
                        nuevoNroVuelo = sc.nextLine();
                        nuevoNroVuelo = "AR" + nuevoNroVuelo;
                        nroVueloValido = validarNumVuelo(nuevoNroVuelo, vuelo);
                    } while (!nroVueloValido);
                    do {
                        System.out.println("Ingrese un id valido de un avion existente:");
                        idAnuevoV = sc.nextLine();
                        idAvueValido = validarFormatoIdA(idAnuevoV);
                        if (idAvueValido) {
                            idAVuelo = validarIdA(idAnuevoV, avion);
                            if (!idAVuelo) {
                                idAvueValido = true;
                            } else {
                                System.out.println("Error: El avión no existe en el sistema.");
                                idAvueValido = false; // Forzamos a repetir el bucle
                            }
                        }
                    } while (!idAvueValido);
                    do {
                        System.out.println("Ingrese un id de ruta existente:");
                        idRnuevoV = sc.nextLine();
                        rutaValida = validarIdRuta(idRnuevoV, ruta);
                    } while (!rutaValida);
                    do {
                        System.out.println("Ingrese dia valido para el nuevo vuelo:");
                        diaNuevoV = sc.nextLine();
                        diaValido = validDia(diaNuevoV);
                    } while (!diaValido);
                    do {
                        System.out.println("Ingrese una hora valida (desde 09:00 hasta 21:00) para el nuevo vuelo:");
                        horaNuevoV = sc.nextLine();
                        horaValida = validarHoraNueV(horaNuevoV);
                    } while (!horaValida);
                    vuelo.add(new Vuelo(nuevoNroVuelo, idAnuevoV, idRnuevoV, diaNuevoV, horaNuevoV, false));
                    break;
                case 3:
                    System.out.println("---------Cambiar Estado de vuelo--------------");
                    System.out.println("Ingrese el id del vuelo: ");
                    idVuelo = sc.nextLine();
                    cambiarEstadoVuelo(idVuelo, vuelo, ruta, avion);
                    break;
                case 4:
                    System.out.println("---------Ver promedio de pasajeros--------------");
                    System.out.println("Ingrese el numero de vuelo: ");
                    idVuelo = sc.nextLine();
                    mostrarPromedio(vuelo, avion, idVuelo);
                    break;
                case 5:
                    System.out.println("---------Lista de Vuelos Ordenada--------------");
                    System.out.println("Ingrese el dia que quiere ordenar: ");
                    dia = sc.nextLine();
                    mostrarVuelosOrdenados(matVuelo, ruta, dia);
                    break;
                case 6:
                    System.out.println("---------Mostrar datos de un avion--------------");
                    System.out.println("Ingrese el id del Avion: ");
                    idAvion = sc.nextLine();
                    mostrarAvion(idAvion, avion);
                    break;
                case 7:
                    System.out.println("---------Mostrar vuelos en una determinada distancia--------------");
                    System.out.println("Ingrese la distancia minima que desea recorrer:");
                    distMin = sc.nextInt();
                    System.out.println("Ingrese la distancia maxima que desea recorrer:");
                    distMax = sc.nextInt();
                    List<Vuelo> mostrarDistVuelo = new ArrayList<>();
                    mostrarDistVuelo = buscarVueloDist(distMin, distMax, vuelo, mostrarDistVuelo, ruta);
                    if (mostrarDistVuelo.isEmpty()) {
                        System.out.println("No hay ningun vuelo que recorra ese rango de distancia.");
                    } else {
                        for (int i = 0; i < mostrarDistVuelo.size(); i++) {
                            System.out.println("Los vuelos en ese rango de distancia son:");
                            System.out.println();
                            System.out.println(mostrarDistVuelo.get(i));
                        }
                    }
                    break;
                case 8:
                    System.out.println("---------Ver cantidad de horarios sin vuelos--------------");
                    sinHorario = horarioSinVuelosRec(matVuelo, 0, 0);
                    System.out.println("La cantidad de horarios sin vuelos son: " + sinHorario);
                    break;
                case 9:
                    Vuelo[] arrVueloInter = new Vuelo[7];
                    System.out.println("---------Primer vuelo internacional del dia--------------");
                    arrVueloInter = vueloInternaciona(matVuelo, ruta, arrVueloInter);
                    for (int i = 0; i < arrVueloInter.length; i++) {
                        dia = cambioAdia(i);
                        if (arrVueloInter[i] != null) {
                            System.out.println("El primero vuelo internacional del " + dia + " es:");
                            System.out.println(arrVueloInter[i]);
                        } else {
                            System.out.println("El dia " + dia + " hay vuelos internacionales.");
                        }
                    }
                    break;
                default:
                    System.out.println("Opcion Invalida. Ingresar opcion valida");
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }

    // validar hora de vuelo
    public static boolean validarHoraNueV(String horaNuevoV) {
        boolean valida = false;
        int finHora = 0, horaV = 0;
        finHora = horaNuevoV.indexOf(":");
        if (finHora != -1) {
            String h = horaNuevoV.substring(0, finHora);
            horaV = Integer.parseInt(h);
            if ((horaV >= 8) && (horaV <= 21)) {
                valida = true;
            }
        }
        return valida;
    }

    // validar que no exista otro vuelo con ese numero
    public static boolean validarNumVuelo(String nuevoNroVuelo, List<Vuelo> vuelo) {
        boolean valido = true;
        Vuelo v;
        int i = 0;
        while ((i < vuelo.size()) && (valido)) {
            v = vuelo.get(i);
            if (v.getNroVuelo().equals(nuevoNroVuelo)) {
                valido = false;
            }
            i++;
        }
        return valido;
    }

    // validar dia
    public static boolean validDia(String diaNuevoV) {
        boolean valido = false;
        switch (diaNuevoV.toLowerCase()) {
            case "lunes":
                valido = true;
                break;
            case "martes":
                valido = true;
                break;
            case "miercoles":
                valido = true;
                break;
            case "jueves":
                valido = true;
                break;
            case "viernes":
                valido = true;
                break;
            case "sabado":
                valido = true;
                break;
            case "domingo":
                valido = true;
                break;

            default:
                System.out.println("Dia no existe.");
                break;
        }
        return valido;
    }

    // validar que exista ese id de ruta
    public static boolean validarIdRuta(String idRnuevoV, List<Ruta> ruta) {
        int i = 0;
        boolean valido = false;
        Ruta r;
        while ((i < ruta.size()) && (!valido)) {
            r = ruta.get(i);
            if (r.getNumRuta().equals(idRnuevoV)) {
                valido = true;
            }
            i++;
        }
        return valido;
    }

    // comparar ID avion si ya existe
    public static boolean validarIdA(String nuevoIda, List<Avion> avion) {
        boolean valido = true;
        Avion a;
        int i = 0;
        while ((i < avion.size()) && (valido)) {
            a = avion.get(i);
            if (a.getId().equals(nuevoIda)) {
                valido = false;
            }
            i++;
        }
        return valido;
    }

    // verificar que el formato del ID AVION sea valido
    public static boolean validarFormatoIdA(String nuevoIdA) {
        boolean idValido = true, encontrado = false;
        String prefijo1, prefijo2, prefijo3;
        int i;
        if ((nuevoIdA.length() <= 8) && (nuevoIdA.length() >= 6)) {
            if (nuevoIdA.length() == 6) {
                prefijo1 = nuevoIdA.substring(0, 3);
                switch (prefijo1) {
                    case "LV-":
                        i = 3;
                        while ((i < nuevoIdA.length()) && (!encontrado)) {

                            if (!Character.isLetter(nuevoIdA.charAt(i))) {
                                encontrado = true;
                                idValido = false;
                            }
                            i++;
                        }
                        break;

                    case "LQ-":
                        i = 3;
                        while ((i < nuevoIdA.length()) && (!encontrado)) {

                            if (!Character.isLetter(nuevoIdA.charAt(i))) {
                                encontrado = true;
                                idValido = false;
                            }
                            i++;
                        }
                        break;
                    default:
                        idValido = false;
                        break;
                }
            } else if (nuevoIdA.length() == 7) {
                prefijo2 = nuevoIdA.substring(0, 4);
                switch (prefijo2) {
                    case "LV-X":
                        i = 4;
                        while ((i < nuevoIdA.length()) && (!encontrado)) {

                            if (!Character.isDigit(nuevoIdA.charAt(i))) {
                                encontrado = true;
                                idValido = false;
                            }
                            i++;
                        }
                        break;

                    case "LV-S":
                        i = 4;
                        while ((i < nuevoIdA.length()) && (!encontrado)) {

                            if (!Character.isDigit(nuevoIdA.charAt(i))) {
                                encontrado = true;
                                idValido = false;
                            }
                            i++;
                        }
                        break;
                    default:
                        idValido = false;
                        break;
                }
            } else if (nuevoIdA.length() == 8) {
                prefijo3 = nuevoIdA.substring(0, 5);
                if (prefijo3.equals("LV-SX")) {
                    i = 5;
                    while ((i < nuevoIdA.length()) && (!encontrado)) {

                        if (!Character.isDigit(nuevoIdA.charAt(i))) {
                            encontrado = true;
                            idValido = false;
                        }
                        i++;
                    }
                } else {
                    idValido = false;
                }
            } else {
                idValido = false;
            }
        } else {
            idValido = false;
        }
        return idValido;
    }

    // cambio dia
    public static String cambioAdia(int i) {
        String dia = "";
        switch (i) {
            case 0:
                dia = "lunes";
                break;
            case 1:
                dia = "martes";
                break;
            case 2:
                dia = "miercoles";
                break;
            case 3:
                dia = "jueves";
                break;
            case 4:
                dia = "viernes";
                break;
            case 5:
                dia = "sabado";
                break;
            case 6:
                dia = "domingo";
                break;

            default:
                System.out.println("Dia no existe.");
                break;
        }
        return dia;
    }

    // modulo distancia
    public static List<Vuelo> buscarVueloDist(int distMin, int distMax, List<Vuelo> vuelo, List<Vuelo> distanciaVuelo,
            List<Ruta> ruta) {
        Vuelo v;
        double dist;
        String rutaV;
        for (int i = 0; i < vuelo.size(); i++) {
            v = vuelo.get(i);
            rutaV = v.getIdRuta();
            dist = distanciaVuelo(rutaV, ruta);
            if ((dist >= distMin) && (dist <= distMax)) {
                distanciaVuelo.add(v);
            }
        }
        return distanciaVuelo;
    }

    public static Vuelo[] vueloInternaciona(Vuelo[][] matVuelo, List<Ruta> ruta, Vuelo[] arrVueloInter) {
        int j;
        Vuelo vInter = null;
        String rutaV;
        boolean encontrado, inter = false;
        for (int i = 0; i < matVuelo.length; i++) {
            j = 0;
            encontrado = false;
            while ((j < matVuelo[i].length) && (!encontrado)) {
                if (matVuelo[i][j] != null) {
                    vInter = matVuelo[i][j];
                    rutaV = vInter.getIdRuta();
                    inter = vueloEsInter(rutaV, ruta);
                    if (inter) {
                        encontrado = true;
                        arrVueloInter[i] = vInter;
                    } else {
                        arrVueloInter[i] = null;
                    }
                }
                j++;
            }
        }

        return arrVueloInter;
    }

    public static boolean vueloEsInter(String rutaV, List<Ruta> ruta) {
        Ruta r;
        int i = 0;
        boolean encontrado = false;
        while (((i < ruta.size()) && (!encontrado))) {
            r = ruta.get(i);
            if (rutaV.equals(r.getNumRuta())) {
                if (r.getEsInternacional()) {
                    encontrado = true;
                }
            }
            i++;
        }
        return encontrado;

    }

    // modulo para ver que lee bien los txt
    /*
     * public static void mostrarDatosCargados(List<Avion> aviones, List<Ruta>
     * rutas, List<Vuelo> vuelos) {
     * 
     * System.out.println("=== AVIONES CARGADOS ===");
     * for (int i = 0; i < aviones.size(); i++) {
     * System.out.println(aviones.get(i));
     * }
     * 
     * System.out.println("\n=== RUTAS CARGADAS ===");
     * for (int i = 0; i < rutas.size(); i++) {
     * System.out.println(rutas.get(i));
     * }
     * 
     * System.out.println("\n=== VUELOS CARGADOS ===");
     * for (int i = 0; i < vuelos.size(); i++) {
     * System.out.println(vuelos.get(i));
     * }
     * }
     */

    // sout para ver los vuelos en mi matriz

    /*
     * public static void mostrarMatVuelo(Vuelo[][] matVuelo) {
     * 
     * System.out.println("\n----- MATRIZ DE VUELOS -----\n");
     * 
     * for (int f = 0; f < matVuelo.length; f++) {
     * System.out.print("Día " + f + ": ");
     * 
     * for (int c = 0; c < matVuelo[0].length; c++) {
     * 
     * if (matVuelo[f][c] != null) {
     * System.out.print(" | " + matVuelo[f][c].getNroVuelo() + " " +
     * matVuelo[f][c].getHora()+ " |");
     * 
     * } else {
     * System.out.print(" | ---- ");
     * }
     * }
     * System.out.println(" |");
     * }
     * 
     * System.out.println("\n----------------------------\n");
     * }
     */

    // modulo que me cambia los dias a filas
    public static int DiaAFila(String dia) {
        int diaV = 0;
        switch (dia.toLowerCase()) {
            case "lunes":
                diaV = 0;
                break;
            case "martes":
                diaV = 1;
                break;
            case "miercoles":
                diaV = 2;
                break;
            case "jueves":
                diaV = 3;
                break;
            case "viernes":
                diaV = 4;
                break;
            case "sabado":
                diaV = 5;
                break;
            case "domingo":
                diaV = 6;
                break;

            default:
                System.out.println("Dia no existe.");
                break;
        }
        return diaV;
    }

    // modulo que me cambia las horas a columnas
    public static int horaAColumna(String hora) {
        String h = hora.substring(0, 2);
        int num = 0, horaV = 0;
        num = Integer.parseInt(h);
        horaV = num - 8;
        return horaV;
    }

    // modulo que me verifica que el avion vuele una sola vez al dia
    public static boolean avionVoloDia(Vuelo[][] matVuelo, int filaDia, String avion) {
        boolean yaVolo = false;
        Vuelo existeV;
        String idAvion;
        for (int c = 0; c < 15; c++) {
            existeV = matVuelo[filaDia][c];
            if (existeV != null) {
                idAvion = existeV.getIdAvion();
                if (idAvion != null) {
                    if (idAvion.equals(avion)) {
                        yaVolo = true;
                    }
                }
            }
        }
        return yaVolo;
    }

    // modulo para ver si es internacional
    public static boolean esInter(String internacional) {
        boolean esInternacional = false;
        String op = internacional.toLowerCase();
        if (op.equals("si")) {
            esInternacional = true;
        }
        return esInternacional;
    }

    // Modulo para obtener la distancia del vuelo.
    public static double distanciaVuelo(String idRuta, List<Ruta> ruta) {
        int i = 0;
        Ruta r;
        boolean encontrado = false;
        double distanciaKm = 0;
        while (((i < ruta.size()) && (!encontrado))) {
            r = ruta.get(i);
            if (idRuta.equals(r.getNumRuta())) {
                encontrado = true;
                distanciaKm = r.getDistanciaKm();
            }
            i++;
        }
        return distanciaKm;
    }

    // modulo para cambiar el estado del vuelo
    public static void cambiarEstadoVuelo(String idVueloAct, List<Vuelo> vuelo, List<Ruta> ruta, List<Avion> avion) {
        int i = 0;
        Vuelo v;
        String idAvion, idRuta;
        boolean encontrado = false;
        double cantidadKm;
        while (((i < vuelo.size()) && (!encontrado))) {
            v = vuelo.get(i);
            idAvion = v.getIdAvion();
            idRuta = v.getIdRuta();
            if (idVueloAct.equals(v.getNroVuelo())) {
                encontrado = true;
                v.setRealizado(true);
                cantidadKm = distanciaVuelo(idRuta, ruta);
                actAvion(idAvion, avion, cantidadKm);
                System.out.println("Vuelo actualizado con exito!");
            }
            i++;
        }
        if (!encontrado) {
            System.out.println("Vuelo no encontrado");
        }
    }

    // modulo para actualizar los km y los vuelos del avion
    public static void actAvion(String idAvion, List<Avion> avion, double cantidadKm) {
        int i = 0;
        Avion v;
        boolean encontrado = false;
        while (((i < avion.size()) && (!encontrado))) {
            v = avion.get(i);
            if (idAvion.equals(v.getId())) {
                encontrado = true;
                v.sumarKmRec(cantidadKm);
                v.sumarVuelo();
            }
            i++;
        }
    }

    // Mostrar datos de un avion
    public static void mostrarAvion(String idAvion, List<Avion> avion) {
        int i = 0;
        Avion av;
        boolean encontrado = false;
        while (((i < avion.size()) && (!encontrado))) {
            av = avion.get(i);
            if (idAvion.equals(av.getId())) {
                encontrado = true;
                System.out.println(av.toString());
            }
            i++;
        }
        if (!encontrado) {
            System.out.println("Avion no encontrado");
        }
    }

    // mostrar y calcular el promedio de pasajeros recursivamente
    public static double[] pasajerosRec(List<Vuelo> vuelo, List<Avion> avion, String idVuelo, int i) {
        double[] pasajeros = new double[2];
        if (i == vuelo.size()) {
            pasajeros[0] = 0;
            pasajeros[1] = 0;
        } else {
            Vuelo v = vuelo.get(i);
            pasajeros = pasajerosRec(vuelo, avion, idVuelo, i + 1);
            if (v.getNroVuelo().equals(idVuelo)) {
                Avion a = buscarAvionRec(v.getIdAvion(), avion, 0);
                if (v.getRealizado()) {// verifico si el vuelo ya fue hecho
                    if (a != null) {
                        pasajeros[0] += a.getCantAsientos();// suma pasajeros
                        pasajeros[1] += 1;// suma vuelo
                    }
                }
            }
        }

        return pasajeros;
    }

    // modulo para buscar el avion de forma recursiva
    public static Avion buscarAvionRec(String idAvion, List<Avion> avion, int i) {
        Avion a, encontrado;
        if (i == avion.size()) {
            encontrado = null;
        } else {
            a = avion.get(i);
            if (a.getId().equals(idAvion)) {
                encontrado = a;
            } else {
                encontrado = buscarAvionRec(idAvion, avion, i + 1);
            }
        }
        return encontrado;
    }

    // modulo para calcular promedio
    public static void mostrarPromedio(List<Vuelo> vuelo, List<Avion> avion, String idVuelo) {
        double[] promedio = pasajerosRec(vuelo, avion, idVuelo, 0); // promedio[0] pasajeros, promedio[1] vuelo
        double prom;

        if (promedio[1] == 0) {
            System.out.println("El vuelo " + idVuelo + " no exste o no fue realizado");
        } else {
            prom = promedio[0] / promedio[1];
            System.out.println("El promedio de pasajeros que volaron en el vuelo " + idVuelo + " es: " + prom);
        }
    }

    // metodo de ordenamiento

    public static List<Vuelo> mergeSort(List<Vuelo> arregloVuelo, List<Ruta> ruta) {
        int mitad;
        List<Vuelo> listaVuelo = new ArrayList<>();
        if (arregloVuelo.size() > 1) {
            mitad = arregloVuelo.size() / 2;
            List<Vuelo> arregloIzquierdo = new ArrayList<>(arregloVuelo.subList(0, mitad));// creo arreglo izq
                                                                                           // divindiendo el origianl
            List<Vuelo> arregloDerecho = new ArrayList<>(arregloVuelo.subList(mitad, arregloVuelo.size()));// creo
                                                                                                           // arreglo
                                                                                                           // derecho
                                                                                                           // divindiendo
                                                                                                           // el
                                                                                                           // origianl
            arregloIzquierdo = mergeSort(arregloIzquierdo, ruta);
            arregloDerecho = mergeSort(arregloDerecho, ruta);
            listaVuelo = merge(arregloIzquierdo, arregloDerecho, ruta);
        } else {
            listaVuelo = arregloVuelo;
        }
        return listaVuelo;
    }

    public static List<Vuelo> merge(List<Vuelo> arregloIzquierdo, List<Vuelo> arregloDerecho, List<Ruta> ruta) {
        List<Vuelo> aux = new ArrayList<>();
        int i = 0, j = 0;
        Vuelo vuelo = arregloIzquierdo.get(i), vuelo2 = arregloDerecho.get(j);
        ;
        double distancia1, distancia2;
        // mientras haya elementos en ambas listas, repito
        while ((i < arregloIzquierdo.size()) && (j < arregloDerecho.size())) {
            vuelo = arregloIzquierdo.get(i);
            vuelo2 = arregloDerecho.get(j);
            distancia1 = distanciaVuelo(vuelo.getIdRuta(), ruta);
            distancia2 = distanciaVuelo(vuelo2.getIdRuta(), ruta);
            if (distancia1 <= distancia2) { // comparo las distancias
                aux.add(vuelo);
                i++;
            } else {
                aux.add(vuelo2);
                j++;
            }
        }
        // copio elementos que quedaron sin comparar en la primera lista
        while (i < arregloIzquierdo.size()) {
            aux.add(arregloIzquierdo.get(i));
            i++;
        }
        // copio elementos que quedaron sin comparar en la segunda lista
        while (j < arregloDerecho.size()) {
            aux.add(arregloDerecho.get(j));
            j++;
        }
        return aux;
    }

    public static void mostrarVuelosOrdenados(Vuelo[][] matVuelo, List<Ruta> ruta, String dia) {
        int fila = DiaAFila(dia);
        double km;
        List<Vuelo> lista = new ArrayList<>();
        if (fila >= 0 && fila <= 6) {
            for (int i = 0; i < matVuelo.length; i++) {
                Vuelo v = matVuelo[fila][i];
                if (v != null) {
                    lista.add(v);
                }
            }
            if (!(lista.isEmpty())) {
                lista = mergeSort(lista, ruta);
                guardarArchivo(lista, dia);
                System.out.println("Vuelos Ordenados: ");
                for (Vuelo v : lista) {
                    km = distanciaVuelo(v.getIdRuta(), ruta);
                    System.out.println("Vuelo: " + v.getNroVuelo() +
                            " | Avion: " + v.getIdAvion() +
                            " | Ruta: " + v.getIdRuta() +
                            " | Dia: " + v.getDia() +
                            " | Hora: " + v.getHora() +
                            " | KM: " + km);
                }
            }
        }
    }

    private static void guardarArchivo(List<Vuelo> vuelo, String dia) {
        try {
            String nombreArchivo = "VuelosOrdenados-" + dia + ".txt";
            FileWriter archivo = new FileWriter("C:\\Users\\Marcos\\OneDrive\\Escritorio\\DA\\" + nombreArchivo, true);
            BufferedWriter escritor = new BufferedWriter(archivo);
            for (Vuelo v : vuelo) {
                escritor.write(v.getNroVuelo() + ";" + v.getIdAvion() + ";" + v.getIdRuta() + ";" + v.getDia() + ";"
                        + v.getHora());
                escritor.newLine();
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ------------------CARGAR COSAS------------------

    private static void cargarAvion(List<Avion> avion) {
        String nombreArchivoEntrada = "Aviones.txt";// guardo el nombre del archivo en un string
        // gestion de errores
        try {
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada); // leo
            BufferedReader lectura = new BufferedReader(lectorArchivo); // archivos
            String linea = ""; // creo variable linea vacia, para leer cada linea del txt
            while ((linea = lectura.readLine()) != null) { // se recorre mientras haya una linea
                String[] bloque = linea.split(";"); // variable para leer cada cadena de linea y separarlo con el ;
                if (bloque.length == 5) { // valido si la cadena del bloque tiene todos los datos

                    String id = (bloque[0]);
                    String modelo = bloque[1];
                    int cantAsientos = Integer.parseInt(bloque[2]); // uso Integer.parseInt para cambiar el tipo de dato
                    int cantVuelos = Integer.parseInt(bloque[3]); // uso Integer.parseInt para cambiar el tipo de dato
                    double kmRec = Double.parseDouble(bloque[4]); // uso Double.parseInt para cambiar el tipo de dato

                    // Almaceno en la lista
                    avion.add(new Avion(id, modelo, cantAsientos, cantVuelos, kmRec));
                }
            }
            lectorArchivo.close();
            lectura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo no existe.");
        } catch (IOException error) {
            System.out.println("Error al leer el archivo " + error.getMessage());
        }
    }

    private static void cargarRuta(List<Ruta> ruta) {
        String nombreArchivoEntrada = "Rutas.txt";// guardo el nombre del archivo en un string
        // gestion de errores
        try {
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada); // leo
            BufferedReader lectura = new BufferedReader(lectorArchivo); // archivos
            String linea = ""; // creo variable linea vacia, para leer cada linea del txt
            while ((linea = lectura.readLine()) != null) { // se recorre mientras haya una linea
                String[] bloque = linea.split(";"); // variable para leer cada cadena de linea y separarlo con el ;
                if (bloque.length == 5) { // valido si la cadena del bloque tiene todos los datos

                    String numRuta = (bloque[0]);
                    String ciudadOrigen = bloque[1];
                    String ciudadDestino = bloque[2];
                    double distanciaKm = Double.parseDouble(bloque[3]); // uso Double.parseInt para cambiar el tipo de
                                                                        // dato
                    // guardo el string del txt y llamo al moduo para devolver el v/f de
                    // internacional
                    String internacional = bloque[4];
                    boolean esInternacional = esInter(internacional);
                    // Almaceno en la lista
                    ruta.add(new Ruta(numRuta, ciudadOrigen, ciudadDestino, distanciaKm, esInternacional));
                }
            }
            lectorArchivo.close();
            lectura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo no existe.");
        } catch (IOException error) {
            System.out.println("Error al leer el archivo " + error.getMessage());
        }

    }

    private static void cargarVuelo(List<Vuelo> vuelo) {
        String nombreArchivoEntrada = "Vuelos.txt";// guardo el nombre del archivo en un string
        // gestion de errores
        try {
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada); // leo
            BufferedReader lectura = new BufferedReader(lectorArchivo); // archivos
            String linea = ""; // creo variable linea vacia, para leer cada linea del txt
            while ((linea = lectura.readLine()) != null) { // se recorre mientras haya una linea
                String[] bloque = linea.split(";"); // variable para leer cada cadena de linea y separarlo con el ;
                if (bloque.length == 5) { // valido si la cadena del bloque tiene todos los datos

                    String nroVuelo = bloque[0];
                    String idAvion = bloque[1];
                    String idRuta = bloque[2];
                    String dia = bloque[3];
                    String hora = bloque[4];

                    // Almaceno en la lista
                    vuelo.add(new Vuelo(nroVuelo, idAvion, idRuta, dia, hora, false));
                }
            }
            lectorArchivo.close();
            lectura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo no existe.");
        } catch (IOException error) {
            System.out.println("Error al leer el archivo " + error.getMessage());
        }

    }

    // modulo que me carga la matriz de vuelo con todas sus condiciones
    public static Vuelo[][] cargaMatVuelo(Vuelo[][] matVuelo, List<Vuelo> vuelos) {
        Vuelo v;
        int fila = 0, colum = 0;
        boolean yaVolo = false;
        for (int i = 0; i < vuelos.size(); i++) {
            v = vuelos.get(i);
            fila = DiaAFila(v.getDia());
            colum = horaAColumna(v.getHora());
            if (matVuelo[fila][colum] == null) {
                yaVolo = avionVoloDia(matVuelo, fila, v.getIdAvion());
                if (!yaVolo) {
                    matVuelo[fila][colum] = v;
                }
            }
        }

        return matVuelo;
    }

    // modulo para calcular recursivamente horarios sin vuelos
    public static int horarioSinVuelosRec(Vuelo[][] matVuelo, int i, int j) {
        int cantidad = 0;
        if (i < matVuelo.length) {
            if (j < matVuelo[i].length) {
                if (matVuelo[i][j] == null) {
                    cantidad = 1 + horarioSinVuelosRec(matVuelo, i, j + 1);
                } else {
                    cantidad = horarioSinVuelosRec(matVuelo, i, j + 1);
                }
            } else {
                cantidad = horarioSinVuelosRec(matVuelo, i + 1, 0);
            }
        }
        return cantidad;
    }
}
