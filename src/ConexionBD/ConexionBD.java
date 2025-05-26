package ConexionBD;

import java.sql.*;

public class ConexionBD {

    private static ConexionBD instancia; // Singleton

    private Connection conexion;
    private Statement stm;
    private ResultSet rs;

    // Constructor privado
    private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/db_escuela_manejo";
            conexion = DriverManager.getConnection(URL, "root", "1234");
            System.out.println("Casi soy ingeniero inmortal");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el conector o Driver");
        } catch (SQLException e) {
            System.out.println("Error en la conexion a MySQL");
        }
    }

    // Método Singleton
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public boolean ejecutarInstruccionLMD(String sql) {
        boolean res = false;
        try {
            stm = conexion.createStatement();
            if (stm.executeUpdate(sql) >= 1) {
                res = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la ejecucion de la instruccion SQL");
        }
        return res;
    }

    public ResultSet ejecutarIstruccionSQL(String sql) {
        rs = null;
        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la instruccion SQL");
        }
        return rs;
    }

    public Connection getConexion() {
        return conexion;
    }


}
