import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testPrograma {

    public static void main(String[] args) {
        List<Avion> avion = new ArrayList<>(); /* creo lista de arreglo de tipo Avion con el nombre de avion */
        List<Ruta> ruta = new ArrayList<>(); /* creo lista de arreglo de tipo Ruta con el nombre de ruta */
        List<Vuelo> vuelo = new ArrayList<>();
        cargarAvion(avion);
        cargarRuta(ruta);
        cargarVuelo(vuelo, avion, ruta);
        Vuelo [][] matVuelo=new Vuelo[7][15];
        matVuelo=cargaMatVuelo(matVuelo, vuelo);
        //mostrarMatVuelo(matVuelo);
        
        /*   // --- IMPRIMIR PARA VER SI CARGÓ BIEN ---
        System.out.println("=== AVIONES CARGADOS ===");
        for (Avion a : avion) {
            System.out.println(a);
        }

        System.out.println("\n=== RUTAS CARGADAS ===");
        for (Ruta r : ruta) {
            System.out.println(r);
        }

        System.out.println("\n=== VUELOS CARGADOS ===");
        for (Vuelo v : vuelo) {
            System.out.println(v);
        }*/
    }
    //sout para ver los vuelos en mi matriz
    /*public static void mostrarMatVuelo(Vuelo[][] matVuelo) {

    System.out.println("\n----- MATRIZ DE VUELOS -----\n");

    for (int f = 0; f < matVuelo.length; f++) {
        System.out.print("Día " + f + ": ");

        for (int c = 0; c < matVuelo[0].length; c++) {

            if (matVuelo[f][c] != null) {
                System.out.print(" | " + matVuelo[f][c].getNroVuelo() + " ");
            } else {
                System.out.print(" | ---- ");
            }
        }
        System.out.println(" |");
    }

    System.out.println("\n----------------------------\n");
}*/

    public static int DiaAFila(String dia){
        int diaV=0;
        dia=dia.toLowerCase();
        switch (dia) {
            case "lunes":
                diaV=0;
                break;
            case "martes":
                diaV=1;
                break;
            case "miercoles":
                diaV=2;
                break;
            case "jueves":
                diaV=3;
                break;
            case "viernes":
                diaV=4;
                break;
            case "sabado":
                diaV=5;
                break;
            case "domingo":
                diaV=6;
                break;
        
            default:
                break;
        }
        return diaV;
    }
    public static int horaAColumna(String hora){
        String h = hora.substring(0, 2); 
        int num=0, horaV=0; 
        num = Integer.parseInt(h);   
        horaV= num - 8;  
        return horaV;               
    }
    public static boolean avionVoloDia(Vuelo[][] matVuelo, int filaDia, Avion avion) {
        boolean yaVolo = false;
        Vuelo existeV;
        Avion idAvion;
        for (int c = 0; c < 15; c++) {
            existeV=matVuelo[filaDia][c];
            if (existeV!=null) {
                idAvion=existeV.getIdAvion();
                if(idAvion!=null){
                    if (idAvion.equals(avion)) {
                        yaVolo=true;
                    }
                }
            }        
        }
        return yaVolo;
    }

    public static Vuelo[][] cargaMatVuelo(Vuelo [][] matVuelo, List<Vuelo>vuelos){
        Vuelo v;
        int fila=0, colum=0;
        boolean yaVolo=false;
        for(int i=0;i<vuelos.size();i++){
            v=vuelos.get(i);
            fila= DiaAFila(v.getDia());
            colum=horaAColumna(v.getHora());
            if (matVuelo[fila][colum]==null) {
                yaVolo=avionVoloDia(matVuelo, fila,v.getIdAvion());
                if(!yaVolo){
                    matVuelo[fila][colum]=v;
                }
            }
        }

        return matVuelo;
    }

    public static Avion buscarIdAvion(List<Avion> aviones, String idA) {
        Avion avion = null;
        int i = 0;
        boolean encontrado = false;
        String idAvion;
        while ((i < aviones.size()) && (!encontrado)) {
            avion = aviones.get(i);
            idAvion = avion.getId();
            if (!(idAvion.equals(idA))) {
                avion = null;
            } else {
                encontrado = true;
            }
            i++;
        }
        return avion;
    }

    public static Ruta buscarIdRuta(List<Ruta> rutas, String idR) {
        Ruta ruta = null;
        int i = 0;
        boolean encontrado = false;
        String idAvion;
        while ((i < rutas.size()) && (!encontrado)) {
            ruta = rutas.get(i);
            idAvion = ruta.getNumRuta();
            if (!(idAvion.equals(idR))) {
                ruta = null;
            } else {
                encontrado = true;
            }
            i++;
        }
        return ruta;
    }
    public static boolean esInter(String internacional){
        boolean esInternacional=false;
        String op= internacional.toLowerCase();
        if (op.equals("si")) {
            esInternacional=true;
        }
        return esInternacional;
    }

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
                    double distanciaKm = Double.parseDouble(bloque[3]); // uso Double.parseInt para cambiar el tipo de dato
                    String internacional = bloque[4]; 
                    boolean esInternacional= esInter(internacional); 
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

    private static void cargarVuelo(List<Vuelo> vuelo, List<Avion> avion, List<Ruta> ruta) {
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
                    String idA = bloque[1];
                    Avion idAvion = buscarIdAvion(avion, idA);
                    String idR = bloque[2];
                    Ruta idRuta =buscarIdRuta(ruta, idR);
                    String dia = bloque[3];
                    String hora = bloque[4];

                    // Almaceno en la lista
                    vuelo.add(new Vuelo(nroVuelo, idAvion, idRuta, dia, hora));
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
}
