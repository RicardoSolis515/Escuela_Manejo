package Ventanas;

import Controlador.LeccionDAO;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import Controlador.InstructorDAO;
import Controlador.ClienteDAO;
import Modelo.Instructor;
import Modelo.Cliente;
import Modelo.Leccion;

public class VentanaInicio extends JFrame implements ActionListener, Runnable, KeyListener {

    //----------------------------------ELEMENTOS PARA MENUBAR----------------------------------------------
    Menu menuLecciones, menuAdministrativos, menuInstructores, menuClientes, menuVehiculos, menuEntrevistas;
    MenuItem itemAñadirLec, itemAdministrarLec,
            itemAñadirAdm, itemAdministrarAdm,
            itemAñadirIns, itemAdministrarIns,
            itemAñadirCli, itemAdministrarCli,
            itemAñadirVeh, itemAdministrarVeh,
            itemAñadirEnt, itemAdministrarEnt;

    //----------------------------------ELEMENTOS PARA IFAÑADIR-------------------------------------------
    IFAñadir ifa;
    IFAñadirIns ifi;
    IFAdministrarIns ifai;

    //----------------------------------ELEMENTOS PARA IFADMINISTRAR------------------------------------


    //---------------------------------VENTANAINICIO------------------------------------
    public VentanaInicio() {
        getContentPane().setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Sistema de Gestión de Lecciones");
        setSize(800, 500);
        setLocationRelativeTo(null);

        Color fondo = new Color(220, 230, 250);
        Color azulOscuro = new Color(25, 25, 112);
        Color textoBlanco = Color.WHITE;

        getContentPane().setBackground(fondo);

        MenuBar menuInicio = new MenuBar();

        menuLecciones = new Menu("Lecciones");
        itemAñadirLec = new MenuItem("Añadir");
        itemAdministrarLec = new MenuItem("Administrar");
        menuLecciones.add(itemAñadirLec);
        menuLecciones.add(itemAdministrarLec);
        itemAñadirLec.addActionListener(this);
        itemAdministrarLec.addActionListener(this);
        menuInicio.add(menuLecciones);

        menuAdministrativos = new Menu("Administrativos");
        itemAñadirAdm = new MenuItem("Añadir");
        itemAdministrarAdm = new MenuItem("Administrar");
        menuAdministrativos.add(itemAñadirAdm);
        menuAdministrativos.add(itemAdministrarAdm);
        itemAñadirAdm.addActionListener(this);
        itemAdministrarAdm.addActionListener(this);
        menuInicio.add(menuAdministrativos);

        menuInstructores = new Menu("Instructores");
        itemAñadirIns = new MenuItem("Añadir");
        itemAdministrarIns = new MenuItem("Administrar");
        menuInstructores.add(itemAñadirIns);
        menuInstructores.add(itemAdministrarIns);
        itemAñadirIns.addActionListener(this);
        itemAdministrarIns.addActionListener(this);
        menuInicio.add(menuInstructores);

        menuClientes = new Menu("Clientes");
        itemAñadirCli = new MenuItem("Añadir");
        itemAdministrarCli = new MenuItem("Administrar");
        menuClientes.add(itemAñadirCli);
        menuClientes.add(itemAdministrarCli);
        itemAñadirCli.addActionListener(this);
        itemAdministrarCli.addActionListener(this);
        menuInicio.add(menuClientes);

        menuVehiculos = new Menu("Vehículos");
        itemAñadirVeh = new MenuItem("Añadir");
        itemAdministrarVeh = new MenuItem("Administrar");
        menuVehiculos.add(itemAñadirVeh);
        menuVehiculos.add(itemAdministrarVeh);
        itemAñadirVeh.addActionListener(this);
        itemAdministrarVeh.addActionListener(this);
        menuInicio.add(menuVehiculos);

        menuEntrevistas = new Menu("Entrevistas");
        itemAñadirEnt = new MenuItem("Añadir");
        itemAdministrarEnt = new MenuItem("Administrar");
        menuEntrevistas.add(itemAñadirEnt);
        menuEntrevistas.add(itemAdministrarEnt);
        itemAñadirEnt.addActionListener(this);
        itemAdministrarEnt.addActionListener(this);
        menuInicio.add(menuEntrevistas);

        setMenuBar(menuInicio);

        // Logo arriba a la izquierda
        String rutaLogo = "img/logoEM.png";
        ImageIcon icono = new ImageIcon(rutaLogo);
        Image imagen = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(imagen));
        logo.setBounds(20, 10, 80, 80);
        add(logo);

        // Panel inferior con texto
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(azulOscuro);
        panelInfo.setBounds(0, 380, 1200, 70);
        panelInfo.setLayout(new BorderLayout());

        JLabel textoInfo = new JLabel(" La autoescuela EasyDrive School of Motoring fue fundada en Glasgow en 1992.");
        textoInfo.setForeground(textoBlanco);
        textoInfo.setFont(new Font("SansSerif", Font.PLAIN, 12));

        panelInfo.add(textoInfo, BorderLayout.CENTER);
        add(panelInfo);

        ifa = new IFAñadir(this);
        ifi = new IFAñadirIns(this);
        ifai = new IFAdministrarIns(this);

        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() instanceof MenuItem) {
                if (e.getSource() == itemAñadirLec) {
                    System.out.println("AÑADIR LECCIÓN");
                    ifa.IFAñadorLec.setVisible(true);
                    //IFAdministrar.setVisible(false);
                } else if (e.getSource() == itemAdministrarLec) {
                    System.out.println("ADMINISTRAR LECCIONES");
                    //IFAdministrar.setVisible(true);
                    //ifa.IFAñadorLec.setVisible(false);

                } else if (e.getSource()==itemAñadirIns) {
                    setSize(800, 500);
                    setLocationRelativeTo(null);
                    ifi.IFAñadirIns.setVisible(true);
                    ifai.IFAdminIns.setVisible(false);
                } else if (e.getSource()==itemAdministrarIns) {
                    setSize(1200, 500);
                    setLocationRelativeTo(null);
                    ifai.IFAdminIns.setVisible(true);
                    ifi.IFAñadirIns.setVisible(false);
                }

            } else {
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void run() {}
}
