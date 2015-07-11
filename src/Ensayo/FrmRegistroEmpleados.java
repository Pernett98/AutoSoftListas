package Ensayo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.util.Date;
//Implementar tabla
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import autosoftlistas.Archivo;
import autosoftlistas.Empleados;
import autosoftlistas.ListaEmpleados;
import java.util.Iterator;
import javax.swing.JLayeredPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FrmRegistroEmpleados extends JFrame implements ActionListener, KeyListener, MouseListener {

    JTextField txtId, txtCargo, txtNombre, txtApellidos, txtFechaN,
            txtEstadoC, txtCorreo, txtTel, txtCel, txtPais, txtDept, txtDir, txtCiudad;
    ButtonGroup btnGrupoSexo;
    JRadioButton rdbM, rdbtF;
    JPasswordField txtClave, txtConfirmarClave;
    JLabel lblID, lblCargo, lblNombre, lblApellidos, lblFecha, lblGenero, lblEstado, lblCorreo, lbltel, lblcel,
            lblPais, lblDep, lblDir, lblCiudad, lblClave, lblConfirmarClave, lblTitulo, lbltipUsuario, lblInformacion;
    JButton btnRegistrar, btnCancelar, btnActualizar, btnBuscar, btnBorrar;
    String ruta = "/COM/soft/Imagenes/";
    private DefaultTableModel dataModel;   //arreglo tipo objects para las columnas de encabezado
    //declarar un JTable
    JTable tbDatos = new JTable();
    JPanel pnDatos = new JPanel();
    ImageIcon imagen = new ImageIcon(ruta + "IconoUsuario.png");
    private JList jlstEmpleados;
    private DefaultListModel defaultListModel;
    private ListaEmpleados listaEmpleados;
    private Archivo archivoEmpleados;
    private Empleados empleados;

    public FrmRegistroEmpleados() {
        
        setTitle("Registro de Empleados");
        setLayout(null);
        setSize(900, 700);
        setLocationRelativeTo(this);
        setIconImage(new ImageIcon(getClass().getResource(ruta + "IconoUsuario.png")).getImage());

        defaultListModel = new DefaultListModel();
        listaEmpleados = new ListaEmpleados();

        archivoEmpleados = new Archivo("c:\\Empleados.txt");
        listaEmpleados = archivoEmpleados.leer();
        poblarJList();
        jlstEmpleados = new JList(defaultListModel);
        jlstEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jlstEmpleados.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int indiceSeleccionado = jlstEmpleados.getSelectedIndex();

                //JOptionPane.showMessageDialog(rootPane, "Indice seleccionado " + indiceSeleccionado);
            }
        });

        //*Manejar datos (CRUD)*/
        dataModel = new DefaultTableModel();

        tbDatos = new JTable(dataModel);

        tbDatos.addMouseListener(this);

        //*Fin Manejar datos*/
        lblTitulo = new JLabel("Registro de empleados");
        lblTitulo.setFont(new java.awt.Font("Centaur", 0, 38));
        lblInformacion = new JLabel("Los campos con * son obligatorios");
        lblInformacion.setFont(new java.awt.Font("Centaur", 0, 22));
        lblInformacion.setForeground(new java.awt.Color(255, 140, 0));
        lblConfirmarClave = new JLabel("Confirmar Clave *");
        lblGenero = new JLabel("Genero");
        lblGenero.setFont(new java.awt.Font("Arial", 0, 22));
        lblClave = new JLabel("Clave *");
        lblID = new JLabel("Id Usuario *");
        lblCargo = new JLabel("Cargo");
        lblNombre = new JLabel("Nombre *");
        lblApellidos = new JLabel("Apellidos *");
        lblFecha = new JLabel("Fecha de nacimiento");
        lblEstado = new JLabel("Estado civil");
        lblCorreo = new JLabel("Correo electronico");
        lbltel = new JLabel("Telefono");
        lblcel = new JLabel("Celular");
        lblPais = new JLabel("Pais");
        lblDep = new JLabel("Departamento");
        lblDir = new JLabel("Direccion");
        lblCiudad = new JLabel("Ciudad");

        /*cboFechaDia = new JComboBox();
         int a = 0;
         for (a = 1; a <= 31; a++) {
         cboFechaDia.addItem(a);
         }

         cboFechaMes = new JComboBox();
         cboFechaMes.addItem("ENERO");
         cboFechaMes.addItem("FEBRERO");
         cboFechaMes.addItem("MARZO");
         cboFechaMes.addItem("ABRIL");
         cboFechaMes.addItem("MAYO");
         cboFechaMes.addItem("JUNIO");
         cboFechaMes.addItem("JULIO");
         cboFechaMes.addItem("AGOSTO");
         cboFechaMes.addItem("SETIEMBRE");
         cboFechaMes.addItem("OCTUBRE");
         cboFechaMes.addItem("NOVIEMBRE");
         cboFechaMes.addItem("DICIEMBRE");

         cboFechaAño = new JComboBox();
         for (a = 1900; a <= 2014; a++) {
         cboFechaAño.addItem(a);
         }*/
        txtClave = new JPasswordField();
        txtConfirmarClave = new JPasswordField();
        txtId = new JTextField("");
        txtCargo = new JTextField("");
        txtNombre = new JTextField("");
        txtApellidos = new JTextField("");
        txtFechaN = new JTextField("");
        txtEstadoC = new JTextField("");
        txtCorreo = new JTextField("");
        txtTel = new JTextField("");
        txtCel = new JTextField("");
        txtPais = new JTextField("");
        txtDept = new JTextField("");
        txtDir = new JTextField("");
        txtCiudad = new JTextField("");
        btnRegistrar = new JButton("Registrar", new ImageIcon(getClass().getResource(ruta + "Guardar.png")));
        btnCancelar = new JButton("Cancelar", new ImageIcon(getClass().getResource(ruta + "Cancelar.png")));
        btnActualizar = new JButton("Actualizar", new ImageIcon(getClass().getResource(ruta + "Edita.png")));
        btnBuscar = new JButton("Buscar", new ImageIcon(getClass().getResource(ruta + "Buscar.png")));
        btnBorrar = new JButton("Borrar", new ImageIcon(getClass().getResource(ruta + "Borrar.png")));

        lblTitulo.setBounds(300, 0, 300, 50);
        add(lblTitulo);

        lblInformacion.setBounds(400, 340, 300, 30);
        add(lblInformacion);

        lblID.setBounds(20, 60, 150, 20);
        add(lblID);

        lblCargo.setBounds(20, 60, 150, 20);
        add(lblCargo);

        lblNombre.setBounds(20, 140, 150, 20);
        add(lblNombre);

        lblApellidos.setBounds(20, 180, 150, 20);
        add(lblApellidos);

        lblFecha.setBounds(20, 60, 150, 20);
        add(lblFecha);

        lblGenero.setBounds(400, 100, 200, 22);
        add(lblGenero);

        lblEstado.setBounds(20, 60, 150, 20);
        add(lblEstado);

        lblCorreo.setBounds(20, 60, 150, 20);
        add(lblCorreo);

        lbltel.setBounds(20, 60, 150, 20);
        add(lbltel);

        lblcel.setBounds(20, 60, 150, 20);
        add(lblcel);

        lblPais.setBounds(20, 100, 150, 20);
        add(lblPais);

        lblDep.setBounds(20, 60, 150, 20);
        add(lblDep);

        lblDir.setBounds(20, 100, 150, 20);
        add(lblDir);

        lblCiudad.setBounds(20, 100, 150, 20);
        add(lblCiudad);

        lblClave.setBounds(20, 220, 150, 20);
        add(lblClave);

        lblConfirmarClave.setBounds(20, 260, 150, 20);
        add(lblConfirmarClave);

        /* cboFechaDia.setBounds(150, 340, 50, 20);
         add(cboFechaDia);
         cboFechaMes.setBounds(200, 340, 100, 20);
         add(cboFechaMes);
         cboFechaAño.setBounds(300, 340, 70, 20);
         add(cboFechaAño);*/
        txtId.setBounds(140, 220, 150, 20);
        add(txtId);

        txtCargo.setBounds(140, 260, 150, 20);
        add(txtCargo);

        txtNombre.setBounds(140, 140, 150, 20);
        txtNombre.addKeyListener(this);
        add(txtNombre);

        txtApellidos.setBounds(140, 180, 150, 20);
        txtApellidos.addKeyListener(this);
        add(txtApellidos);

        txtFechaN.setBounds(140, 60, 150, 20);
        add(txtFechaN);

        txtEstadoC.setBounds(140, 60, 150, 20);
        add(txtEstadoC);

        txtCorreo.setBounds(140, 60, 150, 20);
        add(txtCorreo);

        txtTel.setBounds(140, 60, 150, 20);
        add(txtTel);

        txtCel.setBounds(140, 60, 150, 20);
        add(txtCel);

        txtPais.setBounds(140, 60, 150, 20);
        add(txtPais);

        txtDept.setBounds(140, 60, 150, 20);
        add(txtDept);

        txtCiudad.setBounds(140, 60, 150, 20);
        add(txtCiudad);

        txtDir.setBounds(140, 60, 150, 20);
        add(txtDir);

        txtClave.setBounds(140, 220, 150, 20);
        add(txtClave);

        txtConfirmarClave.setBounds(140, 260, 150, 20);
        add(txtConfirmarClave);

        btnRegistrar.setBounds(75, 400, 130, 32);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        btnCancelar.setBounds(225, 400, 130, 32);
        btnCancelar.addActionListener(this);
        add(btnCancelar);

        btnActualizar.setBounds(375, 400, 130, 32);
        btnActualizar.addActionListener(this);
        add(btnActualizar);

        btnBuscar.setBounds(525, 400, 130, 32);
        btnBuscar.addActionListener(this);
        add(btnBuscar);

        btnBorrar.setBounds(675, 400, 130, 30);
        btnBorrar.addActionListener(this);
        add(btnBorrar);
        btnGrupoSexo = new ButtonGroup();
        rdbtF = new JRadioButton("Femenino");
        rdbtF.setOpaque(false);
        rdbtF.setForeground(Color.white);

        rdbtF.setBounds(340, 140, 150, 20);
        rdbM = new JRadioButton("Masculino");

        rdbM.setOpaque(false);
        rdbM.setForeground(Color.white);

        rdbM.setBounds(500, 140, 150, 20);

        btnGrupoSexo.add(rdbtF);

        btnGrupoSexo.add(rdbM);

        add(rdbtF);

        add(rdbM);

        tbDatos.getTableHeader().setResizingAllowed(false);

        JScrollPane scrollpnDatos = new JScrollPane(tbDatos);

        tbDatos.addMouseListener(this);
        scrollpnDatos.setBounds(0, 450, 900, 200);
        pnDatos.add(scrollpnDatos);

        pnDatos.setBounds(140, 450, 600, 200);
        pnDatos.setBorder(BorderFactory.createTitledBorder("Usuarios registrados"));
        pnDatos.setOpaque(false);
        pnDatos.setForeground(Color.white);
        add(pnDatos);

        JLayeredPane layered = new JLayeredPane();
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon(getClass().getResource(ruta + "Fondofrm.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 900, 700);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);

        show();
    }

    

    /* private void CargaInicial() {
     // pos 0-1-2-3-4-5
     Object[] reg1 = {"001", "Administrador", "KOK", "LOP", "Masculino", "23/08/1998", "123@jmail.com", "123"};
     Object[] reg2 = {"002", "Cliente", "KOL", "ÑPO", "Femenino", "28/06/1997", "456@jmail.com", "456"};
     Object[] reg3 = {"003", "Cliente", "KIO", "KOU", "Femenino", "23/05/1995", "789@jmail.com", "789"};

     miTabla.agregar(reg1);
     miTabla.agregar(reg2);
     miTabla.agregar(reg3);
     dataModel.setDataVector(miTabla.darTablaEntera(), cols);

     }*/
    public void Guardar() {
        String ID = txtId.getText();
        String cargo = txtCargo.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellidos.getText();
        String fechaNacimiento = txtFechaN.getText();
        String Genero = "";
        if (rdbM.isSelected()) {
            Genero = "Masculino";
        }
        if (rdbtF.isSelected()) {
            Genero = "Femenino";
        }
        String estadoCivil = txtEstadoC.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTel.getText();
        String celular = txtCel.getText();
        String pais = txtPais.getText();
        String departamento = txtDept.getText();
        String ciudad = txtCiudad.getText();
        String direccion = txtDir.getText();
        String Clave = txtClave.getText().toString();

        if (empleados == null) {
            empleados = new Empleados(ID, cargo, nombre, apellido, fechaNacimiento, Genero, estadoCivil,
                    correo, telefono, celular, pais, departamento, ciudad, direccion, Clave);
        } else {
            empleados.setID(ID);
            empleados.setCargo(cargo);
            empleados.setNombre(nombre);
            empleados.setApellido(apellido);
            empleados.setFechaNacimiento(fechaNacimiento);
            empleados.setGenero(Genero);
            empleados.setEstadoCivil(estadoCivil);
            empleados.setTelefono(telefono);
            empleados.setCelular(celular);
            empleados.setPais(pais);
            empleados.setDepartamento(departamento);
            empleados.setCiudad(ciudad);
            empleados.setDireccion(direccion);
            empleados.setCorreo(correo);
        }
        setVisible(false);

    }

   /* private void VerInfo() {

        String estado;
        txtUsuario.setText("" + miTabla.darDato(0));
        txtUsuario.setEditable(false);
        cboUsuario.setSelectedItem((String) miTabla.darDato(1));
        txtNombre.setText((String) miTabla.darDato(2));
        txtApellidos.setText((String) miTabla.darDato(3));
        String Genero = ((String) miTabla.darDato(4));
        txtEdad.setText((String) miTabla.darDato(5));
        txtCorreo.setText((String) miTabla.darDato(6));
        txtClave.setText("" + miTabla.darDato(7));

        if (Genero.equals("Masculino")) {
            rdbM.setSelected(true);
        }
        if (Genero.equals("Femenino")) {
            rdbtF.setSelected(true);
        }
    }*/

 /*   private void TraerUsuario() {
        if (!txtUsuario.getText().equals("")) {
            if (miTabla.buscar(txtUsuario.getText(), 0)) {// retorna booleam
                //llamar meto verInfor
                this.VerInfo();
                btnRegistrar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la Usuario",
                        "FALLO", JOptionPane.WARNING_MESSAGE);
                this.limpiar();
                //btnBuscar.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe escribir Usuario",
                    "ATENCION", JOptionPane.WARNING_MESSAGE);
            txtUsuario.requestFocusInWindow();
            //this.limpiar();
            // btnBuscar.setEnabled(false);
        }
    }*/

    public void Modificar() {

        int indiceSeleccionado = jlstEmpleados.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un empleado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
      //      dialogoEmpleados = new DialogoEmpleados(listaEmpleados.infoEnPosicion(indiceSeleccionado + 1));
            archivoEmpleados.guardar(listaEmpleados);
            poblarJList();

        }

    }

    /*  public void Borrar() {
     public void actionPerformed(ActionEvent ae) {
     int indiceSeleccionado = jlstEmpleados.getSelectedIndex();
     if (indiceSeleccionado == -1) {
     JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un empleado", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
     } else {
     if (JOptionPane.showConfirmDialog(rootPane, "Realmente desea borrar el empleado seleccionado", "Confirmar Borrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
     listaEmpleados.borrar(indiceSeleccionado + 1);
     archivoEmpleados.guardar(listaEmpleados);
     poblarJList();
     }
     }
     }}*/
    /*public boolean ValidarCampos() {
     boolean V = true;
     String Id = txtUsuario.getText().toString();
     String Nombre = txtNombre.getText().toString();
     String Tipo = cboUsuario.getSelectedItem().toString();
     String Apellidos = txtApellidos.getText().toString();
     String Correo = txtCorreo.getText().toString();
     String Clave = txtClave.getText().toString();
     String CClave = txtConfirmarClave.getText().toString();

     if (Id.length() == 0) {
     V = false;
     JOptionPane.showMessageDialog(null, "Falta usurio", "Error al llenar campos", 2, null);
     txtUsuario.requestFocus();
     } else if (Tipo.equals("Selecione un perfil:")) {
     V = false;
     JOptionPane.showMessageDialog(null, "Selecione un perfil", "Error al llenar campos", 2, null);
     cboUsuario.requestFocus();
     } else if (Nombre.length() == 0) {
     V = false;
     JOptionPane.showMessageDialog(null, "Falta Nombre", "Error al llenar campos", 2, null);
     txtNombre.requestFocus();
     } else if (Apellidos.length() == 0) {
     V = false;
     JOptionPane.showMessageDialog(null, "Falta Apellido", "Error al llenar campos", 2, null);
     txtApellidos.requestFocus();
     } else if (Clave.length() == 0) {
     V = false;
     JOptionPane.showMessageDialog(null, "error en la clave", "Error al llenar campos", 2, null);
     txtClave.requestFocus();
     } else if (CClave.length() == 0) {
     V = false;
     JOptionPane.showMessageDialog(null, "error en en confirmacion", "Error al llenar campos", 2, null);
     txtConfirmarClave.requestFocus();
     } else if (!CClave.equals(Clave)) {
     V = false;
     JOptionPane.showMessageDialog(null, "Clave y confirmacion no coinciden", "Error al llenar campos", 2, null);
     txtConfirmarClave.requestFocus();
     }

     return V;
     }*/
    public void actionPerformed(ActionEvent accion) {

        if (accion.getSource() == btnRegistrar) {
            Guardar();

        }
        if (accion.getSource() == btnCancelar) {
            limpiar();

        }
        if (accion.getSource() == btnBorrar) {
            //Borrar();
        }
        if (accion.getSource() == btnBuscar) {
            //TraerUsuario();
        }

        if (accion.getSource() == btnActualizar) {
            Modificar();
        }
    }//Fin actionPerformed

    public void limpiar() {
        txtClave.setText("");
        
        txtNombre.setText("");
        txtApellidos.setText("");
        txtConfirmarClave.setText("");
        
        txtCorreo.setText("");
        btnRegistrar.setEnabled(true);

    }

    public static void main(String[] args) {
        new FrmRegistroEmpleados();

    }

    private void poblarJList() {
        defaultListModel.removeAllElements();
        for (Iterator iterator = listaEmpleados.iterator(); iterator.hasNext();) {
            Empleados empleados = (Empleados) iterator.next();
            defaultListModel.addElement(empleados);
        }
    }

    private Empleados buscar(String nombre) {
        for (Iterator iterator = listaEmpleados.iterator(); iterator.hasNext();) {
            Empleados empleados = (Empleados) iterator.next();
            if (empleados.getNombre().contains(nombre)) {
                return empleados;
            }
        }
        return null;
    }

  /*  public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();
        if (e.getSource() == txtEdad) {
// solo numeros
            if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)) {
                e.consume(); // ignorar el evento de teclado
            }
        }
// Solo letras
        if ((e.getSource() == txtNombre) || (e.getSource() == txtApellidos)) {
            if ((caracter >= '0') && (caracter <= '9')) {
                if (caracter != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // ignorar el evento de teclado
                }
            }
        }
    } // fin metodo*/

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mouseClicked(MouseEvent e) {

        int fila = 0;
        try {
            fila = tbDatos.getSelectedRow();

            if (fila > -1) {
                String ide, Tip, nombre, apellido, Gen, edad, mail, clave;
                ide = String.valueOf(tbDatos.getValueAt(fila, 0));
                Tip = String.valueOf(tbDatos.getValueAt(fila, 1));
                nombre = String.valueOf(tbDatos.getValueAt(fila, 2));
                apellido = String.valueOf(tbDatos.getValueAt(fila, 3));
                Gen = String.valueOf(tbDatos.getValueAt(fila, 4));
                edad = String.valueOf(tbDatos.getValueAt(fila, 5));
                mail = String.valueOf(tbDatos.getValueAt(fila, 6));
                clave = String.valueOf(tbDatos.getValueAt(fila, 7));

              //  txtUsuario.setText(ide);
               // txtUsuario.setEditable(false);
                txtNombre.setText(nombre);
                txtApellidos.setText(apellido);
              //  txtEdad.setText(edad);
                txtCorreo.setText(mail);
                txtClave.setText(clave);
                if (Gen.equals("Masculino")) {
                    rdbM.setSelected(true);
                }
                if (Gen.equals("Femenino")) {
                    rdbtF.setSelected(true);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
