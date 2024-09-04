package main;

import utils.AlternadorStrings;

/**
 * Clase principal que demuestra el uso de la clase AlternadorStrings.
 * En este ejemplo, se configuran dos valores (Bien y Mal) y se alterna entre ellos.
 */
public class Main1 {

    public static void main(String[] args) {
        // Creación de una instancia de AlternadorStrings
        AlternadorStrings alternador;
        alternador = new AlternadorStrings();
        
        // Configuración de los valores primario y secundario
        alternador.setPrimario("Bien");
        alternador.setSecundario("Mal");
        
        // Alternar el valor activo de primario a secundario
        alternador.alternar();
        
        // Obtener y almacenar el valor actualmente activo
        String valor = alternador.getActivo();
        
        // Imprimir el valor activo en la consola
        System.out.println(valor);
        
        // Imprimir un mensaje adicional para verificar que el programa sigue funcionando
        System.out.println("Hola!");
    }
}
