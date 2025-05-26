package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Instructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorDAO {

    ConexionBD conexionBD = ConexionBD.getInstancia();

    // ===================== Altas =====================
    public boolean agregarInstructor(Instructor instructor) {
        String sql = "INSERT INTO Instructor (NSS, nombre, apellidoPaterno, apellidoMaterno, senior, matriculaVehiculo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, instructor.getNSS());
            ps.setString(2, instructor.getNombre());
            ps.setString(3, instructor.getApellidoPaterno());
            ps.setString(4, instructor.getApellidoMaterno());
            ps.setBoolean(5, instructor.isSenior());
            ps.setString(6, instructor.getMatriculaVehiculo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===================== Bajas =====================
    public boolean eliminarInstructor(String NSS) {
        String sql = "DELETE FROM Instructor WHERE NSS = ?";
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, NSS);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===================== Cambios =====================
    public boolean editarInstructor(Instructor instructor) {
        String sql = "UPDATE Instructor SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, senior = ?, matriculaVehiculo = ? WHERE NSS = ?";
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, instructor.getNombre());
            ps.setString(2, instructor.getApellidoPaterno());
            ps.setString(3, instructor.getApellidoMaterno());
            ps.setBoolean(4, instructor.isSenior());
            ps.setString(5, instructor.getMatriculaVehiculo());
            ps.setString(6, instructor.getNSS());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===================== Consulta Individual =====================
    public Instructor mostrarInstructor(String NSS) {
        String sql = "SELECT * FROM Instructor WHERE NSS = ?";
        Instructor i = null;
        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, NSS);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = new Instructor(
                        rs.getString("NSS"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getBoolean("senior"),
                        rs.getString("matriculaVehiculo")
                );
            } else {
                System.out.println("Instructor no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    // ===================== Lista de Instructores =====================
    public ArrayList<Instructor> mostrarInstructores() {
        ArrayList<Instructor> listaInstructores = new ArrayList<>();
        String sql = "SELECT * FROM Instructor";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Instructor i = new Instructor(
                        rs.getString("NSS"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getBoolean("senior"),
                        rs.getString("matriculaVehiculo")
                );
                listaInstructores.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaInstructores;
    }
}
