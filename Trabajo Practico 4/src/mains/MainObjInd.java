package mains;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import models.Persona;
import models.Rectangulo;

public class MainObjInd {

	public static void main(String[] args) {
		// Guia trabajo practico interfaces funcionales con Objeto Indefinido
		// Creamos personas y listado de personas para ejemplo
		Persona persona1 = new Persona("Jazmin", 22, 47.3, 1.74);
		Persona persona2 = new Persona("Mili", 25, 54.5, 1.60);
		Persona persona3 = new Persona("Sensei", 40, 70, 1.77);

		List<Persona> personas = new ArrayList<Persona>();
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);

		// Creamos rectangulos y listado de rectangulos para ejemplo
		Rectangulo rectangulo1 = new Rectangulo(22, 33);
		Rectangulo rectangulo2 = new Rectangulo(6, 6);
		Rectangulo rectangulo3 = new Rectangulo(9, 100);

		List<Rectangulo> rectangulos = new ArrayList<Rectangulo>();
		rectangulos.add(rectangulo1);
		rectangulos.add(rectangulo2);
		rectangulos.add(rectangulo3);

		// *****************COMPARATORS*****************//
				
		//1)Crear un comparador que compare dos personas por altura.
		Comparator<Persona> comparaEstatura = Comparator.comparingDouble(Persona::getEstatura);
		// Ordenamos la lista de personas por altura usando el comparador
        personas.sort(comparaEstatura);
        
        // Mostramos las personas ordenadas por altura
        personas.forEach(p -> System.out.println(p.getNombre() + " - Altura: " + p.getEstatura()));
	}

}
