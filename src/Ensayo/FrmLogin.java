package Ensayo;

import Ensayo.frmMenu;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrmLogin extends JFrame implements ActionListener {

    JTextField txtUsuario;
    JPasswordField txtClave;
    JLabel lblUsuario, lblClave, lblIcono,lblTitulo;
    JButton btnAceptar, btnCancelar;
    private boolean frmMenu;
    String ruta = "/COM/soft/Imagenes/";
    ImageIcon imagen = new ImageIcon(ruta + "login.png");

    public FrmLogin() {
        setTitle("Ingreso al sistema");
        setLayout(null);
        setSize(480, 250);
        setLocationRelativeTo(this);
        setIconImage(new ImageIcon(getClass().getResource(ruta + "login.png")).getImage());
        lblClave = new JLabel("Clave");
        lblClave.setFont(new java.awt.Font("Centaur", 0, 18));
        lblClave.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(new java.awt.Font("Centaur", 0, 18));
        lblUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo = new JLabel("Ingreso a AutoSoft");
        lblTitulo.setFont(new java.awt.Font("Centaur",0,22));
        lblTitulo.setForeground(new java.awt.Color(255,255,255));
        lblIcono = new JLabel(new ImageIcon(getClass().getResource(ruta + "Llogin.png")));

        txtClave = new JPasswordField();
        txtClave.setToolTipText("Introduzca su clave");
        txtUsuario = new JTextField("");
        txtUsuario.setToolTipText("Introduzca su Usuario");
        btnAceptar = new JButton("Aceptar", new ImageIcon(getClass().getResource(ruta + "OK.png")));
        btnCancelar = new JButton("Cancelar", new ImageIcon(getClass().getResource(ruta + "Cancel.png")));

        lblUsuario.setBounds(50, 50, 150, 20);
        add(lblUsuario);
        lblClave.setBounds(50, 100, 150, 20);
        add(lblClave);
        lblIcono.setBounds(325, 25, 128, 128);
        add(lblIcono);
        lblTitulo.setBounds(175,0,200,23);
        add(lblTitulo);
        
        txtUsuario.setBounds(150, 50, 150, 20);
        add(txtUsuario);
        txtClave.setBounds(150, 100, 150, 20);
        add(txtClave);
        btnAceptar.setBounds(50, 150, 140, 50);
        btnAceptar.addActionListener(this);
        add(btnAceptar);
        btnCancelar.setBounds(200, 150, 140, 50);
        btnCancelar.addActionListener(this);
        add(btnCancelar);
        
        JLayeredPane layered = new JLayeredPane();
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon(getClass().getResource(ruta + "fondologin.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 475, 250);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        show();
    }//Fin constructor

    public void actionPerformed(ActionEvent accion) {
        String user = txtUsuario.getText();
        String pwd = txtClave.getText();
        if (accion.getSource() == btnAceptar) {
            if (user.length() == 0 || pwd.length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Clave y/o usuario vacios", "Error", 0);
            } else {

                if (validarIngreso(user, pwd) == true) {

                    frmMenu MiMenu = new frmMenu();
                    dispose();

                    MiMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    MiMenu.setVisible(true);
                } else {
                    this.setVisible(true);

                }
            }
        }
        if (accion.getSource() == btnCancelar) {
            limpiar();

        }

    }

    public void limpiar() {
        txtClave.setText("");
        txtUsuario.setText("");
    }

    public boolean validarIngreso(String Usuario, String Clave) {

        boolean mensaje = true;
        String c = "123";
        String u = "Autosoft";

        if ((Usuario.equals(u)) && (Clave.equals(c))) {
            JOptionPane.showMessageDialog(rootPane, "Bienvenido " + Usuario, "Acceso", 1);

        } else {

            JOptionPane.showMessageDialog(rootPane, "Clave y/o usuario incorretos", "Error", 0);
            mensaje = false;

        }
        return mensaje;




    }

    public static void main(String[] args) {
        new FrmLogin();


    }
}//Fin de la clase
