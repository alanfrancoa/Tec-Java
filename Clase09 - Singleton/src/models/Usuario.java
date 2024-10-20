package models;

public class Usuario {
	
	// Atributo estático que contendrá la única instancia de la clase.
	private static Usuario unico;
	
	// Método estático para obtener la instancia única del objeto (patrón Singleton).
	public static Usuario getInstance() {
		// Si no existe una instancia, se crea una nueva.
		if(unico == null) {
			unico = new Usuario();			
		}
		// Devuelve la instancia única.
		return unico;
	}
	
	// Método para crear una instancia de Usuario. Similar a getInstance, pero no devuelve nada.
	public static void crearUsuario() {
		// Si no existe una instancia, se crea una nueva.
		if(unico == null) {
			unico = new Usuario();
		}
	}
	
	// Atributos de instancia (no estáticos), propios de cada Usuario.
	private String nombre;  // Almacena el nombre del usuario.
	private int puntos;     // Almacena los puntos del usuario.
	
	// Constructor privado para evitar que se creen objetos directamente.
	private Usuario() { }
	
	// Métodos getter y setter para acceder y modificar el nombre.
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Métodos getter y setter para acceder y modificar los puntos.
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	// Método para sumar puntos al usuario. El parámetro delta indica cuántos puntos se suman.
	public void addPuntos(int delta) {
		this.puntos += delta;
	}
}
