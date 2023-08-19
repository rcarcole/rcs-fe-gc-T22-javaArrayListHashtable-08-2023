package Ex02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> carrito = new ArrayList<>();

        // productos y sus precios
        while (true) {
            System.out.print("Introduce el precio del artículo (o -1 para finalizar): ");
            double precio = scanner.nextDouble();
            if (precio == -1) {
                break;
            }
            carrito.add(precio);
        }

        // total bruto
        double totalBruto = 0;
        Iterator<Double> iterator = carrito.iterator();
        while (iterator.hasNext()) {
            totalBruto += iterator.next();
        }

        // calculo IVA
        double ivaAplicado;
        System.out.print("Introduce el tipo de IVA (21 o 4): ");
        int tipoIva = scanner.nextInt();
        if (tipoIva == 21) {
            ivaAplicado = 0.21;
        } else {
            ivaAplicado = 0.04;
        }
        double totalConIva = totalBruto + (totalBruto * ivaAplicado);

        System.out.println("Número de artículos comprados: " + carrito.size());
        System.out.println("Precio total bruto: " + totalBruto);
        System.out.println("Precio total con IVA (" + tipoIva + "%): " + totalConIva);

        System.out.print("Introduce la cantidad pagada por el cliente: ");
        double cantidadPagada = scanner.nextDouble();

        double cambio = cantidadPagada - totalConIva;
        if (cambio < 0) {
            System.out.println("El cliente no ha pagado lo suficiente.");
        } else {
            System.out.println("Cambio a devolver al cliente: " + cambio);
        }

        scanner.close();
    }
}
