package containers;

import java.util.Optional;

public class PalabrasContainer {
	
	// Este método devuelve una cadena de texto (String) o null en función de un número aleatorio.
	public String getPalabra() {
		double num = Math.random(); // Genera un número aleatorio entre 0 y 1.
		
		// Si el número es mayor a 0.5, devuelve la cadena "Hola".
		if (num > 0.5) {
			return "Hola";
		}
		// Si el número es menor o igual a 0.5, devuelve null.
		return null;
	}
	
	// Este método devuelve un Optional que podría contener una palabra o estar vacío.
	public Optional<String> getPalabraOpcional (){
		double num = Math.random(); // Genera un número aleatorio entre 0 y 1.
		
		// Si el número es mayor a 0.5, devuelve un Optional que contiene la palabra "hola".
		if (num > 0.5) {
			return Optional.of("hola"); // of() se usa cuando estamos seguros de que el valor no es nulo.
		}
		// Si el número es menor o igual a 0.5, devuelve un Optional vacío.
		return Optional.empty(); // empty() crea un Optional vacío, sin ningún valor.
	}
}
