package models;

import java.util.Scanner;

/**
 * Clase que extiende Comunicador y permite enviar y recibir mensajes,
 * donde los mensajes enviados se transforman a may�sculas.
 */
public class ComunicadorEnMayusculas extends Comunicador {
    
    /**
     * Scanner que se utiliza para leer la entrada del usuario desde la consola.
     */
    private Scanner sc;
    
    /**
     * Constructor que inicializa el Scanner para capturar la entrada del usuario.
     */
    public ComunicadorEnMayusculas() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Implementaci�n del m�todo abstracto enviar de la clase Comunicador.
     * Imprime en pantalla el mensaje recibido, transformado a may�sculas.
     * 
     * @param mje El mensaje que se desea enviar (imprimir en la consola en may�sculas).
     */
    @Override
    public void enviar(String mje) {
        System.out.println(mje.toUpperCase());        
    }

    /**
     * Implementaci�n del m�todo abstracto recibir de la clase Comunicador.
     * Lee y devuelve la siguiente entrada del usuario desde la consola.
     * 
     * @return La entrada del usuario capturada por el Scanner.
     */
    @Override
    public String recibir() {
        return sc.next();
    }

    /**
     * M�todo para cerrar el Scanner y liberar los recursos.
     * Debe llamarse cuando ya no se necesite capturar m�s entradas.
     */
    public void cerrar() {
        if (sc != null) {
            sc.close();
        }
    }
}
