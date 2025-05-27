package Ventanas;

import Controlador.DirectorDAO;
import Modelo.Director;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener{

    DirectorDAO dDAO;

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
        String ubicacionLogo = "img/logoEM.png";
        ImageIcon icono = new ImageIcon(ubicacionLogo);
        Image imagenAjustada = icono.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon iconoAjustado = new ImageIcon(imagenAjustada);

        JLabel logoEscuela = new JLabel();
        logoEscuela.setIcon(iconoAjustado);
        logoEscuela.setBounds(125, 10, 60, 60); // Centrado arriba
        add(logoEscuela);

        //carlosrl_2025
        JLabel txtUsuario = new JLabel("Usuario:");
        txtUsuario.setBounds(50, 80, 100, 25);
        add(txtUsuario);

        usuario = new JTextField();
        usuario.setBounds(50, 105, 200, 25);
        add(usuario);

        //4321
        JLabel txtContrasena = new JLabel("Contraseña:");
        txtContrasena.setBounds(50, 140, 100, 25);
        add(txtContrasena);

        cont = new JPasswordField();
        cont.setBounds(50, 165, 200, 25);
        add(cont);

        btnIniciarSession = new JButton("Iniciar Sesión");
        btnIniciarSession.setBounds(50, 210, 200, 30);
        btnIniciarSession.addActionListener(this);
        add(btnIniciarSession);


        // Colores base
        Color azulClaro = new Color(70, 130, 180);
        Color azulOscuro = new Color(25, 25, 112);
        Color amarilloSuave = new Color(255, 235, 100);
        Color azulMuyClaro = new Color(220, 230, 250);

// Fondo de la ventana
        getContentPane().setBackground(azulMuyClaro);

// Etiquetas en azul oscuro
        txtUsuario.setForeground(azulOscuro);
        txtContrasena.setForeground(azulOscuro);

// Bordes azules para campos de texto y contraseña
        Border bordeAzul = BorderFactory.createLineBorder(azulClaro, 2);
        usuario.setBorder(bordeAzul);
        cont.setBorder(bordeAzul);

// Botón con fondo amarillo y texto azul oscuro
        btnIniciarSession.setBackground(amarilloSuave);
        btnIniciarSession.setForeground(azulOscuro);
        btnIniciarSession.setFocusPainted(false);

// Para que el logo se vea bien sobre el fondo
        logoEscuela.setOpaque(false);


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
