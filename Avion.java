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

    Avion(String id, String modelo, int cantAsientos,int cantVuelos, double kmRec) {
        this.id = id;
        this.modelo = modelo;
        this.cantAsientos = cantAsientos;
        this.cantVuelos = cantVuelos;
        this.kmRec = kmRec;
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

    public String toString() {
        return this.id + " " + this.modelo + " " + this.cantAsientos + " " + this.kmRec+ " " + this.cantVuelos;

    }

    public boolean equals(Avion unAvion) {
        return this.id == unAvion.id;
    }

    public void setKmRec(double km) {
        this.kmRec = km;
    }

    public void setCantVuelos(int vuelo) {
        this.cantVuelos = vuelo;
    }

    public void setCantAsientos(int cant) {
        this.cantAsientos = cant;
    }

}