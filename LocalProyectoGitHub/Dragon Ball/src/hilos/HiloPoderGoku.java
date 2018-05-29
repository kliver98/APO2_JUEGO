package hilos;

import interfaz.VentanaPrincipal;
import modelo.*;

/**
 * Clase que representa el hilo de poder de goku.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class HiloPoderGoku extends Thread {

	/**
	 * Relacion con la ventana principal<br>
	 */
	private VentanaPrincipal ventana;
	
	/**
	 * Relacion con la clase del Juego<br>
	 */
	private Juego juego;
	
	/**
	 * Atributo que representa el movimiento del poder de goku<br>
	 */
	private int movimiento;
	
	/**
	 * Construye un HiloPoderGoku<br>
	 * @param ventana - Clase principal de la interfaz de usuario.<br>
	 * @param juego - Clase principal del modelo.<br>
	 * @param movimiento - Valor en que se movera el poder de goku.<br>
	 */
	public HiloPoderGoku(VentanaPrincipal ventana, Juego juego, int movimiento) {
		this.ventana = ventana;
		this.juego = juego;
		this.movimiento = movimiento;
	}
	
	/**
	 * Metodo que inicia el hilo<br>
	 */
	public void run() {
		while(ventana.poderGoku().isActivado()&&juego.isGokuVivo()) {
			
			ventana.moverPoderGoku(movimiento);
			juego.getPrincipal().setAumentarPoder(movimiento);
			ventana.aumentarPoderGoku();
			
			ventana.poderGoku().verificarPoder();
			
			for (int i = 0; i < juego.getEnemigos().size(); i++) 
				juego.hacerDanioGoku((EnemigoBasico)juego.getEnemigos().get(i), i);
			
			try {
				sleep(15);
				if(ventana.poderGoku().isActivado() == false || ventana.poderGoku().getPosX() > ventana.darTamanioVentana()) 
					this.interrupt();
				else 
					ventana.refrescarJuego();

				if (!juego.isGokuVivo()) 
					this.interrupt();
			} catch (InterruptedException e) {
			}
		}
	}
}
