package Ventanas;

import Controlador.AutoDAO;
import Controlador.DirectorDAO;
import Controlador.InstructorDAO;
import Elementos.Elementos;
import Modelo.Auto;
import Modelo.Director;
import Modelo.Instructor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

public class IFAdministrarIns extends JFrame implements ActionListener, KeyListener {
    JInternalFrame IFAdminIns;

    //--------------Campos para datos del instructor----------------
    JTextField campoNombre, campoApellidoPat, campoApellidoMat;
    JRadioButton rbSenior;
    JComboBox<String> cajavehiculos, cajaNSS;

    //----------------Botones adicionales------------
    JButton btnCancelar, btnAñadir, btnBorrar;
    JButton btnEliminar, btnBuscar, btnEditar;
    JButton btnGuardar;

    boolean edicion = false;

    JTable tablaInstructores;

    public IFAdministrarIns(JFrame ventana) {




        // Internal Frame
        IFAdminIns = new JInternalFrame("Administrar Instructor", false, false, false, false);
        IFAdminIns.setLayout(null);
        IFAdminIns.setBounds(50, 30, 650, 430);
        IFAdminIns.setVisible(false);
        IFAdminIns.setDefaultCloseOperation(HIDE_ON_CLOSE);
        try {
            IFAdminIns.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        // Sección: Selección por NSS
        JLabel lblNSS = new JLabel("Seleccionar NSS:");
        lblNSS.setBounds(40, 20, 150, 25);
        cajaNSS = new JComboBox<>(new String[]{"Seleccione...", "12345678", "87654321"});
        cajaNSS.setBounds(200, 20, 300, 25);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(510, 20, 100, 25);

        // Sección: Datos del Instructor
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
        cajavehiculos = new JComboBox<>(new String[]{"Seleccione...", "ABC-123", "XYZ-789"});
        cajavehiculos.setBounds(200, 230, 300, 25);

        // Sección: Botones
        btnAñadir = new JButton("Añadir");
        btnAñadir.setBounds(40, 300, 100, 30);
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(160, 300, 100, 30);
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(280, 300, 100, 30);
        btnGuardar.setEnabled(false); // Solo en modo edición

        btnBorrar = new JButton("Limpiar");
        btnBorrar.setBounds(400, 300, 100, 30);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(40, 350, 100, 30);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(160, 350, 100, 30);

        // Agregar listeners
        btnAñadir.addActionListener(this);
        btnEditar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnBorrar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnBuscar.addActionListener(this);

        // Agregar componentes al Internal Frame
        IFAdminIns.add(lblNSS);
        IFAdminIns.add(cajaNSS);
        IFAdminIns.add(btnBuscar);
        IFAdminIns.add(lblNombre);
        IFAdminIns.add(campoNombre);
        IFAdminIns.add(lblApellidoPat);
        IFAdminIns.add(campoApellidoPat);
        IFAdminIns.add(lblApellidoMat);
        IFAdminIns.add(campoApellidoMat);
        IFAdminIns.add(lblSenior);
        IFAdminIns.add(rbSenior);
        IFAdminIns.add(lblVehiculo);
        IFAdminIns.add(cajavehiculos);

        IFAdminIns.add(btnAñadir);
        IFAdminIns.add(btnEditar);
        IFAdminIns.add(btnGuardar);
        IFAdminIns.add(btnBorrar);
        IFAdminIns.add(btnEliminar);
        IFAdminIns.add(btnCancelar);


        String[] columnNames = {"NSS", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "Senior", "Matricula Vehiculo"};
        Object[][] rowData = new Object[0][columnNames.length]; // Sin datos aún

        tablaInstructores = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(tablaInstructores);

        scrollPane.setBackground(Color.decode("#d2e2f1"));
        scrollPane.setBounds(580, 80, 560, 300);
        IFAdminIns.add(scrollPane);

        new Elementos().actualizarTabla(tablaInstructores);

        llenarInstructores();
        llenarAutos();

        modoEdicion(edicion);

        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBorrar.setEnabled(false);

        ventana.add(IFAdminIns);




        // Colores base
        Color azulClaro = new Color(70, 130, 180);   // Steel Blue
        Color azulOscuro = new Color(25, 25, 112);   // Midnight Blue
        Color amarillo = new Color(255, 215, 0);     // Gold amarillo intenso
        Color azulMuyClaro = new Color(220, 230, 250);

// Fondo del InternalFrame
        IFAdminIns.getContentPane().setBackground(azulMuyClaro);

// Etiquetas en azul oscuro
        lblNSS.setForeground(azulOscuro);
        lblNombre.setForeground(azulOscuro);
        lblApellidoPat.setForeground(azulOscuro);
        lblApellidoMat.setForeground(azulOscuro);
        lblSenior.setForeground(azulOscuro);
        lblVehiculo.setForeground(azulOscuro);

// Campos de texto y combo con borde azul
        Border bordeAzul = BorderFactory.createLineBorder(azulClaro, 2);

        cajaNSS.setBorder(bordeAzul);
        cajavehiculos.setBorder(bordeAzul);

        campoNombre.setBorder(bordeAzul);
        campoApellidoPat.setBorder(bordeAzul);
        campoApellidoMat.setBorder(bordeAzul);

// Radio button color texto azul oscuro
        rbSenior.setForeground(azulOscuro);

// Botones fondo amarillo y texto azul oscuro
        Color amarilloSuave = new Color(255, 235, 100);

        btnAñadir.setBackground(amarilloSuave);
        btnAñadir.setForeground(azulOscuro);

        btnEditar.setBackground(amarilloSuave);
        btnEditar.setForeground(azulOscuro);

        btnGuardar.setBackground(amarilloSuave);
        btnGuardar.setForeground(azulOscuro);

        btnBorrar.setBackground(amarilloSuave);
        btnBorrar.setForeground(azulOscuro);

        btnEliminar.setBackground(amarilloSuave);
        btnEliminar.setForeground(azulOscuro);

        btnCancelar.setBackground(amarilloSuave);
        btnCancelar.setForeground(azulOscuro);

        btnBuscar.setBackground(amarilloSuave);
        btnBuscar.setForeground(azulOscuro);

// Tabla con fondo azul muy claro y filas seleccionadas en amarillo
        tablaInstructores.setBackground(azulMuyClaro);
        tablaInstructores.setSelectionBackground(amarillo);
        tablaInstructores.setSelectionForeground(azulOscuro);
        tablaInstructores.setGridColor(azulClaro);













    }

    public void llenarInstructores(){
        cajaNSS.removeAllItems();

        InstructorDAO iDAO = new InstructorDAO();
        ArrayList<Instructor> instructores = iDAO.mostrarInstructores();
        for(Instructor x:instructores)
            cajaNSS.addItem(x.getNSS());

    }



    public void llenarAutos(){
        cajavehiculos.removeAllItems();
        InstructorDAO iDAO = new InstructorDAO();

        AutoDAO aDAO = new AutoDAO();
        ArrayList<Auto> autos = aDAO.mostrarAutosDisponibles();
        for(Auto x: autos)
            cajavehiculos.addItem(x.getMatricula());

        cajavehiculos.addItem(iDAO.mostrarInstructor((String) cajaNSS.getSelectedItem()).getMatriculaVehiculo());

        cajavehiculos.setSelectedItem(iDAO.mostrarInstructor((String) cajaNSS.getSelectedItem()).getMatriculaVehiculo());
    }

    public void llenarCampos(){
        String nss = (String) cajaNSS.getSelectedItem();
        InstructorDAO iDAO = new InstructorDAO();
        Instructor ins = iDAO.mostrarInstructor(nss);

        campoNombre.setText(ins.getNombre());
        campoApellidoPat.setText(ins.getApellidoPaterno());
        campoApellidoMat.setText(ins.getApellidoMaterno());

        rbSenior.setSelected(ins.isSenior());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnCancelar) {
            IFAdminIns.setVisible(false);
        } else if (src == btnBorrar) {
            campoNombre.setText("");
            campoApellidoPat.setText("");
            campoApellidoMat.setText("");
            rbSenior.setSelected(false);
            cajavehiculos.setSelectedIndex(0);
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnBorrar.setEnabled(false);
        } else if (src == btnGuardar) {
            //JOptionPane.showMessageDialog(this, "Datos guardados.");
            guardarEdicion();
            modoEdicion(!edicion);
        } else if (src == btnBuscar) {
            llenarCampos();
            btnEliminar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnBorrar.setEnabled(true);
        } else if (src == btnEditar) {
            edicion = !edicion;
            modoEdicion(edicion);
        } else if (src == btnAñadir) {
            //JOptionPane.showMessageDialog(this, "Instructor añadido.");

        } else if (src == btnEliminar) {
            //JOptionPane.showMessageDialog(this, "Instructor eliminado.");
            eliminarInstructor();
        }else if(e.getSource()==cajaNSS){
            llenarAutos();
        }
    }

