package Modelo;


public class Leccion {
    private String nssInstructor;
    private String telefonoCliente;
    private boolean individual;
    private String fecha;
    private String horaInicio;
    private String horaFinal;

    public Leccion(){}

    public Leccion(String nssInstructor, String telefonoCliente, boolean individual, String fecha, String horaInicio, String horaFinal) {
        this.nssInstructor = nssInstructor;
        this.telefonoCliente = telefonoCliente;
        this.individual = individual;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public void setNssInstructor(String nssInstructor) {
        this.nssInstructor = nssInstructor;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setIndividual(boolean individual) {
        this.individual = individual;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getNssInstructor() {
        return nssInstructor;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public boolean isIndividual() {
        return individual;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }
}
