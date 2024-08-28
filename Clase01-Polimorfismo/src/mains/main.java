package mains;


import utils.ComunicadorEnMayusculas;


/**
 * Clase principal que demuestra el uso de la clase ComunicadorPorConsola.
 * Este programa interactúa con el usuario a través de la consola.
 */
public class main {

    /**
     * Método principal que se ejecuta al iniciar el programa.
     * Crea una instancia de ComunicadorPorConsola, envía un saludo y
     * espera una respuesta del usuario, reaccionando de acuerdo a la longitud
     * de la respuesta.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Se crea una instancia de Comunicador utilizando ComunicadorPorConsola.
        ComunicadorEnMayusculas comunicador = new ComunicadorEnMayusculas();
        
        // Envía un saludo por la consola.
        comunicador.saludar();
        
        // Envía otro mensaje por la consola.
        comunicador.enviar("¿Cómo va?");
        
        // Recibe la respuesta del usuario desde la consola.
        String respuesta = comunicador.recibir();
        
        // Verifica la longitud de la respuesta y envía un mensaje en consecuencia.
        if (respuesta.length() > 15) {
            comunicador.enviar("Mucho texto mamita...");
        } else {
            comunicador.enviar("Me alegro que estés " + respuesta);
        }

        // Cierra el Scanner al final del programa para liberar los recursos.
        comunicador.cerrar();
    }
}
