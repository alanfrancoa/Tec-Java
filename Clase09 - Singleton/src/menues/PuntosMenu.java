package menues;

import java.util.Scanner;  // Importa la clase Scanner para manejar la entrada de datos.
import interfaces.MenuIniciable;  // Importa la interfaz que define el comportamiento del menú.
import models.Usuario;  // Importa la clase Usuario, que sigue el patrón Singleton.

public class PuntosMenu implements MenuIniciable {

	// Atributo para almacenar la instancia del Usuario.
	private Usuario usu;
	// Atributo para manejar la entrada del usuario.
	private Scanner sc;		
	
	// Constructor que recibe un Usuario y un Scanner, e inicializa los atributos correspondientes.
	public PuntosMenu(Usuario usu, Scanner sc) {
		this.usu = usu;  // Asigna el Usuario pasado al atributo de la clase.
		this.sc = sc;  // Asigna el Scanner pasado al atributo de la clase.
	}

	// Implementación del método start, requerido por la interfaz MenuIniciable.
	@Override
	public void start() {
		
		// Muestra al usuario cuántos puntos tiene.
		System.out.println("Hola tenes " + usu.getPuntos());
		// Muestra un menú con una opción para gastar puntos.
		System.out.println("Elegi");
		System.out.println("1 - Consejo millonario 30 puntos");
		
		// Captura la opción seleccionada por el usuario.
		int opcion = sc.nextInt();
		
		// Si el usuario elige la opción 1, se le restan 30 puntos.
		if( opcion == 1 ) {
			usu.addPuntos(-30);  // Resta 30 puntos al Usuario.
			// Muestra un consejo como recompensa por gastar los puntos.
			System.out.println("Al que madruga dios lo ayuda");
		}
	}
}
