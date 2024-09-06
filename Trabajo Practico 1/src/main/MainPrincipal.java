package main;
import java.util.ArrayList;
import java.util.List;

import comparator.ComparatorFechaDia;
import comparator.ComparatorFechaFanatismo;
import comparator.ComparatorFechaMes;
import comparator.ComparatorFechaNombre;
import models.FechaFestiva;

public class MainPrincipal {

	public static void main(String[] args) {
		// Creamos instancias de Fechas Festivas.
		FechaFestiva fecha1 = new FechaFestiva(25, 5,"Revolucion de Mayo", 0.8);
		FechaFestiva fecha2 = new FechaFestiva(9, 7,"Dia de la Independencia", 0.8);
		FechaFestiva fecha3 = new FechaFestiva(2, 12,"Cumpleaños de Britney", 0.95);
		FechaFestiva fecha4 = new FechaFestiva(14, 2,"San Valentin", 0.32);
		FechaFestiva fecha5 = new FechaFestiva(20, 6,"Dia de la Bandera", 0.82);
		FechaFestiva fecha6 = new FechaFestiva(24, 3,"Dia de la Memoria", 0.11);
		FechaFestiva fecha7 = new FechaFestiva(21, 5,"Mi cumpleanos", 0.99);
		FechaFestiva fecha8 = new FechaFestiva(25, 12,"Navidad", 0.92);
		FechaFestiva fecha9 = new FechaFestiva(31, 12,"Nochevieja", 0.93);
		FechaFestiva fecha10 = new FechaFestiva(20, 12,"Saturnalia", 0.7);
		
		// Lista para agregar las fechas
		List<FechaFestiva> fechas = new ArrayList<FechaFestiva>();
		
		//Agregar las fechas a la lista
		fechas.add(fecha1);
		fechas.add(fecha2);
		fechas.add(fecha3);
		fechas.add(fecha4);
		fechas.add(fecha5);
		fechas.add(fecha6);
		fechas.add(fecha7);
		fechas.add(fecha8);
		fechas.add(fecha9);
		fechas.add(fecha10);
		
		//Mostramos las fechas por pantalla
		for (FechaFestiva fecha : fechas) {
			System.out.println(fecha);
		}
		
		ComparatorFechaNombre porNombre = new ComparatorFechaNombre();
		fechas.sort(porNombre);
		System.out.println("Fechas ordenadas por nombre: ");
		System.out.println("==================================================");
		//Mostramos las fechas por pantalla
		for (FechaFestiva fecha : fechas) {
			System.out.println(fecha);
		}
		
		fechas.sort(null);
		System.out.println("Fechas ordenadas por dia del año (ordenamiento natural): ");
		System.out.println("==================================================");
		//Mostramos las fechas por pantalla
		for (FechaFestiva fecha : fechas) {
			System.out.println(fecha);
		}
		
		ComparatorFechaDia porDia = new ComparatorFechaDia();
		fechas.sort(porDia);
		System.out.println("Fechas ordenadas por dia del mes: ");
		System.out.println("==================================================");
		//Mostramos las fechas por pantalla
		for (FechaFestiva fecha : fechas) {
			System.out.println(fecha);
		}
		
		ComparatorFechaFanatismo porFanatismo = new ComparatorFechaFanatismo();
		fechas.sort(porFanatismo.reversed());
		System.out.println("Fechas ordenadas por fanatismo: ");
		System.out.println("==================================================");
		//Mostramos las fechas por pantalla
		for (FechaFestiva fecha : fechas) {
			System.out.println(fecha);
		}
		
		ComparatorFechaMes porMes = new ComparatorFechaMes();
		fechas.sort(porMes);
		System.out.println("Fechas ordenadas por mes: ");
		System.out.println("==================================================");
		//Mostramos las fechas por pantalla
		for (FechaFestiva fecha : fechas) {
			System.out.println(fecha);
		}
		
		fechas.sort(porMes.thenComparing(porDia));
		System.out.println("Fechas ordenadas por mes y dia: ");
		System.out.println("==================================================");
		//Mostramos las fechas por pantalla
		for (FechaFestiva fecha : fechas) {
			System.out.println(fecha);
		}
		
		fechas.sort(porFanatismo.thenComparing(porNombre).reversed());
		System.out.println("Fechas ordenadas por fanatismo ascendente y nombre descendente: ");
		System.out.println("==================================================");
		//Mostramos las fechas por pantalla
		for (FechaFestiva fecha : fechas) {
			System.out.println(fecha);
		}
		
		
	}

}
