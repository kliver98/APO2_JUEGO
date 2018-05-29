package modelo;

/**
 * Clase que representa el fondo del videojuego.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.<br>
 *
 */
public class Fondo {
	
	/**
	 * Constante que representa la imagen del fondo..<br>
	 */
	public static final String FONDO = "datos/auxiliares/fondoCompletar.png";
	/**
	 * Atributo que representa la ruta de la imagen del fondo del videojuego.<br>
	 */
	private String imagen;
	/**
	 * Atributo que representa la posición en el eje X en el que se pintara el fondo del videojuego.<br>
	 */
	private int x;
	/**
	 * Constructor de la clase fondo.<br>
	 * @param imagen - Ruta de la imagen del fondo del videojuego.<br>
	 * @param x - Posición en el eje X en el que se pintaje el fondo del videojuego.<br>
	 */
	public Fondo(String imagen, int x) {
		this.imagen = imagen;
		this.x = x;
	}

	/**
	 * Método que la posición del fondo en el eje X.<br>
	 * @return valor del atributo x.<br>
	 */
	public int getX() {
		return x;
	}

	/**
	 * Método que da la ruta de la imagen del fondo.<br>
	 * @return cadena de caracteres que contiene la ruta de la imagen del fondo.<br>
	 */
	public String getImagen() {	
		return imagen;
	}
	
	/**
	 * Método que se encarga de mover el fondo del videojuego.<br>
	 * <b>post: </b>Se modifica el valor del atributo x.<br>
	 */
	public void moverFondo() {
		x -= 1;
		if(x == -1200) {
			x = 1200;
		}
	}
}
