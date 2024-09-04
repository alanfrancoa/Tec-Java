package utils;

/**
 * Clase que alterna entre dos cadenas de texto (Strings).
 * Permite almacenar dos valores y alternar entre ellos cuando se solicita el valor activo.
 * La lógica se implementa de manera que podría ser generalizada para otros tipos de objetos.
 */
public class AlternadorStrings {
    
    // Almacena el valor principal (primario)
    private String primario;
    
    // Almacena el valor secundario
    private String secundario;
    
    // Indica si actualmente se está utilizando el valor primario
    private boolean usarPrimario;
    
    /**
     * Constructor que inicializa el alternador, empezando con el valor primario.
     */
    public AlternadorStrings() {
        this.usarPrimario = true;
    }
    
    /**
     * Devuelve el valor primario.
     * 
     * @return El valor de la cadena primaria.
     */
    public String getPrimario() {
        return primario;
    }
    
    /**
     * Establece el valor primario.
     * 
     * @param primario El valor que se desea establecer como primario.
     */
    public void setPrimario(String primario) {
        this.primario = primario;
    }
    
    /**
     * Devuelve el valor secundario.
     * 
     * @return El valor de la cadena secundaria.
     */
    public String getSecundario() {
        return secundario;
    }
    
    /**
     * Establece el valor secundario.
     * 
     * @param secundario El valor que se desea establecer como secundario.
     */
    public void setSecundario(String secundario) {
        this.secundario = secundario;
    }
    
    /**
     * Devuelve el valor actualmente activo, que puede ser el primario o el secundario,
     * dependiendo del estado de la variable usarPrimario.
     * 
     * @return La cadena activa en este momento.
     */
    public String getActivo() {
        return usarPrimario ? primario : secundario;
    }
    
    /**
     * Alterna entre el valor primario y el secundario.
     * Cambia el estado de la variable usarPrimario.
     */
    public void alternar() {
        this.usarPrimario = !this.usarPrimario;
    }
    
    // Este código utiliza una lógica específica para Strings,
    // pero la estructura es general y podría aplicarse a otros tipos de datos.
    // En ejemplos futuros, esta clase se podría modificar para usar Generics,
    // lo que evitaría la necesidad de restringirla solo a Strings.
}
