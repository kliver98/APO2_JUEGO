package modelo;

import java.util.ArrayList;

/**
 * Clase que representa el juego.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class Juego {
	
	/**
	 * Constante que representa la vida del personaje.<br>
	 */
	public static final int BARRA_VIDA = 650;
	
	/**
	 * 
	 */
	public static final int PUNTOS_ENEMIGOS_BASICOS = 200;
	
	/**
	 * 
	 */
	public static final int PUNTOS_ENEMIGOS_JEFES = 500;

	/**
	 * Relacion con el jugador que esta jugando actualmente.<br>
	 */
	private Jugador actual;
	/**
	 * Relacion con el primero jugador de la lista enlazada.<br>
	 */
	private Jugador primero;
	/**
	 * Atributo que representa el personaje principal del juego.<br>
	 */
	private Personaje principal;
	/**
	 * Atributo que representa los enemigos del personaje principal del juego.<br>
	 */
	private ArrayList<Personaje> enemigos;
	/**
	 * Atributo que representa el fondo del videojuego.<br>
	 */
	private Fondo fondo;
	/**
	 * Atributo que representa un fondo auxiliar del videojuego.<br>
	 */
	private Fondo auxiliar;
	
	/**
	 * Constructor de la clase juego.<br>
	 */
	public Juego() {
		enemigos = new ArrayList<Personaje>();
		crearFondo();
		crearGoku();
		creaEnemigosRandomBasicos();
	}
	
	/**
	 * Metodo que se encarga de agregar un jugador en la ultima posicion<br>
	 * @param nick - nombre del jugador<br>
	 */
	public void agregarJugador(String nick) {
		agregarJugador(new Jugador(nick), primero);
		enemigos = new ArrayList<Personaje>();
	}
	
	/**
	 * Metodo recursivo que buscar el ultimo jugador null y agrega un nuevo jugador en la ultima posicion<br>
	 * @param jugador  - jugador nuevo para agregar<br>
	 * @param pJugador - primer jugador de la lista enlazada<br>
	 */
	private void agregarJugador(Jugador jugador, Jugador pJugador) {
		if (pJugador!=null) {
			if (pJugador.getSiguiente()!=null) 
				agregarJugador(jugador, pJugador.getSiguiente());
			else 
				pJugador.setSiguiente(jugador);
		}
		else 
			primero = jugador;
	}
	
	/**
	 * M�todo encargado de crear el fondo del videojuego.<br>
	 */
	public void crearFondo() {
		fondo = new Fondo(Fondo.FONDO, 0);
		auxiliar = new Fondo(Fondo.FONDO, 1200);
	}

	/**
	 * Metodo que modifica la lista de enemigos.<br>
	 * @param enemigos recibe un arraylist con enemigos nuevos<br>
	 */
	public void setEnemigos(ArrayList<Personaje> enemigos) {
		this.enemigos = enemigos;
	}

	/**
	 * M�todo encargado de crear el personaje principal Son Goku.<br>
	 */
	public void crearGoku() {
		principal = new Goku(Goku.GOKU,  10, 250, Goku.GOKU_VIDA);
		crearPoderPersonajePrincipal();
	}

	/**
	 * Metodo que se encarga de crear enemigos basicos entre un rango especifico.<br>
	 */
	public void crearEnemigosRobots() {
		int x = (int) Math.floor(Math.random()*(1150-800+1)+800); //M = 800, N = 1150, random entre 800 y 1150
		int y = (int) Math.floor(Math.random()*500+1); //Valores entre 0 y 501 excluyendolo

		int random = (int) Math.floor(Math.random()*2+1); //Valores entre 1 y 2
		int velocidad = 0;
		if (random==1) 
			velocidad = EnemigoBasico.MOVER_ABAJO_Y;
		else 
			velocidad = EnemigoBasico.MOVER_ABAJO_Y1;
		
		EnemigoBasico temp = new EnemigoBasico(EnemigoBasico.ROBOT1, x, y, 1, EnemigoBasico.VIDA_ENEMIGOS, velocidad);
		enemigos.add(temp);
	}

	/**
	 * Metodo que se encarga de crear enemigos basicos entre un rango especifico.<br>
	 */
	public void crearEnemigosDemonios(){
		int x = (int) Math.floor(Math.random()*(1150-800+1)+800); //M = 800, N = 1150, ramdon entre 800 y 1150
		int y = (int) Math.floor(Math.random()*500+1); //Valores entre 0 y 501 excluyendolo
		
		int random = (int) Math.floor(Math.random()*2+1); //Valores entre 1 y 2
		int velocidad = 0;
		if (random==1) 
			velocidad = EnemigoBasico.MOVER_ABAJO_Y;
		else 
			velocidad = EnemigoBasico.MOVER_ABAJO_Y1;
	
		EnemigoBasico temp = new EnemigoBasico(EnemigoBasico.DEMONIO1, x, y, 0, EnemigoBasico.VIDA_ENEMIGOS, velocidad);
		enemigos.add(temp);
	}

	/**
	 * M�todo que crea el poder del personaje principal Son Goku.<br>
	 */
	public void crearPoderPersonajePrincipal() {
		int x =  principal.getPosX()+Goku.ORIGEN_PODER_X;
		int y = principal.getPosY()+Goku.ORIGEN_PODER_Y;
		int danioPoder = Poderes.DANIO_PODER_GOKU_GRANDE;
		
		Poder poderGoku = new Poder(Goku.PODER_GOKU_0, x, y, false, danioPoder);
		principal.setPoder(poderGoku);
	}
	
	/**
	 * Metodo que se encarga de crea 3 o 6 enemigos basicos aleatorios entre ellos.<br>
	 */
	public void creaEnemigosRandomBasicos() {
		int x = (int) Math.floor(Math.random()*(6-3+1)+3); //M = 3, N = 6, ramdon entre 3 y 6
		
		for (int i = 0; i < x; i++) {
			int random = (int) Math.floor(Math.random()*2+1); //Valores entre 1 y 2
			if(random==1) 
				crearEnemigosDemonios();
			else
				crearEnemigosRobots();
		}
	}

	/**
	 * Metodo que devuelve el total de Jugadores de la lista de esta<br>
	 * @return longitud de la lista<br>
	 */
	public int tamanioListaPersonajes() {
		return tamanioListaPersonajes(primero,0);
	}
	
	/**
	 * Metodo recursivo que devuelve el tamanio de la lista enlazada de jugadores<br>
	 * @param actual - el jugador actual<br>
	 * @return longitud de la lista enlazada<br>
	 */
	public int tamanioListaPersonajes(Jugador actual,int i) {
		return (actual!=null) ? tamanioListaPersonajes(actual.getSiguiente(),i+1):i;
	}
	
	public void aumentarPoderGoku() {
		if(principal.getAumentarPoder() >= 500) {
			principal.getPoder().setPoder(Goku.PODER_GOKU_1);
		}
	}
	/**
	 * M�todo que da el personaje principal del juego por medio de una relaci�n. En este caso, Son Goku.<br>
	 * @return persona principal Son Goku.<br>
	 */
	public Personaje getPrincipal() {
		return principal;
	}

	/**
	 * M�todo que da el fondo del videojuego.<br>
	 * @return relaci�n con la clase fondo.<br>
	 */
	public Fondo getFondo() {
		return fondo;
	}

	/**
	 * M�todo que da el fondo auxiliar del videojuego<br>
	 * @return relaci�n con la clase fondo.<br>
	 */
	public Fondo getAuxiliar() {
		return auxiliar;
	}
	
	/**
	 * Metodo que da la lista de enemigos del juego.<br>
	 * @return retorna un arraylist con los enemigos guardados<br>
	 */
	public ArrayList<Personaje> getEnemigos() {
		return enemigos;
	}
	
	/**
	 * 
	 * @param evaluado
	 */
	public void hacerDanioGoku(EnemigoBasico evaluado, int i) {
		// PODER
		int poderPosX = principal.getPoder().getPosX();
		int poderPosY = principal.getPoder().getPosY();
		int poderAncho = principal.getPoder().getAncho();
		int poderAlto = principal.getPoder().getAlto();
		
		//ENEMIGO
		int enemigoPosX = evaluado.getPosX();
		int enemigoPosY = evaluado.getPosY();
		int enemigoAncho = evaluado.getAncho();
		int enemigoAlto = evaluado.getAlto();
		
		if(poderPosX+poderAncho >= enemigoPosX && poderPosX <= enemigoPosX+enemigoAncho) {
			if(poderPosY+poderAlto >= enemigoPosY && poderPosY <= enemigoPosY+enemigoAlto) {
				String imagen = Goku.PODER_GOKU_2;
				principal.getPoder().setPoder(imagen);
				
				int danioPoder = principal.getPoder().getDanio();
				int vida = evaluado.getVida()- danioPoder;
				
				if (vida<=0) {
					enemigos.remove(i);
					principal.getPoder().setActivado(false);
					
					if (enemigos.size()==0) 
						creaEnemigosRandomBasicos();
				}
				
				else 
					evaluado.setVida(vida);
			}
		}
	}
	
	/**
	 * Metodo que modifica el perimetro del poder de goku<br>
	 * @param ancho con el nueco valor del ancho del poder de goku<br>
	 * @param alto con el nuevo valor del alto del poder de goku<br>
	 */
	public void modificarPerimetroPoderGoku(int ancho, int alto) {
		principal.getPoder().setPerimetro(alto, ancho);
	}
	
	/**
	 * Metodo que modifica el perimetro de poderes<br> 
	 * @param ancho con el nuevo valor del ancho de los poderes<br>
	 * @param alto con el nuevo valor del alto de los poderes<br>
	 */
	public void modificarPerimetroPoderes(Poder poder, int ancho, int alto) {
		poder.setPerimetro(alto, ancho);
	}
	
	/**
	 * Metodo que modifica el perimetro de los enemigos
	 * @param ancho con el nuevo valor del ancho de los enemigos<br>
	 * @param alto con el nuevo valor del alto de los enemigos<br>
	 * @param evaluado con el enemigo basico que se le modificara el perimetro<br>
	 */
	public void modificarPerimetroEnemigos(int ancho, int alto, EnemigoBasico evaluado) {
		for (int i = 0; i < enemigos.size() ; i++) {
			EnemigoBasico a = (EnemigoBasico)enemigos.get(i);
			
			if(a.equals(evaluado)) {
				a.modificarPerimetro(ancho, alto);
			}
		}
	}
	
	/**
	 * Metodo que modifica el perimetro de goku<br>
	 * @param ancho con el nuevo valor del ancho de goku<br>
	 * @param alto con el nuevo valor del alto de goku<br>
	 */
	public void modificarPerimetroGoku(int ancho, int alto) {
		principal.setPerimetro(ancho, alto);
	}
	
	/**
	 * Metodo que calcula la cantida de vida que se pintara.
	 * @return retorna un entero con la cantida de vida restante.
	 */
	public int porcentajeBarraVidaGoku() {
		int bVida = BARRA_VIDA;
		int vGokuCompleta = Goku.GOKU_VIDA;
		int vGoku = principal.getVida();
		
		int x = (bVida*vGoku)/vGokuCompleta;
		
		return x;
	}
	
	/**
	 * Metodo que se encarga de verificar El da�o de los enemigos hacia goku.
	 * @param evaluado Enemgio el cual Lanzo el poder.
	 * @param poderE Poder del enemigo
	 * @param i pocision del poder en el arryalist.
	 */
	public void verificarDanioEnemigos(EnemigoBasico evaluado, Poder poderE, int i) {
		// PODER
		int gokuPosX = principal.getPosX();
		int gokuPosY = principal.getPosY();
		int gokuAncho = principal.getAncho();
		int gokuAlto = principal.getAlto();
		
		//ENEMIGO
		int enemigoPoderPosX = poderE.getPosX();
		int enemigoPoderPosY = poderE.getPosY();
		int enemigoPoderAncho = poderE.getAncho();
		int enemigoPoderAlto = poderE.getAlto();
		
		if(gokuPosX+gokuAncho >= enemigoPoderPosX && gokuPosX <= enemigoPoderPosX+enemigoPoderAncho) {
			if(gokuPosY+gokuAlto >= enemigoPoderPosY && gokuPosY <= enemigoPoderPosY+enemigoPoderAlto) {
				int danioPoder = poderE.getDanio();
				int vida = principal.getVida() - danioPoder;
				
				if (vida<=0) {
					principal = null;
					//Goku muere
				}
				else {
					principal.setVida(vida);
					evaluado.getPoderes().remove(i);
				}
			}
		}

	}
	
	/**
	 * Metodo que verifica el danio instantaneo d eun enemigo basico<br>
	 * @param evaluado con el enemigo basico que se verificara<br>
	 * @param i con la posicion en el arraylist del enemigo basico evaluado<br>
	 */
	public void verificarDanioInstantaneo(EnemigoBasico evaluado, int i) {
		// PODER
		int gokuPosX = principal.getPosX();
		int gokuPosY = principal.getPosY();
		int gokuAncho = principal.getAncho();
		int gokuAlto = principal.getAlto();
		
		//ENEMIGO
		int enemigoPosX = evaluado.getPosX();
		int enemigoPosY = evaluado.getPosY();
		int enemigoAncho = evaluado.getAncho();
		int enemigoAlto = evaluado.getAlto();
		
		if(gokuPosX+gokuAncho >= enemigoPosX && gokuPosX <= enemigoPosX+enemigoAncho) {
			if(gokuPosY+gokuAlto >= enemigoPosY && gokuPosY <= enemigoPosY+enemigoAlto) {
				int danioPoder = EnemigoBasico.DANIO_INSTANTANEO;
				int vida = principal.getVida() - danioPoder;
				
				if (vida<=0) {
					principal = null;
					//Goku muere
				}
				else {
					principal.setVida(vida);
					enemigos.remove(i);
					if (enemigos.size()==0) 
						creaEnemigosRandomBasicos();
				}
			}
		}
		
	}
	
	public void terminarJuego() {
		
	}
	
}