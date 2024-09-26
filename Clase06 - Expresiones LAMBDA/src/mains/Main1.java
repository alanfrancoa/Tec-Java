package mains;

import java.util.function.Predicate;

import interfaces.Comunicador;
import interfaces.Pesable;

public class Main1 {

	public static void main(String[] args) {
		//----------Creamos una clase anonima con la interfaz pesable----------//
		Pesable articulo1 = new Pesable() {

			@Override
			public double GetPesoEnGramos() {
				return 1867;
			}
		};
		
		//----------Creamos otra clase utilizando expresiones LAMBDA----------//
		Pesable articulo2 = () -> 1453; 
		
		System.out.println(articulo1.GetPesoEnKg());
		
		//----------Se crea una clase anonima con la interfaz Predicate ----------//
		Predicate<Integer> esPar = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				//retorna TRUE cuando al dividir por dos, tengamos resto 0.
				return t % 2 == 0;
			}	
		};
		
		//----------Creamos otra clase anonima, pero utilizando expresiones LAMBDA ----------//
		Predicate<Integer> esParLambda = (Integer t) ->{
			return t % 2 == 0;
		}; 
		
		//----------Creamos otra clase anonima, pero utilizando LAMBDA y poder simplificar la expresion.----------//
		Predicate<Integer> esParLambdaBueno = (Integer t) -> t % 2 == 0;
		
		//----------Creamos otra clase anonima, utilizando LAMBDA podemos seguir simplificando la expresion.----------//
		Predicate<Integer> esParLambdaOptimo = t -> t % 2 == 0;
		
		//La funcion Negate() va a devolver el valor booleano inverso.
		esParLambdaOptimo.negate();
		
		//----------Creamos otra clase anonima, con la interfaz comunicador----------//
		Comunicador comu = new Comunicador() {
			
			/*
			 * Solo podemos sobreescribir las funciones de esta interfaz de esta manera, 
			 * Al NO SER UNA INTERFAZ FUNCIONAL NO PUEDO UTILIZAR EXPRESIONES LAMBDA
			 * al tener mas de una funcion abstracta, da lugar a la ambiguedad. 
			 * */
			
			@Override
			public void enviar(String mje) {
				System.out.println(mje);
				
			}

			@Override
			public String recibir() {
				return "Magnifico";
			}	
		};
		
		comu.enviar("Buenas!!!");
		
	}

}
