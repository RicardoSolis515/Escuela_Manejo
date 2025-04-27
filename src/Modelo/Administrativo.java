package Modelo;

public class Administrativo extends Trabajador{
    private String puesto;

    public Administrativo(String NSS, String nombre, String apellidoPaterno, String apellidoMaterno, String puesto) {
        super(NSS, nombre, apellidoPaterno, apellidoMaterno);
        this.puesto = puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }
}
