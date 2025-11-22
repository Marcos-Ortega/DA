public class Vuelo {
    //aTRIBUTOS
    private String nroVuelo;      
    private String idAvion;       
    private String idRuta;        
    private String dia;           
    private String hora;          

    private int cantPasajeros;    
    private boolean realizado;    

    //Constructuroes
    Vuelo(String nroVuelo, String idAvion, String idRuta, String dia, String hora) {
        this.nroVuelo = nroVuelo;
        this.idAvion = idAvion;
        this.idRuta = idRuta;
        this.dia = dia;
        this.hora = hora;
        this.cantPasajeros = 0;
        this.realizado = false;
    }
    Vuelo(String nroVuelo, String idAvion, String idRuta, String dia, String hora, int cantPasajeros) {
        this.nroVuelo = nroVuelo;
        this.idAvion = idAvion;
        this.idRuta = idRuta;
        this.dia = dia;
        this.hora = hora;
        this.cantPasajeros = cantPasajeros;
        this.realizado = false;
    }

    //get
    public String getNroVuelo() { 
        return nroVuelo; 
    }

    public String getIdAvion() {
        return idAvion; 
    }

    public String getIdRuta() { 
        return idRuta; 
    }

    public String getDia() { 
        return dia; 
    }

    public String getHora() { 
        return hora; 
    }

    public int getCantPasajeros() { 
        return cantPasajeros; 
    }
    //set
    public void setNroVuelo(String nroVuelo) { 
        this.nroVuelo = nroVuelo; 
    }

    public void setIdAvion(String idAvion) { 
        this.idAvion = idAvion; 
    }

    public void setIdRuta(String idRuta) { 
        this.idRuta = idRuta; 
    }

    public void setDia(String dia) { 
        this.dia = dia; 
    }

    public void setHora(String hora) { 
        this.hora = hora; 
    }

    public void setCantPasajeros(int cantPasajeros) { 
        this.cantPasajeros = cantPasajeros; 
    }

    public boolean isRealizado() { 
        return realizado; 
    }

    public void setRealizado(boolean realizado) { 
        this.realizado = realizado; 
    }
    //propio del tipo
    public String toString() {
        return "Vuelo: " + nroVuelo + "  Avion: " + idAvion + "  Ruta: " + idRuta + 
               "  " + dia + " " + hora + "hs"+" Pasajeros: " + cantPasajeros + "  Estado: " +(realizado);
    }
}
