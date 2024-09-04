// Paquete que contiene la clase principal para el segundo main
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        // Creación de un ArrayList sin especificar el tipo de objetos que va a contener.
        // Esto significa que el ArrayList puede almacenar cualquier tipo de objeto, 
        // ya que por defecto es un ArrayList de tipo Object.
        // Si bien esto es posible, no es una buena práctica en código moderno.
        ArrayList listaDelCaos = new ArrayList();
        
        // Se agrega una cadena de texto al ArrayList.
        listaDelCaos.add("Buenas");
        
        // Se crea un objeto Scanner para leer entrada del usuario y se agrega al ArrayList.
        Scanner sc = new Scanner(System.in);
        listaDelCaos.add(sc);
        
        // Se obtiene el segundo objeto almacenado en el ArrayList (el Scanner).
        // Dado que el ArrayList es de tipo Object, el tipo de retorno es Object.
        // Esto es un ejemplo de código que puede llevar a confusión o errores,
        // especialmente en proyectos grandes o en código legado.
        Object misterio = listaDelCaos.get(1);
        
        // Se obtiene el primer objeto almacenado en el ArrayList (la cadena "Buenas").
        // Aquí es necesario hacer un casting a String, ya que el ArrayList almacena objetos como Object.
        // El uso de casting no es una buena práctica, pero es común en situaciones donde se trabaja 
        // con colecciones sin tipos genéricos (por ejemplo, en código legado).
        String a1 = (String) listaDelCaos.get(0);
    }
}
