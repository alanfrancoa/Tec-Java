package main;

import models.Perro;
import utils.AlternadorMagico;

/**
 * Clase principal que demuestra el uso de la clase genérica AlternadorMagico.
 * En este ejemplo, se configuran diferentes tipos de objetos y se alterna entre ellos,
 * mostrando cómo funciona la lógica de alternancia con tipos genéricos.
 */
public class Main2 {

    public static void main(String[] args) {
        // Creación de una instancia de AlternadorMagico sin especificar tipo, lo cual debería generar un warning.
        AlternadorMagico alternador;
        alternador = new AlternadorMagico();
        
        // Se establece el objeto secundario como el mismo alternador.
        // Esto es técnicamente válido, pero puede llevar a comportamientos inesperados.
        alternador.setSecundario(alternador);
        
        // Genera un número aleatorio entre 0 y 9.
        int numero = (int) (Math.random() * 10);
        
        // Bucle que imprime "F en el chat" el número aleatorio de veces.
        for(int i = 0; i < numero; i++) {
            System.out.println("F en el chat");
        }
        
        // Alterna el valor activo de primario a secundario.
        alternador.alternar();
        
        // Aquí se genera un error si intentamos obtener el valor activo después de alternar,
        // ya que el valor secundario es el mismo objeto `AlternadorMagico`, no un `Perro`.
        // Esto causará un ClassCastException cuando intentemos hacer el casting a `Perro`.
        // AlternadorMagico espera un tipo específico de objeto, pero al no haber especificado
        // el tipo en la creación, se permite almacenar cualquier tipo de objeto.
        // Sin embargo, al alternar, intentamos obtener un `Perro`, pero el valor secundario
        // es un `AlternadorMagico`, lo que provoca el error.
        
        alternador.setPrimario(new Perro("Vicentin", 23));
        
        // Este casting provocará un ClassCastException si el valor activo es un AlternadorMagico y no un Perro.
        Perro p = (Perro) alternador.getActivo();
        
        // Imprime la representación del objeto Perro en la consola.
        System.out.println(p);
    }
}
