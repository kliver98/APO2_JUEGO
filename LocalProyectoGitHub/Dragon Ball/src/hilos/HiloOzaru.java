package hilos;
import interfaz.*;
import modelo.*;
public class HiloOzaru extends Thread {

	/**
	 * Atributo que representa las veces que se ha activado el hilo.<br>
	 */
	private int contador;
	private VentanaPrincipal ventana;
	private Juego juego;
	
	public HiloOzaru(VentanaPrincipal ventana, Juego juego) {
		this.ventana = ventana;
		this.juego = juego;
		contador = 0;
	}
	
	public void run() {
		if(contador == 1) {
			
		}
	}
}
