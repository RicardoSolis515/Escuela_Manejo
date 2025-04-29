package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    ConexionBD conexionBD = new ConexionBD();

    public boolean agregarCliente(Cliente c) {
        String sql = "INSERT INTO Cliente (nombre, apellidoPat, apellidoMat, telefono, edad, dirreccion, necesidades) VALUES('" +
                c.getNombre() + "','" +
                c.getApellidoPat() + "','" +
                c.getApellidoMat() + "','" +
                c.getTelefono() + "','" +
                c.getEdad() + "','" +
                c.getDirreccion() + "','" +
                c.getNecesidades() + "')";
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public boolean eliminarCliente(int idCliente) {
        String sql = "DELETE FROM Cliente WHERE idCliente = " + idCliente;
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public boolean editarCliente(int idCliente, Cliente c) {
        String sql = "UPDATE Cliente SET " +
                "nombre = '" + c.getNombre() + "', " +
                "apellidoPat = '" + c.getApellidoPat() + "', " +
                "apellidoMat = '" + c.getApellidoMat() + "', " +
                "telefono = '" + c.getTelefono() + "', " +
                "edad = '" + c.getEdad() + "', " +
                "dirreccion = '" + c.getDirreccion() + "', " +
                "necesidades = '" + c.getNecesidades() + "' " +
                "WHERE idCliente = " + idCliente;
        return conexionBD.ejecutarInstruccionLMD(sql);
    }

    public Cliente mostrarCliente(int idCliente) {
        String sql = "SELECT * FROM Cliente WHERE idCliente = " + idCliente;
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);
        Cliente c = null;

        try {
            if (rs.next()) {
                c = new Cliente(
                        rs.getString("nombre"),
                        rs.getString("apellidoPat"),
                        rs.getString("apellidoMat"),
                        rs.getString("telefono"),
                        rs.getString("edad"),
                        rs.getString("dirreccion"),
                        rs.getString("necesidades")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public ArrayList<Cliente> mostrarClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getString("nombre"),
                        rs.getString("apellidoPat"),
                        rs.getString("apellidoMat"),
                        rs.getString("telefono"),
                        rs.getString("edad"),
                        rs.getString("dirreccion"),
                        rs.getString("necesidades")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
