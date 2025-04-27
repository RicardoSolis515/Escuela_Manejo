package Modelo;

public class Auto {
    private boolean asignado;
    private String matricula;
    private String marca;
    private String modelo;
    private String kilometraje;

    public Auto(boolean asignado, String matricula, String marca, String modelo, String kilometraje) {
        this.asignado = asignado;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getKilometraje() {
        return kilometraje;
    }
}
