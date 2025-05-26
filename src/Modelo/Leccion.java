package Modelo;

public class Leccion {
    private int id;
    private String nssInstructor;
    private String telefonoCliente;
    private boolean individual;
    private String fecha;
    private String horaInicio;
    private String horaFinal;

    public Leccion() {}

    public Leccion(int id, String nssInstructor, String telefonoCliente, boolean individual, String fecha, String horaInicio, String horaFinal) {
        this.id = id;
        this.nssInstructor = nssInstructor;
        this.telefonoCliente = telefonoCliente;
        this.individual = individual;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public Leccion(String nssInstructor, String telefonoCliente, boolean individual, String fecha, String horaInicio, String horaFinal) {
        this.nssInstructor = nssInstructor;
        this.telefonoCliente = telefonoCliente;
        this.individual = individual;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNssInstructor() {
        return nssInstructor;
    }

    public void setNssInstructor(String nssInstructor) {
        this.nssInstructor = nssInstructor;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public boolean isIndividual() {
        return individual;
    }

    public void setIndividual(boolean individual) {
        this.individual = individual;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
}
