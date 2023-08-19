package Ex03;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex03 {

    static class Producto {
        String nombre;
        double precio;

        Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
    }

    private static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Consultar producto");
            System.out.println("3. Listar todos los productos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduce el precio del producto: ");
                    double precio = sc.nextDouble();
                    productos.add(new Producto(nombre, precio));
                    break;
                case 2:
                    System.out.print("Introduce el nombre del producto a consultar: ");
                    String consulta = sc.nextLine();
                    boolean encontrado = false;
                    for (Producto producto : productos) {
                        if (producto.nombre.equals(consulta)) {
                            System.out.println("Precio de " + producto.nombre + ": " + producto.precio);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Lista de productos:");
                    Iterator<Producto> iter = productos.iterator();
                    while (iter.hasNext()) {
                        Producto prod = iter.next();
                        System.out.println(prod.nombre + " - " + prod.precio);
                    }
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige de nuevo.");
                    break;
            }
        }
    }
}
