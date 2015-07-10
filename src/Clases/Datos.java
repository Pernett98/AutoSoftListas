package Clases;

/**
 *
 * @author Velasquez
 */
public class Datos {
    public boolean validarUsuario(String usuario, String contrasena){
        if(usuario.equals("user") && contrasena.equals("123")) {
            return true;
        } else {
            return false;
        }
    }
}
