package Ventanas;

import Controlador.AutoDAO;
import Controlador.InstructorDAO;
import Modelo.Auto;
import Modelo.Instructor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

public class IFAñadirIns extends JFrame implements ActionListener, KeyListener {

    JInternalFrame IFAñadirIns;

    //--------------Campos para creación de instructor----------------
    JTextField campoNSS, campoNombre, campoApellidoPat, campoApellidoMat;
    JRadioButton rbSenior;
    JComboBox<String> cajavehiculos;

    //----------------Botones adicionales------------
    JButton btnCancelar, btnAñadir, btnBorrar;

    public IFAñadirIns(JFrame ventana) {

        // Internal Frame
        IFAñadirIns = new JInternalFrame("Añadir Instructor", false, false, false, false);
        IFAñadirIns.setLayout(null);
        IFAñadirIns.setBounds(50, 30, 600, 400);
        IFAñadirIns.setVisible(false);
        IFAñadirIns.setDefaultCloseOperation(HIDE_ON_CLOSE);

        try {
            IFAñadirIns.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        // Etiquetas y Campos
        JLabel lblNSS = new JLabel("NSS:");
        lblNSS.setBounds(40, 30, 150, 25);
        campoNSS = new JTextField();
        campoNSS.setBounds(200, 30, 300, 25);
        campoNSS.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String nss=campoNSS.getText();
                if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'){
                    if(nss.length()>=11)
                        e.consume();
                }else if(e.getKeyChar()==8){

                }else
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                String nss=campoNSS.getText();
                if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'){
                    if(nss.length()>=11)
                        e.consume();
                }else if(e.getKeyChar()==8){

                }else
                    e.consume();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String nss=campoNSS.getText();
                if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'){
                    if(nss.length()>=11)
                        e.consume();
                }else if(e.getKeyChar()==8){

                }else
                    e.consume();
            }
        });

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 70, 150, 25);
        campoNombre = new JTextField();
        campoNombre.setBounds(200, 70, 300, 25);
        campoNombre.addKeyListener(this);

        JLabel lblApellidoPat = new JLabel("Apellido Paterno:");
        lblApellidoPat.setBounds(40, 110, 150, 25);
        campoApellidoPat = new JTextField();
        campoApellidoPat.setBounds(200, 110, 300, 25);
        campoApellidoPat.addKeyListener(this);

        JLabel lblApellidoMat = new JLabel("Apellido Materno:");
        lblApellidoMat.setBounds(40, 150, 150, 25);
        campoApellidoMat = new JTextField();
        campoApellidoMat.setBounds(200, 150, 300, 25);
        campoApellidoMat.addKeyListener(this);

        JLabel lblSenior = new JLabel("¿Es Senior?");
        lblSenior.setBounds(40, 190, 150, 25);
        rbSenior = new JRadioButton("Sí");
        rbSenior.setBounds(200, 190, 60, 25);

        JLabel lblVehiculo = new JLabel("Vehículo asignado:");
        lblVehiculo.setBounds(40, 230, 150, 25);
        cajavehiculos = new JComboBox<>();
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

        llenarVehiculos();

        // Agregar el internal frame al JFrame principal
        ventana.add(IFAñadirIns);



        // Colores base (mismos que antes)
        Color azulClaro = new Color(70, 130, 180);
        Color azulOscuro = new Color(25, 25, 112);
        Color amarilloSuave = new Color(255, 235, 100);
        Color azulMuyClaro = new Color(220, 230, 250);

// Fondo del internal frame
        IFAñadirIns.getContentPane().setBackground(azulMuyClaro);

// Etiquetas en azul oscuro
        lblNSS.setForeground(azulOscuro);
        lblNombre.setForeground(azulOscuro);
        lblApellidoPat.setForeground(azulOscuro);
        lblApellidoMat.setForeground(azulOscuro);
        lblSenior.setForeground(azulOscuro);
        lblVehiculo.setForeground(azulOscuro);

// Bordes azules para JTextField y JComboBox
        Border bordeAzul = BorderFactory.createLineBorder(azulClaro, 2);
        campoNSS.setBorder(bordeAzul);
        campoNombre.setBorder(bordeAzul);
        campoApellidoPat.setBorder(bordeAzul);
        campoApellidoMat.setBorder(bordeAzul);
        cajavehiculos.setBorder(bordeAzul);

// RadioButton texto azul oscuro
        rbSenior.setForeground(azulOscuro);

// Botones con fondo amarillo suave y texto azul oscuro
        btnAñadir.setBackground(amarilloSuave);
        btnAñadir.setForeground(azulOscuro);

        btnBorrar.setBackground(amarilloSuave);
        btnBorrar.setForeground(azulOscuro);

        btnCancelar.setBackground(amarilloSuave);
        btnCancelar.setForeground(azulOscuro);











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
            InstructorDAO iDAO = new InstructorDAO();
            if(camposLlenos()){
                if(iDAO.mostrarInstructor(campoNSS.getText())==null) {
                    Instructor ins = new Instructor(campoNSS.getText(), campoNombre.getText(),
                            campoApellidoPat.getText(), campoApellidoMat.getText(),
                            rbSenior.isSelected(), (String) cajavehiculos.getSelectedItem());
                    AutoDAO aDAO = new AutoDAO();
                    aDAO.autoAsignacion(true, (String) cajavehiculos.getSelectedItem());

                    iDAO.agregarInstructor(ins);
                    System.out.println("Se puede");
                    JOptionPane.showMessageDialog(this,"Instructor agregado correctamente");

                    campoNSS.setText("");
                    campoNombre.setText("");
                    campoApellidoPat.setText("");
                    campoApellidoMat.setText("");
                    rbSenior.setSelected(false);
                    cajavehiculos.setSelectedIndex(0);

                    llenarVehiculos();
                }else
                    JOptionPane.showMessageDialog(this, "NSS ya existente");

            }
        }
    }

    public boolean camposLlenos() {
        // Validar NSS: debe tener 11 dígitos y no estar vacío
        String nss = campoNSS.getText().trim();
        if (nss.length() != 11) {
            JOptionPane.showMessageDialog(this, "El NSS debe tener exactamente 11 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar que nombre y apellidos no estén vacíos o sólo espacios
        if (campoNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (campoApellidoPat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Apellido Paterno no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (campoApellidoMat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Apellido Materno no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar vehículo asignado seleccionado
        if (cajavehiculos.getSelectedItem() == null || cajavehiculos.getSelectedItem().toString().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un vehículo asignado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }


    public void llenarVehiculos(){
        cajavehiculos.removeAllItems();

        AutoDAO aDAO = new AutoDAO();
        ArrayList<Auto> autos = aDAO.mostrarAutosDisponibles();
        for (Auto x:autos)
            cajavehiculos.addItem( x.getMatricula());

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()>='a'&&e.getKeyChar()<='z'){

        }else if(e.getKeyChar()>='A'&&e.getKeyChar()<='Z'){

        }else if(e.getKeyChar()==8){

        }else
            e.consume();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()>='a'&&e.getKeyChar()<='z'){

        }else if(e.getKeyChar()>='A'&&e.getKeyChar()<='Z'){

        }else if(e.getKeyChar()==8){

        }else
            e.consume();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()>='a'&&e.getKeyChar()<='z'){

        }else if(e.getKeyChar()>='A'&&e.getKeyChar()<='Z'){

        }else if(e.getKeyChar()==8){

        }else
            e.consume();
    }
}
