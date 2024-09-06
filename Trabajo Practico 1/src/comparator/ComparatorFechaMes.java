package comparator;

import java.util.Comparator;

import models.FechaFestiva;

public class ComparatorFechaMes implements Comparator <FechaFestiva> {

	@Override
	public int compare(FechaFestiva o1, FechaFestiva o2) {
		int primerFecha = o1.getMes();
		int segundaFecha = o2.getMes();
		
		int resultado = 0;
		
		if (primerFecha > segundaFecha) {
			resultado = 1;
		} else if (primerFecha < segundaFecha) {
			resultado = -1;
		}
		return resultado;
	}

}
