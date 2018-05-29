package modelo;

import java.util.ArrayList;

/**
 * Clase que representa los personajes del juego.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public abstract class Personaje implements Poderes {

	/**
	 * Constante que representa la velocidad con que se mueve a la izquierda en el eje x<br>
	 */
	public static final int MOVER_IZQ_X = -1;
	/**
	 * Constante que representa la velocidad con que se mueve a la derecha en el eje x<br>
	 */
	public static final int MOVER_DER_X = 1;
	/**
	 * Constante que representa la velocidad con que se mueve aarriba en el eje y<br>
	 */
	public static final int MOVER_ARRIBA_Y = -1;
	/**
	 * Constante que representa la velocidad con que se mueve abajo en el eje y<br>
	 */
	public static final int MOVER_ABAJO_Y = 1;
	/**
	 * Atributo que representa la imagen del personaje en cadena de caracteres.<br>
	 */
	private String imagen;
	/**
	 * Atributo que representa la posición en el eje x del personaje.<br>
	 */
	private int posX;
	/**
	 * Atributo que representa la posición en el eje y del personaje.<br>
	 */
	private int posY;
	/**
	 * Atributo que representa si el personaje se esta moviendo.<br>
	 */
	private boolean moviendo;
	/**
	 * Relación del personaje con su poder.<br>
	 */
	private Poder poder;
	/**
	 * Atributo que representa los poderes que lanza el enemigo.<br>
	 */
	private ArrayList<Poder> poderes;
	/**
	 * Atributo que permite saber si el personaje lanza un poder.<br>
	 */
	private boolean poderActivado;
	/**
	 * Atributo que permite aumentar el poder del personaje.<br>
	 */
	private int aumentarPoder;
	/**
	 * Atributo que representa la vida del personaje.
	 */
	private int vida;
	/**
	 * Atributo que representa el ancho del personaje<br>
	 */
	private int ancho;
	/**
	 * Atributo que representa el alto del personaje<br>
	 */
	private int alto;
	
	/**
	 * Contructor de la clase Personaje.<br>
	 * @param imagen - Ruta que representa la imagen del personaje.<br>
	 * @param posX - Representa la posición en el eje X del personaje.<br>
	 * @param posX - Representa la posición en el eje Y del personaje.<br>
	 */
	public Personaje(String imagen, int posX, int posY, int vida) {
		this.imagen = imagen;
		this.posX = posX;
		this.posY = posY;
		this.setVida(vida);
		poderActivado = false;
		setPoderes(new ArrayList<Poder>());
	}

	/**
	 * Método que da la ruta de la imagen del personaje. 
	 * @return ruta de la imagen.
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Método que modificar la imagen del personaje.
	 * @param imagen - Nueva ruta de imagen.
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Método que devuelve la posición del personaje en el eje X.<br>
	 * @return posición del personaje en el eje X.<br>
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Método que modifica la posición en el eje X del personaje.<br>
	 * <b>post: </b>Se modifica el valor de posX.<br>
	 * @param posX - Nueva valor en el eje X.<br>
	 */
	public void setPosX(int posX) {
		if((this.posX += posX)<=0) {
			this.posX = 0;
		}
		else if((this.posX += posX)>=1150) {
			this.posX = 1150;
		}
		else {
			this.posX += posX;
		}
	}

	/**
	 * Método que devuelve la posición en el eje Y del personaje<br>
	 * @return posición del personaje en el eje Y<br>
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Método que modifica la posición en el eje Y del personaje.<br>
	 * <b> post: </b>Se modifica el valor de posY.<br>
	 * @param posY - Nuevo valor en el eje Y.<br>
	 */
	public void setPosY(int posY) {
		if((this.posY += posY)<=0) {
			this.posY = 0;
		}
		else if((this.posY += posY)>=450) {
			this.posY = 450;
		}
		else {
			this.posY += posY;
		}
	}
	
	/**
	 * Método que modifica la posición en el eje Y del personaje haciendolo mover.<br>
	 * <b>post: </b>Se modifica el valor del atributo posY.<br>
	 * @param mover - Número en que se va a mover el personaje en el eje Y.<br>
	 */
	public abstract void moverPosY(int mover); 
	
	/**
	 * Método que modifica la posición en el eje X del personaje haciendolo mover.<br>
	 * <b>post: </b>Se modifica el valor del atributo posX.<br>
	 * @param mover - Número en que se va a mover el personaje en el eje X.<br>
	 */
	public abstract void moverPosX(int mover);
	
	/**
	 * Metodo que devuelve el boolean si se esta moviendo<br>
	 * @return moviendo del personaje<br>
	 */
	public boolean isMoviendo() {
		return moviendo;
	}

	/**
	 * Metodo que modifica el movimiento del personaje<br>
	 * @param moviendo con el nuevo valor del boolean a cambiar<br>
	 */
	public void setMoviendo(boolean moviendo) {
		this.moviendo = moviendo;
	}

	/**
	 * Metodo que calcula el ancho de la imagen y el alto de la imagen<br> //No se que mas poner porque no han implementado nada :v
	 * @param anchoImagen con el valor del ancho de la imagen<br>
	 * @param altoImagen con el valor del alto de la imagen<br>
	 */
	public void calcularAnchoAlto(int anchoImagen, int altoImagen) {
		
	}
	
	/**
	 * Método que da la ruta de la imagen del poder del personaje.<br>
	 * @return cadena de caracteres de la ruta de la imagen.<br>
	 */
	public Poder getPoder() {
		return poder;
	}

	/**
	 * Método que modifica el poder del personaje.<br>
	 *<b>post :</b>Se modifica el objeto del atributo poder.<br>
	 * @param poder - nueva poder del personaje.<br>
	 */
	public void setPoder(Poder poder) {
		this.poder = poder;
	}

	/**
	 * Método que dice que si el poder del personaje esta activado.<br>
	 * @return valor de verdad del atributo poderActivado.<br>
	 */
	public boolean isPoderActivado() {
		return poderActivado;
	}

	/**
	 * Método que modifica si el poder del personaje se encuentra activado.<br>
	 * @param poderActivado - nuevo valor de verdad.<br>
	 */
	public void setPoderActivado(boolean poderActivado) {
		this.poderActivado = poderActivado;
	}	
	
	/**
	 * Método que permite dar el aumento de poder de Son Goku.<br>
	 * @return número entero que permite saber si se aumenta el poder o no.<br>
	 */
	public int getAumentarPoder() {
		return aumentarPoder;
	}
	
	/**
	 * Método que modifica el número entero para aumentar el poder del personaje.<br>
	 * <b>post: </b>Se modifica el valor del atributo "aumentarPoder".<br>
	 * @param aumentarPoder - nuevo número entero para el aumento de poder.<br>
	 */
	public void setAumentarPoder(int aumentarPoder) {
		if(aumentarPoder == 0) {
			this.aumentarPoder = 0;
		}
		else {
			this.aumentarPoder += aumentarPoder;
		}
	}

	/**
	 * Metodo que modifica el perimetro del personaje<br>
	 * @param ancho con el nuevo valor del ancho del personaje<br>
	 * @param alto con el nuevo valor del alto del personaje<br>
	 */
	public void setPerimetro(int ancho, int alto) {
		setAlto(alto);
		setAncho(ancho);
	}
	
	/**
	 * Metodo que devuelve el arraylist de los poderes del personaje<br>
	 * @return poderes del personaje<br>
	 */
	public ArrayList<Poder> getPoderes() {
		return poderes;
	}

	/**
	 * Metodo que modifica los poderes del personaje<br>
	 * @param poderes con los nuevos poderes a modificar<br>
	 */
	public void setPoderes(ArrayList<Poder> poderes) {
		this.poderes = poderes;
	}

	/**
	 * Metodo que devuelve la vida del personaje<br>
	 * @return vida del personaje<br>
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Metodo que modifica la vida del personaje<br>
	 * @param vida con el nuevo valor de la vida del personaje<br>
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Metodo que devuelve el ancho del personaje<br>
	 * @return ancho del personaje<br>
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Metodo que modifica el ancho del personaje<br>
	 * @param ancho con el nuevo valor a modifciar<br>
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * Metodo que devuelve el alto del personaje<br>
	 * @return alto del personaje<br>
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * Metodo que modifica el alto del personaje<br>
	 * @param alto con el nuevo alto del personaje<br>
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}
}
