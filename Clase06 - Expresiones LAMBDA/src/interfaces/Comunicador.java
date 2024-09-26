package interfaces;

public interface Comunicador {

	    public void enviar(String mje);

	    public abstract String recibir();

	    public default int sumar(int a, int b) {
	        return a + b;
	    }

	    public default void saludar() {
	        this.enviar("Hola");    
	    }
	}
