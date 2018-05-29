package test;

import java.util.Random;
import org.junit.Test;
import junit.framework.TestCase;
import modelo.*;

/**
 * Pruebas unitarias de la clase Goku.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class GokuTest extends TestCase {

	/**
	 * Atributo que representa la direccion de la imagen de goku<br>
	 */
	private String imagen;
	/**
	 * Atributo que representa la posicion x de goku<br>
	 */
	private int posX;
	/**
	 * Atributo que representa la posicion y de goku<br>
	 */
	private int posY;
	/**
	 * Relacion con la clase Goku<br>
	 */
	private Goku goku;
	
	/**
	 * Construye un escenario con una posX, posY e imagen<br>
	 */
	public void setupEscenario() {
		Random r = new Random();
		posX = r.nextInt(124);
		posY = r.nextInt(421);
		imagen = "./datos/personajes/ImageGoku.png";
		goku = new Goku(imagen,posX,posY,Goku.GOKU_VIDA);
	}
	
	/**
	 * Prueba del metodo moverPosY<br>
	 */
	@Test
	public void testMoverPosY() {
		setupEscenario();
		int mover = 10;
		goku.moverPosY(mover);
		assertEquals(posY+mover*3,goku.getPosY());
	}
	
	/**
	 * Prueba del metodo moverPosX<br>
	 */
	@Test
	public void testMoverPosX() {
		setupEscenario();
		int mover = 5;
		goku.moverPosX(mover);
		assertEquals(posX+mover*3,goku.getPosX());
	}
	
	/**
	 * Prueba del metodo setAumentarPoder<br>
	 */
	@Test
	public void testSetAumentarPoder() {
		setupEscenario();
		Random r = new Random(System.currentTimeMillis());
		int aumentarPoder = r.nextInt(2);
		int valor = goku.getAumentarPoder();
		goku.setAumentarPoder(aumentarPoder);
		assertEquals(valor+aumentarPoder,goku.getAumentarPoder());
	}
	
}
