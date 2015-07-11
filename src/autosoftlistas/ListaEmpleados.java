package autosoftlistas;

import java.util.Iterator;

/**
 *
 * @author Velasquez
 */
public class ListaEmpleados {
    private Nodo cab, cola;
    private int nroNodos;

    public ListaEmpleados() {
        cab = cola = null;
        nroNodos = 0;
    }

    public void insertarAlfinal(Empleados empleados) {
        Nodo p = new Nodo();

        p.info = empleados;
        p.sig = null;

        if (cab == null) {
            cab = cola = p;
            p.ant = null;
        } else {
            cola.sig = p;
            p.ant = cola;
            cola = p;
        }
        nroNodos++;
    }

    public Empleados infoEnPosicion(int pos) {
        Nodo t = cab;
        if (pos <= nroNodos) {
            for (int i = 1; i < pos; i++) {
                t = t.sig;
            }
            return t.info;
        } else {
            return null;
        }
    }

    public void borrar(int pos) {
        Nodo t = cab;
        if (pos <= nroNodos) {
            for (int i = 1; i < pos; i++) {
                t = t.sig;
            }
            if (cab == cola) {
                cab = cola = null;
            } else if (cab == t) {
                cab = cab.sig;
                cab.ant = null;
            } else if (cola == t) {
                cola = cola.ant;
                cola.sig = null;
            } else {
                t.ant.sig = t.sig;
                t.sig.ant = t.ant;
            }
        }
    }



    public Iterator<Empleados> iterator() {
        return new IteradorLista();
    }

    private class IteradorLista implements Iterator {

        private Nodo actual = cab;

        @Override
        public boolean hasNext() {
            return (actual != null);
        }

        @Override
        public Empleados next() {
            Empleados empleados = actual.info;
            actual = actual.sig;
            return empleados;
        }
    }

    private static class Nodo {

        private Empleados info;
        private Nodo sig, ant;
    }
}


