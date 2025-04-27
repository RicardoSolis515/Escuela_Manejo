package Modelo;

public class Cliente {
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String telefono;
    private String edad;
    private String dirreccion;
    private String necesidades;

    public Cliente(String nombre, String apellidoPat, String apellidoMat, String telefono, String edad, String dirreccion, String necesidades) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.telefono = telefono;
        this.edad = edad;
        this.dirreccion = dirreccion;
        this.necesidades = necesidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public void setNecesidades(String necesidades) {
        this.necesidades = necesidades;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEdad() {
        return edad;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public String getNecesidades() {
        return necesidades;
    }
}
