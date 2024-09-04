// Paquete que contiene la clase principal para el segundo main
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        // Creaci�n de un ArrayList sin especificar el tipo de objetos que va a contener.
        // Esto significa que el ArrayList puede almacenar cualquier tipo de objeto, 
        // ya que por defecto es un ArrayList de tipo Object.
        // Si bien esto es posible, no es una buena pr�ctica en c�digo moderno.
        ArrayList listaDelCaos = new ArrayList();
        
        // Se agrega una cadena de texto al ArrayList.
        listaDelCaos.add("Buenas");
        
        // Se crea un objeto Scanner para leer entrada del usuario y se agrega al ArrayList.
        Scanner sc = new Scanner(System.in);
        listaDelCaos.add(sc);
        
        // Se obtiene el segundo objeto almacenado en el ArrayList (el Scanner).
        // Dado que el ArrayList es de tipo Object, el tipo de retorno es Object.
        // Esto es un ejemplo de c�digo que puede llevar a confusi�n o errores,
        // especialmente en proyectos grandes o en c�digo legado.
        Object misterio = listaDelCaos.get(1);
        
        // Se obtiene el primer objeto almacenado en el ArrayList (la cadena "Buenas").
        // Aqu� es necesario hacer un casting a String, ya que el ArrayList almacena objetos como Object.
        // El uso de casting no es una buena pr�ctica, pero es com�n en situaciones donde se trabaja 
        // con colecciones sin tipos gen�ricos (por ejemplo, en c�digo legado).
        String a1 = (String) listaDelCaos.get(0);
    }
}
