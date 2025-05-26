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

public class IFAdministrar
        //extends JFrame implements ActionListener
{
/*
    JInternalFrame IFAdministrar;
    JComboBox<String> cajaInstructorA, cajaClienteA;

    JTextField campoAño, campoMes, campoDia, campoHoraInicio, campoHoraFinal, indice;

    JTable lecciones;

    boolean edicion = false, componenteSeleccionado = false;

    JTextArea detallesInstructor, detallesCliente;

    JButton btnAnterior, btnSiguiente; // Corregido: era "btnSiguente"
    JButton btnEditar, btnEliminar, btnBuscar, btnGuardar;
    JButton btnAñadirA, btnBorrarA, btnCancelarA;

    int idLeccionSeleccionada = -1;

    public IFAdministrar(){
        //------------------------------------IFADMINISTRAR----------------------------------
        IFAdministrar = new JInternalFrame("Administrar Lecciones", false, false, false, false);
        IFAdministrar.setSize(800, 600);
        IFAdministrar.setVisible(false);
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

        cajaInstructorA = new JComboBox<>();
        cajaInstructorA.setBounds(margenIzq, 45, 250, 25);
        cajaInstructorA.addActionListener(this);
        IFAdministrar.add(cajaInstructorA);

        JLabel lblClienteA = new JLabel("Cliente:");
        lblClienteA.setBounds(margenIzq + 280, 20, 150, 20);
        IFAdministrar.add(lblClienteA);

        cajaClienteA = new JComboBox<>();
        cajaClienteA.setBounds(margenIzq + 280, 45, 250, 25);
        cajaClienteA.addActionListener(this);
        IFAdministrar.add(cajaClienteA);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(margenIzq + 550, 45, 80, 25); // Ajustado tamaño
        btnBuscar.addActionListener(this);
        IFAdministrar.add(btnBuscar);

        // -------------------------- Fecha --------------------------
        JLabel lblFecha = new JLabel("Fecha (Año / Mes / Día):");
        lblFecha.setBounds(margenIzq, 90, 200, 20);
        IFAdministrar.add(lblFecha);

        campoAño = new JTextField();
        campoAño.setBounds(margenIzq, 115, 80, 25);
        campoAño.setEnabled(false);
        campoAño.addKeyListener(this); // Cambiado de ActionListener
        IFAdministrar.add(campoAño);

        campoMes = new JTextField();
        campoMes.setBounds(margenIzq + 90, 115, 60, 25);
        campoMes.setEnabled(false);
        campoMes.addKeyListener(this); // Cambiado de ActionListener
        IFAdministrar.add(campoMes);

        campoDia = new JTextField();
        campoDia.setBounds(margenIzq + 160, 115, 60, 25);
        campoDia.setEnabled(false);
        campoDia.addKeyListener(this); // Cambiado de ActionListener
        IFAdministrar.add(campoDia);

        // -------------------------- Horarios --------------------------
        JLabel lblHoraInicio = new JLabel("Hora de inicio:");
        lblHoraInicio.setBounds(margenIzq + 280, 90, 150, 20);
        IFAdministrar.add(lblHoraInicio);

        campoHoraInicio = new JTextField();
        campoHoraInicio.setBounds(margenIzq + 280, 115, 100, 25);
        campoHoraInicio.setEnabled(false);
        campoHoraInicio.addKeyListener(this); // Cambiado de ActionListener
        IFAdministrar.add(campoHoraInicio);

        JLabel lblHoraFinal = new JLabel("Hora final:");
        lblHoraFinal.setBounds(margenIzq + 390, 90, 150, 20);
        IFAdministrar.add(lblHoraFinal);

        campoHoraFinal = new JTextField();
        campoHoraFinal.setBounds(margenIzq + 390, 115, 100, 25);
        campoHoraFinal.setEnabled(false);
        campoHoraFinal.addKeyListener(this); // Cambiado de ActionListener
        IFAdministrar.add(campoHoraFinal);

        // -------------------------- Botones de acción --------------------------
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(margenIzq + 500, 115, 60, 25); // Ajustado tamaño
        btnEditar.addActionListener(this);
        btnEditar.setEnabled(false);
        IFAdministrar.add(btnEditar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(margenIzq + 570, 115, 80, 25); // Ajustado tamaño
        btnEliminar.addActionListener(this);
        btnEliminar.setEnabled(false);
        IFAdministrar.add(btnEliminar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(margenIzq + 480, 160, 120, 35);
        btnGuardar.addActionListener(this);
        btnGuardar.setEnabled(false);
        IFAdministrar.add(btnGuardar);

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
        indice.addKeyListener(this); // Cambiado de ActionListener
        IFAdministrar.add(indice);

        btnSiguiente = new JButton(">"); // Corregido: era btnCancelarA duplicado
        btnSiguiente.setBounds(margenIzq + 340, 220, 120, 35);
        btnSiguiente.addActionListener(this);
        IFAdministrar.add(btnSiguiente);

        // -------------------------- Tabla de lecciones --------------------------
        lecciones = new JTable();
        JScrollPane scrollLecciones = new JScrollPane(lecciones);
        scrollLecciones.setBounds(margenIzq, 260, 600, 150);
        IFAdministrar.add(scrollLecciones);

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
    public void cargarDatosPersonas(JComboBox<String> cajaClienteTemp, JComboBox<String> cajaInstructorTemp) {
        try {
            InstructorDAO instructorDAO = new InstructorDAO();
            ClienteDAO clienteDAO = new ClienteDAO();

            cajaInstructorTemp.removeAllItems();
            for (Instructor instructor : instructorDAO.mostrarInstructores()) {
                cajaInstructorTemp.addItem(instructor.getNSS());
            }

            cajaClienteTemp.removeAllItems();
            for (Cliente cliente : clienteDAO.mostrarClientes()) {
                cajaClienteTemp.addItem(cliente.getTelefono());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }

    int posicionActual = 0;

    public void actualizarTablaLecciones() {
        try {
            String instructorSeleccionado = (String) cajaInstructorA.getSelectedItem();
            String clienteSeleccionado = (String) cajaClienteA.getSelectedItem();

            if (instructorSeleccionado == null || clienteSeleccionado == null ||
                    instructorSeleccionado.contains("Seleccione") || clienteSeleccionado.contains("Seleccione")) {
                return;
            }

            LeccionDAO leccionDAO = new LeccionDAO();
            ArrayList<Leccion> listaLecciones = leccionDAO.mostrarLecciones();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora Inicio");
            modelo.addColumn("Hora Final");
            modelo.addColumn("NSS Instructor");
            modelo.addColumn("Teléfono Cliente");

            for (Leccion leccion : listaLecciones) {
                modelo.addRow(new Object[]{
                        leccion.getId(),
                        leccion.getFecha(),
                        leccion.getHoraInicio(),
                        leccion.getHoraFinal(),
                        leccion.getNssInstructor(),
                        leccion.getTelefonoCliente()
                });
            }

            lecciones.setModel(modelo);

            boolean hayDatos = modelo.getRowCount() > 0;
            btnEditar.setEnabled(hayDatos);
            btnEliminar.setEnabled(hayDatos);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar tabla: " + e.getMessage());
        }
    }

    public void habilitarEdicionCampos(boolean habilitar) {
        campoAño.setEnabled(habilitar);
        campoMes.setEnabled(habilitar);
        campoDia.setEnabled(habilitar);
        campoHoraInicio.setEnabled(habilitar);
        campoHoraFinal.setEnabled(habilitar);
        btnGuardar.setEnabled(habilitar);
        btnCancelarA.setEnabled(habilitar);
    }

    public void limpiarCampos() {
        campoAño.setText("");
        campoMes.setText("");
        campoDia.setText("");
        campoHoraInicio.setText("");
        campoHoraFinal.setText("");
        idLeccionSeleccionada = -1;
    }

    public void mostrarDetallesPersona(String personaNombre, JTextArea area) {
        if (personaNombre == null || personaNombre.contains("Seleccione")) {
            area.setText("No disponible");
            return;
        }

        try {
            area.setText("Detalles de: " + personaNombre);
        } catch (Exception e) {
            area.setText("Error al cargar detalles");
        }
    }

    private void mostrarLeccion(Leccion leccion, int pos) {
        String[] fecha = leccion.getFecha().split("-");
        campoAño.setText(String.valueOf(fecha[0]));
        campoMes.setText(String.format(fecha[1]));
        campoDia.setText(String.format(fecha[2]));
        campoHoraInicio.setText(leccion.getHoraInicio());
        campoHoraFinal.setText(leccion.getHoraFinal());
        indice.setText(String.valueOf(pos));
    }



    public void llenarCampos() {
        obtenerLeccionSeleccionada();
        int fila = lecciones.getSelectedRow();
        if (fila >= 0) {
            campoAño.setText(lecciones.getValueAt(fila, 1).toString().split("-")[0]);
            campoMes.setText(lecciones.getValueAt(fila, 1).toString().split("-")[1]);
            campoDia.setText(lecciones.getValueAt(fila, 1).toString().split("-")[2]);
            campoHoraInicio.setText(lecciones.getValueAt(fila, 2).toString());
            campoHoraFinal.setText(lecciones.getValueAt(fila, 3).toString());
            indice.setText(String.valueOf(fila + 1));
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla.");
        }
    }

    private void obtenerLeccionSeleccionada() {
        int fila = lecciones.getSelectedRow();
        if (fila >= 0) {
            idLeccionSeleccionada = Integer.parseInt(lecciones.getValueAt(fila, 0).toString());
        } else {
            idLeccionSeleccionada = -1;
        }
    }

    private void eliminarLeccionSeleccionada() {
        int fila = lecciones.getSelectedRow();
        if (fila >= 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta lección?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(lecciones.getValueAt(fila, 0).toString());
                LeccionDAO dao = new LeccionDAO();
                boolean eliminado = dao.eliminarLeccion(id);
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Lección eliminada correctamente.");
                    actualizarTablaLecciones();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la lección.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una lección para eliminar.");
        }
    }

    private void guardarLeccionEditada() {
        if (idLeccionSeleccionada != -1) {
            try {
                if (campoAño.getText().trim().isEmpty() ||
                        campoMes.getText().trim().isEmpty() ||
                        campoDia.getText().trim().isEmpty() ||
                        campoHoraInicio.getText().trim().isEmpty() ||
                        campoHoraFinal.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
                    return;
                }

                String fecha = campoAño.getText() + "-" + campoMes.getText() + "-" + campoDia.getText();
                String horaInicio = campoHoraInicio.getText();
                String horaFinal = campoHoraFinal.getText();

                String nssInstructor = "123";
                String telefonoCliente = "555";
                boolean individual = true;

                Leccion leccionEditada = new Leccion(nssInstructor, telefonoCliente, individual, fecha, horaInicio, horaFinal);
                leccionEditada.setId(idLeccionSeleccionada);

                LeccionDAO dao = new LeccionDAO();
                boolean actualizado = dao.editarLeccion(idLeccionSeleccionada, leccionEditada);

                if (actualizado) {
                    JOptionPane.showMessageDialog(this, "Lección actualizada exitosamente.");
                    actualizarTablaLecciones();
                    limpiarCampos();
                    habilitarEdicionCampos(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar la lección.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cajaInstructorA) {
            mostrarDetallesPersona((String) cajaInstructorA.getSelectedItem(), detallesInstructor);
            actualizarTablaLecciones();
        } else if (e.getSource() == cajaClienteA) {
            mostrarDetallesPersona((String) cajaClienteA.getSelectedItem(), detallesCliente);
            actualizarTablaLecciones();
        } else if (e.getSource() == btnEditar) {
            edicion = !edicion;
            habilitarEdicionCampos(edicion);

        } else if (e.getSource() == btnCancelarA) {
            limpiarCampos();
            IFAdministrar.setVisible(false);
        } else if (e.getSource() == btnBuscar) {
            String instructor = "" + cajaInstructorA.getSelectedItem();
            String cliente = "" + cajaClienteA.getSelectedItem();

            String condicion = "NSSInstructor = '" + instructor + "' AND telefonoCliente = '" + cliente + "'";
            LeccionDAO dao = new LeccionDAO();
            posicionActual = 0;
            Leccion leccion = dao.obtenerLeccionPos(posicionActual, condicion);

            if (leccion != null) {
                mostrarLeccion(leccion, posicionActual);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna lección con los datos especificados.");
            }
        } else if (e.getSource() == btnAñadirA) {
            ifa.IFAñadorLec.setVisible(true);
            IFAdministrar.setVisible(false);
        } else if (e.getSource() == btnGuardar) {
            guardarLeccionEditada();
        } else if (e.getSource() == btnEliminar) {
            eliminarLeccionSeleccionada();
        } else if (e.getSource() == btnAnterior) {
            if (indice.getText() == null || indice.getText().isEmpty())
                return;
            int nuevaPosicion = posicionActual - 1;
            if (nuevaPosicion >= 0) {
                String instructor = (String) cajaInstructorA.getSelectedItem();
                String cliente = (String) cajaClienteA.getSelectedItem();

                String condicion = "NSSInstructor = '" + instructor + "' AND telefonoCliente = '" + cliente + "'";
                LeccionDAO dao = new LeccionDAO();
                Leccion leccion = dao.obtenerLeccionPos(nuevaPosicion, condicion);

                if (leccion != null) {
                    posicionActual = nuevaPosicion;
                    mostrarLeccion(leccion, posicionActual);
                } else {
                    JOptionPane.showMessageDialog(this, "No fue posible obtener la lección anterior.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ya estás en la primera lección.");
            }
        } else if (e.getSource() == btnSiguiente) {
            if (indice.getText() == null || indice.getText().isEmpty())
                return;
            int nuevaPosicion = posicionActual + 1;
            String instructor = (String) cajaInstructorA.getSelectedItem();
            String cliente = (String) cajaClienteA.getSelectedItem();

            String condicion = "NSSInstructor = '" + instructor + "' AND telefonoCliente = '" + cliente + "'";
            LeccionDAO dao = new LeccionDAO();
            Leccion leccion = dao.obtenerLeccionPos(nuevaPosicion, condicion);

            if (leccion != null) {
                posicionActual = nuevaPosicion;
                mostrarLeccion(leccion, posicionActual);
            } else {
                JOptionPane.showMessageDialog(this, "No hay más lecciones.");
            }
        }
    }
    */
}

