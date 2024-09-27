package mains;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import models.Persona;
import models.Rectangulo;

public class Main1 {

	public static void main(String[] args) {
		
		//Creamos personas y listado de personas para ejemplo
		Persona persona1 = new Persona("Benito", 33, 78.5, 1.88);
		Persona persona2 = new Persona("Mili", 25, 54.5, 1.70);
		Persona persona3 = new Persona("Sensei", 40, 70, 1.77);
		
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		//Creamos rectangulos y listado de rectangulos para ejemplo
		Rectangulo rectangulo1 = new Rectangulo(22, 33);
		Rectangulo rectangulo2 = new Rectangulo(6, 6);
		Rectangulo rectangulo3 = new Rectangulo(9, 100);
		
		List<Rectangulo> rectangulos = new ArrayList<Rectangulo>();
		rectangulos.add(rectangulo1);
		rectangulos.add(rectangulo2);
		rectangulos.add(rectangulo3);
		
		//*****************COMPARATORS*****************//
		//Comparador que compara dos personas por altura
		Comparator<Persona> porAltura = (p1, p2) -> Double.compare(p1.getEstatura(), p2.getEstatura());
		//Comparador que compara personas por edad
		Comparator<Persona> porEdad = (p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad());
		//Comparador que compara personas por edad y si son iguales por estatura.
		Comparator <Persona> porEdadYAltura = porEdad.thenComparing(porAltura);
		//Comparador que compara personas por peso inversamente.
		Comparator <Persona> porPeso = (p1, p2) -> Double.compare(p1.getPeso(), p2.getPeso());
		Comparator <Persona> porPesoInverso = porPeso.reversed();
		//Comparador que compara las bases de dos rectangulos
		Comparator <Rectangulo> porBase = (r1, r2) -> Double.compare(r1.getBase(), r2.getBase());
		
		//*****************FUNCTIONS*****************//
		//Funcion que reciba un rectangulo y retorne su area.
		Function <Rectangulo, Double> getArea = (r) -> r.getBase() * r.getAltura();
		//Funcion que reciba un rectangulo y retorne su perimetro.
		Function <Rectangulo, Double> getPerimetro = (r) -> (r.getBase() * 2 ) + (r.getAltura() *2);
		//Funcion que reciba un double y retorne el triple de ese numero.
		Function <Double, Double> getTriple = (n) -> n * 3;
		//Funcion que retorne el triple del area de un rectangulo
		Function <Rectangulo, Double> getAreaTriple = (r) -> getTriple.apply(getArea.apply(r));
		//Funcion que reciba una persona y retorne un rectangulo con la misma estatura y de base el peso.
		Function <Persona, Rectangulo> rectangulizar = (r) -> new Rectangulo(r.getPeso(), r.getEstatura());
		//Funcion que retorne el triple del area de una persona, como si la misma fuera un rectangulo.
		Function <Persona, Double> tripleAreaPersona = (p) -> getAreaTriple.apply(rectangulizar.apply(p));
		
		
		//*****************PREDICATES*****************//
		//Predicado que evalua si una persona es mayor a dos metros.
		Predicate<Persona> masDeDosMetros = (p) -> p.getEstatura() > 2;
		//Predicado que evalua si una persona es menor a dos metros.
		Predicate<Persona> menosDeDosMetros = masDeDosMetros.negate();
		//Predicado que evalua si una persona es Mayor de edad
		Predicate<Persona> mayoriaDeEdad = (p) -> p.getEdad() > 18;
		//Predicado que evalua si una persona es mayor de edad o mide mas de dos metros.
		Predicate<Persona> mayoriaODosMetros = mayoriaDeEdad.or(menosDeDosMetros);
		//Predicado que evalua si un rectangulo es un cuadrado
		Predicate<Rectangulo> esCuadrado = (r) -> r.getAltura() == r.getBase();
		
		
		//*****************CONSUMERS*****************//
		//Consumidor que reciba una persona y muestre su edad por pantalla
		Consumer<Persona> muestraEdad = (p) -> System.out.println("La edad es: " + p.getEdad());
		//Consumidor que incremente la edad de una persona en 3 años.
		Consumer<Persona> sumarTresAnios = (p) -> p.setEdad(p.getEdad() + 3);
		//Consumidor que incremente la edad de una persona en 3 años y luego la muestre.
		Consumer<Persona> sumarTresYMostrar = sumarTresAnios.andThen(muestraEdad);
		//Consumidor que transforme un rectangulo en cuadrado, haciendo que su base valga su altura.
		Consumer<Rectangulo> hacerCuadrado = (r) -> r.setBase(r.getAltura());
		
		// Usar comparador por edad
		personas.sort(porEdad);
		System.out.println("Personas ordenadas por edad:");
		personas.forEach(p -> System.out.println(p.getNombre() + ": " + p.getEdad()));

		// Usar la función de área en un rectángulo
		rectangulos.forEach(r -> {
		    System.out.println("Área del rectángulo: " + getArea.apply(r));
		});

		// Filtrar personas mayores de edad
		List<Persona> mayoresDeEdad = personas.stream()
		    .filter(mayoriaDeEdad)
		    .toList();
		System.out.println("Personas mayores de edad:");
		mayoresDeEdad.forEach(p -> System.out.println(p.getNombre()));

	}
}
