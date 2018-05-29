package interfaz;

import javax.swing.*;
import hilos.*;
import modelo.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase principal de la interfaz de usuario.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constante que representa el nombre de la aplicacion<br>
	 */
	public static final String NOMBRE_APP = "Dragon Ball";
	
	/**
	 * Relacion con el panel del juego<br>
	 */
	private PanelJuego panelJuego;
	
	/**
	 * Relacion con el panel de las opciones<br>
	 */
	private PanelHabilidades panelHabilidades;
	
	/**
	 * Atributo que representa la relación con clase principal del modelo.<br>
	 */
	private Juego juego;
	
	/**
	 * Constructor de la clase VentanaPrincipal<br>
	 */
	public VentanaPrincipal() {
		juego = new Juego();
		panelJuego = new PanelJuego(this);
		panelHabilidades = new PanelHabilidades(this);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(NOMBRE_APP);

		startVerificarJuego();
		
		nuevoJuego();
	}

	/**
	 * Método que ejecuta el programa.
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal menu = new VentanaPrincipal();
		menu.setVisible(true);
	}

	/**
	 * Método que da la clase principal del modelo.<br>
	 * @return relación con la clase principal del modelo.<br>
	 */
	public Juego getJuego() {
		return juego;
	}
	
	/**
	 * 
	 */
	public void iniciarHilos() {
		startHiloFondo();
		starHilosEnemigos();
		startHiloPoderEnemigo();
	}
	
	/**
	 * Método que inicia el hilo del eje Y del personaje Son Goku<br>
	 */
	public void startVerificarJuego() {
		HiloVerificarJuego hilo = new HiloVerificarJuego(this, getJuego());
		hilo.start();
	}

	/**
	 * Método que inicia el hilo del eje Y del personaje Son Goku<br>
	 */
	public void startHiloGokuY(int valorMovimiento) {
		HiloMovimientoGokuY hilo = new HiloMovimientoGokuY(this, getJuego(), valorMovimiento);
		hilo.start();
	}
	
	/**
	 * Método que inicia el hilo del eje X del personaje Son Goku<br>
	 */
	public void startHiloGokuX(int valorMovimiento) {
		HiloMovimientoGokuX hilo = new HiloMovimientoGokuX(this, getJuego(), valorMovimiento);
		hilo.start();
	}
	
	/**
	 * Método que inicia el hilo del movimiento del poder fuerte del personaje principal goku.<br>
	 * @param valorMovimiento - cantidad en que se debe mover el poder del personaje principal.<br>
	 */
	public void startHiloPoderGoku(int valorMovimiento) {
		HiloPoderGoku hilo = new HiloPoderGoku(this, getJuego(), valorMovimiento);
		hilo.start();
	}
	
	/**
	 * Metodo que incia el hilo de los poderes de los enemigos basicos<br>
	 */
	public void startHiloPoderEnemigo() {
		HiloPoderesEnemigosBasicos hilo = new HiloPoderesEnemigosBasicos(this, juego, EnemigoBasico.AVANCE_PODER);
		hilo.start();
	}
	/**
	 * Metodo que crea multiples hilos para cada personaje enemigo.
	 */
	public void starHilosEnemigos() {
		HilosMovimientoEnemigosY hilo = new HilosMovimientoEnemigosY(this, juego);
		hilo.start();
	}
	
	/**
	 * Método que inicia el hilo del fondo del videojuego.<br>
	 */
	public void startHiloFondo() {
		HiloMovimientoFondo hilo = new HiloMovimientoFondo(this, getJuego());
		hilo.start();
	}
	
	/**
	 * Método que da el personaje principal del juego por medio de una relación. En este caso, Son Goku.<br>
	 * @return persona principal Son Goku.<br>
	 */
	public Goku getPrincipal() {
		return (Goku) juego.getPrincipal();
	}
	
	/**
	 * Método que da el fondo del videojuego por medio de la relación que tiene la clase principal del modelo.<br>
	 * @return fondo del videojuego.<br>
	 */
	public Fondo getFondo() {
		return juego.getFondo();
	}
	
	/**
	 * Método que da el fondo auxiliar del videojuego por medio de la relación que tiene la clase principal del modelo.<br>
	 * @return fondo del videojuego.<br>
	 */
	public Fondo getFondoAuxiliar() {
		return juego.getAuxiliar();
	}
	/**
	 * Método que se encarga de actualizar o refrescar el videojuego.<br>
	 */
	public void refrescarJuego() {
		this.repaint();
		panelJuego.repaint();
	}
	
	/**
	 * Método que modifica la posición en el eje Y del personaje goku haciendolo mover.<br>
	 */
	public void modificarPosYGoku(int mover) {
		juego.getPrincipal().moverPosY(mover);
	}
	
	/**
	 * Método que modifica la posición en el eje X del personaje goku haciendolo mover.<br>
	 */
	public void modificarPosXGoku(int mover) {
		juego.getPrincipal().moverPosX(mover);
	}
	
	/**
	 * Método que modifica el estado del movimiento del personaje.<br>
	 * @param moviendo - nuevo valor de verdad para el estado de movimiento.<br>
	 */
	public void modificarIsMovimiento(boolean moviendo) {
		juego.getPrincipal().setMoviendo(moviendo);
	}
	
	/**
	 * Método que modifica el estado del poder de goku.<br>
	 * @param poderActivado - nuevo valor de verdad.<br>
	 */
	public void modificarPoderActivadoGoku(boolean poderActivado) {
		juego.getPrincipal().getPoder().setActivado(poderActivado);
	}
	
	/**
	 * Método que mueve la imagen del poder de goku.<br>
	 * @param movimiento - valor en el que se debe mover la imagen del poder.<br>
	 */
	public void moverPoderGoku(int movimiento) {
		juego.getPrincipal().getPoder().setPosX(movimiento);
	}
	
	/**
	 * Método que da la ruta de la imagen del poder de goku.<br>
	 * @return cadena de caracteres de la imagen del poder del personaje principal golu.<br>
	 */
	public String imagenPoderGoku() {
		return juego.getPrincipal().getPoder().getPoder();
	}
	
	/**
	 * Método que da el poder de goku gracias a la relación que tiene este con la clase Poder.<br>
	 * @return poder de goku.<br>
	 */
	public Poder poderGoku() {
		return juego.getPrincipal().getPoder();
	}
	
	/**
	 * Metodo que retorna los enemigos del modelo.<br>
	 * @return un arraylist con los enemigos creados.<br>
	 */
	public ArrayList<Personaje> enemigos(){
		return juego.getEnemigos();
	}
	
	/**
	 * Método que crea el poder más fuerte del personaje principal.<br>
	 */
	public void crearPoderPersonajePrincipal() {
		juego.crearPoderPersonajePrincipal();
	}
	
	/**
	 * Metodo que aumenta el poder de goku<br>
	 */
	public void aumentarPoderGoku() {
		juego.aumentarPoderGoku();
	}
	
	/**
	 * Metodo que genera un danio en un enemigo<br>
	 * @param evaluado - EnemigoBasico al cual se le hizo danio<br>
	 */
	public void hacerDanioGoku(EnemigoBasico evaluado, int i) {
		juego.hacerDanioGoku(evaluado, i);
	}
	
	/**
	 * Metodo que modifica el perimetro del poder de goku<br>
	 * @param ancho con el nuevo ancho del poder de goku<br>
	 * @param alto con el nuevo alto del poder de goku<br>
	 */
	public void modificarPerimetroPoderGoku(int ancho, int alto) {
		juego.modificarPerimetroPoderGoku(ancho, alto);
	}
	
	/**
	 * Metodo que modifica el perimetro de un enemigo basico<br>
	 * @param ancho con el nuevo ancho a modificar<br>
	 * @param alto con el nuevo alto a modificar<br>
	 * @param evaluado que es el enemigo basico que se le modificara el perimetro<br>
	 */
	public void modificarPerimetroEnemigoBasico(int ancho, int alto, EnemigoBasico evaluado) {
		juego.modificarPerimetroEnemigos(ancho, alto, evaluado);
	}
	
	/**
	 * Metodo que calcula la cantida de vida que se pintara.
	 * @return retorna un entero con la cantida de vida restante.
	 */
	public int barraVida() {
		return juego.porcentajeBarraVidaGoku();
	}
	
	/**
	 * Metodo que modifica el perimetro de goku<br>
	 * @param ancho con el nuevo ancho de goku<br>
	 * @param alto con el nuevo alto de goku<br>
	 */
	public void modificarPerimetroGoku(int ancho, int alto) {
		juego.modificarPerimetroGoku(ancho, alto);
	}
	
	/**
	 * Metodo que modifica el perimetro de un poder<br>
	 * @param ancho con el nuevo valor del ancho a modificar<br>
	 * @param alto con el nuevo valor del alto a modificar<br>
	 */
	public void modificarPerimetroPoderes(Poder poder, int ancho, int alto) {
		juego.modificarPerimetroPoderes(poder, ancho, alto);
	}
	
	/**
	 * Metodo que devuelve el tamanio del panel juego<br>
	 * @return ancho del panel jeugo<br>
	 */
	public int darTamanioVentana() {
		return PanelJuego.WIDTH;
	}
	
	public void nuevoJuego() {
		int seleccion = JOptionPane.showOptionDialog( null,"Seleccione una opción",
				"Menu del Juego",JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
				new String[] { "Nuevo Jugador", "Jugador existente", "Ver puntajes"},"opcion 1");
	
		if (seleccion != -JOptionPane.CANCEL_OPTION){
			 if (seleccion == 0) {
				String usuario = JOptionPane.showInputDialog(null, "Ingrese Usuario");
				if ( usuario!=null && !usuario.isEmpty() )
					juego.agregarJugador(usuario);
				else
					nuevoJuego();
			 }
			 if (seleccion==1) {
				 String usuario = JOptionPane.showInputDialog(null, "Ingrese Usuario");
				 if ( usuario==null || usuario.isEmpty() )
					 nuevoJuego();
			}
		 }
		 else {
			System.exit(0);
		}
		 
		 add(panelJuego, BorderLayout.CENTER);
		 add(panelHabilidades, BorderLayout.SOUTH);
		 setVisible(true);
		 pack();
		 setLocationRelativeTo(null);
		 
		 iniciarHilos();
	}

	public Jugador jugadorActual() {
		return juego.getActual();
	}

	public PanelHabilidades getPanelHabilidades() {
		return panelHabilidades;
	}

	public void setPanelHabilidades(PanelHabilidades panelHabilidades) {
		this.panelHabilidades = panelHabilidades;
	}
}