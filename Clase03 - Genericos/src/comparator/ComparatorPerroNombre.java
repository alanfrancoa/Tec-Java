package comparator;

import java.util.Comparator;

import models.Perro;

public class ComparatorPerroNombre implements Comparator<Perro> {

    @Override
    public int compare(Perro o1, Perro o2) {
        // Se obtienen los nombres de los perros a comparar.
        String nombre1 = o1.getNombre();
        String nombre2 = o2.getNombre();
        
        // Se compara los nombres ignorando las diferencias entre mayúsculas y minúsculas.
        return nombre1.compareToIgnoreCase(nombre2);
    }

}
