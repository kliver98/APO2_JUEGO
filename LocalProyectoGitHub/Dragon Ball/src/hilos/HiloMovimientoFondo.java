package hilos;
import interfaz.VentanaPrincipal;
import modelo.Juego;

/**
 * Clase que representa el hilo que mueve el fondo del videojuego.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class HiloMovimientoFondo extends Thread {
	
	/**
	 * Atributo que representa la relación con la clase principal de la interfaz de usuario.<br>
	 */
	private VentanaPrincipal ventana;
	
	/**
	 * Atributo que representa la relación con la clase principal del modelo.<br>
	 */
	private Juego juego;
	
	/**
	 * Contructor de la clase HiloMovimientoFondo.<br>
	 * @param ventana - Clase principal de la interfaz de usuario.<br>
	 * @param juego - Clase principal del modelo.<br>
	 */
	public HiloMovimientoFondo(VentanaPrincipal ventana, Juego juego) {
		this.ventana = ventana;
		this.juego = juego;
	}
	
	/**
	 * Método que ejecuta el hilo.<br>
	 */
	public void run() {
		while(juego.isGokuVivo()) {
			ventana.refrescarJuego();

			juego.getFondo().moverFondo();
			juego.getAuxiliar().moverFondo();
			try {
				sleep(10);
				if (!juego.isGokuVivo()) 
					this.interrupt();
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}
}
