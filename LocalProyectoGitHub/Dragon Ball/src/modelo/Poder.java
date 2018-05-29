package modelo;

/**
 * Clase que representa el poder de cada uno de los personajes.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.<br>
 *
 */
public class Poder {
	
	/**
	 * Constante que representa la animacion del poder de un robot<br>
	 */
	private static final int ANIMACION_PODER_ROBOT = 100;
	/**
	 * Atributo que representa la ruta de la imagen del poder.<br>
	 */
	private String poder;
	/**
	 * Atributo que representa la posición en el eje X del juego en el que se crea el poder.<br>
	 */
	private int posX;
	/**
	 * Atributo que representa la posición en el eje Y del juego en el que se crea el poder.<br>
	 */
	private int posY;
	/**
	 * Atributo que representa si el poder ha sido activado.<br>
	 */
	private boolean activado;
	/**
	 * Atributo que representa el ancho del poder<br>
	 */
	private int ancho;
	/**
	 * Atributo que representa el alto del poder<br>
	 */
	private int alto;
	/**
	 * Atributo tipo entero que representa cada cuento cambiara la animacion.
	 */
	private int intercalarPoderRobotAnimacion;
	/**
	 * Atributo que representa cuanto daño hara el enmigo.
	 */
	private int danio;
	
	/**
	 * Constructor de la clase Poder.<br>
	 * @param poder - cadena de caracteres que representa la imagen del poder.<br>
	 * @param posX - posición en el eje X del juego en el que se crea el poder.<br>
	 * @param posY - posición en el eje Y del juego en el que se crea el poder.<br>
	 * @param activado - valor de verdad si el poder esta activado.<br>
	 */
	public Poder(String poder, int posX, int posY, boolean activado, int danio) {
		this.poder = poder;
		this.posX = posX;
		this.posY = posY;
		this.activado = activado;
		this.setDanio(danio);
		intercalarPoderRobotAnimacion = 0;
	}

	/**
	 * Método que da la posición en el eje X del poder.<br>
	 * @return posición en el eje X.<br>
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Método que modifica la posición en el eje X en la que se encuentra el poder.<br>
	 * <b>post: </b>Se modifica el valor del atributo posX.<br>
	 * @param posX - nueva posición en el eje X.<br>
	 */
	public void setPosX(int posX) {
		this.posX += posX;
	}

	/**
	 * Método que da la posición en el eje Y del poder.<br>
	 * @return posición en el eje Y.<br>
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Método que da el estado del valor de si esta activado o no el poder.<br>
	 * @return valor de verdad.<br>
	 */
	public boolean isActivado() {
		return activado;
	}

	/**
	 * Método que modifica el estado del valor de si esta activado o no el poder.<br>
	 * <b>post: </b>Se modifica el valor de verdad del atributo "activado".<br>
	 * @param activado - nuevo valor de verdad.<br>
	 */
	public void setActivado(boolean activado) {
		this.activado = activado;
	}
	
	/**
	 * Método que permite saber si el personaje esta lanzando un poder.<br>
	 * @return valor de verdad.<br>
	 */
	public boolean isPoderActivado() {
		return activado;
	}

	/**
	 * Método que permite modifica el estado del personaje para lanzar un poder.<br>
	 * <b>post: </b>Se modifica el valor de verdad del atributo poderActivado.<br>
	 * @param poderActivado - valor de verdad.<br>
	 */
	public void setPoderActivado(boolean poderActivado) {
		this.activado = poderActivado;
	}

	/**
	 * Método que da la ruta de la imagen del poder.<br>
	 * @return cadena de caracteres que contiene la ruta de la imagen del poder.<br>
	 */
	public String getPoder() {
		return poder;
	}

	/**
	 * Método que modifica la ruta de la imagen del poder.<br>
	 * <b>post: </b>Se modifica la cadena de caracteres del atributo "poder".<br>
	 * @param poder - nueva ruta de imagen.<br>
	 */
	public void setPoder(String poder) {
		this.poder = poder;
	}

	/**
	 * Metodo que devuelve el ancho del poder<br>
	 * @return ancho del poder<br>
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Metodo que modifica el ancho del poder<br>
	 * @param ancho con el nuevo ancho del poder<br>
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * Metodo que devuelve el alto del poder<br>
	 * @return alto del poder<br>
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * Metodo que modifica el alto del poder<br>
	 * @param alto del poder<br>
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	/**
	 * Metodo que modificia el perimetro del poder<br>
	 * @param alto con el valor del alto a modificar<br>
	 * @param ancho con el valor del ancho a modifcar<br>
	 */
	public void setPerimetro(int alto, int ancho) {
		setAlto(alto);
		setAncho(ancho);
	}
	
	/**
	 * Metodo que devuelve el danio del poder<br>
	 * @return danio del poder<br>
	 */
	public int getDanio() {
		return danio;
	}

	/**
	 * Metodo que modifica el danio del poder<br>
	 * @param danio<br>
	 */
	public void setDanio(int danio) {
		this.danio = danio;
	}

	/**
	 * Metodo que se encarga de mover el poder enemigo<br>
	 * @param movimiento entero que representa cuanto se va a mover en el eje x.<br>
	 */
	public void moverPoderEnemigo(int movimiento) {
		this.posX -= movimiento;
		
		intercalarPoderRobotAnimacion++;
		
		if (intercalarPoderRobotAnimacion==ANIMACION_PODER_ROBOT) 
			intercalarAnimacionPoderRobot();
	}
	
	/**
	 * Metodo que intercala las imagenes del poder del robot<br>
	 */
	public void intercalarAnimacionPoderRobot() {
		if (poder.equals(Personaje.PODER_ROBOT_1)) 
			poder = Personaje.PODER_ROBOT_2;
		
		else if (poder.equals(Personaje.PODER_ROBOT_2)) 
			poder = Personaje.PODER_ROBOT_1;
		
		intercalarPoderRobotAnimacion = 0;
	}
	
	/**
	 * Metodo que verifica el poder para para saber si ya se salio de los limites del panel y asi lo desactiva<br>
	 */
	public void verificarPoder() {
		if (posX>=1200) {
			setActivado(false);
		}
	}
}
