package autosoftlistas;

//jm
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Velasquez
 */
public class Archivo {
    private final String camino;

    public Archivo(String camino) {
        this.camino = camino;
    }

    public void guardar(ListaEmpleados listaEmpleados) {
        try {
            FileWriter fileWriter = new FileWriter(camino, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Iterator iterator = listaEmpleados.iterator(); iterator.hasNext();) {
                frmEmpleados empleados = (frmEmpleados) iterator.next();
                printWriter.println(empleados);
            }

            printWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ListaEmpleados leer() {
        ListaEmpleados listaEmpleados = new ListaEmpleados();

        FileReader fileReader;
        try {

            File file = new File(camino);

            if (file.exists()) {
                fileReader = new FileReader(file);

                BufferedReader bufferReader = new BufferedReader(fileReader);
                String linea;

                while ((linea = bufferReader.readLine()) != null) {
                    String[] campoEmpleado = linea.split(" ");
                    frmEmpleados empleados = new frmEmpleados(campoEmpleado[0], Integer.parseInt(campoEmpleado[1]), campoEmpleado[2], campoEmpleado[3], campoEmpleado[4], Integer.parseInt(campoEmpleado[5]), Integer.parseInt(campoEmpleado[6]), campoEmpleado[7], campoEmpleado[8], campoEmpleado[9], campoEmpleado[10], campoEmpleado[11], campoEmpleado[12], campoEmpleado[13]);
                    listaEmpleados.insertarAlfinal(empleados);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listaEmpleados;
    }

}

