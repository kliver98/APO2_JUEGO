package test;

import java.util.Random;
import org.junit.Test;
import junit.framework.TestCase;
import modelo.*;

/**
 * Pruebas unitarias de la clase Jugador.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class JugadorTest extends TestCase {
	
	/**
	 * Atributo que representa el nombre de usuario del jugador<br>
	 */
	private String nickName;
	/**
	 * Relacion con la clase Jugador<br>
	 */
	private Jugador jugador;
	
	/**
	 * Metodo que configura el escenario principal<br>
	 */
	public void setupEscenario() {
		Random r = new Random();
		int value = r.nextInt(2003);
		nickName = "Prueba_"+value;
		jugador = new Jugador(nickName);
	}
	
	/**
	 * Prueba del metodo getNickName<br>
	 */
	@Test
	public void testGetNickName() {
		setupEscenario();
		assertTrue(nickName.equals(jugador.getNickName()));
	}
	
	/**
	 * Prueba del metodo setNickName<br>
	 */
	@Test
	public void testSetNickName() {
		setupEscenario();
		String nuevoNickName = "Prueba___";
		jugador.setNickName(nuevoNickName);
		assertEquals(nuevoNickName,jugador.getNickName());
	}
	
	/**
	 * Prueba del metodo getPuntaje<br>
	 */
	@Test
	public void testGetPuntaje() {
		setupEscenario();
		assertEquals(0,jugador.getPuntaje());
	}
	
	/**
	 * Prueba del metodo setPuntaje<br>
	 */
	@Test
	public void testSetPuntaje() {
		setupEscenario();
		Random r = new Random();
		int nuevoPuntaje = r.nextInt(100);
		jugador.setPuntaje(nuevoPuntaje);
		assertTrue(nuevoPuntaje==jugador.getPuntaje());
	}
	
	/**
	 * Prueba del metodo getNivel<br>
	 */
	@Test
	public void testGetNivel() {
		setupEscenario();
		assertTrue(jugador.getNivel()==0);
	}
	
	/**
	 * Prueba del metodo setNivel<br>
	 */
	@Test
	public void testSetNivel() {
		setupEscenario();
		int valor = 3;
		jugador.setNivel(valor);
		assertTrue(valor==jugador.getNivel());
	}
	
	/**
	 * Prueba del metodo getSiguiente<br>
	 */
	@Test
	public void testGetSiguiente() {
		setupEscenario();
		assertNull(jugador.getSiguiente());
	}
	
	/**
	 * Prueba del metodo setSiguiente<br>
	 */
	@Test
	public void testSetSiguiente() {
		setupEscenario();
		Jugador sig = new Jugador("Nuevo");
		jugador.setSiguiente(sig);
		assertEquals(sig,jugador.getSiguiente());
	}

}
