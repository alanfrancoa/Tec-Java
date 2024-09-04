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
        
        // Encontrar el perro con el mayor peso usando la "comparaci�n natural"
        // "Comparaci�n natural" se refiere a la comparaci�n implementada en el m�todo compareTo de la clase Perro
        Perro perroMax = Collections.max(perros);
        // Encontrar el perro con el menor peso usando la misma "comparaci�n natural"
        Perro perroMin = Collections.min(perros);
        
        // Imprimir el perro m�s gordito y el m�s flaquito
        System.out.println("El perro m�s gordito es: " + perroMax);
        System.out.println("El perro m�s flaquito es: " + perroMin);
        
        // Crear una instancia de ComparatorPerroNombre para comparar perros por su nombre
        ComparatorPerroNombre compi = new ComparatorPerroNombre();
        
        // Ordenar la lista de perros por nombre en orden alfab�tico
        // La comparaci�n se realiza usando el Comparator definido en ComparatorPerroNombre
        perros.sort(compi);
        // Nota: este m�todo altera la lista original de forma irreversible.
        // Si se pasara 'null' como argumento, la lista se ordenar�a usando la "comparaci�n natural", en este caso, seria el peso de los perros, definido en la clase Perro. 
        
        // Imprimir la lista de perros ordenada por nombre
        for (Perro perro : perros) {
            System.out.println(perro);
        }

    }

}

