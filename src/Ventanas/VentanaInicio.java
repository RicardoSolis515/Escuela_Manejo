package Ventanas;

import Controlador.DirectorDAO;
import Controlador.LeccionDAO;
import Modelo.Director;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import Controlador.InstructorDAO;
import Controlador.ClienteDAO;
import Modelo.Instructor;
import Modelo.Cliente;
import Modelo.Leccion;

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
    JComboBox cajaInstructor, cajaCliente, cajaMes, cajaDia, cajaAño, cajahoraInicio, cajaHoraFinal;
    JRadioButton rbCompuesta;

    JButton btnAñadir, btnBorrar, btnCancelar;

    JTable horasDisponiblesIn, horasDisponiblesCl;

    private boolean datosInicializados = false;

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


        JLabel txtInstructor = new JLabel("Instructor:");
        txtInstructor.setBounds(30, 20, 150, 20);
        IFAñadorLec.add(txtInstructor);

        cajaInstructor = new JComboBox();
        cajaInstructor.setBounds(30, 45, 250, 25);
        cajaInstructor.addActionListener(this);
        IFAñadorLec.add(cajaInstructor);

        JLabel txtCliente = new JLabel("Cliente:");
        txtCliente.setBounds(360, 20, 150, 20);
        IFAñadorLec.add(txtCliente);

        cajaCliente = new JComboBox();
        cajaCliente.setBounds(360, 45, 250, 25);
        cajaCliente.addActionListener(this);
        IFAñadorLec.add(cajaCliente);


// -------------------------------- Fecha --------------------------------
        JLabel txtFecha = new JLabel("Fecha (Año / Mes / Día):");
        txtFecha.setBounds(30, 90, 250, 20);
        IFAñadorLec.add(txtFecha);

        cajaAño = new JComboBox();
        cajaAño.setBounds(30, 115, 80, 25);
        cajaAño.addActionListener(this);
        IFAñadorLec.add(cajaAño);

        cajaMes = new JComboBox();
        cajaMes.setBounds(120, 115, 60, 25);
        cajaMes.addActionListener(this);
        IFAñadorLec.add(cajaMes);

        cajaDia = new JComboBox();
        cajaDia.setBounds(190, 115, 60, 25);
        cajaDia.addActionListener(this);
        IFAñadorLec.add(cajaDia);



// ---------------------------- Horarios ---------------------------------
        JLabel txtHoraInicio = new JLabel("Hora de inicio:");
        txtHoraInicio.setBounds(360, 90, 150, 20);
        IFAñadorLec.add(txtHoraInicio);

        cajahoraInicio = new JComboBox();
        cajahoraInicio.setBounds(360, 115, 120, 25);
        cajahoraInicio.addActionListener(this);
        IFAñadorLec.add(cajahoraInicio);

        JLabel txtHoraFinal = new JLabel("Hora de finalización:");
        txtHoraFinal.setBounds(500, 90, 150, 20);
        IFAñadorLec.add(txtHoraFinal);

        cajaHoraFinal = new JComboBox();
        cajaHoraFinal.setBounds(500, 115, 120, 25);
        cajaHoraFinal.addActionListener(this);
        IFAñadorLec.add(cajaHoraFinal);


// ------------------------ Tipo de clase -------------------------------
        JLabel txtCompuesta = new JLabel("Tipo de clase:");
        txtCompuesta.setBounds(30, 160, 200, 20);
        IFAñadorLec.add(txtCompuesta);

        rbCompuesta = new JRadioButton("Clase compuesta");
        rbCompuesta.setBounds(30, 185, 200, 25);
        rbCompuesta.setEnabled(false);
        IFAñadorLec.add(rbCompuesta);


