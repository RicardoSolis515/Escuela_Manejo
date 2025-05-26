package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Auto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutoDAO {
    ConexionBD conexionBD = ConexionBD.getInstancia();

    public boolean agregarAuto(Auto auto) {
        String sql = "INSERT INTO Auto VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, auto.getMatricula());
            ps.setBoolean(2, auto.isAsignado());
            ps.setString(3, auto.getMarca());
            ps.setString(4, auto.getModelo());
            ps.setString(5, auto.getKilometraje());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAuto(String matricula) {
        String sql = "DELETE FROM Auto WHERE matricula = ?";
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, matricula);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editarAuto(Auto auto) {
        String sql = "UPDATE Auto SET asignado = ?, marca = ?, modelo = ?, kilometraje = ? WHERE matricula = ?";
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setBoolean(1, auto.isAsignado());
            ps.setString(2, auto.getMarca());
            ps.setString(3, auto.getModelo());
            ps.setString(4, auto.getKilometraje());
            ps.setString(5, auto.getMatricula());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean autoAsignacion(boolean estado, String matricula) {
        String sql = "UPDATE Auto SET asignado = ? WHERE matricula = ?";
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setBoolean(1, estado);
            ps.setString(2, matricula);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Auto mostrarAuto(String matricula) {
        String sql = "SELECT * FROM Auto WHERE matricula = ?";
        Auto auto = null;
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
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
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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

    public ArrayList<Auto> mostrarAutosDisponibles() {
        ArrayList<Auto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Auto WHERE asignado = false";
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
