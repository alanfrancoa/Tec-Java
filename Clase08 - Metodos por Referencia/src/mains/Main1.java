package mains;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

import containers.PalabrasContainer;

public class Main1 {

    public static void main(String[] args) {
        // Métodos de referencia con objeto definido:
        // Por referencia, el "protagonista" no es el dueño del método, sino la acción en sí.
        // Con "::" estamos haciendo referencia al método, sin ejecutarlo.
        // Con "." estamos ejecutando el método directamente.
        
        Scanner sc = new Scanner(System.in);
        
        // Creamos una lista usando un Stream generado a partir de la entrada por consola.
        // El método sc::next es una referencia a método que toma la siguiente entrada del scanner.
        // Se aplica map para convertir el objeto recibido a String (aunque innecesario, pues sc::next ya retorna String).
        // filter se asegura de que solo pasen palabras que comiencen con "S".
        // limit(3) garantiza que solo se tomen las primeras 3 palabras válidas.
        List<String> pepe = Stream.generate(sc::next)
                                  .map(s -> s.toString())
                                  .filter(s -> s.startsWith("S"))
                                  .limit(3)
                                  .toList(); // Importante el orden de las operaciones en la pipeline de Stream.
        
        // Se transforma la lista inmutable retornada por Stream en una lista mutable de tipo ArrayList.
        pepe = new ArrayList<String>(pepe);
        System.out.println("Pepe Inicial");
        System.out.println(pepe);

        // Creamos dos nuevas listas vacías.
        List<String> pepe1 = new ArrayList<String>();
        List<String> jorgito = new ArrayList<String>();

        // Referencia a método usando la lista 'pepe'.
        // Esto crea un Consumer que llama al método add de la lista 'pepe'.
        // Cuando el consumer sea ejecutado, agregará un elemento a la lista.
        Consumer<String> pAdd = pepe::add;

        // Expresión lambda equivalente.
        // Aunque más explícita, es equivalente a la referencia a método pepe::add.
        // Consumer<String> pAddL = (s) -> pepe.add(s);
        // Notar: Las lambdas requieren que las variables dentro de su cuerpo sean efectivamente finales (no mutables).

        // Consumer para agregar elementos a la lista 'jorgito' usando referencia a método.
        Consumer<String> jAdd = jorgito::add;

        // Consumer equivalente usando expresión lambda para la lista 'jorgito'.
        Consumer<String> jAddL = s -> jorgito.add(s);

        // Instanciamos el contenedor PalabrasContainer (presumiblemente tiene un Optional<String>).
        PalabrasContainer cont = new PalabrasContainer();

        // Si el Optional contiene un valor, se pasa al consumer jAdd, que lo agregará a la lista 'jorgito'.
        cont.getPalabraOpcional().ifPresent(jAdd);

        // Igual que el anterior, pero para agregar el valor opcional a la lista 'pepe'.
        cont.getPalabraOpcional().ifPresent(pAdd);

        // Agregamos un valor constante directamente a 'jorgito' usando el consumer jAdd.
        jAdd.accept("Hola Amoooor");
        System.out.println("Pepe");
        System.out.println(pepe);
        
        System.out.println("Jorgito");
        System.out.println(jorgito);
        
        // Definimos un PrintStream para la salida estándar (System.out es un PrintStream).
        // System es una clase, mientras que System.out es un objeto que maneja la salida.
        PrintStream salida = System.out;

        // Imprimimos cada elemento de 'jorgito' usando un método de referencia.
        // salida::println es un consumer que imprime cada elemento de la lista.
        jorgito.forEach(salida::println);

        // Hacemos lo mismo para la lista 'pepe', usando directamente System.out::println.
        pepe.forEach(System.out::println);
    }
}
