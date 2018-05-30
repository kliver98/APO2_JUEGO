package hilos;
import interfaz.*;
import modelo.*;
public class HiloOzaru extends Thread {

	/**
	 * Atributo que representa las veces que se ha activado el hilo.<br>
	 */
	private VentanaPrincipal ventana;
	private Juego juego;
	
	public HiloOzaru(VentanaPrincipal ventana, Juego juego) {
		this.ventana = ventana;
		this.juego = juego;
	}
	
	public void run() {
		while(juego.isGokuVivo()) {
			if (juego.getOzaru()!=null) {
				
				Ozaru ozaru = (Ozaru) juego.getOzaru();
				ozaru.moverPosY(Ozaru.AVANCE_OZARU);
				
				for (int j = 0; j < ozaru.getPoderes().size(); j++) {
					Poder poder = ozaru.getPoderes().get(j);
					
					if (poder!=null) {
						poder.moverPoderEnemigo(Ozaru.AVANCE_PODER);
						
						if(poder.getPosX()<=0) 
							ozaru.getPoderes().remove(j);
						
						juego.verificarDanioEnemigosOzaru(ozaru, poder, j);
					}
				}
				if (ozaru.getPoder()!=null) {
					ozaru.getPoder().moverPoderEnemigo(Ozaru.AVANCE_PODER+5);
					juego.verificarDanioEnemigosOzaru(ozaru, ozaru.getPoder(), 0);
				}
			
				juego.verificarDanioInstantaneoJefe(ozaru);
			}
			else {
				juego.verificarCreacionPrimerJefe();
			}
			try {
				sleep(30);
				if (!juego.isGokuVivo()) 
					this.interrupt();
			} catch (InterruptedException e) {
			}
			
		}
	}
}
