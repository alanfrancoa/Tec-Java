// Paquete que contiene los modelos (clases)
package models;

import interfaces.Pesable;

// Clase Perro que implementa la interfaz Pesable
public class Perro implements Pesable {
    
    // Atributo para almacenar el nombre del perro
    private String nombre;
    
    // Atributo para almacenar el peso del perro en kilogramos
    private double pesoEnKg;
    
    // Constructor que inicializa el nombre y el peso del perro
    public Perro(String nombre, double pesoEnKg) {
        super(); // Llama al constructor de la clase base (en este caso, Object)
        this.nombre = nombre;
        this.pesoEnKg = pesoEnKg;
    }

    // Método getter para obtener el nombre del perro
    public String getNombre() {
        return nombre;
    }

    // Método setter para establecer el nombre del perro
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener el peso del perro en kilogramos
    public double getPesoEnKg() {
        return pesoEnKg;
    }

    // Método setter para establecer el peso del perro en kilogramos
    public void setPesoEnKg(double pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }

    // Implementación del método de la interfaz Pesable
    // Este método devuelve el peso del perro en gramos
    @Override
    public double GetPesoEnGramos() {
        return this.pesoEnKg * 1000;
    }

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", pesoEnKg=" + pesoEnKg + "]";
	}
    
    
}
