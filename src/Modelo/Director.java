package Modelo;

public class Director {
    private String nss;
    private String contraseña;
    private String usuario;

    public Director(String nss, String contraseña, String usuario) {
        this.nss = nss;
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNss() {
        return nss;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUsuario() {
        return usuario;
    }
}
