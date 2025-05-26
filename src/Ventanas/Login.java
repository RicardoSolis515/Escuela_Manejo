package Ventanas;

import Controlador.DirectorDAO;
import Modelo.Director;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener{

    DirectorDAO dDAO;

    JMenu menuAlumnos, menuAsignaturas;

    JMenuItem altas, bajas, cambios, consultas;

    JInternalFrame IF_Altas;

    JPasswordField cont;

    JTextField usuario;

    JButton btnIniciarSession;



    public Login() {

        dDAO= new DirectorDAO();

        getContentPane().setLayout(null);;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Login");

        setSize(300, 500);

        setVisible(true);

        setLocationRelativeTo(null);

        JLabel txtUsuario = new JLabel("Usuario:");
        txtUsuario.setBounds(50, 30, 100, 25);
        add(txtUsuario);

        usuario = new JTextField();
        usuario.setBounds(50, 60, 200, 25);
        add(usuario);

        JLabel txtContrasena = new JLabel("Contraseña:");
        txtContrasena.setBounds(50, 100, 100, 25);
        add(txtContrasena);

        cont = new JPasswordField();
        cont.setBounds(50, 130, 200, 25);
        add(cont);

        btnIniciarSession = new JButton("Iniciar Sesión");
        btnIniciarSession.setBounds(50, 180, 200, 30);
        btnIniciarSession.addActionListener(this);
        add(btnIniciarSession);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        Director dir = dDAO.mostrarDirector();
        if(e.getSource()==btnIniciarSession){
            if(usuario.getText().equals(dir.getUsuario()) && cont.getText().equals(dir.getContraseña())){
                Thread ventanaInicial = new Thread(new VentanaInicio());
                dispose();
            }else
                JOptionPane.showMessageDialog(this, "Usuario o contraseña no coinciden");



        }
    }

    public static void main(String[] args) {

        DirectorDAO dirDAO = new DirectorDAO();


        //============ Prueba bajas ==========




        //============ Prueba 1Combios ==========




        //============ Prueba Consultas ==========

        Director dire = dirDAO.mostrarDirector();



        SwingUtilities.invokeLater(new Runnable() { //Siemnpre agregar ese codigo

            @Override
            public void run() {

                new Login();

            }
        });

    }

}
