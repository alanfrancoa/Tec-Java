package utils;

/**
 * Clase abstracta que define la estructura básica de un comunicador.
 * Las subclases deben implementar los métodos abstractos para definir 
 * el comportamiento específico de envío y recepción de mensajes.
 */
public abstract class Comunicador {
    
    /**
     * Método abstracto para enviar un mensaje.
     * Las subclases deben implementar este método para definir 
     * cómo se envía un mensaje.
     * 
     * @param mje El mensaje que se desea enviar.
     */
    public abstract void enviar(String mje);
    
    /**
     * Método abstracto para recibir un mensaje.
     * Las subclases deben implementar este método para definir 
     * cómo se recibe un mensaje.
     * 
     * @return El mensaje recibido.
     */
    public abstract String recibir();
    
    /**
     * Método concreto para sumar dos números enteros.
     * 
     * @param a El primer número.
     * @param b El segundo número.
     * @return La suma de los dos números.
     */
    public int sumar(int a, int b) {
        return a + b;
    }
    
    /**
     * Método concreto que envía un saludo.
     * Envía el mensaje "Hola" utilizando el método enviar().
     */
    public void saludar() {
        this.enviar("Hola");    
    }
}
