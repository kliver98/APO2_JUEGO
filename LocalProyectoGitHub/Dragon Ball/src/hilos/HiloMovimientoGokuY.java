package hilos;
import interfaz.VentanaPrincipal;
import modelo.Juego;

/**
 * Clase que representa el hilo que mueve al personaje goku en el eje Y.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class HiloMovimientoGokuY extends Thread{
	
	/**
	 * Atributo que representa la relación con la clase principal de la interfaz de usuario.<br>
	 */
	private VentanaPrincipal ventana;
	
	/**
	 * Atributo que representa la relación con la clase principal del modelo.<br>
	 */
	private Juego juego;
	
	/**
	 * Atributo que representa la cantidad en que se va a mover el personaje.<br>
	 */
	private int valorMovimiento;
	
	/**
	 * Contructor de la clase HiloMovimientoFondo.<br>
	 * @param ventana - Clase principal de la interfaz de usuario.<br>
	 * @param juego - Clase principal del modelo.<br>
	 * @param valorMovimiento - Valor en que se movera el personaje.<br>
	 */
	public HiloMovimientoGokuY(VentanaPrincipal ventana, Juego juego, int valorMovimiento) {
		this.ventana = ventana;
		this.juego = juego;
		this.valorMovimiento = valorMovimiento;
	}
	
	/**
	 * Método que ejecuta el hilo.<br>
	 */
	public void run() {
		while(juego.getPrincipal().isMoviendo()) {
			ventana.modificarPosYGoku(valorMovimiento);
			try {
				sleep(15);
				if(juego.getPrincipal().isMoviendo() == false) {
					this.interrupt();
				}
				else {
					ventana.refrescarJuego();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
