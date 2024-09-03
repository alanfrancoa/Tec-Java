// Paquete que contiene las interfaces
package interfaces;

// Definición de la interfaz Pesable
public interface Pesable {
    
    // Método abstracto que debe ser implementado por las clases que utilizan esta interfaz.
    // Devuelve el peso en gramos.
    public double GetPesoEnGramos();
    
    // Método predeterminado que calcula el peso en kilogramos basado en el peso en gramos.
    // Este método tiene una implementación y no es obligatorio sobrescribirlo.
    public default double GetPesoEnKg() {
        return this.GetPesoEnGramos() / 1000;
    }
    
    // Método predeterminado que calcula el peso en miligramos basado en el peso en gramos.
    // También tiene una implementación predeterminada.
    public default double GetPesoEnMg() {
        return this.GetPesoEnGramos() * 1000;
    }
}
