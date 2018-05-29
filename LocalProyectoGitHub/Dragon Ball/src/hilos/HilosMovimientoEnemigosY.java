package hilos;

import java.util.ArrayList;

import interfaz.VentanaPrincipal;
import modelo.EnemigoBasico;
import modelo.Juego;
import modelo.Personaje;

/**
 * Clase que representa el hilo que mueve a los enemigos en el eje y.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class HilosMovimientoEnemigosY extends Thread{

	/**
	 * Relacion con la ventana principal<br>
	 */
	private VentanaPrincipal ventana;
	/**
	 * Relacion con la clase del jugeo<br>
	 */
	private Juego juego;
	/**
	 * Atributo que representa la velocidad que se mueve el enemigo en el eje y<br>
	 */
	private int velocidad;
	
	/**
	 * Construye un HiloMovimientoEnemigosY<br>
	 * @param ventana - Clase principal de la interfaz de usuario.<br>
	 * @param juego - Clase principal del modelo.<br>
	 */
	public HilosMovimientoEnemigosY(VentanaPrincipal ventana, Juego juego) {
		this.ventana = ventana;
		this.juego = juego;
	}
	
	/**
	 * Metodo que inicia el hilo<br>
	 */
	public void run() {
		while(true) {
			for (int i = 0; i < juego.getEnemigos().size(); i++) {
				EnemigoBasico enemigo = (EnemigoBasico) juego.getEnemigos().get(i);
				velocidad = enemigo.getVelocidad();
				
				((EnemigoBasico)enemigo).moverPosY(velocidad);
				
				juego.verificarDanioInstantaneo(enemigo, i);
			}
			
			try {
				sleep(20);
			} catch (InterruptedException e) {
			}
		}
		
	}
}
