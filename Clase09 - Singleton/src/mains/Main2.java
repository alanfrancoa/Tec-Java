package mains;

import factories.MenuFactory;  // Importa la clase que fabrica los menús.
import interfaces.MenuIniciable;  // Importa la interfaz que todos los menús deben implementar.

public class Main2 {

	public static void main(String[] args) {

		// Crea una instancia de MenuFactory, que es responsable de crear los menús.
		MenuFactory factory = new MenuFactory();
		
		// Obtiene una instancia del menú de autenticación (AuthMenu) utilizando la fábrica.
		MenuIniciable menuLogin = factory.getMenuLogin();
		// Llama al método 'start' del menú de autenticación para iniciar la interacción de login.
		menuLogin.start();
		
		// Obtiene una instancia del menú de juegos (JuegosMenu) utilizando la fábrica.
		MenuIniciable menuJuego = factory.getMenuJuegos();
		// Llama al método 'start' del menú de juegos para comenzar la interacción de juegos.
		menuJuego.start();
		
		// Obtiene una instancia del menú de puntos (MenuPuntos) utilizando la fábrica.
		var mnuPuntos = factory.getMenuPuntos();
		// Llama al método 'start' del menú de puntos para mostrar y modificar los puntos del usuario.
		mnuPuntos.start();
	}
}
