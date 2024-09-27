package mains;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main2 {
    /*USO DE STREAM*/

    public static void main(String[] args) {
        //---------- Creacion de lista INMUTABLE ----------//
        // List.of() crea una lista inmutable que no puede ser modificada
        List<String> nombres = List.of("Lucila", "Carolina", "Minolta", "Karina", "Josué", "Alberto");
        
        //---------- Clase anonima utilizando la interfaz Predicate ----------//
        // Predicate define un criterio booleano para filtrar elementos. Aquí se verifica si los nombres comienzan con 'M'
        Predicate<String> empiezanConM = (t) -> t.startsWith("M");
        
        //---------- Usamos el Stream para procesar la lista ----------//
        // El uso de Stream nos permite realizar operaciones de alto nivel (filtros, mapeo, etc.)
        // Stream nos da una copia inmutable de la lista para trabajar, no altera la original.
        // El método filter() recibe un Predicate que filtra los elementos según una condición
        // Finalmente, toList() convierte la secuencia filtrada de vuelta a una lista
        List<String> listaFiltrada = nombres.stream().filter(empiezanConM).toList();
        
        // Mostramos el resultado de la lista filtrada (nombres que comienzan con 'M')
        System.out.println(listaFiltrada); //[Minolta]
        
        //---------- Clase anonima utilizando la interfaz Consumer ----------//
        // Consumer acepta un parámetro y no devuelve nada. En este caso, imprime el String que recibe.
        Consumer<String> mostrar = (s) -> System.out.println(s);
        
        //---------- Clase anonima utilizando la interfaz Comparator ----------//
        // Comparator define cómo se comparan dos objetos. Aquí comparamos strings ignorando mayúsculas/minúsculas.
        Comparator<String> alfabetico = (s1, s2) -> s1.compareToIgnoreCase(s2);
        
        //---------- Clase anonima utilizando la interfaz Function ----------//
        // Function toma un valor de entrada y devuelve un valor de salida.
        // Aquí convierte cada string a mayúsculas.
        Function<String, String> enMayusculas = (s) -> s.toUpperCase();
        
        //---------- Aplicamos todas las clases anonimas ----------//
        // sorted(alfabetico): Ordena los nombres alfabéticamente ignorando las mayúsculas.
        // map(enMayusculas): Convierte cada string de la lista a mayúsculas.
        // forEach(mostrar): Muestra cada string en mayúsculas.
        nombres.stream().sorted(alfabetico).map(enMayusculas).forEach(mostrar);
    }
}
