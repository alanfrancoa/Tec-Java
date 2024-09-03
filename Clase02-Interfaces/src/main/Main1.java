package main;

import interfaces.Pesable;
import models.BotellaDeAgua;
import models.Perro;
import utils.Balanza;

public class Main1 {

    public static void main(String[] args) {
        // Creación de un objeto de tipo Perro que implementa la interfaz Pesable
        Pesable pesable1 = new Perro("Chicho", 25);
        
        // Imprimir el peso del perro en gramos
        System.out.println(pesable1.GetPesoEnGramos());
        
        // Imprimir el peso del perro en miligramos
        System.out.println(pesable1.GetPesoEnMg());
        
        // Creación de un objeto de tipo BotellaDeAgua que implementa la interfaz Pesable
        Pesable pesable2 = new BotellaDeAgua(500);
        
        // Obtener el peso en kilogramos (aunque no lo imprimes)
        pesable1.GetPesoEnKg();
        
        // Creación de un objeto de tipo Balanza para comparar pesos
        Balanza bal = new Balanza();
        
        // Comparar los dos objetos Pesable para determinar cuál es el más pesado
        Pesable masPesado = bal.getMasPesado(pesable1, pesable2);
        
        // Imprimir cuál es el objeto más pesado
        System.out.println("El mas pesado es: " + masPesado.toString());
    }
}
