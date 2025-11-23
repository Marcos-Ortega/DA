public class Vuelo {
    //aTRIBUTOS
    private String nroVuelo;      
    private Avion idAvion;       
    private Ruta idRuta;        
    private String dia;           
    private String hora;          
    private int cantPasajeros;    
    private boolean realizado;    

    //Constructuroes
    //constructor vacio
    Vuelo(String nroVuelo) {
        this.nroVuelo = nroVuelo;
        this.idAvion = null;
        this.idRuta = null;
        this.dia = "";
        this.hora = "";
        this.cantPasajeros = 0;
        this.realizado = false;
    }
    Vuelo(String nroVuelo, Avion idAvion, Ruta idRuta, String dia, String hora, int cantPasajeros) {
        this.nroVuelo = nroVuelo;
        this.idAvion = idAvion;
        this.idRuta = idRuta;
        this.dia = dia;
        this.hora = hora;
        this.cantPasajeros = cantPasajeros;
        this.realizado = false;
    }

    //Obseravores
    public String getNroVuelo() { 
        return this.nroVuelo; 
    }

    public Avion getIdAvion() {
        return this.idAvion; 
    }

    public Ruta getIdRuta() { 
        return this.idRuta; 
    }

    public String getDia() { 
        return this.dia; 
    }

    public String getHora() { 
        return this.hora; 
    }

    public int getCantPasajeros() { 
        return this.cantPasajeros; 
    }

    public boolean getRealizado(){
        return this.realizado;
    }

    //Modificadores
    public void setIdAvion(Avion idAvion) { 
        this.idAvion = idAvion; 
    }

    public void setIdRuta(Ruta idRuta) { 
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

    public boolean equals(Vuelo otroVuelo) {
        return this.nroVuelo.equals(otroVuelo);
    }
     
}
