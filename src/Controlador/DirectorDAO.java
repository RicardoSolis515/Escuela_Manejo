package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Director;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DirectorDAO {
    ConexionBD conexionBD = new ConexionBD();

    public boolean agregarDirector(Director d) {
        String sql = "INSERT INTO Director VALUES('" +
                d.getNss() + "','" +
                d.getUsuario() + "','" +
                d.getContraseña() + "')";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public boolean eliminarDirector(String nss) {
        String sql = "DELETE FROM Director WHERE nss = '" + nss + "'";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public boolean editarDirector(Director d) {
        String sql = "UPDATE Director SET " +
                "usuario = '" + d.getUsuario() + "', " +
                "contraseña = '" + d.getContraseña() + "' " +
                "WHERE nss = '" + d.getNss() + "'";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public Director mostrarDirector(String nss) {
        String sql = "SELECT * FROM Director WHERE nss = '" + nss + "'";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);
        Director d = null;

        try {
            if (rs.next()) {
                d = new Director(
                        rs.getString("nss"),
                        rs.getString("contraseña"),
                        rs.getString("usuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return d;
    }
}
