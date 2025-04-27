package Modelo;

public class Entrevista {
    private String nssInstructor;
    private String telefonoCliente;
    private String fecha;

    public Entrevista(String nssInstructor, String telefonoCliente, String fecha) {
        this.nssInstructor = nssInstructor;
        this.telefonoCliente = telefonoCliente;
        this.fecha = fecha;
    }

    public void setNssInstructor(String nssInstructor) {
        this.nssInstructor = nssInstructor;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNssInstructor() {
        return nssInstructor;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getFecha() {
        return fecha;
    }
}
