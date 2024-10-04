package mains;

import java.util.Optional; // Importamos la clase Optional para manejar valores que pueden ser nulos
import java.util.function.Consumer; // Importamos la interfaz Consumer para manejar operaciones sobre objetos

import contenedores.PalabrasContainer; // Importamos la clase PalabrasContainer que contiene métodos para obtener palabras

public class Main1 {

	public static void main(String[] args) {
		// Creamos una instancia de la clase PalabrasContainer
		PalabrasContainer cont = new PalabrasContainer();
		
		// Obtenemos una palabra desde el contenedor (puede ser nula)
		String palabra = cont.getPalabra();
		// A simple vista no podríamos saber si esta palabra es nula, lo cual podría causar un problema al intentar, por ejemplo, convertirla a mayúsculas.

		// Creamos un Optional que puede contener la palabra o estar vacío (si la palabra es null)
		Optional<String> opcionalPalabra = Optional.ofNullable(palabra);
		// El método ofNullable crea un Optional que podría contener un valor nulo (null).

		// Aquí estamos intentando obtener el valor de opcionalPalabra
		// Si está vacío y tratamos de usar .get(), nos lanzaría una excepción (NoSuchElementException), por eso la línea está comentada.
		// System.out.println(opcionalPalabra.get());

		// En su lugar, usamos el método orElse() que imprime "No hay valores" si opcionalPalabra está vacío (es null).
		System.out.println(opcionalPalabra.orElse("No hay valores"));
		// orElse devuelve un valor por defecto cuando no hay un valor presente (null).

		// Si opcionalPalabra tiene un valor, lo convertimos a mayúsculas. Si no, se establece como null.
		String pal = opcionalPalabra.map(s -> s.toUpperCase()).orElse(null);
		// map transforma el valor dentro del Optional si está presente, en este caso lo pasamos a mayúsculas.

		// Obtenemos un Optional de otra palabra desde cont y aplicamos la conversión a mayúsculas si tiene valor.
		Optional<String> miPalabra = Optional.ofNullable(cont.getPalabraOpcional().map(s -> s.toUpperCase()).orElse(""));
		// orElse("") asegura que si no hay valor, el resultado será una cadena vacía.

		// Mostramos el Optional. Si no tiene valor, se imprime Optional.empty.
		System.out.println(miPalabra);

		// Creamos un Consumer que recibe una cadena (String) y la imprime
		Consumer<String> mostrar = (s) -> System.out.println(s);

		// Creamos un Runnable que imprime "No existe." cuando se ejecuta.
		Runnable noEx = () -> System.out.println("No existe.");
		
		// Intentamos obtener otro valor opcional de cont y lo mostramos si está presente, o imprimimos "No existe." si no está.
		cont.getPalabraOpcional().ifPresentOrElse(mostrar, noEx);
		// ifPresentOrElse ejecuta mostrar si hay un valor, o noEx si no lo hay.
	}
}
