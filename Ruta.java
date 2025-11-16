public class Ruta {
    private int numRuta;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double distanciaKm;
    private boolean internacional;

    Ruta(int numRuta, String ciudadOrigen, String ciudadDestino, double distanciaKm, boolean internacional) {
        this.numRuta = numRuta;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.distanciaKm = distanciaKm;
        this.internacional = internacional;
    }

    Ruta(int numRuta) {
        this.numRuta = numRuta;
        this.ciudadOrigen = "";
        this.ciudadDestino = "";
        this.distanciaKm = 0;
    }
    
}