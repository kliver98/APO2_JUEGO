package test;

import java.util.Random;
import org.junit.Test;
import junit.framework.TestCase;
import modelo.*;

/**
 * Pruebas unitarias de la clase EnemigoBasico.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class EnemigoBasicoTest extends TestCase {
	
	/**
	 * Atributo que representa la imagen del personaje en cadena de caracteres.<br>
	 */
	private String imagen;
	/**
	 * Atributo que representa la posición en el eje y del personaje.<br>
	 */
	private int posY;
	/**
	 * Atributo que representa la posición en el eje x del personaje.<br>
	 */
	private int posX;
	/**
	 * Atributo para saber si es Demonio o robot.<br>
	 */
	private int tipoEnemigo;
	/**
	 * Atributo que representa la vida del enemigo<br>
	 */
	private int vida;
	/**
	 * Atributo que representa la velocidad del enemigo<br>
	 */
	private int velocidad;
	/**
	 * Relacion con la clase EnemigoBasico<br>
	 */
	private EnemigoBasico enemigoBasico;
	
	/**
	 * Metodo que configura el escenario con un enemigo basico Demonio1<br>
	 */
	public void setupEscenarioDemonio() {
		imagen = EnemigoBasico.DEMONIO1;
		Random r = new Random();
		posY = r.nextInt(10);
		posX = r.nextInt(50);
		tipoEnemigo = r.nextInt(2);
		vida = EnemigoBasico.VIDA_ENEMIGOS;
		velocidad = EnemigoBasico.MOVER_ABAJO_Y;
		enemigoBasico = new EnemigoBasico(imagen,posX,posY,tipoEnemigo,vida,velocidad);
	}
	
	/**
	 * Metodo que configura el escenario con un enemigo basico robot2<br>
	 */
	public void setupEscenarioRobot() {
		imagen = EnemigoBasico.ROBOT2;
		Random r = new Random();
		posY = r.nextInt(10);
		posX = r.nextInt(50);
		tipoEnemigo = r.nextInt(2);
		vida = EnemigoBasico.VIDA_ENEMIGOS;
		velocidad = EnemigoBasico.MOVER_ARRIBA_Y;
		enemigoBasico = new EnemigoBasico(imagen,posX,posY,tipoEnemigo,vida,velocidad);
	}
	
	/**
	 * Prueba del metodo crearPoderes<br>
	 */
	@Test
	public void testCrearPoderes() {
		setupEscenarioDemonio();
		int tamanioUno = enemigoBasico.getPoderes().size();
		Random r = new Random();
		int n = r.nextInt(10);
		for (int i = 0; i < n; i++) {			
			enemigoBasico.crearPoderes();
		}
		int tamanioDos = enemigoBasico.getPoderes().size();
		assertEquals(tamanioUno,tamanioDos-n);
	}
	
	/**
	 * Prueba del metodo moverPosY<br>
	 */
	@Test
	public void testMoverPosY() {
		setupEscenarioDemonio();
		Random r = new Random();
		int mover = r.nextInt(12);
		int inicial = enemigoBasico.getPosY();
		enemigoBasico.moverPosY(mover);
		int fin = enemigoBasico.getPosY();
		assertEquals(inicial+mover*3,fin);
	}
	
	/**
	 * Prueba del metodo cambiarImagenDemonio<br>
	 */
	@Test
	public void testCambiarImagenDemonio() {
		setupEscenarioDemonio();
		for (int i = 0; i < EnemigoBasico.CAMBIO_ANIMACION; i++) {
			enemigoBasico.moverPosY(i);
		}
		enemigoBasico.cambiarImagenDemonio();
		assertTrue(EnemigoBasico.DEMONIO2.equals(enemigoBasico.getImagen()));
	}
	
	/**
	 * Prueba del metodo cambiarImagenRobot<br>
	 */
	@Test
	public void testCambiarImagenRobot() {
		setupEscenarioRobot();
		enemigoBasico.cambiarImagenRobot();
		assertTrue(EnemigoBasico.ROBOT3.equals(enemigoBasico.getImagen()));
	}
	
	/**
	 * Prueba del metodo setPosY<br>
	 */
	@Test
	public void testSetPosY() {
		setupEscenarioDemonio();
		Random r = new Random();
		int valor = r.nextInt(123);
		int actual = enemigoBasico.getPosY();
		enemigoBasico.setPosY(valor);
		assertTrue((actual+valor*3)==enemigoBasico.getPosY());
	}
	
	/**
	 * Prueba del metodo moverPosX<br>
	 */
	@Test
	public void testMoverPosX() {
		setupEscenarioDemonio();
		Random r = new Random();
		int mover = r.nextInt(10);
		enemigoBasico.moverPosX(mover);
		assertTrue(true);
	}
	
	/**
	 * Prueba del metodo getAncho<br>
	 */
//	@Test
//	public void testGetAncho() {
//		setupEscenarioDemonio();
//		assertEquals(0,enemigoBasico.getAncho());
//	}
//	
//	/**
//	 * Prueba del metodo setAncho<br>
//	 */
//	@Test
//	public void testSetAncho() {
//		setupEscenarioDemonio();
//		int nuevoAncho = 10000;
//		enemigoBasico.setAncho(nuevoAncho);
//		assertEquals(nuevoAncho,enemigoBasico.getAncho());
//	}
//	
//	/**
//	 * Prueba del metodo getAlto<br>
//	 */
//	@Test
//	public void testGetAlto() {
//		setupEscenarioDemonio();
//		assertTrue(0==enemigoBasico.getAlto());
//	}
//	
//	/**
//	 * Prueba del metodo setAlto<br>
//	 */
//	@Test
//	public void testSetAlto() {
//		setupEscenarioDemonio();
//		int nuevoAlto = 100000;
//		enemigoBasico.setAlto(nuevoAlto);
//		assertEquals(nuevoAlto,enemigoBasico.getAlto());
//	}
	
	/**
	 * Prueba del metodo getTipoEnemigo<br>
	 */
	@Test
	public void testGetTipoEnemigo() {
		setupEscenarioRobot();
		assertTrue(tipoEnemigo==enemigoBasico.getTipoEnemigo());
	}
	
	/**
	 * Prueba del metodo setTipoEnemigo<br>
	 */
	@Test
	public void testSetTipoEnemigo() {
		setupEscenarioDemonio();
		int valor = 3;
		enemigoBasico.setTipoEnemigo(valor);
		assertTrue(valor==enemigoBasico.getTipoEnemigo());
	}
	
	/**
	 * Prueba el metodo getVelocidad<br>
	 */
	@Test
	public void testGetVelocidad() {
		setupEscenarioRobot();
		assertEquals(velocidad,enemigoBasico.getVelocidad());
	}
	
	/**
	 * Prueba el metodo setVelocidad<br>
	 */
	@Test
	public void testSetVelocidad() {
		setupEscenarioRobot();
		int valor = EnemigoBasico.MOVER_ABAJO_Y1;
		enemigoBasico.setVelocidad(valor);
		assertTrue(EnemigoBasico.MOVER_ABAJO_Y1==enemigoBasico.getVelocidad());
	}
	
	/**
	 * Prueba del metodo modificarPerimetro<br>
	 */
	@Test
	public void testModificarPerimetro() {
		setupEscenarioRobot();
		int alto = 100;
		int ancho = 200;
		enemigoBasico.modificarPerimetro(ancho, alto);
		assertTrue(ancho==enemigoBasico.getAncho());
		assertTrue(alto==enemigoBasico.getAlto());
	}

}
