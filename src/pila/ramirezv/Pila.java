package pila.ramirezv;

import java.util.Scanner;

public class Pila {

    private String pila[];
    private int tope, max;

    public Pila(int m) {
        max = m;
        pila = new String[max];
        tope = 0;
    }

    private void Agregar(String n) {
        if (tope < max) {
            pila[tope] = n;
            tope++;
            System.out.println("El dato fue agregado");
        } else {
            System.out.println("Se llego al tope de la pila");
        }
    }

    private void Eliminar() {
        if (tope > 0) {
            tope--;
            System.out.println("El dato fue eliminado");
        } else {
            System.out.println("***Los datos fueron vaciados con exito***");
        }
    }

    private void Mostrar() {
        if (!Vacia()) {
            for (int a = (tope - 1); a >= 0; a--) {
                System.out.println(pila[a]);
            }
        } else {
            System.out.println("Pila vacia");
        }
    }

    private boolean Buscar(String dato) {
        boolean encontrado = false;
        if (!Vacia()) {
            for (int a = (tope - 1); a >= 0; a--) {
                if (pila[a].equals(dato)) {
                    encontrado = true;
                }
            }
        } else {
            System.out.println("No se encontro ningun dato");
        }
        return encontrado;
    }

    //Observar si esta vacia
    private boolean Vacia() {
        if (pila == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String arg[]) {
        int t, opcion;
        String dato;
        Scanner teclado = new Scanner(System.in);
        System.out.println("\t*********");
        System.out.println("\t* Pilas *");
        System.out.println("\t*********");
        System.out.println("=> Introdusca:");
        System.out.println("  - Capacidad de la pila: ");
        t = teclado.nextInt();
        Pila pilita = new Pila(t);
        do {
            System.out.println("__________________");
            System.out.println("1. Agregar dato");
            System.out.println("2. Eliminar dato");
            System.out.println("3. Mostrar datos");
            System.out.println("4. Buscar dato");
            System.out.println("5. Salir");
            System.out.println("__________________");
            System.out.println("**Elija una opcion");
            System.out.println("__");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introdusca un dato: ");
                    dato = teclado.next();
                    pilita.Agregar(dato);
                    break;
                case 2:
                    pilita.Eliminar();
                    break;
                case 3:
                    pilita.Mostrar();
                    break;
                case 4:
                    System.out.println("Dato a buscar: ");
                    dato = teclado.next();
                    if (pilita.Buscar(dato)) {
                        System.out.println("Dato encontrado");
                    } else {
                        System.out.println("Dato no encontrado");
                    }
                    break;
            }
        } while (opcion != 5);
    }
}
