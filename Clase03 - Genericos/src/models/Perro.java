// Paquete que contiene los modelos (clases)
package models;

/**
 * Clase que representa un Perro, implementa la interfaz Comparable para permitir la comparación de objetos Perro
 * según su peso en gramos.
 */
public class Perro implements Comparable<Perro> {
    
    // Atributo para almacenar el nombre del perro
    private String nombre;
    
    // Atributo para almacenar el peso del perro en kilogramos
    private double pesoEnKg;
    
    /**
     * Constructor que inicializa el nombre y el peso del perro.
     * 
     * @param nombre El nombre del perro.
     * @param pesoEnKg El peso del perro en kilogramos.
     */
    public Perro(String nombre, double pesoEnKg) {
        super(); // Llama al constructor de la clase base (en este caso, Object)
        this.nombre = nombre;
        this.pesoEnKg = pesoEnKg;
    }

    /**
     * Método getter para obtener el nombre del perro.
     * 
     * @return El nombre del perro.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre del perro.
     * 
     * @param nombre El nuevo nombre del perro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el peso del perro en kilogramos.
     * 
     * @return El peso del perro en kilogramos.
     */
    public double getPesoEnKg() {
        return pesoEnKg;
    }

    /**
     * Método setter para establecer el peso del perro en kilogramos.
     * 
     * @param pesoEnKg El nuevo peso del perro en kilogramos.
     */
    public void setPesoEnKg(double pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }

    /**
     * Método para obtener el peso del perro en gramos.
     * 
     * @return El peso del perro en gramos.
     */
    public double GetPesoEnGramos() {
        return this.pesoEnKg * 1000;
    }

    /**
     * Sobrescribe el método toString para proporcionar una representación 
     * en forma de cadena del objeto Perro.
     * 
     * @return Una cadena que representa al perro, mostrando su nombre y peso en kg.
     */
    @Override
    public String toString() {
        return "Perro [nombre=" + nombre + ", pesoEnKg=" + pesoEnKg + "]";
    }

    /**
     * Implementación del método compareTo de la interfaz Comparable.
     * Permite comparar dos objetos Perro según su peso en gramos.
     * 
     * @param o El objeto Perro con el cual se va a comparar.
     * @return Un valor positivo si este perro es más pesado, negativo si es más liviano,
     *         y 0 si ambos perros tienen el mismo peso.
     */
    @Override
    public int compareTo(Perro o) {
        // si compareTo es mayor a 0, this > o
        // si compareTo es menor a 0, this < o
        // si compareTo es igual a 0, ambos son iguales en peso

        int resultado = 0;
        if(this.GetPesoEnGramos() > o.GetPesoEnGramos()) {
            resultado = 1;
        } else if (this.GetPesoEnGramos() < o.GetPesoEnGramos()) {
            resultado = -1;
        }
        return resultado;
    }
}

