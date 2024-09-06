package comparator;

import java.util.Comparator;

import models.FechaFestiva;

public class ComparatorFechaDia implements Comparator <FechaFestiva>{

	@Override
	public int compare(FechaFestiva o1, FechaFestiva o2) {
		int primerFecha = o1.getDia();
		int segundaFecha = o2.getDia();
		int resultado = Integer.compare(primerFecha, segundaFecha);
		return resultado;
	}

}
