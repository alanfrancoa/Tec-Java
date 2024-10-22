package mains;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import models.Persona;
import models.Rectangulo;

public class Main {

	public static void main(String[] args) {
		// TP nro 4, metodos por referencia con objeto definido e objeto indefinidop
		//Ejemplo de uso, creacion de lista con 50 rectangulkos distintos.
		var listaRectangulos = Stream.generate(Rectangulo::getRandom).limit(50).toList();
		//Hoja 2 parte 1 
		//1) crear una lista de a partir de un stream formado con los dias de la semana:
		var listaDias = Stream.of("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo").toList();
		
		//2) crear una lista con 60 personas aleatorias en una variable llamada ListaPersonas
		var listaPersonas = Stream.generate(Persona::getRandom).limit(60).toList();
		
		//Hoja 2 parte 2
		//1) Mostrar todas las personas
		Consumer<Persona> mostrarPersona = s -> System.out.println(s);
		System.out.println("Lista de personas:");
		listaPersonas.stream().forEach(mostrarPersona);
		
		//2) Mostrar todos los rectangulos
		Consumer<Rectangulo> mostrarRectangulo = s -> System.out.println(s);
		System.out.println("Lista de rectangulos: ");
		listaRectangulos.stream().forEach(mostrarRectangulo);
		
		//3) Duplicar la base de todos los rectangulos
		Consumer<Rectangulo> duplicarBaseR = s -> s.setBase(s.getBase() * 2);
		listaRectangulos.stream().forEach(duplicarBaseR);
		listaRectangulos.forEach(mostrarRectangulo);
		
		//Hoja 3 parte 1
		//1)Evaluar si todas las personas son mayores de 20 años
		boolean mayoresDeVeinte = listaPersonas.stream().allMatch(p -> p.getEdad() > 20 );
		System.out.println(mayoresDeVeinte ? "Todos son mayores de 20" : "Hay menores de 20");
		
		//2)Evaluar si existe al menos una persona de más de 1.95 cm.
		boolean existenMayoresDe195 = listaPersonas.stream().anyMatch(p -> p.getEstatura() > 1.95);
		System.out.println(existenMayoresDe195 ? "Hay personas mayores de 1,95" : "Todos son menores de 1,95");
		
		//3) Evaluar si no existe ninguna que su nombre empiece con R.
		Predicate<Persona> conR = s -> s.getNombre().startsWith("R");
		boolean personasConR = listaPersonas.stream().noneMatch(conR);
		System.out.println(personasConR ? "No hay personas con R" : "Existen personas con R");

		//4) Evaluar si todos los rectángulos tienen el perímetro menor que el área.
		Predicate<Rectangulo> perimetroMenorArea = s -> s.getPerimetro() < s.getArea();
		boolean rectanguloPerMenArea = listaRectangulos.stream().allMatch(perimetroMenorArea);
		System.out.println(rectanguloPerMenArea ? "Todos los rectangulos tienen perimetro menor que area." : "Hay rectangulos con perimetro mayor al area.");
		
		//5) Evaluar si existe al menos un rectángulo donde el perímetro sea el triple de la altura.
		Predicate<Rectangulo> perimetroTripleAltura = r -> r.getPerimetro() == r.getAltura() * 3;
		boolean rectanguloPerTriAlt = listaRectangulos.stream().anyMatch(perimetroTripleAltura);
		System.out.println( rectanguloPerTriAlt ? "Hay al menos un rectangulo con perimetro del triple de la altura" : "No hay rectangulos con perimetro del triple de la altura.");
		
		//6) Evaluar si no existe ningún rectángulo donde el la altura sea más del doble de la base
		Predicate<Rectangulo> alturaDobleBase = r -> r.getAltura() > r.getBase() * 2;
		boolean rectanguloAlturaDobleBase = listaRectangulos.stream().noneMatch(alturaDobleBase);
		System.out.println(rectanguloAlturaDobleBase ? "No hay rectangulos con altura mayor al doble de la base." : "Hay rectangulos con altura mayor al doble de la base.");
		
		//Hoja 3 Parte 2
		//1) Buscar el rectángulo con mayor área.
		Optional<Rectangulo> optRectMayorArea = listaRectangulos.stream().max(Comparator.comparing(Rectangulo::getArea));
		if (optRectMayorArea.isPresent()) {
		    System.out.println(optRectMayorArea.get());
		} else {
		    System.out.println("No se encontró un rectangulo.");
		}
		
		//2) Buscar la persona con menor edad.
		Optional<Persona> masJoven = listaPersonas.stream().min(Comparator.comparing(Persona::getEdad));
		masJoven.ifPresent(persona -> System.out.println("Persona mas joven: " + persona));
		
		//3) Buscar el rectángulo con mayor perímetro.
		Optional<Rectangulo> mayorPerimetro = listaRectangulos.stream().max(Comparator.comparing(Rectangulo::getPerimetro));
		mayorPerimetro.ifPresent(rectangulo -> System.out.println("Perimetro mas grande: " + rectangulo));
		
		//4) Obtener el primer elemento de la lista de rectangulos
		Optional<Rectangulo> primerRectangulo = listaRectangulos.stream().findFirst();
		primerRectangulo.ifPresent(mostrarRectangulo);
		
	}

}
