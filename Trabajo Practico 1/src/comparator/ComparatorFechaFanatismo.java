package comparator;

import java.util.Comparator;

import models.FechaFestiva;

public class ComparatorFechaFanatismo implements Comparator <FechaFestiva> {

	@Override
	public int compare(FechaFestiva o1, FechaFestiva o2) {
		double primerFecha = o1.getFanatismo();
		double segundaFecha = o2.getFanatismo();
		int resultado = Double.compare(primerFecha, segundaFecha);
		return resultado;
	}

}
