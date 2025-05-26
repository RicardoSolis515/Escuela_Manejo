package Ventanas;

import Controlador.InstructorDAO;
import Modelo.Instructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

public class IFAñadirIns extends JFrame implements ActionListener {

    JInternalFrame IFAñadirIns;

    //--------------Campos para creación de instructor----------------
    JTextField campoNSS, campoNombre, campoApellidoPat, campoApellidoMat;
    JRadioButton rbSenior;
    JComboBox<String> cajavehiculos;

    //----------------Botones adicionales------------
    JButton btnCancelar, btnAñadir, btnBorrar;

    public IFAñadirIns(JFrame ventana) {
        setTitle("Ventana contenedora");
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Internal Frame
        IFAñadirIns = new JInternalFrame("Añadir Instructor", false, false, false, false);
        IFAñadirIns.setLayout(null);
        IFAñadirIns.setBounds(50, 30, 600, 400);
        IFAñadirIns.setVisible(true);
        IFAñadirIns.setDefaultCloseOperation(HIDE_ON_CLOSE);

        try {
            IFAñadirIns.setMaximum(false);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        // Etiquetas y Campos
        JLabel lblNSS = new JLabel("NSS:");
        lblNSS.setBounds(40, 30, 150, 25);
        campoNSS = new JTextField();
        campoNSS.setBounds(200, 30, 300, 25);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 70, 150, 25);
        campoNombre = new JTextField();
        campoNombre.setBounds(200, 70, 300, 25);

        JLabel lblApellidoPat = new JLabel("Apellido Paterno:");
        lblApellidoPat.setBounds(40, 110, 150, 25);
        campoApellidoPat = new JTextField();
        campoApellidoPat.setBounds(200, 110, 300, 25);

        JLabel lblApellidoMat = new JLabel("Apellido Materno:");
        lblApellidoMat.setBounds(40, 150, 150, 25);
        campoApellidoMat = new JTextField();
        campoApellidoMat.setBounds(200, 150, 300, 25);

        JLabel lblSenior = new JLabel("¿Es Senior?");
        lblSenior.setBounds(40, 190, 150, 25);
        rbSenior = new JRadioButton("Sí");
        rbSenior.setBounds(200, 190, 60, 25);

        JLabel lblVehiculo = new JLabel("Vehículo asignado:");
        lblVehiculo.setBounds(40, 230, 150, 25);
        cajavehiculos = new JComboBox<>(new String[]{"Seleccione...", "ABC-123", "XYZ-789"});
        cajavehiculos.setBounds(200, 230, 300, 25);

        // Botones
        btnAñadir = new JButton("Añadir");
        btnAñadir.setBounds(100, 290, 100, 30);
        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(240, 290, 100, 30);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(380, 290, 100, 30);

        // Listeners
        btnAñadir.addActionListener(this);
        btnBorrar.addActionListener(this);
        btnCancelar.addActionListener(this);

        // Agregar al Internal Frame
        IFAñadirIns.add(lblNSS);
        IFAñadirIns.add(campoNSS);
        IFAñadirIns.add(lblNombre);
        IFAñadirIns.add(campoNombre);
        IFAñadirIns.add(lblApellidoPat);
        IFAñadirIns.add(campoApellidoPat);
        IFAñadirIns.add(lblApellidoMat);
        IFAñadirIns.add(campoApellidoMat);
        IFAñadirIns.add(lblSenior);
        IFAñadirIns.add(rbSenior);
        IFAñadirIns.add(lblVehiculo);
        IFAñadirIns.add(cajavehiculos);
        IFAñadirIns.add(btnAñadir);
        IFAñadirIns.add(btnBorrar);
        IFAñadirIns.add(btnCancelar);

        // Agregar el internal frame al JFrame principal
        ventana.add(IFAñadirIns);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == btnCancelar) {
            IFAñadirIns.setVisible(false);
        } else if (fuente == btnBorrar) {
            campoNSS.setText("");
            campoNombre.setText("");
            campoApellidoPat.setText("");
            campoApellidoMat.setText("");
            rbSenior.setSelected(false);
            cajavehiculos.setSelectedIndex(0);
        } else if (fuente == btnAñadir) {
            JOptionPane.showMessageDialog(this, "Instructor añadido (simulado)");
        }
    }

    public static void main(String[] args) {
        new IFAñadirIns(null);
    }
}
