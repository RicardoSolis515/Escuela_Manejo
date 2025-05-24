package Ventanas;

import Controlador.DirectorDAO;
import Modelo.Director;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

public class VentanaInicio extends JFrame implements ActionListener, Runnable {

    //----------------------------------ELEMENTOS PARA MENUBAR----------------------------------------------
    Menu menuLecciones, menuAdministrativos, menuInstructores, menuClientes, menuVehiculos, menuEntrevistas;
    MenuItem itemAñadirLec, itemAdministrarLec,
            itemAñadirAdm, itemAdministrarAdm,
            itemAñadirIns, itemAdministrarIns,
            itemAñadirCli, itemAdministrarCli,
            itemAñadirVeh, itemAdministrarVeh,
            itemAñadirEnt, itemAdministrarEnt;



    //----------------------------------ELEMENTOS PARA IFAÑADIR-------------------------------------------
    JInternalFrame IFAñadorLec;
    JComboBox cajaInstructor, cajaCliente, cajaMes, cajaDia, cajaAño, cajahora;
    JRadioButton rbCompuesta;

    JButton btnAñadir, btnBorrar, btnCancelar;



    //----------------------------------ELEMENTOS PARA IFADMINISTRAR------------------------------------




    //---------------------------------VENTANAINICIO------------------------------------
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
                itemAñadirLec.addActionListener(this);
                itemAdministrarLec.addActionListener(this);

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

        IFAñadorLec = new JInternalFrame();
        IFAñadorLec.setSize(400,400);
        IFAñadorLec.setVisible(false);
        IFAñadorLec.setClosable(false);
        IFAñadorLec.setMaximizable(false);
        IFAñadorLec.setIconifiable(false);
        IFAñadorLec.setResizable(false);
        IFAñadorLec.setDefaultCloseOperation(HIDE_ON_CLOSE);
        IFAñadorLec.getContentPane().setLayout(null);
        try {
            IFAñadorLec.setMaximum(true);
        } catch (PropertyVetoException e) {

        }


            cajaInstructor = new JComboBox();
            cajaInstructor.setBounds(20, 20, 150, 25);
            cajaInstructor.addActionListener(this);
            IFAñadorLec.add(cajaInstructor);

            cajaCliente = new JComboBox();
            cajaCliente.setBounds(200, 20, 150, 25);
            cajaCliente.addActionListener(this);
            IFAñadorLec.add(cajaCliente);

            cajaMes = new JComboBox();
            cajaMes.setBounds(20, 60, 100, 25);
            cajaMes.addActionListener(this);
            IFAñadorLec.add(cajaMes);

            cajaDia = new JComboBox();
            cajaDia.setBounds(130, 60, 50, 25);
            cajaDia.addActionListener(this);
            IFAñadorLec.add(cajaDia);

            cajaAño = new JComboBox();
            cajaAño.setBounds(190, 60, 70, 25);
            cajaAño.addActionListener(this);
            IFAñadorLec.add(cajaAño);

            cajahora = new JComboBox();
            cajahora.setBounds(270, 60, 80, 25);
            cajahora.addActionListener(this);
            IFAñadorLec.add(cajahora);

            rbCompuesta = new JRadioButton("Clase compuesta");
            rbCompuesta.setBounds(20, 100, 200, 25);
            rbCompuesta.addActionListener(this);
            IFAñadorLec.add(rbCompuesta);

            btnAñadir = new JButton("Añadir");
            btnAñadir.setBounds(20, 150, 100, 30);
            btnAñadir.addActionListener(this);
            IFAñadorLec.add(btnAñadir);

            btnBorrar = new JButton("Borrar");
            btnBorrar.setBounds(140, 150, 100, 30);
            btnBorrar.addActionListener(this);
            IFAñadorLec.add(btnBorrar);

            btnCancelar = new JButton("Cancelar");
            btnCancelar.setBounds(260, 150, 100, 30);
            btnCancelar.addActionListener(this);
            IFAñadorLec.add(btnCancelar);

        add(IFAñadorLec);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof MenuItem){

            if(e.getSource()==itemAñadirLec){
                System.out.println("AÑADIR");
                IFAñadorLec.setVisible(true);
            }
            if(e.getSource()==itemAdministrarLec){
                System.out.println("ADMINISTRAR");
            }

        }else{

        }

    }

    @Override
    public void run() {

        new VentanaInicio();
    }
}

