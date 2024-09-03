// Paquete que contiene clases utilitarias
package utils;

import interfaces.Pesable;

// Clase Balanza que contiene métodos para comparar objetos que implementan la interfaz Pesable
public class Balanza {
    
    // Método que recibe dos objetos que implementan la interfaz Pesable y devuelve el más pesado
    public Pesable getMasPesado(Pesable pes1, Pesable pes2) {
        // Compara los pesos en gramos de los dos objetos usando un operador ternario.
        // Si el peso del primer objeto (pes1) es mayor que el del segundo (pes2), 
        // se devuelve pes1; de lo contrario, se devuelve pes2.
        return pes1.GetPesoEnGramos() > pes2.GetPesoEnGramos() ? pes1 : pes2;
    }
}
