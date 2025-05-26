package Ventanas;

import Controlador.ClienteDAO;
import Controlador.InstructorDAO;
import Controlador.LeccionDAO;
import Modelo.Cliente;
import Modelo.Instructor;
import Modelo.Leccion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

public class IFAñadir extends JFrame implements ActionListener {

    JInternalFrame IFAñadorLec;
    JComboBox<String> cajaInstructor, cajaCliente;
    JComboBox<Integer> cajaMes, cajaDia, cajaAño, cajahoraInicio, cajaHoraFinal;
    JRadioButton rbCompuesta;

    JButton btnAñadir, btnBorrar, btnCancelar;

    JTable horasDisponiblesIn, horasDisponiblesCl;

    private boolean datosInicializados = false;

    public IFAñadir(JFrame ventana){
        IFAñadorLec = new JInternalFrame();
        IFAñadorLec.setSize(700, 500); // Aumentado el tamaño para acomodar mejor los elementos
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
            e.printStackTrace(); // Agregado manejo de excepción
        }

        JLabel txtInstructor = new JLabel("Instructor:");
        txtInstructor.setBounds(30, 20, 150, 20);
        IFAñadorLec.add(txtInstructor);

        cajaInstructor = new JComboBox<>();
        cajaInstructor.setBounds(30, 45, 250, 25);
        cajaInstructor.addActionListener(this);
        IFAñadorLec.add(cajaInstructor);

        JLabel txtCliente = new JLabel("Cliente:");
        txtCliente.setBounds(360, 20, 150, 20);
        IFAñadorLec.add(txtCliente);

        cajaCliente = new JComboBox<>();
        cajaCliente.setBounds(360, 45, 250, 25);
        cajaCliente.addActionListener(this);
        IFAñadorLec.add(cajaCliente);

        // -------------------------------- Fecha --------------------------------
        JLabel txtFecha = new JLabel("Fecha (Año / Mes / Día):");
        txtFecha.setBounds(30, 90, 250, 20);
        IFAñadorLec.add(txtFecha);

        cajaAño = new JComboBox<>();
        cajaAño.setBounds(30, 115, 80, 25);
        cajaAño.addActionListener(this);
        IFAñadorLec.add(cajaAño);

        cajaMes = new JComboBox<>();
        cajaMes.setBounds(120, 115, 60, 25);
        cajaMes.addActionListener(this);
        IFAñadorLec.add(cajaMes);

        cajaDia = new JComboBox<>();
        cajaDia.setBounds(190, 115, 60, 25);
        cajaDia.addActionListener(this);
        IFAñadorLec.add(cajaDia);

        // ---------------------------- Horarios ---------------------------------
        JLabel txtHoraInicio = new JLabel("Hora de inicio:");
        txtHoraInicio.setBounds(360, 90, 150, 20);
        IFAñadorLec.add(txtHoraInicio);

        cajahoraInicio = new JComboBox<>();
        cajahoraInicio.setBounds(360, 115, 120, 25);
        cajahoraInicio.addActionListener(this);
        IFAñadorLec.add(cajahoraInicio);

        JLabel txtHoraFinal = new JLabel("Hora de finalización:");
        txtHoraFinal.setBounds(500, 90, 150, 20);
        IFAñadorLec.add(txtHoraFinal);

        cajaHoraFinal = new JComboBox<>();
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
        btnAñadir.setBounds(150, 220, 120, 35);
        btnAñadir.addActionListener(this);
        IFAñadorLec.add(btnAñadir);

        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(290, 220, 120, 35);
        btnBorrar.addActionListener(this);
        IFAñadorLec.add(btnBorrar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(430, 220, 120, 35);
        btnCancelar.addActionListener(this);
        IFAñadorLec.add(btnCancelar);

        // ---------------------- Tabla: Horarios Disponibles Instructor ---------------------
        JLabel lblTablaIn = new JLabel("Disponibilidad del instructor:");
        lblTablaIn.setBounds(30, 270, 250, 20);
        IFAñadorLec.add(lblTablaIn);

        horasDisponiblesIn = new JTable();
        JScrollPane scrollIn = new JScrollPane(horasDisponiblesIn);
        scrollIn.setBounds(30, 295, 300, 120);
        IFAñadorLec.add(scrollIn);

        // ---------------------- Tabla: Horarios Disponibles Cliente ---------------------
        JLabel lblTablaCl = new JLabel("Disponibilidad del cliente:");
        lblTablaCl.setBounds(360, 270, 250, 20);
        IFAñadorLec.add(lblTablaCl);

        horasDisponiblesCl = new JTable();
        JScrollPane scrollCl = new JScrollPane(horasDisponiblesCl);
        scrollCl.setBounds(360, 295, 300, 120);
        IFAñadorLec.add(scrollCl);

        // Inicialización de datos
        cargarDatosPersonas();
        llenarHoras();
        llenarFechas();
        datosInicializados = true;

        // Configuración inicial solo si hay datos
        if (cajaInstructor.getItemCount() > 0) {
            cajaInstructor.setSelectedIndex(0);
        }
        if (cajaCliente.getItemCount() > 0) {
            cajaCliente.setSelectedIndex(0);
        }

        mostrarDisponibilidad();
        ventana.add(IFAñadorLec);
    }

