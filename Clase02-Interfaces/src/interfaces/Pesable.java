// Paquete que contiene las interfaces
package interfaces;

// Definici�n de la interfaz Pesable
public interface Pesable {
    
    // M�todo abstracto que debe ser implementado por las clases que utilizan esta interfaz.
    // Devuelve el peso en gramos.
    public double GetPesoEnGramos();
    
    // M�todo predeterminado que calcula el peso en kilogramos basado en el peso en gramos.
    // Este m�todo tiene una implementaci�n y no es obligatorio sobrescribirlo.
    public default double GetPesoEnKg() {
        return this.GetPesoEnGramos() / 1000;
    }
    
    // M�todo predeterminado que calcula el peso en miligramos basado en el peso en gramos.
    // Tambi�n tiene una implementaci�n predeterminada.
    public default double GetPesoEnMg() {
        return this.GetPesoEnGramos() * 1000;
    }
}
