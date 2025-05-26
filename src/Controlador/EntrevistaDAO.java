package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Entrevista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntrevistaDAO {
    ConexionBD conexionBD = ConexionBD.getInstancia();

    public boolean agregarEntrevista(Entrevista e) {
        String sql = "INSERT INTO Entrevista (nssInstructor, telefonoCliente, fecha) VALUES ('" +
                e.getNssInstructor() + "','" +
                e.getTelefonoCliente() + "','" +
                e.getFecha() + "')";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public boolean eliminarEntrevista(int idEntrevista) {
        String sql = "DELETE FROM Entrevista WHERE idEntrevista = " + idEntrevista;
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public ArrayList<Entrevista> mostrarEntrevistas() {
        ArrayList<Entrevista> lista = new ArrayList<>();
        String sql = "SELECT * FROM Entrevista";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Entrevista e = new Entrevista(
                        rs.getString("nssInstructor"),
                        rs.getString("telefonoCliente"),
                        rs.getString("fecha")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}
