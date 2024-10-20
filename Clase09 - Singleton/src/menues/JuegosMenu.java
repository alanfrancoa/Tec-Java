package menues;

import java.util.Scanner;  // Importa la clase Scanner para la entrada de datos.
import interfaces.MenuIniciable;  // Importa la interfaz que define el comportamiento de menús.
import models.Usuario;  // Importa la clase Usuario que sigue el patrón Singleton.

public class JuegosMenu implements MenuIniciable {

	// Atributo Scanner para capturar la entrada del usuario.
	private Scanner sc;
	// Atributo booleano que controla si el menú continúa ejecutándose.
	private boolean continuar = true;

	// Constructor que inicializa el Scanner.
	public JuegosMenu(Scanner sc) {
		super();  // Llama al constructor de la clase base (aunque no es estrictamente necesario).
		this.sc = sc;  // Asigna el Scanner pasado como parámetro al atributo de la clase.
	}

	// Método principal que inicia el menú y ejecuta un bucle hasta que el usuario elija salir.
	public void start() {
		// Bucle que se repite mientras "continuar" sea true.
		while (continuar) {
			// Muestra un mensaje pidiendo que el usuario elija una opción.
			System.out.println("Elija");
			// Lee la opción ingresada por el usuario.
			int opcion = sc.nextInt();

			// Switch que ejecuta diferentes métodos según la opción ingresada.
			switch (opcion) {
				// Opción 1: Llama al método adivinarLetra().
				case 1 -> this.adivinarLetra();
				// Opción 2: Llama al método adivinarSuma().
				case 2 -> this.adivinarSuma();
				// Opción 0: Cambia el valor de "continuar" a false para salir del bucle.
				case 0 -> this.continuar = false;
				// Opción por defecto: Muestra un mensaje de error si la opción es inválida.
				default -> System.out.println("Invalida");
			}
		}
	}

	// Método vacío que representa un juego de adivinar una suma (pendiente de implementación).
	private void adivinarSuma() {
		// Lógica del juego de adivinar la suma pendiente.
	}

	// Método que simula un juego donde se debe adivinar con qué letra empieza "Jorge".
	private void adivinarLetra() {
		// Pide al usuario que ingrese una letra.
		System.out.println("Con que letra empieza Jorge?");
		// Lee la letra ingresada por el usuario.
		String letra = sc.next();

		// Verifica si la letra ingresada es "j" (ignorando mayúsculas o minúsculas).
		if (letra.equalsIgnoreCase("j")) {
			// Si es correcta, muestra un mensaje de éxito.
			System.out.println("Bien");
			// Obtiene la instancia única del Usuario usando el patrón Singleton.
			Usuario wachin = Usuario.getInstance();
			// Añade 100 puntos al usuario.
			wachin.addPuntos(100);
		}
	}
}
