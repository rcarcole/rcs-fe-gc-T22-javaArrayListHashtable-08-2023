package Ex04;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex04 {
    
    static class Producto {
        String nombre;
        double precio;
        int cantidad;

        Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }
    }

    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Double> carrito = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir producto al inventario");
            System.out.println("2. Consultar producto");
            System.out.println("3. Listar todos los productos");
            System.out.println("4. Realizar venta");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Introduce la cantidad de producto: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    productos.add(new Producto(nombre, precio, cantidad));
                    break;
                case 2:
                    System.out.print("Introduce el nombre del producto a consultar: ");
                    String consulta = scanner.nextLine();
                    boolean encontrado = false;
                    for (Producto producto : productos) {
                        if (producto.nombre.equals(consulta)) {
                            System.out.println("Precio de " + producto.nombre + ": " + producto.precio + ", Cantidad: " + producto.cantidad);
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
                    for (Producto prod : productos) {
                        System.out.println(prod.nombre + " - " + prod.precio + " - Cantidad: " + prod.cantidad);
                    }
                    break;
                case 4:
                    carrito.clear();
                    while (true) {
                        System.out.print("Introduce el nombre del producto para añadir al carrito (o 'salir' para finalizar): ");
                        String prodVenta = scanner.nextLine();
                        if (prodVenta.equals("salir")) break;

                        Producto productoAComprar = null;
                        for (Producto p : productos) {
                            if (p.nombre.equals(prodVenta)) {
                                productoAComprar = p;
                                break;
                            }
                        }

                        if (productoAComprar != null && productoAComprar.cantidad > 0) {
                            carrito.add(productoAComprar.precio);
                            productoAComprar.cantidad--;
                        } else {
                            System.out.println("Producto no disponible o no existe en el inventario.");
                        }
                    }

                    double totalBruto = 0;
                    for (Double precioArticulo : carrito) {
                        totalBruto += precioArticulo;
                    }
                    System.out.print("Introduce el tipo de IVA (21 o 4): ");
                    int tipoIva = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    double ivaAplicado = tipoIva == 21 ? 0.21 : 0.04;
                    double totalConIva = totalBruto + (totalBruto * ivaAplicado);

                    System.out.println("Número de artículos comprados: " + carrito.size());
                    System.out.println("Precio total bruto: " + totalBruto);
                    System.out.println("Precio total con IVA (" + tipoIva + "%): " + totalConIva);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige de nuevo.");
                    break;
            }
        }
    }
}

