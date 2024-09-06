package comparator;

import java.util.Comparator;

import models.FechaFestiva;

public class ComparatorFechaNombre implements Comparator <FechaFestiva>{

	@Override
	public int compare(FechaFestiva o1, FechaFestiva o2) {
		String s1 = o1.getNombre();
		String s2 = o2.getNombre();
		int resultado = s1.compareToIgnoreCase(s2);
		return resultado;
	}

}
