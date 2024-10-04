package mains;

import models.BotellaDeAgua;

public class Main1 {
	public static void main(String[] args) {
		
		double b = Calculos.sumar(1, 20);
		
		BotellaDeAgua bot1 = new BotellaDeAgua(1);
		
		BotellaDeAgua bot2 = BotellaDeAgua.getVacia();
	}
}
