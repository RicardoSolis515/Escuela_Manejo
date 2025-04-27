package Modelo;

public class Instructor extends Trabajador{
    private boolean senior;
    private String matriculaVehiculo;

    public Instructor(String NSS, String nombre, String apellidoPaterno, String apellidoMaterno, boolean senior, String matriculaVehiculo) {
        super(NSS, nombre, apellidoPaterno, apellidoMaterno);
        this.senior = senior;
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public boolean isSenior() {
        return senior;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }
}
