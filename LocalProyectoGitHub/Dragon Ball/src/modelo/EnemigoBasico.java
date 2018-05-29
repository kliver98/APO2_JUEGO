package modelo;

/**
 * Clase que representa a los personajes enemigos.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class EnemigoBasico extends Personaje {
	
	/**
	 * Constante que representa la vida total del enemigo.
	 */
	public static final int VIDA_ENEMIGOS = 5;
	/**
	 * Constante que representa el danio que se hace goku si toca un enemigo.
	 */
	public static final int DANIO_INSTANTANEO = 1000;
	/**
	 * Constante que representa los pixeles que movera en el eje y.S
	 */
	public static final int MOVER_ABAJO_Y = 1;
	/**
	 * Constante que representa los pixeles que movera en el eje y, a una velocidad mayor.
	 */
	public static final int MOVER_ABAJO_Y1 = 2;
	/**
	 * Constante que representa la imagen del primer enemigo.
	 */
	public static final String DEMONIO1 = "datos/personajes/demonio0.png";
	/**
	 * Constante que representa una segunda imagen del primer enemigo.
	 */
	public static final String DEMONIO2 = "datos/personajes/demonio1.png";
	/**
	 * Constante que representa la imagen del segundo enemigo.
	 */
	public static final String ROBOT1 = "datos/personajes/enemigoRobot0.png";
	/**
	 * Constante que representa la imagen del segundo enemigo.
	 */
	public static final String ROBOT2 = "datos/personajes/enemigoRobot1.png";
	/**
	 * Constante que representa la imagen del segundo enemigo.
	 */
	public static final String ROBOT3 = "datos/personajes/enemigoRobot2.png";
	/**
	 * Constante que representa el origen del poder del enemigo en el eje X.<br>
	 */
	public static final int ORIGEN_PODER_X = 30;
	/**
	 * Constante que representa el origen del poder del enemigo en el eje Y.<br>
	 */
	public static final int ORIGEN_PODER_Y = -30;
	/**
	 * Constante que representa la cantidad en que movera el poder del enemigo.<br>
	 */
	public static final int AVANCE_PODER = 3;
	/**
	 * constate que representa un entero de que valor debe tomar algo para generar nuevos poderes. 
	 */
	public static final int GENERAR_NUEVOS_PODERES = 40;
	/**
	 * Constate que representa cada cuanto debe cambiar la animacion
	 */
	public static final int CAMBIO_ANIMACION = 10;
	/**
	 * Atributo tipo boolean para saber si el enemigo tiene que subir o bajar en el mapa.
	 */
	private boolean movimientoContrario;
	/**
	 * Atributo de tipo int para ir contando las veces que se llama esta clase y hacer un cambio en la animacion.
	 */
	private int contador;
	/**
	 * Atributo de tipo int para ir contando las veces que se llama esta clase y hacer un cambio en la animacion.
	 */
	private int contadorPoderes;
	/**
	 * Atributo para saber si es Demonio o robot.
	 */
	private int tipoEnemigo;
	/**
	 * Atributo que representa la velocidad a la que se mueve el enemigo.
	 */
	private int velocidad;
	
	/**
	 * Construye un enemigo basico<br>
	 * @param imagen con la direccion de la imagen del enemigo basico<br>
	 * @param posX con la posicion en el eje x del enemigo basico<br>
	 * @param posY con la posicion en el eje y del enemigo basico<br>
	 * @param tipoEnemigo con valor indicando el tipo de enemigo que es el enemigo basico<br>
	 * @param vida con el valor de la vida que tiene el enemigo basico<br>
	 * @param velocidad con la velocidad que tiene el enemigo basico<br>
	 */
	public EnemigoBasico(String imagen, int posX, int posY, int tipoEnemigo, int vida, int velocidad) {
		super(imagen, posX, posY, vida);
		movimientoContrario = false;
		contador = 0;
		contadorPoderes = 0;
		this.tipoEnemigo = tipoEnemigo;
		this.setVelocidad(velocidad);
	}
	
	/**
	 * Este metodo se encarga de crear poderes nuevos.
	 */
	public void crearPoderes() {
		int x = EnemigoBasico.ORIGEN_PODER_X;
		int y = EnemigoBasico.ORIGEN_PODER_Y;
		String imagenD = EnemigoBasico.PODER_DEMONIO_DEBIL;
		String imagenR = EnemigoBasico.PODER_ROBOT_1;
		int danioD = Poderes.DANIO_DEMONIO;
		int danioR = Poderes.DANIO_ROBOT;
		
		if (tipoEnemigo==0) {
			Poder poderDemonio = new Poder(imagenD, getPosX()-x, getPosY()-y, true, danioD);
			getPoderes().add(poderDemonio);
		}
		else {
			Poder poderRobot = new Poder(imagenR, getPosX()-x, getPosY()-y, true, danioR);
			getPoderes().add(poderRobot);
		}
	}

	/**
	 * Metodo sobreescrito que mueve al enemigo basico en la posicion y<br>
	 * @param mover con el valor a mover en el eje y<br>
	 */
	@Override
	public void moverPosY(int mover) {
		setPosY(mover);
		contador++;
		
		contadorPoderes++;
		
		//Tiempo de generar nuevos poderes
		int ramdon = (int) Math.floor(Math.random()*(60-30+1)+30); //M = 30, N = 60, random entre 30 y 60
		if (contadorPoderes>=ramdon) {
			crearPoderes();
			contadorPoderes = 0;
			
			cambiarImagenRobot();
		}
		
		cambiarImagenDemonio();
	}
	
	/**
	 * Metodo que se encarga de cambiar las imagenes de los demonios para paracer una animacion.
	 */
	public void cambiarImagenDemonio() {
		if(super.getImagen().equals(DEMONIO1)&&contador==CAMBIO_ANIMACION) {
			super.setImagen(DEMONIO2);
			contador = 0;
		}
		
		else if (super.getImagen().equals(DEMONIO2)&&contador==CAMBIO_ANIMACION) {
			super.setImagen(DEMONIO1);
			contador = 0;
		}
	}
	
	/**
	 * Metodo que se encargar de cambiar la imagen del robot cuando dispara.
	 */
	public void cambiarImagenRobot() {
		if (getImagen().equals(ROBOT1)) 
			setImagen(ROBOT2);
		
		else if (getImagen().equals(ROBOT2)) 
			setImagen(ROBOT3);
		
		else if (getImagen().equals(ROBOT3)) 
			setImagen(ROBOT1);
	}
	
	/**
	 * Metodo sobrrescrito que modifica la posicion y del enemigo<br>
	 * @param posY con que se modificara el enemigo basico<br>
	 */
	@Override
	public void setPosY(int posY) {
		if (super.getPosY()>=450) 
			movimientoContrario = true;
		
		if(super.getPosY()<=0) 
			movimientoContrario = false;
		
		if (movimientoContrario) 
			super.setPosY(-posY);
		else 
			super.setPosY(posY);
	}

	/**
	 * Metodo sobrrescrito que mueve el enemigo basico en el eje x<br>
	 * @param mover con el valor que se va a mover en el eje x el enemigo<br>
	 */
	@Override
	public void moverPosX(int mover) {}
	
	/**
	 * Metodo que devuelve el tipo de enemigo<br>
	 * @return tipoEnemigo con el tipo de enmigo<br>
	 */
	public int getTipoEnemigo() {
		return tipoEnemigo;
	}

	/**
	 * Metodo que modifica el tipo de enemigo<br>
	 * @param tipoEnemigo con el que va a ser modificado<br>
	 */
	public void setTipoEnemigo(int tipoEnemigo) {
		this.tipoEnemigo = tipoEnemigo;
	}

	/**
	 * Metodo que devuelve la velocidad del enemigo<br>
	 * @return velocidad del enemigo<br>
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Metodo que modifica la velocidad del enemigo<br>
	 * @param velocidad que se va a modificar en el enemigo<br>
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * Metodo que modifica el perimetro del enemigo<br>
	 * @param ancho con el valor a modificar del enemigo<br>
	 * @param alto con el valor a modificar del enemigo<br>
	 */
	public void modificarPerimetro(int ancho, int alto) {
		setAlto(alto);
		setAncho(ancho);
	}

}
