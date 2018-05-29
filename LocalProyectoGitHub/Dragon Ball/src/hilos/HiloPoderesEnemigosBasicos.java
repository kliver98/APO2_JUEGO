package hilos;

import interfaz.VentanaPrincipal;
import modelo.*;

/**
 * Clase que representa el hilo de los poderes de los enemigos basicos.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class HiloPoderesEnemigosBasicos extends Thread {

	/**
	 * Relacion con la ventana principal<br>
	 */
	private VentanaPrincipal ventana;
	/**
	 * Relacion con la clase Juego<br>
	 */
	private Juego juego;
	/**
	 * Atributo que representa el movimiento de los poderes de los enemigos basicos<br>
	 */
	private int movimiento;
	
	/**
	 * Construye un HiloPoderesEnemigosBasicos<br>
	 * @param ventana - Clase principal de la interfaz de usuario.<br>
	 * @param juego - Clase principal del modelo.<br>
	 * @param movimiento - Valor en que se movera el personaje.<br>
	 */
	public HiloPoderesEnemigosBasicos(VentanaPrincipal ventana, Juego juego, int movimiento) {
		this.ventana = ventana;
		this.juego = juego;
		this.movimiento = movimiento;
	}
	
	/**
	 * Metodo que ejecuta el hilo<br>
	 */
	public void run() {
		while(true) {
			for (int i = 0; i < juego.getEnemigos().size(); i++) {
				EnemigoBasico enemigo = (EnemigoBasico) juego.getEnemigos().get(i);
				
				for (int j = 0; j < enemigo.getPoderes().size(); j++) {
					Poder poder = enemigo.getPoderes().get(j);
					
					if (poder!=null) {
						poder.moverPoderEnemigo(movimiento);
						
						if(poder.getPosX()<=0) 
							enemigo.getPoderes().remove(j);
					}
//					else {
//						enemigo.getPoderes().remove(j);
//					}
					juego.verificarDanioEnemigos(enemigo, poder, j);
				}
			}
			
			try {
				sleep(5);
			} catch (InterruptedException e) {
			}
			
		}
	}
}
