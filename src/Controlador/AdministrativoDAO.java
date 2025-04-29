package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Administrativo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdministrativoDAO {

    ConexionBD conexionBD = new ConexionBD();

    // ===================== Altas =====================
    public boolean agregarAdministrativo(Administrativo administrativo) {
        String sql = "INSERT INTO Administrativo VALUES('" +
                administrativo.getNSS() + "','" +
                administrativo.getNombre() + "','" +
                administrativo.getApellidoPaterno() + "','" +
                administrativo.getApellidoMaterno() + "','" +
                administrativo.getPuesto() + "')";

        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    // ===================== Bajas =====================
    public boolean eliminarAdministrativo(String NSS) {
        String sql = "DELETE FROM Administrativo WHERE NSS = '" + NSS + "'";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    // ===================== Cambios =====================
    public boolean editarAdministrativo(Administrativo administrativo) {
        String sql = "UPDATE Administrativo SET " +
                "nombre = '" + administrativo.getNombre() + "', " +
                "apellidoPaterno = '" + administrativo.getApellidoPaterno() + "', " +
                "apellidoMaterno = '" + administrativo.getApellidoMaterno() + "', " +
                "puesto = '" + administrativo.getPuesto() + "' " +
                "WHERE NSS = '" + administrativo.getNSS() + "'";

        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    // ===================== Consulta Individual =====================
    public Administrativo mostrarAdministrativo(String NSS) {
        String sql = "SELECT * FROM Administrativo WHERE NSS = '" + NSS + "'";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        Administrativo a = null;

        try {
            if (rs.next()) {
                a = new Administrativo(
                        rs.getString("NSS"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("puesto")
                );
            } else {
                System.out.println("Administrativo no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;
    }

    // ===================== Lista de Administrativos =====================
    public ArrayList<Administrativo> mostrarAdministrativos() {
        ArrayList<Administrativo> listaAdministrativos = new ArrayList<>();
        String sql = "SELECT * FROM Administrativo";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Administrativo a = new Administrativo(
                        rs.getString("NSS"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("puesto")
                );
                listaAdministrativos.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaAdministrativos;
    }
}
