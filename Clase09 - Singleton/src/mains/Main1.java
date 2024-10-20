package mains;

import java.util.Scanner;  // Importa la clase Scanner para capturar la entrada de datos.
import menues.AuthMenu;  // Importa la clase AuthMenu para manejar la autenticación del usuario.
import menues.JuegosMenu;  // Importa la clase JuegosMenu que contiene los juegos interactivos.

public class Main1 {

	public static void main(String[] args) {

		// Crea una instancia de Scanner para capturar la entrada de datos del usuario desde la consola.
		Scanner sc = new Scanner(System.in);
		
		// Crea una instancia de AuthMenu, pasando el Scanner como argumento.
		// AuthMenu es el menú de autenticación donde el usuario ingresará su nombre.
		AuthMenu aMenu = new AuthMenu(sc);
		// Llama al método start() de AuthMenu para iniciar la interacción de autenticación.
		aMenu.start();
		
		// Crea una instancia de JuegosMenu, también pasando el Scanner como argumento.
		// JuegosMenu es el menú que permite al usuario participar en diferentes juegos.
		JuegosMenu jMenu = new JuegosMenu(sc);
		
		// Llama al método start() de JuegosMenu para iniciar el menú de juegos.
		jMenu.start();
	}

}
