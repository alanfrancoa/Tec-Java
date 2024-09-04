package main;

import models.Comunicador;
import models.ComunicadorEnMayusculas;
import models.ComunicadorEnMinusculas;
import utils.AlternadorMagico;

/**
 * Clase principal que demuestra el uso de la clase gen�rica AlternadorMagico
 * con la clase abstracta Comunicador y sus implementaciones en may�sculas y min�sculas.
 * Este ejemplo muestra c�mo alternar entre diferentes comportamientos de comunicaci�n
 * seg�n la entrada del usuario.
 */
public class Main3 {

    public static void main(String[] args) {
        // Creaci�n de una instancia de AlternadorMagico que trabaja con objetos de tipo Comunicador.
        AlternadorMagico<Comunicador> alternador = new AlternadorMagico<Comunicador>();
        
        // Configuraci�n del comunicador primario que transforma mensajes a may�sculas.
        alternador.setPrimario(new ComunicadorEnMayusculas());
        
        // Configuraci�n del comunicador secundario que transforma mensajes a min�sculas.
        alternador.setSecundario(new ComunicadorEnMinusculas());
        
        // Bucle infinito que permite la interacci�n continua con el usuario.
        while(true) {
            // Env�o del mensaje "Hola!" usando el comunicador activo.
            alternador.getActivo().enviar("Hola!");
            
            // Recepci�n de la entrada del usuario para decidir la acci�n a tomar.
            String op = alternador.getActivo().recibir();
            
            // Si el usuario ingresa "1", se env�a otro mensaje "Que tal?" usando el comunicador activo.
            if (op.equals("1")) {
                alternador.getActivo().enviar("Que tal?");
            } 
            // Si el usuario ingresa "2", se alterna entre el comunicador primario y el secundario.
            else if (op.equals("2")) {
                alternador.alternar();
            } 
            // Si la entrada del usuario no es "1" ni "2", se notifica que la opci�n es incorrecta.
            else {
                System.out.println("Opcion incorrecta");
            }
        }
    }
}
