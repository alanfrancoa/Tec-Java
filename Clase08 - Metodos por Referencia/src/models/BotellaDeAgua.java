package models;

import java.util.Objects;

public class BotellaDeAgua {
	private double capacidad;
	
	public static BotellaDeAgua getRandom() {
		return new BotellaDeAgua(Math.random() * 5); //techo de 5
	}
	
	public static BotellaDeAgua getVacia() {
		return new BotellaDeAgua(0);
	}
	
	public static int compararPorLitros (BotellaDeAgua b1, BotellaDeAgua b2) {
		return Double.compare(b1.capacidad, b2.capacidad);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(capacidad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BotellaDeAgua other = (BotellaDeAgua) obj;
		return Double.doubleToLongBits(capacidad) == Double.doubleToLongBits(other.capacidad);
	}

	public static boolean estaVacia(BotellaDeAgua b) {
		return b.capacidad == 0;
	}
	
	//Metodo estatico, para poder llamarlo directamente de la clase
	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "BotellaDeAgua [capacidad=" + capacidad + "]";
	}

	public BotellaDeAgua(double capacidad) {
		super();
		this.capacidad = capacidad;
	}
	
	
	
}
