package main;

import models.Perro;
import utils.AlternadorMagico;

/**
 * Clase principal que demuestra el uso de la clase gen�rica AlternadorMagico.
 * En este ejemplo, se configuran diferentes tipos de objetos y se alterna entre ellos,
 * mostrando c�mo funciona la l�gica de alternancia con tipos gen�ricos.
 */
public class Main2 {

    public static void main(String[] args) {
        // Creaci�n de una instancia de AlternadorMagico sin especificar tipo, lo cual deber�a generar un warning.
        AlternadorMagico alternador;
        alternador = new AlternadorMagico();
        
        // Se establece el objeto secundario como el mismo alternador.
        // Esto es t�cnicamente v�lido, pero puede llevar a comportamientos inesperados.
        alternador.setSecundario(alternador);
        
        // Genera un n�mero aleatorio entre 0 y 9.
        int numero = (int) (Math.random() * 10);
        
        // Bucle que imprime "F en el chat" el n�mero aleatorio de veces.
        for(int i = 0; i < numero; i++) {
            System.out.println("F en el chat");
        }
        
        // Alterna el valor activo de primario a secundario.
        alternador.alternar();
        
        // Aqu� se genera un error si intentamos obtener el valor activo despu�s de alternar,
        // ya que el valor secundario es el mismo objeto `AlternadorMagico`, no un `Perro`.
        // Esto causar� un ClassCastException cuando intentemos hacer el casting a `Perro`.
        // AlternadorMagico espera un tipo espec�fico de objeto, pero al no haber especificado
        // el tipo en la creaci�n, se permite almacenar cualquier tipo de objeto.
        // Sin embargo, al alternar, intentamos obtener un `Perro`, pero el valor secundario
        // es un `AlternadorMagico`, lo que provoca el error.
        
        alternador.setPrimario(new Perro("Vicentin", 23));
        
        // Este casting provocar� un ClassCastException si el valor activo es un AlternadorMagico y no un Perro.
        Perro p = (Perro) alternador.getActivo();
        
        // Imprime la representaci�n del objeto Perro en la consola.
        System.out.println(p);
    }
}
