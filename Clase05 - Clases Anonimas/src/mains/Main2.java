package mains;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main2 {

	public static void main(String[] args) {
		//INTERFACES FUNCIONALES
		//COMPARATOR, PREDICATE, CONSUMER, FUNCTION.
		
		// Creacion de lista y se agregan elementos con List.of()
		List<String> palabras1 = List.of("Hola", "Jajaja", "Chicho", "Ay", "Cocodrilo", "Huevo Acuña", "Messi"); // Lista original
																															
		// Creacion de una lista modificable, donde se aplicaran las distintas interfaces.
		List<String> palabras = new ArrayList<String>(palabras1);
		
		//----------------------PREDICATE----------------------//
		//Metodo: Test. Recibe un generico, devuelve un booleano.
		
		//Creamos la clase anonima con la interfaz predicate.
		Predicate<String> prediMayorACuatro = new Predicate<String>(){

			@Override
			public boolean test(String t) {
				//la condicion evalua si la palabra es mayor a 4 caracteres
				return t.length() > 4;
			}
		};
		//Utilizamos la interfaz en el metodo RemoveIf
		
		//palabras.removeIf(prediMayorACuatro);
		System.out.println("---------------------Predicate: Mayor a 4---------------------");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
		
		//----------------------FUNCTION----------------------//
		//Metodo: Apply"Funcion Comodin". Recibe un generico de tipo T, devuelve un generico de tipo R.
		
		//Creamos la clase anonima para la interfaz Function
		Function<String, Integer> cuantasLetras = new Function<String, Integer>(){

			@Override
			public Integer apply(String t) {
				//Devuelve Cantidad de letras que tiene el String.
				return t.length();
			}
			
		};
		//Utilizamos el metodo implementado de la clace intefaz
		
		System.out.println("---------------------Function: Cantidad de letras---------------------");
		for (String palabra : palabras) {
		System.out.println(palabra + " | Cantidad de letras: " + cuantasLetras.apply(palabra));
		}
		
		//----------------------CONSUMER----------------------//
		//Metodo: Accept. Recibe un generico de tipo T, No retorna nada.
				
		//Creamos la clase anonima, para la interfaz Consumer.
		Consumer<String> mostrar = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("Palabra: " + t);				
				}
			};
			
			System.out.println("---------------------Consumer: Mostrar palabras---------------------");
			palabras.forEach(mostrar);
	}
}
