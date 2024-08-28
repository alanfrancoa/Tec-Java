package utils;

/**
 * Clase abstracta que define la estructura b�sica de un comunicador.
 * Las subclases deben implementar los m�todos abstractos para definir 
 * el comportamiento espec�fico de env�o y recepci�n de mensajes.
 */
public abstract class Comunicador {
    
    /**
     * M�todo abstracto para enviar un mensaje.
     * Las subclases deben implementar este m�todo para definir 
     * c�mo se env�a un mensaje.
     * 
     * @param mje El mensaje que se desea enviar.
     */
    public abstract void enviar(String mje);
    
    /**
     * M�todo abstracto para recibir un mensaje.
     * Las subclases deben implementar este m�todo para definir 
     * c�mo se recibe un mensaje.
     * 
     * @return El mensaje recibido.
     */
    public abstract String recibir();
    
    /**
     * M�todo concreto para sumar dos n�meros enteros.
     * 
     * @param a El primer n�mero.
     * @param b El segundo n�mero.
     * @return La suma de los dos n�meros.
     */
    public int sumar(int a, int b) {
        return a + b;
    }
    
    /**
     * M�todo concreto que env�a un saludo.
     * Env�a el mensaje "Hola" utilizando el m�todo enviar().
     */
    public void saludar() {
        this.enviar("Hola");    
    }
}
