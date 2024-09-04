package utils;

/**
 * Clase gen�rica que alterna entre dos objetos del mismo tipo.
 * La clase se define con un par�metro de tipo gen�rico <T>, lo que permite
 * que la clase funcione con cualquier tipo de objeto que se decida en tiempo de instanciaci�n.
 */
public class AlternadorMagico <T> {
    
    // Almacena el valor primario de tipo gen�rico T.
    private T primario;
    
    // Almacena el valor secundario de tipo gen�rico T.
    private T secundario;
    
    // Indica si actualmente se est� utilizando el valor primario.
    private boolean usarPrimario;
    
    /**
     * Constructor que inicializa el alternador, empezando con el valor primario.
     */
    public AlternadorMagico() {
        this.usarPrimario = true;
    }

    /**
     * Devuelve el valor primario.
     * 
     * @return El valor primario de tipo T.
     */
    public T getPrimario() {
        return primario;
    }

    /**
     * Establece el valor primario.
     * 
     * @param primario El valor que se desea establecer como primario de tipo T.
     */
    public void setPrimario(T primario) {
        this.primario = primario;
    }

    /**
     * Devuelve el valor secundario.
     * 
     * @return El valor secundario de tipo T.
     */
    public T getSecundario() {
        return secundario;
    }

    /**
     * Establece el valor secundario.
     * 
     * @param secundario El valor que se desea establecer como secundario de tipo T.
     */
    public void setSecundario(T secundario) {
        this.secundario = secundario;
    }
    
    /**
     * Devuelve el valor actualmente activo, que puede ser el primario o el secundario,
     * dependiendo del estado de la variable usarPrimario.
     * 
     * @return El valor activo de tipo T.
     */
    public T getActivo() {
        return usarPrimario ? primario : secundario;
    }
    
    /**
     * Alterna entre el valor primario y el secundario.
     * Cambia el estado de la variable usarPrimario.
     */
    public void alternar() {
        this.usarPrimario = !this.usarPrimario;
    }
    
    // Este c�digo es gen�rico, lo que significa que puede manejar diferentes tipos de datos
    // seg�n se especifique en el momento de la instanciaci�n de la clase.
    // Esto proporciona flexibilidad y seguridad de tipo, evitando errores comunes
    // asociados con el uso de clases que no emplean generics.
}
