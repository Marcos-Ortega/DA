public class Avion {
    private String id;
    private String modelo;
    private int cantAsientos;
    private int cantVuelos;
    private double kmRec;  

    //Constructor
    //constructor vacio
    Avion(String id) {
        this.id = id;
        this.modelo = "";
        this.cantAsientos = 0;
        this.cantVuelos = 0;
        this.kmRec = 0.0;
    }

    Avion(String elId, String elModelo, int laCantAsientos,int laCantVuelos, double km) {
        this.id = elId;
        this.modelo = elModelo;
        this.cantAsientos = laCantAsientos;
        this.cantVuelos = laCantVuelos;
        this.kmRec = km;
    }

    // Observadores
    public String getId() {
        return this.id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getCantAsientos() {
        return this.cantAsientos;
    }

    public double getKmRec() {
        return this.kmRec;
    }

    public double getCantVuelos() {
        return this.cantVuelos;
    }

    //Modificadores
    public void setKmRec(double km) {
        this.kmRec = km;
    }

    public void setCantVuelos(int laCantVuelos) {
        this.cantVuelos = laCantVuelos;
    }

    public void setCantAsientos(int laCantAsientos) {
        this.cantAsientos = laCantAsientos;
    }

    //propios del tipo
    public String toString() {
        return "Id del avion: "+this.id + " Modelo: " + this.modelo + " Cantidad de asientos: " + this.cantAsientos + " Kilometros recorridos: " + this.kmRec+ " Cantidad de vuelos realizados: " + this.cantVuelos;

    }

    public boolean equals(Avion unAvion) {
        return this.id.equals(unAvion.getId());
    }

    public void sumarKmRec(double km){
        this.kmRec += km;
    }
    public void sumarVuelo(){
        this.cantVuelos += 1;
    }
}