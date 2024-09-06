package models;

public class FechaFestiva implements Comparable <FechaFestiva> {
	private int dia;
	private int mes;
	private String nombre;
	private double fanatismo;
	public int getDia() {
		return dia;
	}
	public FechaFestiva(int dia, int mes, String nombre, double fanatismo) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.nombre = nombre;
		this.fanatismo = fanatismo;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getFanatismo() {
		return fanatismo;
	}
	public void setFanatismo(double fanatismo) {
		this.fanatismo = fanatismo;
	}
	@Override
	public String toString() {
		return "FechaFestiva [dia=" + dia + ", mes=" + mes + ", nombre=" + nombre + ", fanatismo=" + fanatismo + "]";
	}
	
	public int getDiasTotales() {
		int cantidadPorMesesCompletos = (this.mes - 1 ) * 30;
		return this.dia + cantidadPorMesesCompletos;
	}
	
	@Override
	public int compareTo(FechaFestiva o) {
		int resultado = 0;
		if (this.getDiasTotales() > o.getDiasTotales()) {
			resultado = 1;
		} else if (this.getDiasTotales() < o.getDiasTotales()) {
			resultado = -1;
		}
					
		return resultado;
	}
	
	
}
