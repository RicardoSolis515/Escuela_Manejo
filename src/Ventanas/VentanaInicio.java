package Ventanas;

import Controlador.DirectorDAO;
import Controlador.LeccionDAO;
import Modelo.Director;

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

    //----------------------------------ELEMENTOS PARA IFADMINISTRAR------------------------------------

    JInternalFrame IFAdministrar;
    JComboBox cajaInstructorA, cajaClienteA;

    JTextField campoAño, campoMes, campoDia, campoHoraInicio, campoHoraFinal,indice;

    JTable lecciones;

    boolean edicion=false, componenteSeleccionado = false;

    JTextArea detallesInstructor, detallesCliente;

    JButton btnAnterior, btnSiguente;
    JButton btnEditar, btnEliminar, btnBuscar, btnGuardar;
    JButton btnAñadirA, btnBorrarA, btnCancelarA;

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

        ifa = new IFAñadir(this);
        //--------------------------------------FIN DE AÑADIR----------------------------
        /*
         *******************************************************************************************

         *******************************************************************************************

         */
        //---------------------------------------------------------------------------------

        //------------------------------------IFADMINISTRAR----------------------------------

        IFAdministrar = new JInternalFrame();
        IFAdministrar.setSize(800, 600);
        IFAdministrar.setVisible(false);
        IFAdministrar.setClosable(false);
        IFAdministrar.setMaximizable(false);
        IFAdministrar.setIconifiable(false);
        IFAdministrar.setResizable(false);
        IFAdministrar.setDefaultCloseOperation(HIDE_ON_CLOSE);
        IFAdministrar.getContentPane().setLayout(null);

        try {
            IFAdministrar.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        int margenIzq = 20;

// -------------------------- Filtros de búsqueda --------------------------
        JLabel lblInstructorA = new JLabel("Instructor:");
        lblInstructorA.setBounds(margenIzq, 20, 150, 20);
        IFAdministrar.add(lblInstructorA);

        cajaInstructorA = new JComboBox();
        cajaInstructorA.setBounds(margenIzq, 45, 250, 25);
        cajaInstructorA.addActionListener(this);
        IFAdministrar.add(cajaInstructorA);

        JLabel lblClienteA = new JLabel("Cliente:");
        lblClienteA.setBounds(margenIzq + 280, 20, 150, 20);
        IFAdministrar.add(lblClienteA);

        cajaClienteA = new JComboBox();
        cajaClienteA.setBounds(margenIzq + 280, 45, 250, 25);
        cajaClienteA.addActionListener(this);
        IFAdministrar.add(cajaClienteA);

        btnBuscar = new JButton();
        btnBuscar.setBounds(margenIzq + 550, 45, 60, 60);
        btnBuscar.addActionListener(this);
        IFAdministrar.add(btnBuscar);


// -------------------------- Fecha --------------------------
        JLabel lblFecha = new JLabel("Fecha (Año / Mes / Día):");
        lblFecha.setBounds(margenIzq, 90, 200, 20);
        IFAdministrar.add(lblFecha);

        campoAño = new JTextField();
        campoAño.setBounds(margenIzq, 115, 80, 25);
        campoAño.setEnabled(false);
        campoAño.addActionListener(this);
        IFAdministrar.add(campoAño);

        campoMes = new JTextField();
        campoMes.setBounds(margenIzq + 90, 115, 60, 25);
        campoMes.setEnabled(false);
        campoMes.addActionListener(this);
        IFAdministrar.add(campoMes);

        campoDia = new JTextField();
        campoDia.setBounds(margenIzq + 160, 115, 60, 25);
        campoDia.setEnabled(false);
        campoDia.addActionListener(this);
        IFAdministrar.add(campoDia);

// -------------------------- Horarios --------------------------
        JLabel lblHoraInicio = new JLabel("Hora de inicio:");
        lblHoraInicio.setBounds(margenIzq + 280, 90, 150, 20);
        IFAdministrar.add(lblHoraInicio);

        campoHoraInicio = new JTextField();
        campoHoraInicio.setBounds(margenIzq + 280, 115, 100, 25);
        campoHoraInicio.setEnabled(false);
        campoHoraInicio.addActionListener(this);
        IFAdministrar.add(campoHoraInicio);

        JLabel lblHoraFinal = new JLabel("Hora final:");
        lblHoraFinal.setBounds(margenIzq + 390, 90, 150, 20);
        IFAdministrar.add(lblHoraFinal);

        campoHoraFinal = new JTextField();
        campoHoraFinal.setBounds(margenIzq + 390, 115, 100, 25);
        campoHoraFinal.setEnabled(false);
        campoHoraFinal.addActionListener(this);
        IFAdministrar.add(campoHoraFinal);

// -------------------------- Botones de acción --------------------------
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(margenIzq + 500, 115, 40, 40);
        btnEditar.addActionListener(this);
        btnEditar.setEnabled(false);
        IFAdministrar.add(btnEditar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(margenIzq + 480, 160, 120, 35);
        btnGuardar.addActionListener(this);
        btnGuardar.setEnabled(false);
        IFAdministrar.add(btnGuardar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(margenIzq + 550, 115, 40, 40);
        btnEliminar.addActionListener(this);
        btnEliminar.setEnabled(false);
        IFAdministrar.add(btnEliminar);

// -------------------------- Tabla de lecciones --------------------------
        lecciones = new JTable();
        JScrollPane scrollLecciones = new JScrollPane(lecciones);
        scrollLecciones.setBounds(margenIzq, 260, 600, 150);
        IFAdministrar.add(scrollLecciones);

// -------------------------- Botones del formulario --------------------------
        btnAñadirA = new JButton("Añadir");
        btnAñadirA.setBounds(margenIzq + 60, 160, 120, 35);
        btnAñadirA.addActionListener(this);
        IFAdministrar.add(btnAñadirA);

        btnBorrarA = new JButton("Borrar");
        btnBorrarA.setBounds(margenIzq + 200, 160, 120, 35);
        btnBorrarA.addActionListener(this);
        IFAdministrar.add(btnBorrarA);

        btnCancelarA = new JButton("Cancelar");
        btnCancelarA.setBounds(margenIzq + 340, 160, 120, 35);
        btnCancelarA.addActionListener(this);
        IFAdministrar.add(btnCancelarA);


        //--------------Botones para navegar--------------
        btnAnterior = new JButton("<");
        btnAnterior.setBounds(margenIzq + 60, 220, 120, 35);
        btnAnterior.addActionListener(this);
        IFAdministrar.add(btnAnterior);

        indice = new JTextField();
        indice.setBounds(margenIzq + 200, 220, 120, 35);
        indice.setEnabled(false);
        indice.addActionListener(this);
        IFAdministrar.add(indice);

        btnCancelarA = new JButton(">");
        btnCancelarA.setBounds(margenIzq + 340, 220, 120, 35);
        btnCancelarA.addActionListener(this);
        IFAdministrar.add(btnCancelarA);

// -------------------------- Panel de Info Adicional --------------------------
        JLabel infoInstructor = new JLabel("Detalles del Instructor:");
        infoInstructor.setBounds(640, 20, 140, 20);
        IFAdministrar.add(infoInstructor);

        detallesInstructor = new JTextArea();
        detallesInstructor.setEditable(false);
        JScrollPane scrollInstructor = new JScrollPane(detallesInstructor);
        scrollInstructor.setBounds(640, 45, 130, 100);
        IFAdministrar.add(scrollInstructor);

        JLabel infoCliente = new JLabel("Detalles del Cliente:");
        infoCliente.setBounds(640, 160, 140, 20);
        IFAdministrar.add(infoCliente);

        detallesCliente = new JTextArea();
        detallesCliente.setEditable(false);
        JScrollPane scrollCliente = new JScrollPane(detallesCliente);
        scrollCliente.setBounds(640, 185, 130, 100);
        IFAdministrar.add(scrollCliente);

        cargarDatosPersonas(cajaClienteA, cajaInstructorA);


        add(IFAdministrar);



    }

    public void cargarDatosPersonas(JComboBox cajaClienteTemp, JComboBox cajaInstructorTemp) {
        InstructorDAO instructorDAO = new InstructorDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        cajaInstructorTemp.removeAllItems();
        for (Instructor instructor : instructorDAO.mostrarInstructores()) {
            cajaInstructorTemp.addItem(instructor.getNombre() + " " + instructor.getApellidoPaterno());
        }

        cajaClienteTemp.removeAllItems();
        for (Cliente cliente : clienteDAO.mostrarClientes()) {
            cajaClienteTemp.addItem(cliente.getNombre() + " " + cliente.getApellidoPat());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof MenuItem) {
            if (e.getSource() == itemAñadirLec) {
                System.out.println("AÑADIR");
                ifa.IFAñadorLec.setVisible(true);
                IFAdministrar.setVisible(false);
            }
            if (e.getSource() == itemAdministrarLec) {
                System.out.println("ADMINISTRAR");
                IFAdministrar.setVisible(true);
                ifa.IFAñadorLec.setVisible(false);
            }
        } else {


            //Acciones de IFAdministrar
            if (e.getSource() == cajaInstructorA) {
                mostrarDetallesPersona(cajaInstructorA.getSelectedItem(), detallesInstructor);
                actualizarTablaLecciones();
            }
            if (e.getSource() == cajaClienteA) {
                mostrarDetallesPersona(cajaClienteA.getSelectedItem(), detallesCliente);
                actualizarTablaLecciones();
            }
            if (e.getSource() == btnEditar) {
                habilitarEdicionCampos(true);
            }
            if (e.getSource() == btnCancelarA) {
                habilitarEdicionCampos(false);
                limpiarCampos();
            }
            if (e.getSource() == btnBuscar) {
                actualizarTablaLecciones(); // o una búsqueda específica
            }
            if(e.getSource()==btnAñadirA){
                //Preguntar si quiere salir de esta ventana y si elige si
                /*
                IFAñadir.setVisable(true);
                IFAdministrar.setVisable(false);
                 */
            }


        }
    }

    //Metodos Administracion
    public void actualizarTablaLecciones() {
        Instructor instructor = (Instructor) cajaInstructorA.getSelectedItem();
        Cliente cliente = (Cliente) cajaClienteA.getSelectedItem();

        if (instructor == null || cliente == null) return;

        LeccionDAO ld = new LeccionDAO();
        ArrayList<Leccion> listaLecciones = ld.mostrarLecciones();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora Inicio");
        modelo.addColumn("Hora Final");

        for (Leccion lec : listaLecciones) {
            modelo.addRow(new Object[]{
                    lec.getFecha().toString(),
                    lec.getHoraInicio(),
                    lec.getHoraFinal()
            });
        }

        lecciones.setModel(modelo);
    }


    public void habilitarEdicionCampos(boolean habilitar) {
        campoAño.setEnabled(habilitar);
        campoMes.setEnabled(habilitar);
        campoDia.setEnabled(habilitar);
        campoHoraInicio.setEnabled(habilitar);
        campoHoraFinal.setEnabled(habilitar);
        btnGuardar.setEnabled(habilitar);
    }

    public void limpiarCampos() {
        campoAño.setText("");
        campoMes.setText("");
        campoDia.setText("");
        campoHoraInicio.setText("");
        campoHoraFinal.setText("");
    }

    public void mostrarDetallesPersona(Object persona, JTextArea area) {
        if (persona == null) {
            area.setText("No disponible");
            return;
        }

        if (persona instanceof Instructor) {
            Instructor ins = (Instructor) persona;
            area.setText(ins.toString());
        } else if (persona instanceof Cliente) {
            Cliente cl = (Cliente) persona;
            area.setText(cl.toString());
        }
    }



    //-------------------





    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }
}
