package utils;

import java.util.Scanner;

/**
 * Clase que extiende Comunicador y permite enviar y recibir mensajes 
 * a trav�s de la consola.
 */
public class ComunicadorPorConsola extends Comunicador {
    
    /**
     * Scanner que se utiliza para leer la entrada del usuario desde la consola.
     */
    private Scanner sc;
    
    /**
     * Constructor que inicializa el Scanner para capturar la entrada del usuario.
     */
    public ComunicadorPorConsola() {
        // Cuando instanciamos la clase se crea un nuevo Scanner. 
        this.sc = new Scanner(System.in);
    }
    
    /**
     * Implementaci�n del m�todo abstracto enviar de la clase Comunicador.
     * Imprime en pantalla el mensaje recibido como argumento.
     * 
     * @param mje El mensaje que se desea enviar (imprimir en la consola).
     */
    @Override
    public void enviar(String mje) {
        System.out.println(mje);        
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

