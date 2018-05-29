package test;

import java.util.Random;
import org.junit.Test;
import junit.framework.TestCase;
import modelo.*;

/**
 * Pruebas unitarias de la clase Juego.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class FondoTest extends TestCase {
	
	/**
	 * Atributo que representa la direccion de la imagen del fondo<br>
	 */
	private String imagen;
	/**
	 * Atributo que representa la posicion en el eje x del fondo<br>
	 */
	private int x;
	/**
	 * Relacion con la clase FOndo<br>
	 */
	private Fondo fondo;
	
	/**
	 * Método que configura el escenario principal<br>
	 */
	public void setupEscenario() {
		imagen = Fondo.FONDO;
		Random r = new Random(System.currentTimeMillis());
		x = r.nextInt(1134);
		fondo = new Fondo(imagen,x);
	}
	
	/**
	 * Prueba del metodo getX<br>
	 */
	@Test
	public void testGetX() {
		setupEscenario();
		assertEquals(x,fondo.getX());
	}
	
	/**
	 * Prueba del metodo getImagen<br>
	 */
	@Test
	public void testGetImagen() {
		setupEscenario();
		assertTrue(imagen.equals(fondo.getImagen()));
	}
	
	/**
	 * Prueba del metodo moverFondo<br>
	 */
	@Test
	public void testMoverFondo() {
		setupEscenario();
		int value = fondo.getX()-1;
		fondo.moverFondo();
		assertTrue(value == fondo.getX());
	}

}
