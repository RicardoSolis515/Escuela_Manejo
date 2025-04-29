package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Instructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorDAO {

    ConexionBD conexionBD = new ConexionBD();

    // ===================== Altas =====================
    public boolean agregarInstructor(Instructor instructor) {
        String sql = "INSERT INTO Instructor VALUES('" +
                instructor.getNSS() + "','" +
                instructor.getNombre() + "','" +
                instructor.getApellidoPaterno() + "','" +
                instructor.getApellidoMaterno() + "'," +
                instructor.isSenior() + ",'" +
                instructor.getMatriculaVehiculo() + "')";

        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    // ===================== Bajas =====================
    public boolean eliminarInstructor(String NSS) {
        String sql = "DELETE FROM Instructor WHERE NSS = '" + NSS + "'";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    // ===================== Cambios =====================
    public boolean editarInstructor(Instructor instructor) {
        String sql = "UPDATE Instructor SET " +
                "nombre = '" + instructor.getNombre() + "', " +
                "apellidoPaterno = '" + instructor.getApellidoPaterno() + "', " +
                "apellidoMaterno = '" + instructor.getApellidoMaterno() + "', " +
                "senior = " + instructor.isSenior() + ", " +
                "matriculaVehiculo = '" + instructor.getMatriculaVehiculo() + "' " +
                "WHERE NSS = '" + instructor.getNSS() + "'";

        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    // ===================== Consulta Individual =====================
    public Instructor mostrarInstructor(String NSS) {
        String sql = "SELECT * FROM Instructor WHERE NSS = '" + NSS + "'";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        Instructor i = null;

        try {
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
