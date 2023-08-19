package Ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex01 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> notasMedias = new HashMap<>();

        System.out.print("Introduce el número de alumnos: ");
        int numeroAlumnos = sc.nextInt();

        for (int i = 0; i < numeroAlumnos; i++) {
            System.out.print("Introduce el nombre del alumno " + (i + 1) + ": ");
            sc.nextLine();
            String nombre = sc.nextLine();

            System.out.print("¿Cuántas notas tiene " + nombre + "? ");
            int numNotas = sc.nextInt();
            
            ArrayList<Double> notas = new ArrayList<>();

            for (int j = 0; j < numNotas; j++) {
                System.out.print("Introduce la nota " + (j + 1) + ": ");
                notas.add(sc.nextDouble());
            }

            double sumaNotas = 0;
            for (Double nota : notas) {
                sumaNotas += nota;
            }
            double media = sumaNotas / notas.size();
            notasMedias.put(nombre, media);
        }

        // Mostrar las medias de lasn otas
        System.out.println("\nNotas medias:");
        for (Map.Entry<String, Double> entry : notasMedias.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        sc.close();
    }
}
