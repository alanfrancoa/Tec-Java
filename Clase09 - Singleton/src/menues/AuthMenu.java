package menues;

import java.util.Scanner;  // Importa la clase Scanner para la entrada de datos.
import interfaces.MenuIniciable;  // Importa la interfaz que implementa este menú.
import models.Usuario;  // Importa la clase Usuario, implementada con el patrón Singleton.

public class AuthMenu implements MenuIniciable {

	// Atributo que representa el objeto Scanner para capturar la entrada del usuario.
	private Scanner sc;

	// Constructor que recibe un Scanner como parámetro e inicializa el atributo sc.
	public AuthMenu(Scanner sc) {
		super();  // Llama al constructor de la clase base (implícito aquí, aunque no estrictamente necesario).
		this.sc = sc;  // Asigna el Scanner pasado al atributo de la clase.
	}

	// Método que inicia la interacción con el usuario.
	public void start() {
		// Solicita al usuario que ingrese su nombre.
		System.out.println("Cual es tu nombre?");
		// Lee el nombre ingresado por el usuario.
		String nombre = sc.next();
		
		// Obtiene la instancia única del objeto Usuario usando el método Singleton.
		Usuario usu = Usuario.getInstance();
		
		// Establece el nombre del usuario con el valor ingresado.
		usu.setNombre(nombre);
	}
}
