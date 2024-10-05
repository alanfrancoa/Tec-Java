package mains;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import models.BotellaDeAgua;

public class Main2 {
	// OBJETO INDEFINIDO
	public static void main(String[] args) {
		// Creamos una instancia de BotellaDeAgua llamada botellin, con un peso inicial de 2
		BotellaDeAgua botellin = new BotellaDeAgua(2);
		
		/*
		 * Supplier<Double> bgp = botellin::getPeso;
		 * 
		 * Este es un ejemplo de un método con "objeto definido".
		 * 
		 * - Aquí estamos refiriéndonos a un método de una instancia específica: botellin.
		 * - La referencia es directa a este objeto, por lo tanto, 'this' está definido y no varía.
		 * - El método 'getPeso' pertenece exclusivamente a esta instancia (botellin).
		 * - En este caso usamos `Supplier`, que no necesita parámetros, porque el objeto ya está definido.
		 * 
		 * -> OBJETO DEFINIDO: 'botellin' es la instancia y su método 'getPeso' está ligado a él.
		 */
		Supplier<Double> bgp = botellin::getCapacidad; 
		
		/*
		 * Function<BotellaDeAgua, Double> gp = BotellaDeAgua::getPeso;
		 * 
		 * Este es un ejemplo de un método con "objeto indefinido".
		 * 
		 * - Aquí no estamos refiriéndonos a una instancia específica, sino que estamos haciendo
		 *   referencia al método 'getPeso' de la clase BotellaDeAgua.
		 * - Esto se conoce como "objeto indefinido" porque el 'this' se pasará dinámicamente 
		 *   en el momento de la ejecución.
		 * - El 'this' en este caso es el primer parámetro de entrada que varía cada vez que
		 *   la función se aplica a diferentes objetos.
		 * - Esta es una `Function` que toma un objeto de tipo BotellaDeAgua como argumento y 
		 *   devuelve su peso.
		 * 
		 * -> OBJETO INDEFINIDO: No hay un objeto fijo, el 'this' será el objeto que se pase
		 *    en el momento de invocar la función.
		 */
		Function<BotellaDeAgua, Double> ge = BotellaDeAgua::getCapacidad;
		
		List<BotellaDeAgua> bot = Stream.generate(BotellaDeAgua::getRandom).limit(5).toList();
		
		bot.stream().map(BotellaDeAgua::getCapacidad).forEach(System.out::println);
		//Si esta en cursiva, es un método estatico. 
		//Si no esta en cursiva, es un método de objeto. 
		//Si no esta en cursiva, y hay un objeto -> método por referencia con objeto definido
		//Sino esta en cursiva, y hay clase -> método por referencia con objeto indefinido
	}
}
