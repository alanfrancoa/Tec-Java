// Paquete que contiene los modelos (clases)
package models;

import interfaces.Pesable;

// Clase BotellaDeAgua que implementa la interfaz Pesable
public class BotellaDeAgua implements Pesable {
    
    // Atributo que almacena la cantidad de agua en litros
    private double cantLitros;
    
    // Constructor que inicializa la cantidad de litros en la botella
    public BotellaDeAgua(double cantLitros) {
        super(); // Llama al constructor de la clase base (en este caso, Object)
        this.cantLitros = cantLitros;
    }

    // Método getter para obtener la cantidad de litros en la botella
    public double getCantLitros() {
        return cantLitros;
    }

    // Método setter para establecer la cantidad de litros en la botella
    public void setCantLitros(double cantLitros) {
        this.cantLitros = cantLitros;
    }

    // Implementación del método de la interfaz Pesable
    // Este método devuelve el peso de la botella en gramos, 
    // asumiendo que 1 litro de agua pesa 1000 gramos y la botella vacía pesa 20 gramos
    @Override
    public double GetPesoEnGramos() {
        return this.cantLitros * 1000 + 20;
    }

	@Override
	public String toString() {
		return "BotellaDeAgua [cantLitros=" + cantLitros + "]";
	}
    
}
