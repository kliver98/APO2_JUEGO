package modelo;

/**
 * Clase que representa al personaje Son Goku.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class Goku extends Personaje{
	
	/**
	 * Constante que representa la imagen del personaje principal.<br>
	 */
	public static final String GOKU = "datos/personajes/kidGoku0.png";
	/**
	 * Constante que representa la vida del personaje.<br>
	 */
	public static final int GOKU_VIDA = 1000;
	/**
	 * Constante que representa una segunda imagen del personaje principal.<br>
	 */
	public static final String GOKU1 = "datos/personajes/kidGoku1.png";
	/**
	 * 
	 */
	public static final String IMAGEN_VIDA = "datos/personajes/ImageGoku.png";
	/**
	 * Constante que representa el origen del poder de Goku en el eje X.<br>
	 */
	public static final int ORIGEN_PODER_X = 30;
	/**
	 * Constante que representa el origen del poder de Goku en el eje Y.<br>
	 */
	public static final int ORIGEN_PODER_Y = -30;
	/**
	 * Constante que representa la cantidad en que movera el poder de Goku.<br>
	 */
	public static final int AVANCE_PODER = 5;
	
	/**
	 * Constructor de la clase Goku.<br>
	 * @param imagen - Ruta de la imagen del personaje.<br>
	 * @param posX - Representa la posición en el eje X del personaje.<br>
	 * @param posX - Representa la posición en el eje Y del personaje.<br>
	 */
	public Goku(String imagen, int posX, int posY, int vida) {
		super(imagen, posX, posY, vida);
		setMoviendo(false);
	}

	/**
	 * Metodo sobreescrito que mueve la posicion y de goku<br>
	 */
	@Override
	public void moverPosY(int mover) {
		super.setPosY(mover);	
	}

	/**
	 * Metodo sobreescrito que mueve la posicion x de goku<br>
	 */
	@Override
	public void moverPosX(int mover) {
		super.setPosX(mover);
	}
	
	/**
	 * Metodo sobreescrito que modifica el poder de goku<br>
	 * @param aumentarPoder con el nuevo valor del poder a aumentar<br>
	 */
	@Override
	public void setAumentarPoder(int aumentarPoder) {
		int temp = super.getAumentarPoder() + aumentarPoder;
		if(temp >= 850) {
			super.setAumentarPoder(0);
		}
		else {
			super.setAumentarPoder(aumentarPoder);
		}
	}
}
