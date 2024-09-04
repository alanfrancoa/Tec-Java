package main;

import models.Comunicador;
import models.ComunicadorEnMayusculas;
import models.ComunicadorEnMinusculas;
import utils.AlternadorMagico;

/**
 * Clase principal que demuestra el uso de la clase genérica AlternadorMagico
 * con la clase abstracta Comunicador y sus implementaciones en mayúsculas y minúsculas.
 * Este ejemplo muestra cómo alternar entre diferentes comportamientos de comunicación
 * según la entrada del usuario.
 */
public class Main3 {

    public static void main(String[] args) {
        // Creación de una instancia de AlternadorMagico que trabaja con objetos de tipo Comunicador.
        AlternadorMagico<Comunicador> alternador = new AlternadorMagico<Comunicador>();
        
        // Configuración del comunicador primario que transforma mensajes a mayúsculas.
        alternador.setPrimario(new ComunicadorEnMayusculas());
        
        // Configuración del comunicador secundario que transforma mensajes a minúsculas.
        alternador.setSecundario(new ComunicadorEnMinusculas());
        
        // Bucle infinito que permite la interacción continua con el usuario.
        while(true) {
            // Envío del mensaje "Hola!" usando el comunicador activo.
            alternador.getActivo().enviar("Hola!");
            
            // Recepción de la entrada del usuario para decidir la acción a tomar.
            String op = alternador.getActivo().recibir();
            
            // Si el usuario ingresa "1", se envía otro mensaje "Que tal?" usando el comunicador activo.
            if (op.equals("1")) {
                alternador.getActivo().enviar("Que tal?");
            } 
            // Si el usuario ingresa "2", se alterna entre el comunicador primario y el secundario.
            else if (op.equals("2")) {
                alternador.alternar();
            } 
            // Si la entrada del usuario no es "1" ni "2", se notifica que la opción es incorrecta.
            else {
                System.out.println("Opcion incorrecta");
            }
        }
    }
}