    public void llenarFechas(){
        cajaAño.removeAllItems();
        for (int año = 2025; año <= 2030; año++) {
            cajaAño.addItem(año);
        }
        cajaAño.setSelectedItem(2025);

        cajaMes.removeAllItems();
        for (int mes = 1; mes <= 12; mes++) {
            cajaMes.addItem(mes);
        }

        llenarDias();
    }

    public void mostrarDisponibilidad() {
        if (!datosInicializados) return;

        if (cajaInstructor.getSelectedItem() == null ||
                cajaCliente.getSelectedItem() == null ||
                cajaAño.getSelectedItem() == null ||
                cajaMes.getSelectedItem() == null ||
                cajaDia.getSelectedItem() == null) {
            return; // Retorna silenciosamente en lugar de mostrar mensaje
        }

        try {
            String instructorSeleccionado = (String) cajaInstructor.getSelectedItem();
            String clienteSeleccionado = (String) cajaCliente.getSelectedItem();

            // Extraer NSS e ID del instructor y cliente seleccionados
            String nss = obtenerNSSInstructor(instructorSeleccionado);
            String telefono = obtenerTelefonoCliente(clienteSeleccionado);

            if (nss == null || telefono == null) {
                return;
            }

            String año = cajaAño.getSelectedItem().toString();
            String mes = String.format("%02d", (Integer) cajaMes.getSelectedItem());
            String dia = String.format("%02d", (Integer) cajaDia.getSelectedItem());

            // DISPONIBILIDAD INSTRUCTOR
            ArrayList<ArrayList<Integer>> dispIn = instructorDisponible(nss, año, mes, dia);
            actualizarTablaDisponibilidad(horasDisponiblesIn, dispIn);

            // DISPONIBILIDAD CLIENTE
            ArrayList<ArrayList<Integer>> dispCl = clienteDisponible(telefono, año, mes, dia);
            actualizarTablaDisponibilidad(horasDisponiblesCl, dispCl);

        } catch (Exception e) {
            System.err.println("Error al mostrar disponibilidad: " + e.getMessage());
        }
    }

    private void actualizarTablaDisponibilidad(JTable tabla, ArrayList<ArrayList<Integer>> disponibilidad) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Inicio");
        model.addColumn("Final");

