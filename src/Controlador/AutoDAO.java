package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Auto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutoDAO {
    ConexionBD conexionBD = new ConexionBD();

    public boolean agregarAuto(Auto auto) {
        String sql = "INSERT INTO Auto VALUES('" +
                auto.getMatricula() + "'," +
                auto.isAsignado() + ",'" +
                auto.getMarca() + "','" +
                auto.getModelo() + "','" +
                auto.getKilometraje() + "')";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public boolean eliminarAuto(String matricula) {
        String sql = "DELETE FROM Auto WHERE matricula = '" + matricula + "'";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public boolean editarAuto(Auto auto) {
        String sql = "UPDATE Auto SET " +
                "asignado = " + auto.isAsignado() + ", " +
                "marca = '" + auto.getMarca() + "', " +
                "modelo = '" + auto.getModelo() + "', " +
                "kilometraje = '" + auto.getKilometraje() + "' " +
                "WHERE matricula = '" + auto.getMatricula() + "'";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public Auto mostrarAuto(String matricula) {
        String sql = "SELECT * FROM Auto WHERE matricula = '" + matricula + "'";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);
        Auto auto = null;

        try {
            if (rs.next()) {
                auto = new Auto(
                        rs.getBoolean("asignado"),
                        rs.getString("matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("kilometraje")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auto;
    }

    public ArrayList<Auto> mostrarAutos() {
        ArrayList<Auto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Auto";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Auto auto = new Auto(
                        rs.getBoolean("asignado"),
                        rs.getString("matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("kilometraje")
                );
                lista.add(auto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
