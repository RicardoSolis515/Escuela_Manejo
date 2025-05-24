package Ventanas;

import Controlador.DirectorDAO;
import Modelo.Director;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame implements ActionListener, Runnable {

    DirectorDAO dDAO;

    JMenu menuAlumnos, menuAsignaturas;

    JMenuItem altas, bajas, cambios, consultas;

    JInternalFrame IF_Altas;

    JPasswordField cont;

    JTextField usuario;

    JButton btnIniciarSession;

    public VentanaInicio() {
        getContentPane().setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Login");

        setSize(300, 500);

        setVisible(true);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

        new VentanaInicio();
    }
}

