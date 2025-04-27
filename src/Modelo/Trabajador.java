package Modelo;

public class Trabajador {
    private String NSS;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Trabajador(String NSS, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.NSS = NSS;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNSS() {
        return NSS;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
}
