package mains;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		//CLASES ANONIMAS
		// Creacion de lista y se agregan elementos con List.of()
		List<String> palabras1 = List.of("Hola", "Jajaja", "Chicho", "Ay", "Cocodrilo", "Huevo Acuña", "Messi"); // Lista original
																													
		// Creacion de una lista modificable
		List<String> palabras = new ArrayList<String>(palabras1);

		// Creamos un Comparator que nos compare por longitud de palabra
		Comparator<String> cantLetras = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};

		// Ordenamos la lista por longitud
		palabras.sort(cantLetras);

		System.out.println("---------- Comparator: Cantidad Letras ----------");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}

		// Creamos un comparador pero que su orden este invertido
		Comparator<String> cantLetrasInvertido_1 = cantLetras.reversed();
		
		// Vamos a usar en nuevo criterio
		palabras.sort(cantLetrasInvertido_1);

		System.out.println("---------- Comparator: Cantidad Letras INVERTIDO ----------");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
	}

}
