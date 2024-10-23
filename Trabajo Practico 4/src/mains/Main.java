package mains;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
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
		
		//Hoja 4 primer parte
		
		//1) Mostrar todos los rectángulos con base mayor a su altura.
		listaRectangulos.stream().filter(r -> r.getBase() > r.getAltura()).forEach(mostrarRectangulo);
		
		//2) Incrementar en 0.4 la estatura de todas las personas que midan menos de 1.4
		System.out.println("Lista de personas");
		listaPersonas.stream().forEach(mostrarPersona);
		listaPersonas.stream().filter( p -> p.getEstatura() < 1.4 ).forEach( p -> p.setEstatura(p.getEstatura() + 0.4 ));
		System.out.println("Lista de personas con altura modificada");
		listaPersonas.stream().forEach(mostrarPersona);
		//3) Encontrar a la persona más alta de las que tengan menos de 40 años.
		Optional<Persona> masAlto = listaPersonas.stream().filter( p -> p.getEdad() < 40 ).max(Comparator.comparing(Persona::getEstatura));
		masAlto.ifPresent(p -> System.out.println("Persona mas alta de menos de 40: " + p));
		
		//4) Encontrar a la persona más baja que cuyo nombre empiece con J.
		Optional<Persona> bajaConJ = listaPersonas.stream().filter(p -> p.getNombre().startsWith("J")).min(Comparator.comparing(Persona::getEstatura));
		bajaConJ.ifPresent(p -> System.out.println("Persona mas baja con nombre que empieza con J: " + p));
		
		//5) Mostrar todos los rectángulos cuya área sea mayor a 2000 y su perímetro sea mayor al área.
		Predicate<Rectangulo> areaMayor2000 = r -> r.getArea() > 2000;
		Predicate<Rectangulo> perimetroMayorArea = r -> r.getPerimetro() > r.getArea();
		Predicate<Rectangulo> areaMayorPerimetroMayor = areaMayor2000.and(perimetroMayorArea);
		
		//Ya que la condicion es muy especifica, y posiblemente no sea cumplida, hacemos if para mostrar los rectangulos o mostramos un mensaje diciendo que no hay rectangulos.
		if (listaRectangulos.stream().filter(areaMayorPerimetroMayor).findAny().isPresent()) {
			System.out.println("Rectangulos area mayor a 2000 y perimetro mayor area.");
		    listaRectangulos.stream().filter(areaMayorPerimetroMayor).forEach(mostrarRectangulo);
		} else {
		    System.out.println("No hay rectángulos que cumplan con las condiciones: área mayor a 2000 y perímetro mayor al área.");
		}
				
		//Hoja 4 segunda parte
		
		//1) Mostrar los rectángulos ordenados por área.
		Comparator<Rectangulo> compArea = Comparator.comparing(Rectangulo::getArea);
		System.out.println("Lista rectangulos por area: ");
		listaRectangulos.stream().sorted(compArea).forEach(mostrarRectangulo);
		
		//2) Traer una lista de personas ordenadas por altura.}
		System.out.println("Listado personas por altura");
		listaPersonas.stream().sorted( Comparator.comparing(Persona::getEstatura)).forEach(mostrarPersona);
		
		//3) Mostrar los rectángulos ordenados por perímetro decrecientemente.
		Comparator<Rectangulo> perimetroDecreciente = Comparator.comparing(Rectangulo::getPerimetro).reversed();
		System.out.println("Lista de rectangulos ordenada, por perimetro decreciente.");
		listaRectangulos.stream().sorted(perimetroDecreciente).forEach(mostrarRectangulo);
		
		//4) Obtener una lista de las personas ordenadas por edad y si tienen la misma edad, usar la estatura como segundo criterio.
		Comparator<Persona> edadYEstatura = Comparator.comparing(Persona::getEstatura).thenComparing(Persona::getEdad);
		System.out.println("Listado de personas ordenadas por estatura y edad:");
		listaPersonas.stream().sorted(edadYEstatura).forEach(mostrarPersona);
		
		//Hoja 5
		
		//1) Obtener una lista con solo los nombres de las personas (Puede repetir)
		Function<Persona, String> toNombre = p -> p.getNombre();
		var listaNombres = listaPersonas.stream().map(toNombre).toList();
		System.out.println("Lista nombres: ");
		listaNombres.stream().forEach( n -> System.out.print(" |" + n));
		
		//2) Obtener una lista con las áreas de todos los rectángulos.
		Function<Rectangulo, Double> toArea =  r -> r.getArea();
		var listaAreas = listaRectangulos.stream().map(toArea).toList();
		System.out.println("");
		System.out.println("Lista areas: ");
		listaAreas.stream().forEach( n -> System.out.print(" |" + n));
		
		//3) Obtener una lista con la suma del área y el perímetro de cada uno de los rectángulos.
		Function<Rectangulo, Double> toAreaYPerimetro = r -> r.getArea() + r.getPerimetro();
		var listaAreasYPerimetros = listaRectangulos.stream().map(toAreaYPerimetro).toList();
		System.out.println("");
		System.out.println("Lista de sumas de areas y perimetros: ");
		listaAreasYPerimetros.stream().forEach( n -> System.out.print(" |" + n));
		
		//4) Obtener una lista con todas las personas convertidas en rectángulos siendo su altura: la estatura de la persona * 50 y la base: el peso de la persona.
		Function<Persona, Rectangulo> personaToRectangulo = p -> new Rectangulo("", p.getPeso(), p.getEstatura() * 50);
		var listaPersonasToRectangulo = listaPersonas.stream().map(personaToRectangulo).toList();
		System.out.println("Lista de personas convertidas en rectangulos: ");
		listaPersonasToRectangulo.stream().forEach(mostrarRectangulo);
		
		//5) Obtener una lista con la suma del área y el perímetro de cada una de las personas (Si fueran rectángulos)
		System.out.println("Lista de sumas de areas y perimetros de personas convertidas en rectangulos: ");
		listaPersonasToRectangulo.stream().map(toAreaYPerimetro).forEach( n -> System.out.print(" |" + n));
	}

}