    public void guardarEdicion(){
        Instructor ins = new Instructor((String) cajaNSS.getSelectedItem(),campoNombre.getText(),
                campoApellidoPat.getText(),campoApellidoMat.getText(),
                rbSenior.isSelected(),(String) cajavehiculos.getSelectedItem());

        AutoDAO aDAO = new AutoDAO();
        for (int i = 0; i < cajavehiculos.getItemCount(); i++) {
            String item = (String) cajavehiculos.getItemAt(i);
            aDAO.autoAsignacion(false, item);
            System.out.println(item);
        }

        aDAO.autoAsignacion(true,(String) cajavehiculos.getSelectedItem());
        InstructorDAO iDAO = new InstructorDAO();
        iDAO.editarInstructor(ins);
    }

    public void eliminarInstructor(){
        InstructorDAO iDAO = new InstructorDAO();
        AutoDAO aDAO = new AutoDAO();
        DirectorDAO dDAO = new DirectorDAO();

        String nss = (String) cajaNSS.getSelectedItem();
        String matricula = iDAO.mostrarInstructor(nss).getMatriculaVehiculo();

        Director d= dDAO.mostrarDirector();
        if(d.getNss().equals(nss)){
            JOptionPane.showMessageDialog(this, "NO SE PUEDE ELIMINAR EL DIRECTOR");
        }else{
            iDAO.eliminarInstructor(nss);
            aDAO.autoAsignacion(false, matricula);
        }

    }

    public void modoEdicion(boolean confirmacion){
        cajaNSS.setEnabled(!confirmacion);
        btnBuscar.setEnabled(!confirmacion);
        btnBorrar.setEnabled(!confirmacion);
        btnCancelar.setEnabled(!confirmacion);
        btnEliminar.setEnabled(!confirmacion);
        btnAñadir.setEnabled(!confirmacion);

        btnGuardar.setEnabled(confirmacion);
        cajavehiculos.setEnabled(confirmacion);
        campoNombre.setEnabled(confirmacion);
        campoApellidoPat.setEnabled(confirmacion);
        campoApellidoMat.setEnabled(confirmacion);
        rbSenior.setEnabled(confirmacion);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

}

