package modelo;

/**
 * Clase que representa el jugador.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class Jugador {

	/**
	 * Atributo que representa el nickname o apodo del jugador.
	 */
	private String nickName;
	/**
	 * Atributo que representa el puntaje obtenido por el jugador.
	 */
	private int puntaje;
	/**
	 * Atributo que representa el nivel logrado por el jugador.
	 */
	private int nivel;
	/**
	 * Atributo que representa otro jugador.
	 */
	private Jugador siguiente;
	
	/**
	 * Constructor de la clase Jugador.
	 * @param nickName - Nombre o apodo del jugador.
	 */
	public Jugador(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Método que da el nickname del jugador.
	 * @return nickname del jugador.
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Método que modificar el nickname del jugador.
	 * @param nickName - Nuevo nombre o apodo.
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Método que da el puntaje del jugador.
	 * @return puntaje del jugador.
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * Método que modifica el puntaje del jugador.
	 * @param puntaje - Nuevo puntaje.
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	/**
	 * Método que da el nivel del jugador.
	 * @return nivel del jugador.
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Método que modifica el nivel del jugador.
	 * @param nivel -  nuevo nivel.
	 */	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Método que da el jugador siguiente.
	 * @return siguiente jugador.
	 */
	public Jugador getSiguiente() {
		return siguiente;
	}
	
	/**
	 * Metodo que modifica el jugador siguiente
	 * @param siguiente - Jugador nuevo
	 */
	public void setSiguiente(Jugador siguiente) {
		this.siguiente = siguiente;
	}
	
}