        for (ArrayList<Integer> rango : disponibilidad) {
            if (!rango.isEmpty()) {
                int inicio = rango.get(0);
                for (int i = 1; i < rango.size(); i++) {
                    int fin = rango.get(i);
                    model.addRow(new Object[]{inicio + ":00", fin + ":00"});
                }
            }
        }
        tabla.setModel(model);
    }

    private String obtenerNSSInstructor(String nombreCompleto) {
        try {
            InstructorDAO instructorDAO = new InstructorDAO();
            for (Instructor instructor : instructorDAO.mostrarInstructores()) {
                String nombreInstructor = instructor.getNombre() + " " + instructor.getApellidoPaterno();
                if (nombreInstructor.equals(nombreCompleto)) {
                    return instructor.getNSS();
                }
            }
        } catch (Exception e) {
            System.err.println("Error al obtener NSS del instructor: " + e.getMessage());
        }
        return null;
    }

    private String obtenerTelefonoCliente(String nombreCompleto) {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            for (Cliente cliente : clienteDAO.mostrarClientes()) {
                String nombreCliente = cliente.getNombre() + " " + cliente.getApellidoPat();
                if (nombreCliente.equals(nombreCompleto)) {
                    return cliente.getTelefono();
                }
            }
        } catch (Exception e) {
            System.err.println("Error al obtener teléfono del cliente: " + e.getMessage());
        }
        return null;
    }

    public void verificarClaseCompuesta(){
        if (cajahoraInicio.getSelectedItem() == null || cajaHoraFinal.getSelectedItem() == null) {
            rbCompuesta.setSelected(false);
            return;
        }

        int horaInicial = (Integer) cajahoraInicio.getSelectedItem();
        int horaFinal = (Integer) cajaHoraFinal.getSelectedItem();

        rbCompuesta.setSelected(horaFinal - horaInicial > 1);
    }

    private void llenarDias() {
        cajaDia.removeAllItems();

        if (cajaAño.getSelectedItem() == null || cajaMes.getSelectedItem() == null) {
            return;
        }

        int año = (Integer) cajaAño.getSelectedItem();
        int mes = (Integer) cajaMes.getSelectedItem();

        int dias = switch (mes) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0)) ? 29 : 28; // Cálculo correcto de año bisiesto
            default -> 31;
        };

        for (int dia = 1; dia <= dias; dia++) {
            cajaDia.addItem(dia);
        }
    }

    public void accionBorrar() {
        if (cajaInstructor.getItemCount() > 0) cajaInstructor.setSelectedIndex(0);
        if (cajaCliente.getItemCount() > 0) cajaCliente.setSelectedIndex(0);
        if (cajaAño.getItemCount() > 0) cajaAño.setSelectedIndex(0);
        if (cajaMes.getItemCount() > 0) cajaMes.setSelectedIndex(0);
        if (cajaDia.getItemCount() > 0) cajaDia.setSelectedIndex(0);
        if (cajahoraInicio.getItemCount() > 0) cajahoraInicio.setSelectedIndex(0);
        if (cajaHoraFinal.getItemCount() > 0) cajaHoraFinal.setSelectedIndex(0);

        horasDisponiblesIn.setModel(new DefaultTableModel());
        horasDisponiblesCl.setModel(new DefaultTableModel());
        rbCompuesta.setSelected(false);
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
            String instructorSeleccionado = (String) cajaInstructor.getSelectedItem();
            String clienteSeleccionado = (String) cajaCliente.getSelectedItem();

            String nss = obtenerNSSInstructor(instructorSeleccionado);
            String telefono = obtenerTelefonoCliente(clienteSeleccionado);

            if (nss == null || telefono == null) {
                JOptionPane.showMessageDialog(this, "Error al obtener los datos del instructor o cliente.");
                return;
            }

            String año = cajaAño.getSelectedItem().toString();
            String mes = String.format("%02d", (Integer) cajaMes.getSelectedItem());
            String dia = String.format("%02d", (Integer) cajaDia.getSelectedItem());
            boolean compuesta = rbCompuesta.isSelected();

            int horaInicio = (Integer) cajahoraInicio.getSelectedItem();
            int horaFin = (Integer) cajaHoraFinal.getSelectedItem();

            if (horaFin <= horaInicio) {
                JOptionPane.showMessageDialog(this, "La hora final debe ser mayor que la hora de inicio.");
                return;
            }

            if (!validarHorasPermitidas(horaInicio, horaFin)) {
                JOptionPane.showMessageDialog(this, "Las horas seleccionadas no están disponibles para instructor y cliente.");
                return;
            }

            Leccion leccion = new Leccion();
            leccion.setNssInstructor(nss);
            leccion.setTelefonoCliente(telefono);
            leccion.setFecha(año + "-" + mes + "-" + dia);
            leccion.setHoraInicio(String.valueOf(horaInicio));
            leccion.setHoraFinal(String.valueOf(horaFin));
            leccion.setIndividual(!compuesta);

            LeccionDAO dao = new LeccionDAO();
            boolean creacion = dao.agregarLeccion(leccion);

            if (creacion) {
                JOptionPane.showMessageDialog(this, "Lección guardada exitosamente.");
                accionBorrar();
                mostrarDisponibilidad(); // Actualizar disponibilidad después de guardar
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la lección.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
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
            String inicioStr = model.getValueAt(fila, 0).toString();
            String finStr = model.getValueAt(fila, 1).toString();

            // Extraer solo la hora (remover ":00")
            int inicioTabla = Integer.parseInt(inicioStr.replace(":00", ""));
            int finTabla = Integer.parseInt(finStr.replace(":00", ""));

            if (inicio >= inicioTabla && fin <= finTabla) {
                return true;
            }
        }
        return false;
    }

    public void cargarDatosPersonas() {
        try {
            InstructorDAO instructorDAO = new InstructorDAO();
            ClienteDAO clienteDAO = new ClienteDAO();

            cajaInstructor.removeAllItems();
            ArrayList<Instructor> instructores = instructorDAO.mostrarInstructores();
            for (Instructor instructor : instructores) {
                cajaInstructor.addItem(instructor.getNombre() + " " + instructor.getApellidoPaterno());
            }

            cajaCliente.removeAllItems();
            ArrayList<Cliente> clientes = clienteDAO.mostrarClientes();
            for (Cliente cliente : clientes) {
                cajaCliente.addItem(cliente.getNombre() + " " + cliente.getApellidoPat());
            }
        } catch (Exception e) {
            System.err.println("Error al cargar datos de personas: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al cargar datos de instructores y clientes.");
        }
    }

    private void llenarHoras() {
        cajahoraInicio.removeAllItems();
        cajaHoraFinal.removeAllItems();

        for (int hora = 8; hora <= 19; hora++) {
            cajahoraInicio.addItem(hora);
        }

        for (int hora = 9; hora <= 20; hora++) {
            cajaHoraFinal.addItem(hora);
        }
    }

    public ArrayList<ArrayList<Integer>> instructorDisponible(String nss, String año, String mes, String dia) {
        try {
            LeccionDAO leccionDAO = new LeccionDAO();
            ArrayList<Leccion> todasLasLecciones = leccionDAO.mostrarLecciones();

            String fechaBuscada = año + "-" + mes + "-" + dia;

            // Filtrar lecciones del instructor y fecha
            ArrayList<Leccion> leccionesFiltradas = new ArrayList<>();
            for (Leccion l : todasLasLecciones) {
                if (l.getNssInstructor().equals(nss) && l.getFecha().equals(fechaBuscada)) {
                    leccionesFiltradas.add(l);
                }
            }

            return calcularDisponibilidad(leccionesFiltradas);

        } catch (Exception e) {
            System.err.println("Error al calcular disponibilidad del instructor: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<ArrayList<Integer>> clienteDisponible(String telefonoCliente, String año, String mes, String dia) {
        try {
            LeccionDAO leccionDAO = new LeccionDAO();
            ArrayList<Leccion> todasLasLecciones = leccionDAO.mostrarLecciones();

            String fechaBuscada = año + "-" + mes + "-" + dia;

            ArrayList<Leccion> leccionesFiltradas = new ArrayList<>();
            for (Leccion l : todasLasLecciones) {
                if (l.getTelefonoCliente().equals(telefonoCliente) && l.getFecha().equals(fechaBuscada)) {
                    leccionesFiltradas.add(l);
                }
            }

            return calcularDisponibilidad(leccionesFiltradas);

        } catch (Exception e) {
            System.err.println("Error al calcular disponibilidad del cliente: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private ArrayList<ArrayList<Integer>> calcularDisponibilidad(ArrayList<Leccion> leccionesFiltradas) {
        int horaInicioMin = 8;
        int horaFinMax = 20;

        ArrayList<ArrayList<Integer>> horasDisponibles = new ArrayList<>();

        for (int horaInicio = horaInicioMin; horaInicio < horaFinMax; horaInicio++) {
            boolean inicioValido = true;

            // Verificar si la hora de inicio está ocupada
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

                    // Verificar si el rango completo está libre
                    for (Leccion l : leccionesFiltradas) {
                        int inicioExistente = Integer.parseInt(l.getHoraInicio());
                        int finExistente = Integer.parseInt(l.getHoraFinal());

                        // Si hay solapamiento, no es válido
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

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Acciones de IFAñadir
            if (e.getSource() == cajahoraInicio || e.getSource() == cajaHoraFinal) {
                verificarClaseCompuesta();
            }

            if (e.getSource() == cajaAño || e.getSource() == cajaMes) {
                llenarDias();
                mostrarDisponibilidad();
            }

            if (e.getSource() == cajaDia) {
                mostrarDisponibilidad();
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
        } catch (Exception ex) {
            System.err.println("Error en actionPerformed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}