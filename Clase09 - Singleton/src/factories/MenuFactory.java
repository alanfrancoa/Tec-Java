package factories;

import java.util.Scanner;  // Importa la clase Scanner para la entrada de datos.
import interfaces.MenuIniciable;  // Importa la interfaz que define el comportamiento de los menús.
import menues.AuthMenu;  // Importa el menú de autenticación.
import menues.JuegosMenu;  // Importa el menú de juegos.
import menues.PuntosMenu;  // Importa el menú de puntos.
import models.Usuario;  // Importa la clase Usuario, que sigue el patrón Singleton.

public class MenuFactory {
	
	// Atributo privado para almacenar la instancia de Scanner.
	private Scanner sc;
	
	// Método que retorna el Scanner, pero solo lo inicializa si es necesario (Lazy Initialization).
	public Scanner getScanner() {
		if (sc == null) {  // Si el Scanner no ha sido inicializado...
			sc = new Scanner(System.in);  // ...se crea una nueva instancia.
		}
		return sc;  // Retorna la instancia de Scanner.
	}
	
	// Método que retorna un nuevo menú de autenticación (AuthMenu).
	public MenuIniciable getMenuLogin() {
		// Crea y retorna una instancia de AuthMenu, usando el Scanner obtenido de getScanner().
		return new AuthMenu(this.getScanner());
	}
	
	// Método que retorna un nuevo menú de juegos (JuegosMenu).
	public MenuIniciable getMenuJuegos() {
		// Crea y retorna una instancia de JuegosMenu, usando el mismo Scanner.
		return new JuegosMenu(this.getScanner());
	}
	
	// Método que retorna un nuevo menú de puntos (MenuPuntos).
	public MenuIniciable getMenuPuntos() {
		// Crea y retorna una instancia de MenuPuntos.
		// Usa la instancia del Usuario (patrón Singleton) y el Scanner.
		return new PuntosMenu(
			Usuario.getInstance(),  // Obtiene la única instancia de Usuario (Singleton).
			this.getScanner()  // Usa el mismo Scanner.
		);
	}
}
