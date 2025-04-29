package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Leccion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeccionDAO {
    ConexionBD conexionBD = new ConexionBD();

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
        String sql = "DELETE FROM Leccion WHERE idLeccion = " + idLeccion;
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public ArrayList<Leccion> mostrarLecciones() {
        ArrayList<Leccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Leccion";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Leccion l = new Leccion(
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
