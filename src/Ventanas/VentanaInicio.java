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

    //----------------------------------ELEMENTOS PARA IFADMINISTRAR------------------------------------


    //---------------------------------VENTANAINICIO------------------------------------
    public VentanaInicio() {
        getContentPane().setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Sistema de Gestión de Lecciones"); // Título más descriptivo

        setSize(800, 500);

        setVisible(true);

        setLocationRelativeTo(null);

        MenuBar menuInicio = new MenuBar();

        // Configuración del menú Lecciones
        menuLecciones = new Menu("Lecciones");
        itemAñadirLec = new MenuItem("Añadir");
        itemAdministrarLec = new MenuItem("Administrar");
        menuLecciones.add(itemAñadirLec);
        menuLecciones.add(itemAdministrarLec);
        itemAñadirLec.addActionListener(this);
        itemAdministrarLec.addActionListener(this);
        menuInicio.add(menuLecciones);

        // Configuración del menú Administrativos
        menuAdministrativos = new Menu("Administrativos");
        itemAñadirAdm = new MenuItem("Añadir");
        itemAdministrarAdm = new MenuItem("Administrar");
        menuAdministrativos.add(itemAñadirAdm);
        menuAdministrativos.add(itemAdministrarAdm);
        itemAñadirAdm.addActionListener(this); // Agregado
        itemAdministrarAdm.addActionListener(this); // Agregado
        menuInicio.add(menuAdministrativos);

        // Configuración del menú Instructores
        menuInstructores = new Menu("Instructores");
        itemAñadirIns = new MenuItem("Añadir");
        itemAdministrarIns = new MenuItem("Administrar");
        menuInstructores.add(itemAñadirIns);
        menuInstructores.add(itemAdministrarIns);
        itemAñadirIns.addActionListener(this); // Agregado
        itemAdministrarIns.addActionListener(this); // Agregado
        menuInicio.add(menuInstructores);

        // Configuración del menú Clientes
        menuClientes = new Menu("Clientes");
        itemAñadirCli = new MenuItem("Añadir");
        itemAdministrarCli = new MenuItem("Administrar");
        menuClientes.add(itemAñadirCli);
        menuClientes.add(itemAdministrarCli);
        itemAñadirCli.addActionListener(this); // Agregado
        itemAdministrarCli.addActionListener(this); // Agregado
        menuInicio.add(menuClientes);

        // Configuración del menú Vehículos
        menuVehiculos = new Menu("Vehículos");
        itemAñadirVeh = new MenuItem("Añadir");
        itemAdministrarVeh = new MenuItem("Administrar");
        menuVehiculos.add(itemAñadirVeh);
        menuVehiculos.add(itemAdministrarVeh);
        itemAñadirVeh.addActionListener(this); // Agregado
        itemAdministrarVeh.addActionListener(this); // Agregado
        menuInicio.add(menuVehiculos);

        // Configuración del menú Entrevistas
        menuEntrevistas = new Menu("Entrevistas");
        itemAñadirEnt = new MenuItem("Añadir");
        itemAdministrarEnt = new MenuItem("Administrar");
        menuEntrevistas.add(itemAñadirEnt);
        menuEntrevistas.add(itemAdministrarEnt);
        itemAñadirEnt.addActionListener(this); // Agregado
        itemAdministrarEnt.addActionListener(this); // Agregado
        menuInicio.add(menuEntrevistas);

        setMenuBar(menuInicio);

        ifa = new IFAñadir(this);


        ifi = new IFAñadirIns(this);

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
                    ifi.IFAñadirIns.setVisible(true);
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
