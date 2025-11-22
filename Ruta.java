public class Ruta {
    private String numRuta;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double distanciaKm;
    private boolean internacional;

    Ruta(String numRuta, String ciudadOrigen, String ciudadDestino, double distanciaKm, boolean internacional) {
        this.numRuta = numRuta;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.distanciaKm = distanciaKm;
        this.internacional = internacional;
    }

    Ruta(String numRuta) {
        this.numRuta = numRuta;
        this.ciudadOrigen = "";
        this.ciudadDestino = "";
        this.distanciaKm = 0;
        this.internacional=false;
    }
    
}