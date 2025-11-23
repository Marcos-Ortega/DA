public class Ruta {
    private String numRuta;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double distanciaKm;
    private boolean internacional;

    // Contructores
    // constructor vacio
    Ruta(String elNumRuta) {
        this.numRuta = elNumRuta;
        this.ciudadOrigen = "";
        this.ciudadDestino = "";
        this.distanciaKm = 0.0;
        this.internacional = false;
    }

    Ruta(String elNumRuta, String laCiudadOrigen, String laCiudadDestino, double laDistanciaKm, boolean esInternacional) {
        this.numRuta = elNumRuta;
        this.ciudadOrigen = laCiudadOrigen;
        this.ciudadDestino = laCiudadDestino;
        this.distanciaKm = laDistanciaKm;
        this.internacional = esInternacional;
    }

    //Observadores
    public String getNumRuta(){
        return this.numRuta;
    }
    public String getCiudadOrigen(){
        return this.ciudadOrigen;
    }
    public String getCiudadDestino(){
        return this.ciudadDestino;
    }
    public Double getDistanciaKm(){
        return this.distanciaKm;
    }
    public boolean getEsInternacional(){
        return this.internacional;
    }

    //Modificadores
    public void setCiudadOrigen(String laCiudadOrigen){
        this.ciudadOrigen=laCiudadOrigen;
    }
    public void setCiudadDestino(String laCiudadDestino){
        this.ciudadDestino=laCiudadDestino;
    }
    public void setDistanciaKm(Double laDistanciaKm){
        this.distanciaKm=laDistanciaKm;
    }
    public void setEsInternacional(boolean esInternacional){
        this.internacional= esInternacional;
    }

    //Propios del Tipo
    public String toString() {
        return "Ruta: " + numRuta + "  Ciudad de Origen: " + ciudadOrigen + "  Ciudad de Destino: " + ciudadDestino + 
               " Distancia en kilometros " + distanciaKm + " Es internacional?" + internacional;
    }

    public boolean equals(Ruta OtraRuta){
        return this.numRuta.equals(OtraRuta);
    }

}