package hilos;

import javax.swing.JOptionPane;

import interfaz.VentanaPrincipal;
import modelo.Juego;

public class HiloVerificarJuego extends Thread{
	
	/**
	 * Atributo que representa la relación con la clase principal de la interfaz de usuario.<br>
	 */
	private VentanaPrincipal ventana;
	
	/**
	 * Atributo que representa la relación con la clase principal del modelo.<br>
	 */
	private Juego juego;
	
	public HiloVerificarJuego(VentanaPrincipal ventana, Juego juego) {
		this.ventana = ventana;
		this.juego = juego;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(1000);
				
//				ventana.getPanelHabilidades().repaint();
//				ventana.repaint();
				if (!juego.isGokuVivo()) {
					JOptionPane.showConfirmDialog(ventana, "Juego Terminado", "Game Over", JOptionPane.DEFAULT_OPTION);
					ventana.setVisible(false);
					
//					System.out.println("asd");
					juego.crearNuevaPartida();
					sleep(1000);	
					ventana.nuevoJuego();
					sleep(1000);	
				}
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}

}
