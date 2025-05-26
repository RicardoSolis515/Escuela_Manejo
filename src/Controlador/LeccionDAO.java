package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Leccion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeccionDAO {
    ConexionBD conexionBD = ConexionBD.getInstancia();

    public boolean agregarLeccion(Leccion l) {
        String sql = "INSERT INTO Leccion (nssInstructor, telefonoCliente, individual, fecha, horaInicio, horaFinal) VALUES ('" +
                l.getNssInstructor() + "','" +
                l.getTelefonoCliente() + "'," +
                l.isIndividual() + ",'" +
                l.getFecha() + "','" +
                l.getHoraInicio() + "','" +
                l.getHoraFinal() + "')";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public boolean eliminarLeccion(int idLeccion) {
        // Cambiado de idLeccion a id
        String sql = "DELETE FROM Leccion WHERE id = " + idLeccion;
        return conexionBD.ejecutarInstruccionLMD(sql);
    }



    public boolean editarLeccion(int id, Leccion l) {
        String sql = "UPDATE Leccion SET " +
                "nssInstructor = '" + l.getNssInstructor() + "', " +
                "telefonoCliente = '" + l.getTelefonoCliente() + "', " +
                "individual = " + l.isIndividual() + ", " +
                "fecha = '" + l.getFecha() + "', " +
                "horaInicio = '" + l.getHoraInicio() + "', " +
                "horaFinal = '" + l.getHoraFinal() + "' " +
                "WHERE id = " + id;
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public Leccion obtenerLeccionPos(int pos, String condicion) {
        ArrayList<Leccion> lecciones = mostrarLecciones(condicion);
        if (pos >= 0 && pos < lecciones.size()) {
            return lecciones.get(pos);
        }
        return null;
    }

    public ArrayList<Leccion> mostrarLecciones(String condicion) {
        ArrayList<Leccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Leccion "+condicion;
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Leccion l = new Leccion(
                        rs.getInt("id"), // Nueva línea
                        rs.getString("nssInstructor"),
                        rs.getString("telefonoCliente"),
                        rs.getBoolean("individual"),
                        rs.getString("fecha"),
                        rs.getString("horaInicio"),
                        rs.getString("horaFinal")
                );
                lista.add(l);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public ArrayList<Leccion> mostrarLecciones() {
        ArrayList<Leccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Leccion";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Leccion l = new Leccion(
                        rs.getInt("id"), // Nueva línea
                        rs.getString("nssInstructor"),
                        rs.getString("telefonoCliente"),
                        rs.getBoolean("individual"),
                        rs.getString("fecha"),
                        rs.getString("horaInicio"),
                        rs.getString("horaFinal")
                );
                lista.add(l);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}
