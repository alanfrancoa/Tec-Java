package mains;

import java.util.function.Predicate;
import interfaces.Comunicador;
import interfaces.Pesable;

public class Main1 {

    public static void main(String[] args) {
        //---------- Creamos una clase anónima con la interfaz Pesable ----------//
        // Implementamos directamente el método GetPesoEnGramos de la interfaz
        Pesable articulo1 = new Pesable() {
            @Override
            public double GetPesoEnGramos() {
                return 1867; // Retorna el peso en gramos
            }
        };

        //---------- Creamos otra implementación usando expresiones LAMBDA ----------//
        // Aquí usamos una lambda porque Pesable es una interfaz funcional (con un solo método abstracto)
        Pesable articulo2 = () -> 1453; // Retorna directamente 1453 gramos

        // Mostramos el peso en kilogramos (suponiendo que GetPesoEnKg esté implementado en Pesable)
        System.out.println(articulo1.GetPesoEnKg());

        //---------- Creamos una clase anónima con la interfaz Predicate ----------//
        // Predicate es una interfaz funcional que acepta un parámetro y devuelve un booleano
        Predicate<Integer> esPar = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                // Retorna TRUE si el número es par (resto de la división por 2 es 0)
                return t % 2 == 0;
            }
        };

        //---------- Implementamos Predicate utilizando una expresión LAMBDA ----------//
        Predicate<Integer> esParLambda = (Integer t) -> {
            return t % 2 == 0; // Mismo comportamiento, pero más conciso
        };

        //---------- Simplificamos la expresión LAMBDA eliminando el bloque de llaves ----------//
        Predicate<Integer> esParLambdaBueno = (Integer t) -> t % 2 == 0;

        //---------- Simplificación adicional: el tipo de parámetro se infiere automáticamente ----------//
        Predicate<Integer> esParLambdaOptimo = t -> t % 2 == 0;

        // Negate() invierte el valor booleano retornado por la lambda (si es true, retorna false, y viceversa)
        esParLambdaOptimo.negate();

        //---------- Creamos una clase anónima con la interfaz Comunicador ----------//
        Comunicador comu = new Comunicador() {
            /*
             * Como Comunicador no es una interfaz funcional (tiene más de un método abstracto),
             * no podemos usar expresiones lambda para implementarla, ya que eso causaría ambigüedad.
             */
            @Override
            public void enviar(String mje) {
                System.out.println(mje); // Enviar un mensaje
            }

            @Override
            public String recibir() {
                return "Magnifico"; // Recibir un mensaje
            }
        };

        // Llamamos al método enviar de la implementación de Comunicador
        comu.enviar("¡Buenas!!!");
    }
}
