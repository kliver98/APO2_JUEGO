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
	public static final int POS_Y = 300;
	
	/**
	 * Constante que representa la vida del ozaru.<br>
	 */
	public static final int VIDA_OZARU = 500;
	
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
	 * Constante que representa la cantidad en que movera el poder de Goku.<br>
	 */
	public static final int AVANCE_OZARU = 2;
	
	/**
	 * constate que representa un entero de que valor debe tomar algo para generar nuevos poderes. 
	 */
	public static final int GENERAR_PODER_GRANDE = 500;
	
	/**
	 * Atributo para cambiar la animacion del mono
	 */
	private int contador;

	/**
	 * Atributo para lanzar poderes
	 */
	private int contadorPoderes;

	/**
	 * Atributo para lanzar poder fuerte.
	 */
	private int contadorPoderFuerte;
	
	/**
	 * Atributo tipo boolean para saber si el enemigo tiene que subir o bajar en el mapa.
	 */
	private boolean movimientoContrario;
	
	/**
	 * Método constructor de la clase ozaru.<br>
	 * @param imagen - cadena de caracteres que representan la imagen del ozaru.<br>
	 * @param posX - representa la posición del ozaru en el eje x.<br>
	 * @param posY - representa la posición del ozaru en el eje y.<br>
	 * @param vida - representa la vida del ozaru.<br>
	 */
	public Ozaru(String imagen, int posX, int posY, int vida) {
		super(imagen, posX, posY, vida);
		movimientoContrario = false;
		contador = 0;
		contadorPoderes = 0;
	}

	/**
	 * Método que crea el poder del primer jefe del juego.<br>
	 */
	public void crearPoderesOzaru() {
		int x = Ozaru.ORIGEN_PODER_X;
		int y = Ozaru.ORIGEN_PODER_Y;
		int danio = Ozaru.DANIO_PODER_OZARU;
		String imagen = Ozaru.PODER_OZARU;
		Poder poderOzaru = new Poder(imagen, getPosX()-x, getPosY()-y, true, danio);
		getPoderes().add(poderOzaru);
	}
	
	/**
	 * Método que crea el poder del primer jefe del juego.<br>
	 */
	public void crearPoderesOzaruFuerte() {
		int x = Ozaru.ORIGEN_PODER_X;
		int y = Ozaru.ORIGEN_PODER_Y;
		int danio = Ozaru.DANIO_PODER_OZARU_FUERTE;
		String imagen = Ozaru.PODER_OZARU_FUERTE;
		Poder poderOzaru = new Poder(imagen, getPosX()-x, getPosY()-y, true, danio);
		setPoder(poderOzaru);
	}

	@Override
	public void moverPosY(int mover) {
		setPosY(mover);
		
		contadorPoderes++;
		contadorPoderFuerte++;
		
		//Tiempo de generar nuevos poderes
		int ramdon = (int) Math.floor(Math.random()*(60-30+1)+30); //M = 30, N = 60, random entre 30 y 60
		if (contadorPoderes>=ramdon) {
			crearPoderesOzaru();
			contadorPoderes = 0;
			cambiarImagenOzaru();
		}
		if (contadorPoderFuerte==GENERAR_PODER_GRANDE) {
			crearPoderesOzaruFuerte();
			cambiarImagenOzaru();
		}
		
	}
	
	public void cambiarImagenOzaru() {
		if(super.getImagen().equals(MONO_1)) 
			super.setImagen(MONO_2);
		
		else 
			super.setImagen(MONO_1);
	}

	@Override
	public void moverPosX(int mover) {
	}
	
	@Override
	public void setPosY(int posY) {
		if (super.getPosY()>=350) 
			movimientoContrario = true;
		
		if(super.getPosY()<=0) 
			movimientoContrario = false;
		
		if (movimientoContrario) 
			super.setPosY(-posY);
		else 
			super.setPosY(posY);
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getContadorPoderes() {
		return contadorPoderes;
	}

	public void setContadorPoderes(int contadorPoderes) {
		this.contadorPoderes = contadorPoderes;
	}

	public int getContadorPoderFuerte() {
		return contadorPoderFuerte;
	}

	public void setContadorPoderFuerte(int contadorPoderFuerte) {
		this.contadorPoderFuerte = contadorPoderFuerte;
	}

}
