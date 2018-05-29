package test;

import java.util.Random;
import org.junit.Test;
import junit.framework.TestCase;
import modelo.*;

/**
 * Pruebas unitarias de la clase Poder.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class PoderTest extends TestCase {
	
	/**
	 * Atributo que representa la imagen de poder<br>
	 */
	private String sPoder;
	/**
	 * Atributo que representa la posixion x de la imagen del poder<br>
	 */
	private int posX;
	/**
	 * Atributo que representa la posicion y de la imagen del poder<br>
	 */
	private int posY;
	/**
	 * Atributo que representa si el poder esta activado o no<br>
	 */
	private boolean activado;
	/**
	 * Atributo que representa el danio que tiene este poder<br>
	 */
	private int danio;
	/**
	 * Relacion con la clase Poder<br>
	 */
	private Poder poder;
	
	/**
	 * Metodo que configura el escenario principal<br>
	 */
	public void setupEscenario() {
		sPoder = "./datos/poderes/poderGohan.png";
		posX = 0;
		posY = 0;
		activado = false;
		danio = Poderes.DANIO_DEMONIO;
		poder = new Poder(sPoder,posX,posY,activado,danio);
	}
	
	/**
	 * Prueba el metodo getPosX<br>
	 */
	@Test
	public void testGetPosX() {
		setupEscenario();
		assertEquals(posX,poder.getPosX());
	}
	
	/**
	 * Prueba el metodo setPosX<br>
	 */
	@Test
	public void testSetPosX() {
		setupEscenario();
		Random r = new Random(System.currentTimeMillis());
		int valor = r.nextInt(123);
		poder.setPosX(valor);
		assertEquals(valor+posX,poder.getPosX());
	}
	
	/**
	 * Prueba el metodo getPosY<br>
	 */
	@Test
	public void testGetPosY() {
		setupEscenario();
		assertEquals(posY,poder.getPosX());
	}

	/**
	 * Prueba el metodo isActivado<br>
	 */
	@Test
	public void testIsActivado() {
		setupEscenario();
		assertEquals("No deberia estar activado",activado,poder.isActivado());
	}
	
	/**
	 * Prueba el metodo setActivado<br>
	 */
	@Test
	public void testSetActivado() {
		setupEscenario();
		boolean cambiar = true;
		poder.setActivado(cambiar);
		assertEquals(cambiar,poder.isActivado());
	}
	
	/**
	 * Prueba el metodo isPoderActivado<br>
	 */
	@Test
	public void testIsPoderActivado() {
		setupEscenario();
		assertEquals("No deberia estar activado",activado,poder.isPoderActivado());
	}
	
	/**
	 * Prueba el metodo setPoderActivado<br>
	 */
	@Test
	public void testSetPoderActivado() {
		setupEscenario();
		boolean cambiar = true;
		poder.setActivado(cambiar);
		assertEquals(cambiar,poder.isPoderActivado());
	}
	
	/**
	 * Prueba el metodo getPoder<br>
	 */
	@Test
	public void testGetPoder() {
		setupEscenario();
		assertEquals(sPoder,poder.getPoder());
	}

	/**
	 * Prueba el metodo setPoder<br>
	 */
	@Test
	public void testSetPoder() {
		setupEscenario();
		String nPoder = "nuevo";
		poder.setPoder(nPoder);
		assertEquals(nPoder,poder.getPoder());
	}
	
	/**
	 * Prueba el metodo getAncho<br>
	 */
	@Test
	public void testGetAncho() {
		setupEscenario();
		assertEquals(0,poder.getAncho());
	}
	
	/**
	 * Prueba el metodo setAncho<br>
	 */
	@Test
	public void testSetAncho() {
		setupEscenario();
		Random r = new Random(System.currentTimeMillis());
		int valor = r.nextInt(432);
		poder.setAncho(valor);
		assertEquals(valor,poder.getAncho());
	}
	
	/**
	 * Prueba el metodo getAlto<br>
	 */
	@Test
	public void testGetAlto() {
		setupEscenario();
		assertEquals(0,poder.getAlto());
	}
	
	/**
	 * Prueba el metodo setAlto<br>
	 */
	@Test
	public void testSetAlto() {
		setupEscenario();
		Random r = new Random(System.currentTimeMillis());
		int valor = r.nextInt(432);
		poder.setAlto(valor);
		assertEquals(valor,poder.getAlto());
	}
	
	/**
	 * Prueba el metodo setPerimtero<br>
	 */
	@Test
	public void testSetPerimetro() {
		setupEscenario();
		int alto = 100;
		int ancho = 230;
		poder.setPerimetro(alto, ancho);
		assertTrue(alto==poder.getAlto());
		assertEquals(ancho,poder.getAncho());
	}
	
	/**
	 * Prueba el metodo getDanio<br>
	 */
	@Test
	public void testGetDanio() {
		setupEscenario();
		assertTrue(danio==poder.getDanio());
	}
	
	/**
	 * Prueba el metodo setDanio<br>
	 */
	@Test
	public void testSetDanio() {
		setupEscenario();
		poder.setDanio(Poderes.DANIO_ROBOT);
		assertEquals(Poderes.DANIO_ROBOT,poder.getDanio());
	}
	
	/**
	 * Prueba el metodo moverPoderEnemigo<br>
	 */
	@Test
	public void testMoverPoderEnemigo() {
		setupEscenario();
		Random r = new Random();
		int movimiento = r.nextInt(5);
		poder.moverPoderEnemigo(movimiento);
		int nPosX= posX;
		nPosX -= movimiento;
		assertEquals(nPosX,poder.getPosX());
	}
	
	/**
	 * Prueba el metodo intercalarAnimacionPoderRobot<br>
	 */
	@Test
	public void testIntercalarAnimacionPoderRobot() {
		setupEscenario();
		poder.setPoder(Personaje.PODER_ROBOT_1);
		poder.intercalarAnimacionPoderRobot();
		assertEquals(Personaje.PODER_ROBOT_2,poder.getPoder());
	}
	
	/**
	 * Prueba que verifica el poder<br>
	 */
	@Test
	public void testVerificarPoder() {
		setupEscenario();
		poder.setPosX(poder.getPosX()*(-1));
		poder.verificarPoder();
		assertTrue(!poder.isPoderActivado());
		poder.setPosX(1300);
		poder.verificarPoder();
		assertTrue(!poder.isPoderActivado());
		
	}
	
}
