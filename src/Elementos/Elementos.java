package Elementos;

//import controlador.AlumnoDAO;
import Modelo.ResultSetTableModel;

import  javax.swing.*;
import java.sql.SQLException;

public class Elementos extends JFrame{

//./img/nombreImagen

    public void actualizarTabla(JTable tabla) {

        final String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";

        final String URL = "jdbc:mysql://localhost:3306/dd_topicos_2025";

        final String CONSULTA = "SELECT * FROM Alumnos";

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(CONTROLADOR_JDBC, URL, CONSULTA);

            tabla.setModel(modelo);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }

    }

    public void actualizarTablaConsulta(JTable tabla, String consulta) {

        final String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";

        final String URL = "jdbc:mysql://localhost:3306/dd_topicos_2025";

        final String CONSULTA = "SELECT * FROM Alumnos " + consulta;

        try {
            ResultSetTableModel modelo = new ResultSetTableModel(CONTROLADOR_JDBC, URL, CONSULTA);

            tabla.setModel(modelo);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }

    }

    public void restablecer(JComponent... componentes) {

        //En java

        for(JComponent c : componentes) {

            System.out.println(c);

            if(c instanceof JTextField) {

                ((JTextField) c).setText("");

            }
            else if(c instanceof JComboBox){

                ((JComboBox) c).setSelectedIndex(0);


            }else if(c instanceof JRadioButton){

                ((JRadioButton) c).setSelected(true);

            }

        }

    }

}