// ----------------------------- Botones --------------------------------
        btnAñadir = new JButton("Añadir");
        btnAñadir.setBounds(150, 250, 120, 35);
        btnAñadir.addActionListener(this);
        IFAñadorLec.add(btnAñadir);

        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(290, 250, 120, 35);
        btnBorrar.addActionListener(this);
        IFAñadorLec.add(btnBorrar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(430, 250, 120, 35);
        btnCancelar.addActionListener(this);
        IFAñadorLec.add(btnCancelar);

        // ---------------------- Tabla: Horarios Disponibles Instructor ---------------------
        JLabel lblTablaIn = new JLabel("Disponibilidad del instructor:");
        lblTablaIn.setBounds(30, 300, 250, 20);
        IFAñadorLec.add(lblTablaIn);

        horasDisponiblesIn = new JTable();
        JScrollPane scrollIn = new JScrollPane(horasDisponiblesIn);
        scrollIn.setBounds(30, 325, 300, 100);
        IFAñadorLec.add(scrollIn);

// ---------------------- Tabla: Horarios Disponibles Cliente ---------------------
        JLabel lblTablaCl = new JLabel("Disponibilidad del cliente:");
        lblTablaCl.setBounds(360, 300, 250, 20);
        IFAñadorLec.add(lblTablaCl);

        horasDisponiblesCl = new JTable();
        JScrollPane scrollCl = new JScrollPane(horasDisponiblesCl);
        scrollCl.setBounds(360, 325, 300, 100);
        IFAñadorLec.add(scrollCl);



        cargarDatosPersonas();
        llenarHoras();
        llenarFechas();
        datosInicializados = true;
        cajaInstructor.setSelectedIndex(0);
        cajaCliente.setSelectedIndex(0);
        mostrarDisponibilidad();

        add(IFAñadorLec);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof MenuItem) {
            if (e.getSource() == itemAñadirLec) {
                System.out.println("AÑADIR");
                IFAñadorLec.setVisible(true);
            }
            if (e.getSource() == itemAdministrarLec) {
                System.out.println("ADMINISTRAR");
            }
        } else {
            if (e.getSource() == cajahoraInicio || e.getSource() == cajaHoraFinal) {
                verificarClaseCompuesta();
            }

            if (e.getSource() == cajaAño || e.getSource() == cajaMes) {
                llenarDias();
            }

            if (e.getSource() == cajaInstructor || e.getSource() == cajaCliente) {
                mostrarDisponibilidad();
            }

            if (e.getSource() == btnAñadir) {
                guardarLeccion();
            }

            if (e.getSource() == btnBorrar) {
                accionBorrar();
            }

            if (e.getSource() == btnCancelar) {
                accionBorrar();
                IFAñadorLec.setVisible(false);
            }
        }
    }


    public void llenarFechas(){
        cajaAño.removeAllItems();
        for (int año = 2025; año <= 2030; año++)
            cajaAño.addItem(año);

        cajaAño.setSelectedItem(2025);

        cajaMes.removeAllItems();
        for (int mes = 1; mes <= 12; mes++)
            cajaMes.addItem(mes);

        llenarDias();


    }

    public void mostrarDisponibilidad() {
        if(!datosInicializados) return;

        if (cajaInstructor.getSelectedItem() == null ||
                cajaCliente.getSelectedItem() == null ||
                cajaAño.getSelectedItem() == null ||
                cajaMes.getSelectedItem() == null ||
                cajaDia.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this, "Por favor asegúrate de seleccionar un instructor, cliente y una fecha completa (año, mes y día).");
            return;
        }

        String nss = (String) cajaInstructor.getSelectedItem();
        String telefono = (String) cajaCliente.getSelectedItem();
        String año = cajaAño.getSelectedItem().toString();
        String mes = cajaMes.getSelectedItem().toString();
        String dia = cajaDia.getSelectedItem().toString();

        if (mes.length() == 1) mes = "0" + mes;
        if (dia.length() == 1) dia = "0" + dia;

        LeccionDAO lDAO = new LeccionDAO();

        // DISPONIBILIDAD INSTRUCTOR
        ArrayList<ArrayList<Integer>> dispIn = instructorDisponible(nss, año, mes, dia);
        DefaultTableModel modelIn = new DefaultTableModel();
        modelIn.addColumn("Inicio");
        modelIn.addColumn("Final");
        for (ArrayList<Integer> rango : dispIn) {
            int inicio = rango.get(0);
            for (int i = 1; i < rango.size(); i++) {
                int fin = rango.get(i);
                if (fin - inicio == 1) {
                    modelIn.addRow(new Object[]{inicio, fin});
                }
            }
        }
        horasDisponiblesIn.setModel(modelIn);

        // DISPONIBILIDAD CLIENTE
        ArrayList<ArrayList<Integer>> dispCl = clienteDisponible(telefono, año, mes, dia);
        DefaultTableModel modelCl = new DefaultTableModel();
        modelCl.addColumn("Inicio");
        modelCl.addColumn("Final");
        for (ArrayList<Integer> rango : dispCl) {
            int inicio = rango.get(0);
            for (int i = 1; i < rango.size(); i++) {
                int fin = rango.get(i);
                if (fin - inicio == 1) {
                    modelCl.addRow(new Object[]{inicio, fin});
                }
            }
        }
        horasDisponiblesCl.setModel(modelCl);
    }



    public void verificarClaseCompuesta(){
        if (cajahoraInicio.getSelectedItem() == null || cajaHoraFinal.getSelectedItem() == null) {
            rbCompuesta.setSelected(false);
            return;
        }

        int horaInicial = (int) cajahoraInicio.getSelectedItem();
        int horaFinal = (int) cajaHoraFinal.getSelectedItem();

        rbCompuesta.setSelected(horaFinal - horaInicial > 1);
    }

    private void llenarDias() {
        cajaDia.removeAllItems();

        if (cajaAño.getSelectedItem() == null || cajaMes.getSelectedItem() == null)
            return;

        int año = (int) cajaAño.getSelectedItem();
        int mes = (int) cajaMes.getSelectedItem();
        int feb;
        if(año%4==0)
            feb=29;
        else
            feb=28;

        int dias = switch (mes) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> feb;
            default -> 31;
        };

        for (int dia = 1; dia <= dias; dia++) {
            cajaDia.addItem(dia);
        }
    }

    public void accionBorrar() {
        cajaInstructor.setSelectedIndex(0);
        cajaCliente.setSelectedIndex(0);
        cajaAño.setSelectedIndex(0);
        cajaMes.setSelectedIndex(0);
        cajaDia.setSelectedIndex(0);

        horasDisponiblesIn.setModel(new DefaultTableModel());
        horasDisponiblesCl.setModel(new DefaultTableModel());
    }

    public void guardarLeccion() {
        if (cajaInstructor.getSelectedItem() == null ||
                cajaCliente.getSelectedItem() == null ||
                cajaAño.getSelectedItem() == null ||
                cajaMes.getSelectedItem() == null ||
                cajaDia.getSelectedItem() == null ||
                cajahoraInicio.getSelectedItem() == null ||
                cajaHoraFinal.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos, incluyendo las horas.");
            return;
        }

        try {
            String nss = (String) cajaInstructor.getSelectedItem();
            String telefono = (String) cajaCliente.getSelectedItem();
            String año = cajaAño.getSelectedItem().toString();
            String mes = cajaMes.getSelectedItem().toString();
            String dia = cajaDia.getSelectedItem().toString();

            if (mes.length() == 1) mes = "0" + mes;
            if (dia.length() == 1) dia = "0" + dia;

            int horaInicio = Integer.parseInt(cajahoraInicio.getSelectedItem().toString());
            int horaFin = Integer.parseInt(cajaHoraFinal.getSelectedItem().toString());

            if (horaFin <= horaInicio) {
                JOptionPane.showMessageDialog(this, "La hora final debe ser mayor que la hora de inicio.");
                return;
            }

            if (!validarHorasPermitidas(horaInicio, horaFin)) {
                JOptionPane.showMessageDialog(this, "Las horas seleccionadas no están disponibles para instructor y cliente.");
                return;
            }
            if((int) cajahoraInicio.getSelectedItem() > (int) cajaHoraFinal.getSelectedItem()){
                JOptionPane.showMessageDialog(this, "La hora inicial no puede ser despues de la hora final");
                return;
            }

            Leccion leccion = new Leccion();
            leccion.setNssInstructor(nss);
            leccion.setTelefonoCliente(telefono);
            leccion.setFecha(año + "-" + mes + "-" + dia);
            leccion.setHoraInicio("" + horaInicio);
            leccion.setHoraFinal("" + horaFin);

            LeccionDAO dao = new LeccionDAO();
            boolean creacion = dao.agregarLeccion(leccion);

            if (creacion) {
                JOptionPane.showMessageDialog(this, "Lección guardada exitosamente.");
                accionBorrar();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la lección.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public boolean validarHorasPermitidas(int horaInicio, int horaFin) {
        boolean disponibleCliente = disponibleEnTabla(horasDisponiblesCl, horaInicio, horaFin);
        boolean disponibleInstructor = disponibleEnTabla(horasDisponiblesIn, horaInicio, horaFin);

        return disponibleCliente && disponibleInstructor;
    }

    public boolean disponibleEnTabla(JTable tabla, int inicio, int fin) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (int fila = 0; fila < model.getRowCount(); fila++) {
            int inicioTabla = (int) model.getValueAt(fila, 0);
            int finTabla = (int) model.getValueAt(fila, 1);

            if (inicio == inicioTabla && fin == finTabla) {
                return true;
            }
        }
        return false;
    }



    public void cargarDatosPersonas() {
        InstructorDAO instructorDAO = new InstructorDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        cajaInstructor.removeAllItems();
        for (Instructor instructor : instructorDAO.mostrarInstructores()) {
            cajaInstructor.addItem(instructor.getNombre() + " " + instructor.getApellidoPaterno());
        }

        cajaCliente.removeAllItems();
        for (Cliente cliente : clienteDAO.mostrarClientes()) {
            cajaCliente.addItem(cliente.getNombre() + " " + cliente.getApellidoPat());
        }
    }

    private void llenarHoras() {
        cajahoraInicio.removeAllItems();
        cajaHoraFinal.removeAllItems();

        for (int hora = 8; hora <= 19; hora++) {
            cajahoraInicio.addItem(hora);
            cajaHoraFinal.addItem(hora+1);
        }
    }

    @Override
    public void run() {

        new VentanaInicio();
    }

    public ArrayList<ArrayList<Integer>> instructorDisponible(String nss, String año, String mes, String dia) {
        LeccionDAO leccionDAO = new LeccionDAO();
        ArrayList<Leccion> todasLasLecciones = leccionDAO.mostrarLecciones();

        String mesFormateado = (mes.length() == 1) ? "0" + mes : mes;
        String diaFormateado = (dia.length() == 1) ? "0" + dia : dia;
        String fechaBuscada = año + mesFormateado + diaFormateado;

        // Filtrar lecciones del instructor y fecha
        ArrayList<Leccion> leccionesFiltradas = new ArrayList<>();
        for (Leccion l : todasLasLecciones) {
            if (l.getNssInstructor().equals(nss) && l.getFecha().equals(fechaBuscada)) {
                leccionesFiltradas.add(l);
            }
        }

        int horaInicioMin = 8;
        int horaFinMax = 20;

        ArrayList<ArrayList<Integer>> horasDisponibles = new ArrayList<>();

        for (int horaInicio = horaInicioMin; horaInicio < horaFinMax; horaInicio++) {

            boolean inicioValido = true;

            for (Leccion l : leccionesFiltradas) {
                int inicioExistente = Integer.parseInt(l.getHoraInicio());
                int finExistente = Integer.parseInt(l.getHoraFinal());

                if (horaInicio >= inicioExistente && horaInicio < finExistente) {
                    inicioValido = false;
                    break;
                }
            }

            if (inicioValido) {
                ArrayList<Integer> horasFinalesPosibles = new ArrayList<>();

                for (int horaFinal = horaInicio + 1; horaFinal <= horaFinMax; horaFinal++) {
                    boolean finValido = true;

                    for (Leccion l : leccionesFiltradas) {
                        int inicioExistente = Integer.parseInt(l.getHoraInicio());
                        int finExistente = Integer.parseInt(l.getHoraFinal());

                        if (!(horaFinal <= inicioExistente || horaInicio >= finExistente)) {
                            finValido = false;
                            break;
                        }
                    }

                    if (finValido) {
                        horasFinalesPosibles.add(horaFinal);
                    } else {
                        break;
                    }
                }

                if (!horasFinalesPosibles.isEmpty()) {
                    ArrayList<Integer> entrada = new ArrayList<>();
                    entrada.add(horaInicio);
                    entrada.addAll(horasFinalesPosibles);
                    horasDisponibles.add(entrada);
                }
            }
        }

        return horasDisponibles;
    }

    public ArrayList<ArrayList<Integer>> clienteDisponible(String telefonoCliente, String año, String mes, String dia) {
        LeccionDAO leccionDAO = new LeccionDAO();
        ArrayList<Leccion> todasLasLecciones = leccionDAO.mostrarLecciones();

        String mesFormateado = (mes.length() == 1) ? "0" + mes : mes;
        String diaFormateado = (dia.length() == 1) ? "0" + dia : dia;
        String fechaBuscada = año + mesFormateado + diaFormateado;

        ArrayList<Leccion> leccionesFiltradas = new ArrayList<>();
        for (Leccion l : todasLasLecciones) {
            if (l.getTelefonoCliente().equals(telefonoCliente) && l.getFecha().equals(fechaBuscada)) {
                leccionesFiltradas.add(l);
            }
        }

        int horaInicioMin = 8;
        int horaFinMax = 20;

        ArrayList<ArrayList<Integer>> horasDisponibles = new ArrayList<>();

        for (int horaInicio = horaInicioMin; horaInicio < horaFinMax; horaInicio++) {
            boolean inicioValido = true;

            for (Leccion l : leccionesFiltradas) {
                int inicioExistente = Integer.parseInt(l.getHoraInicio());
                int finExistente = Integer.parseInt(l.getHoraFinal());

                if (horaInicio >= inicioExistente && horaInicio < finExistente) {
                    inicioValido = false;
                    break;
                }
            }

            if (inicioValido) {
                ArrayList<Integer> horasFinalesPosibles = new ArrayList<>();

                for (int horaFinal = horaInicio + 1; horaFinal <= horaFinMax; horaFinal++) {
                    boolean finValido = true;

                    for (Leccion l : leccionesFiltradas) {
                        int inicioExistente = Integer.parseInt(l.getHoraInicio());
                        int finExistente = Integer.parseInt(l.getHoraFinal());

                        if (!(horaFinal <= inicioExistente || horaInicio >= finExistente)) {
                            finValido = false;
                            break;
                        }
                    }

                    if (finValido) {
                        horasFinalesPosibles.add(horaFinal);
                    } else {
                        break;
                    }
                }

                if (!horasFinalesPosibles.isEmpty()) {
                    ArrayList<Integer> entrada = new ArrayList<>();
                    entrada.add(horaInicio);
                    entrada.addAll(horasFinalesPosibles);
                    horasDisponibles.add(entrada);
                }
            }
        }

        return horasDisponibles;
    }


}
