package mains;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import models.Persona;
import models.Rectangulo;

public class Main1 {

	public static void main(String[] args) {
		// Guia TP nro 3 STREAMS

		// Creacion de lista de rectangulos
		List<Rectangulo> listaRectangulos = Stream.generate(() -> Rectangulo.getRandom()).limit(50).toList();
		// Pag. 2, ej 1: Crear una lista a partir de un Stream formado por los nombres
		// de los dias de la semana.
		Stream.of("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo");
		// Pag. 2 Ej 2: Crear una lista con 60 personas aleatorias.
		List<Persona> listaPersonas = Stream.generate(() -> Persona.getRandom()).limit(60).toList();

		// Creacion de consumer para mostrar personas
		Consumer<Persona> mostrarPers = (p) -> System.out.println(p.getNombre() + " " + p.getApellido());

		Consumer<Persona> mostrarPersEstatura = (p) -> System.out
				.println(p.getNombre() + " " + p.getApellido() + " " + p.getEstatura());
		Consumer<Persona> mostrarPersEdadyEstatura = (p) -> System.out
				.println(p.getNombre() + " " + p.getApellido() + " " + p.getEdad() + " " + p.getEstatura());
		// Creacion de consumer para mostrar rectangulos
		Consumer<Rectangulo> mostrarRect = (p) -> System.out
				.println("Base: " + p.getBase() + " | Altura: " + p.getAltura());

		System.out.println("LISTA DE PERSONAS: ");
		// Mostramos todas las personas
		listaPersonas.forEach(mostrarPers);

		System.out.println("LISTA DE RECTANGULOS: ");
		// Mostrar todos los rectangulos
		listaRectangulos.forEach(mostrarRect);

		// Creacion de consumer para duplicar base de los rectangulos
		Consumer<Rectangulo> duplicarBase = (r) -> r.setBase(r.getBase() * 2);

		System.out.println("LISTA DE RECTANGULOS con base duplicada: ");
		// listaRectangulos.forEach(duplicarBase);
		// listaRectangulos.forEach(mostrarRect);

		// Ejercicios Hoja 3, Evaluar elementos en base a condicion.
		// Evaluar si todas las personas son mayores de 20 años
		boolean todasMayoresDe20 = listaPersonas.stream().allMatch((r) -> r.getEdad() > 20);
		// Evaluar si existe al menos una persona con mas de 1,95 m.
		boolean algunaMasDe195 = listaPersonas.stream().anyMatch((r) -> r.getEstatura() > 1.95);
		// Evaluar si no existe ninguna que su nombre empiece con R.
		boolean nombresSinR = listaPersonas.stream().noneMatch((r) -> r.getNombre().startsWith("R"));
		System.out.println("nombres sin r: " + nombresSinR);
		// Verificar si todos los rectangulos tienen perimetro menor que el area.
		boolean perimetroTripleAltura = listaRectangulos.stream().allMatch((r) -> r.getPerimetro() < r.getArea());
		// Evaluar si al menos uno de los rectangulos tienen perimetro sea el triple que
		// la altura.
		boolean rectanguloPerimetroTripleAltura = listaRectangulos.stream()
				.anyMatch((r) -> r.getPerimetro() > r.getAltura() * 3);
		// Evaluar si no existe ningun rectangulo donde la altura sea mas del doble de
		// la base.
		boolean rectanguloAlturaDobleBase = listaRectangulos.stream().noneMatch((r) -> r.getAltura() > r.getBase() * 2);

		// Ejercicios Hoja 3, obtener elementos.
		// Buscar el rectangulo con mayor area.
		Optional<Rectangulo> mayorArea = listaRectangulos.stream()
				.max((r1, r2) -> Double.compare(r1.getArea(), r2.getArea()));
		
		System.out.println(mayorArea.map(rectangulo -> "Rectángulo con mayor área: " + rectangulo)
                .orElse("No se encontró ningún rectángulo."));

		// Buscar la persona con menor edad.
		Optional<Persona> masJoven = listaPersonas.stream()
				.min((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
		masJoven.ifPresent(persona -> System.out.println("Persona mas joven: " + persona));

		// Buscar el rectangulo con mayor perimetro
		Optional<Rectangulo> perimetroMasGrande = listaRectangulos.stream()
				.max((r1, r2) -> Double.compare(r1.getPerimetro(), r2.getPerimetro()));
		perimetroMasGrande.ifPresent(rectangulo -> System.out.println("Rectángulo con mayor perimetro: " + rectangulo));

		
		// Obtener el primer elemento de la lista de rectangulos
		Optional<Rectangulo> primerRectangulo = listaRectangulos.stream().findFirst();
		primerRectangulo.ifPresent(rectangulo -> System.out.println("Primer rectangulo: " + rectangulo));

		// Mostrar todos los rectángulos con base mayor a su altura.

		var listaRectangulosChatos = listaRectangulos.stream().filter(p -> p.getBase() > p.getAltura());
		System.out.println("Rectangulos chatos:");
		listaRectangulosChatos.forEach(mostrarRect);

		// Incrementar en 0.4 la estatura de todas las personas que midan menos de 1.4
		var listaPersonasBajas = listaPersonas.stream().filter(p -> p.getEstatura() > 1.4);
		listaPersonasBajas.forEach(p -> p.setEstatura(p.getEstatura() + 0.4));

		// Encontrar a la persona mas alta que tenga menos 40 Años
		var listaMenores40 = listaPersonas.stream().filter(p -> p.getEstatura() < 40);
		Optional<Persona> masAlto = listaMenores40.max((p1, p2) -> Double.compare(p1.getEstatura(), p2.getEstatura()));

		// Encontrar a la persona más baja que cuyo nombre empiece con J
		var listaNombresConJ = listaPersonas.stream().filter(p -> p.getNombre().startsWith("J"));
		Optional<Persona> masBajaConJ = listaNombresConJ
				.min((p1, p2) -> Double.compare(p1.getEstatura(), p2.getEstatura()));

		// Encontrar los rectangulos con Area mayor a 2000, y perimetro mayor al area.
		var listaRectangulosEspeciales = listaRectangulos.stream().filter(p -> p.getArea() > 2000)
				.filter(p -> p.getPerimetro() > p.getArea());
		System.out.println("Rectangulos especiales:");
		listaRectangulosEspeciales.forEach(mostrarRect);

		// Ejercicios: Pag 4
		// 1-Mostrar los rectángulos ordenados por área.
		Function<Rectangulo, Double> extArea = (r) -> r.getArea();
		Comparator<Rectangulo> porArea = Comparator.comparing(extArea);
		List<Rectangulo> listaRectangulosOrdenada = listaRectangulos.stream().sorted(porArea).toList();
		System.out.println("------------------------------");
		System.out.println("Lista de rectangulos ordenada por area:");
		listaRectangulosOrdenada.forEach(mostrarRect);
		// 2. Traer una lista de personas ordenadas por altura.
		Function<Persona, Double> extEstatura = (p) -> p.getEstatura();
		Comparator<Persona> porEstatura = Comparator.comparing(extEstatura);
		List<Persona> personasPorEstatura = listaPersonas.stream().sorted(porEstatura).toList();
		System.out.println("------------------------------");
		System.out.println("Lista de personas ordenadas por estatura:");
		personasPorEstatura.forEach(mostrarPersEstatura);
		// 3. Mostrar los rectángulos ordenados por perímetro decrecientemente.
		Function<Rectangulo, Double> extPerimetro = (p) -> p.getPerimetro();
		Comparator<Rectangulo> porPerimetroDec = Comparator.comparing(extPerimetro).reversed();
		List<Rectangulo> rectangulosPorPerimetroDec = listaRectangulos.stream().sorted(porPerimetroDec).toList();
		System.out.println("------------------------------");
		System.out.println("Lista de rectangulos ordenados por perimetro decreciente:");
		rectangulosPorPerimetroDec.forEach(mostrarRect);
		// 4. Obtener una lista de las personas ordenadas por edad y si tienen la misma
		// edad, usar la estatura como segundo criterio
		Function<Persona, Integer> extEdad = (p) -> p.getEdad();
		Comparator<Persona> porEdadyEstatura = Comparator.comparing(extEdad).thenComparing(porEstatura);
		List<Persona> personasPorEdadyEstatura = listaPersonas.stream().sorted(porEdadyEstatura).toList();
		System.out.println("------------------------------");
		System.out.println("Lista de personas ordenadas por edad y estatura:");
		personasPorEdadyEstatura.forEach(mostrarPersEdadyEstatura);

		// Ejercicios: Pag 5
		// 1. Obtener una lista con solo los nombres de las personas (Puede repetir)
		Function<Persona, String> toNombre = p -> p.getNombre() + ", " + p.getNombre();
		List<String> ListaNombres = listaPersonas.stream().map(toNombre).toList();
		System.out.println("Lista nombres: ");
		System.out.println(ListaNombres);
		// 2. Obtener una lista con las áreas de todos los rectángulos.
		Function<Rectangulo, Double> toArea = r -> r.getArea();
		List<Double> listaAreas = listaRectangulos.stream().map(toArea).toList();
		System.out.println("Lista Areas: ");
		System.out.println(listaAreas);
		// 3. Obtener una lista con la suma del área y el perímetro de cada uno de los
		// rectángulos.
		Function<Rectangulo, Double> toAreayPerimetro = r -> r.getArea() + r.getPerimetro();
		List<Double> listaAreayPerimetro = listaRectangulos.stream().map(toAreayPerimetro).toList();
		System.out.println("Lista de sumas de Area y Perimetro: ");
		System.out.println(listaAreayPerimetro);
		// 4. Obtener una lista con todas las personas convertidas en rectángulos
		// Siendo la altura: la estatura de la persona * 50 y la base: el peso de la
		// persona
		Function<Persona, Rectangulo> toRectangulo = (p) -> new Rectangulo(null, p.getPeso(), p.getEstatura() * 50);

		// Convertir la lista de personas en una lista de rectángulos
		List<Rectangulo> listaRectangulosDePersonas = listaPersonas.stream().map(toRectangulo).toList();
		// Mostrar la lista de rectángulos creados a partir de las personas
		System.out.println("Lista de rectángulos creados a partir de personas:");
		listaRectangulosDePersonas.forEach(mostrarRect);
		// 5. Obtener una lista con la suma del área y el perímetro de cada una de las
		// personas (Si fueran rectángulos).
		List<Double> segundaListadeAreaPer = listaRectangulosDePersonas.stream().map(toAreayPerimetro).toList();
		System.out.println("Lista de sumas de Area y Perimetro de personas ");
		System.out.println(segundaListadeAreaPer);
		
		//-----------------------------------------------------------------
		/*** TRABAJO PRACTICO NRO 5. Streams avanzado ***/
		
		//1) Mostrar los rectángulos cuya área es mayor a 300 y su base sea mayor a su altura. Ordenarlos por la suma de su área y su perímetro.
		Predicate<Rectangulo> mayor300 = s -> s.getArea() > 300;
		Predicate<Rectangulo> baseMayor = s -> s.getBase() > s.getAltura();
		Function<Rectangulo, Double> sumaAreaPerimetro = s -> s.getArea() + s.getPerimetro();
		
		Comparator<Rectangulo> porAreaYPerimetro = Comparator.comparing(sumaAreaPerimetro);
		System.out.println("Lista rectangulos mayores a 300...");
		listaRectangulos.stream().filter(mayor300.and(baseMayor)).sorted(porAreaYPerimetro).forEach(mostrarRect);
		//2) Crear una lista convirtiendo la lista de personas en rectángulos (Siendo la estatura*50 la altura y el peso la base), pero solo incluyendo las personas de más de 30 años, ordenadas por edad.
		
		Predicate<Persona> mayor30 = s -> s.getEdad() >= 30;
		Comparator<Persona> porEdad = Comparator.comparing(extEdad);
		var listaRectangulizados = listaPersonas.stream().filter(mayor30).sorted(porEdad).map(toRectangulo);
		System.out.println("Personas por rectangulos 2: ordenadas por edad");
		listaRectangulizados.forEach(mostrarRect);
				
		//3) Mostrar un las personas mayores a 30 años que midan más de 1,5 metros. Los mismos deben estar ordenados por edad como primer criterio y estatura como segundo criterio.
		
		Predicate<Persona> mayor150 = s -> s.getEstatura() >= 1.5;
		listaPersonas.stream().filter(mayor30.and(mayor150)).sorted(porEdadyEstatura).forEach(mostrarPersEdadyEstatura);
		//4) Mostrar la persona más joven, contemplando solo las 10 personas más altas.
		
		Comparator<Persona> EstaturaInv = porEstatura.reversed();
		var top10AlturaList = listaPersonas.stream().sorted(EstaturaInv).limit(10).toList();
		Optional<Persona> masJovenAlto = top10AlturaList.stream().min((s1, s2) -> Double.compare(s1.getEdad(), s2.getEdad()));
		
		System.out.println("Top 10: altura");
		top10AlturaList.stream().forEach(mostrarPersEdadyEstatura);
		
		if (masJovenAlto.isPresent()) {
		    System.out.println(masJovenAlto.get());
		} else {
		    System.out.println("No se encontró una persona joven y alta.");
		}
		
		//5) Mostrar los 30 rectángulos con más área, ordenados por perímetro.
		
		Comparator<Rectangulo> areaInv = porArea.reversed();
		var top30rect = listaRectangulos.stream().sorted(areaInv).limit(30).toList();
		
		Comparator<Rectangulo> porPerimetro = (s1, s2) -> Double.compare(s1.getPerimetro(), s2.getPerimetro());
		
		top30rect.stream().sorted(porPerimetro).forEach(mostrarRect);
		
		
	}

}
