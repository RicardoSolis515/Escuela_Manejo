package Ventanas;

import Controlador.DirectorDAO;
import Modelo.Director;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame implements ActionListener, Runnable {

    Menu menuLecciones, menuAdministrativos, menuInstructores, menuClientes, menuVehiculos, menuEntrevistas;
    MenuItem itemAñadirLec, itemAdministrarLec,
            itemAñadirAdm, itemAdministrarAdm,
            itemAñadirIns, itemAdministrarIns,
            itemAñadirCli, itemAdministrarCli,
            itemAñadirVeh, itemAdministrarVeh,
            itemAñadirEnt, itemAdministrarEnt;

    public VentanaInicio() {
        getContentPane().setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Login");

        setSize(800, 500);

        setVisible(true);

        setLocationRelativeTo(null);

        MenuBar menuInicio = new MenuBar();

            menuLecciones= new Menu("Lecciones");

                itemAñadirLec = new MenuItem("Añadir");
                itemAdministrarLec = new MenuItem("Administrar");
                menuLecciones.add(itemAñadirLec);
                menuLecciones.add(itemAdministrarLec);

            menuInicio.add(menuLecciones);

            menuAdministrativos = new Menu("Administrativos");

                itemAñadirAdm = new MenuItem("Añadir");
                itemAdministrarAdm = new MenuItem("Administrar");
                menuAdministrativos.add(itemAñadirAdm);
                menuAdministrativos.add(itemAdministrarAdm);

            menuInicio.add(menuAdministrativos);

            menuInstructores = new Menu("Instructores");

                itemAñadirIns = new MenuItem("Añadir");
                itemAdministrarIns = new MenuItem("Administrar");
                menuInstructores.add(itemAñadirIns);
                menuInstructores.add(itemAdministrarIns);

            menuInicio.add(menuInstructores);

            menuClientes = new Menu("Clientes");

                itemAñadirCli = new MenuItem("Añadir");
                itemAdministrarCli = new MenuItem("Administrar");
                menuClientes.add(itemAñadirCli);
                menuClientes.add(itemAdministrarCli);

            menuInicio.add(menuClientes);

            menuVehiculos = new Menu("Vehículos");

                itemAñadirVeh = new MenuItem("Añadir");
                itemAdministrarVeh = new MenuItem("Administrar");
                menuVehiculos.add(itemAñadirVeh);
                menuVehiculos.add(itemAdministrarVeh);

            menuInicio.add(menuVehiculos);

            menuEntrevistas = new Menu("Entrevistas");

                itemAñadirEnt = new MenuItem("Añadir");
                itemAdministrarEnt = new MenuItem("Administrar");
                menuEntrevistas.add(itemAñadirEnt);
                menuEntrevistas.add(itemAdministrarEnt);

            menuInicio.add(menuEntrevistas);


        setMenuBar(menuInicio);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

        new VentanaInicio();
    }
}

