package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparator.ComparatorPerroNombre;
import models.Perro;

public class Main4 {

    public static void main(String[] args) {
        // Crear instancias de Perro con nombre y peso
        Perro perrin1 = new Perro("Chicho", 13);
        Perro perrin2 = new Perro("Chita", 24);
        Perro perrin3 = new Perro("Perla", 3);
        Perro perrin4 = new Perro("Theda", 28);
        
        // Lista para almacenar los perros
        List<Perro> perros = new ArrayList<Perro>();
        
        // Agregar perros a la lista
        perros.add(perrin1);
        perros.add(perrin2);
        perros.add(perrin3);
        perros.add(perrin4);
        
        // Encontrar el perro con el mayor peso usando la "comparación natural"
        // "Comparación natural" se refiere a la comparación implementada en el método compareTo de la clase Perro
        Perro perroMax = Collections.max(perros);
        // Encontrar el perro con el menor peso usando la misma "comparación natural"
        Perro perroMin = Collections.min(perros);
        
        // Imprimir el perro más gordito y el más flaquito
        System.out.println("El perro más gordito es: " + perroMax);
        System.out.println("El perro más flaquito es: " + perroMin);
        
        // Crear una instancia de ComparatorPerroNombre para comparar perros por su nombre
        ComparatorPerroNombre compi = new ComparatorPerroNombre();
        
        // Ordenar la lista de perros por nombre en orden alfabético
        // La comparación se realiza usando el Comparator definido en ComparatorPerroNombre
        perros.sort(compi);
        // Nota: este método altera la lista original de forma irreversible.
        // Si se pasara 'null' como argumento, la lista se ordenaría usando la "comparación natural", en este caso, seria el peso de los perros, definido en la clase Perro. 
        
        // Imprimir la lista de perros ordenada por nombre
        for (Perro perro : perros) {
            System.out.println(perro);
        }

    }

}

