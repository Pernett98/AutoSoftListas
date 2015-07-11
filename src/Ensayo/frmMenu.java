package Ensayo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;

public class frmMenu extends JFrame implements ActionListener {

    String ruta = "/COM/soft/Imagenes/";
    ImageIcon imagen = new ImageIcon(ruta + "Icono.png");
    JMenuBar barra = new JMenuBar();
    JMenu Personal = new JMenu("Personal");

    JMenu Clientes = new JMenu("Clientes");
    JMenu Ayuda = new JMenu("Ayuda");
    JMenuItem subMenuVehiculos, subMenuClientes, subMenuServicios,subMenuEmpleado,
            subMenuHistorial, subMenuVenta, subMenuAyuda, subMenuAcerca, subMenuSalir, subMenuCerrar;
    JDesktopPane dspEscritorio;

    public frmMenu() {
        setTitle("Menu Principal");
        setSize(1365, 750);

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource(ruta + "Icono.png")).getImage());
        setLayout(null);
        setLocationRelativeTo(null);
        Ayuda.setMnemonic('Y');
        Personal.setMnemonic('A');
        Clientes.setMnemonic('F');

        barra.add(Personal);
        Personal.setFont(new java.awt.Font("Centaur", 0, 18));
        barra.add(Clientes);
        Clientes.setFont(new java.awt.Font("Centaur", 0, 18));
        barra.add(Ayuda);
        Ayuda.setFont(new java.awt.Font("Centaur", 0, 18));
        setJMenuBar(barra);//agregarla al jframe
        subMenuVehiculos = new JMenuItem("Administrar Vehiculos", new ImageIcon(getClass().getResource(ruta + "Auto.png")));
        subMenuVehiculos.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuAyuda = new JMenuItem("Ayudas", new ImageIcon(getClass().getResource(ruta + "Ayuda.png")));
        subMenuAyuda.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuSalir = new JMenuItem("Salir", new ImageIcon(getClass().getResource(ruta + "Cancelar.png")));
        subMenuSalir.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuCerrar = new JMenuItem("Cerrar seccion", new ImageIcon(getClass().getResource(ruta + "Salir.png")));
        subMenuCerrar.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuClientes = new JMenuItem("Administrar Clientes", new ImageIcon(getClass().getResource(ruta + "Editar.png")));
        subMenuClientes.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuHistorial = new JMenuItem("Historial de venta", new ImageIcon(getClass().getResource(ruta + "Historial.png")));
        subMenuHistorial.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuAcerca = new JMenuItem("Acerca de", new ImageIcon(getClass().getResource(ruta + "Acerca.png")));
        subMenuAcerca.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuVenta = new JMenuItem("Registro venta", new ImageIcon(getClass().getResource(ruta + "Venta.png")));
        subMenuVenta.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuServicios = new JMenuItem("Administrar Servicios", new ImageIcon(getClass().getResource(ruta + "Servicios.png")));
        subMenuServicios.setFont(new java.awt.Font("Centaur", 0, 16));
        subMenuEmpleado = new JMenuItem("Administrar Empleados", new ImageIcon(getClass().getResource(ruta + "Editar.png")));
        subMenuEmpleado.setFont(new java.awt.Font("Centaur", 0, 16));

        Personal.add(subMenuClientes);
        Personal.add(subMenuServicios);
        Personal.add(subMenuVehiculos);
        Personal.add(subMenuEmpleado);
        Personal.addSeparator();
        Personal.add(subMenuCerrar);
        Personal.addSeparator();
        Personal.add(subMenuSalir);

        Clientes.add(subMenuVenta);
        Clientes.add(subMenuHistorial);

        Ayuda.add(subMenuAcerca);
        Ayuda.add(subMenuAyuda);

        JLayeredPane layered = new JLayeredPane();
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon(getClass().getResource(ruta + "AutoSoftFondo.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 1365, 750);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);

        subMenuVenta.addActionListener(this);
        subMenuAcerca.addActionListener(this);
        subMenuHistorial.addActionListener(this);
        subMenuVehiculos.addActionListener(this);
        subMenuEmpleado.addActionListener(this);
        subMenuClientes.addActionListener(this);
        subMenuSalir.addActionListener(this);
        subMenuAyuda.addActionListener(this);
        subMenuCerrar.addActionListener(this);
        subMenuServicios.addActionListener(this);

        dspEscritorio = new javax.swing.JDesktopPane();
        show();
    }//fin constructor

    public void actionPerformed(ActionEvent abrir) {

        if (abrir.getSource() == subMenuClientes) {

            //FrmRegistroUsuarios MiMenuUsuarios = new FrmRegistroUsuarios();
        }
        if (abrir.getSource() == subMenuVehiculos) {

           // FrmRegistroProductos MiMenuProductos = new FrmRegistroProductos();
        }
        if (abrir.getSource() == subMenuServicios) {

          //  FrmRegistroProveedor MiMenuProveedor = new FrmRegistroProveedor();
        }
        if (abrir.getSource() == subMenuEmpleado) {

          FrmRegistroEmpleados MiMenuEmple= new FrmRegistroEmpleados();
        }
        if (abrir.getSource() == subMenuSalir) {

            dispose();
        }
        if (abrir.getSource() == subMenuCerrar) {

            FrmLogin Milogin = new FrmLogin();
            dispose();
        }

    }//fin action performed

    public static void main(String args[]) {
        new frmMenu();

    }
}//fin de la clase
