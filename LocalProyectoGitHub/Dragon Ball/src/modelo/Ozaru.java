package modelo;

public class Ozaru extends Personaje {

	/**
	 * Constante que representa la primera imagen del ozaru.<br>
	 */
	public static final String MONO_1 = "datos/personajes/monoGigante0.png";
	
	/**
	 * Constante que representa la segunda imagen del ozaru.<br>
	 */
	public static final String MONO_2 = "datos/personajes/monoGigante1.png";
	
	/**
	 * Constante que representa la posición del ozaru en el eje x.<br>
	 */
	public static final int POS_X = 1000;
	
	/**
	 * Constante que representa la posición del ozaru en el eje y.<br>
	 */
	public static final int POS_Y = 500;
	
	/**
	 * Constante que representa la vida del ozaru.<br>
	 */
	public static final int VIDA_OZARU = 500;
	
	/**
	 * Constante que representa el origen del poder de Goku en el eje X.<br>
	 */
	
	public static final int ORIGEN_PODER_X = 1000;
	/**
	 * Constante que representa el origen del poder de Goku en el eje Y.<br>
	 */
	
	public static final int ORIGEN_PODER_Y = 500;
	
	/**
	 * Constante que representa la cantidad en que movera el poder de Goku.<br>
	 */
	public static final int AVANCE_PODER = 5;
	
	/**
	 * 
	 * @param imagen
	 * @param posX
	 * @param posY
	 * @param vida
	 */
	public Ozaru(String imagen, int posX, int posY, int vida) {
		super(imagen, posX, posY, vida);
	}

	@Override
	public void moverPosY(int mover) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverPosX(int mover) {
		// TODO Auto-generated method stub
		
	}

}
