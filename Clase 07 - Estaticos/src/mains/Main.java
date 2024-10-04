package mains;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import models.BotellaDeAgua;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        // Supplier es un proveedor de objetos, en este caso genera botellas de agua aleatoriamente
        Supplier<BotellaDeAgua> generador = () -> BotellaDeAgua.getRandom();

        // Genera una lista de 5 botellas de agua aleatorias
        List<BotellaDeAgua> botellas = Stream.generate(generador)
                                              .limit(5)
                                              .collect(Collectors.toList());

        // Imprime las botellas generadas
        System.out.println("Botellas generadas:");
        botellas.forEach(System.out::println);

        // Predicate es una condición que determina si una botella está vacía (si su capacidad es 0)
        Predicate<BotellaDeAgua> predicateVacia = BotellaDeAgua::estaVacia;

        // Filtra las botellas vacías y las imprime
        System.out.println("Botellas vacías:");
        botellas.stream()
                .filter(predicateVacia) // Aplica el predicate para filtrar solo botellas vacías
                .forEach(System.out::println); // Muestra las botellas vacías

        // Comparator que compara botellas por su capacidad en litros
        Comparator<BotellaDeAgua> compi = Comparator.comparing(BotellaDeAgua::getCapacidad);

        // Ordena las botellas por capacidad (de menor a mayor) y las imprime
        System.out.println("Botellas ordenadas por capacidad:");
        botellas.stream()
                .sorted(compi) // Ordena las botellas usando el comparador
                .forEach(System.out::println); // Muestra las botellas ordenadas

        // Aplica el Predicate para mostrar si la botella está vacía o no, una por una
        System.out.println("Estado de cada botella (vacía o no):");
        botellas.forEach(b -> {
            if (predicateVacia.test(b)) {
                System.out.println("La botella está vacía: " + b);
            } else {
                System.out.println("La botella NO está vacía: " + b);
            }
        });
    }
}
