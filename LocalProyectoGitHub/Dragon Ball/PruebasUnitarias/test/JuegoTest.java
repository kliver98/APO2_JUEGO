package test;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;
import junit.framework.TestCase;
import modelo.*;

/**
 * Pruebas unitarias de la clase Juego.
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class JuegoTest extends TestCase {

	/**
	 * Relacion con la clase juego<br>
	 */
	private Juego juego;
	
	/**
	 * Metodo que configura el escenario principal<br>
	 */
	public void setupEscenario() {
		juego = new Juego();
	}
	
	/**
	 * Metodo que configura el escenario con un enemigo basico robot1<br>
	 */
	public void setupEscenarioConEnemigoBasicoDemonio() {
		juego = new Juego();
		int poderAncho = juego.getPrincipal().getPoder().getAncho();
		EnemigoBasico evaluado = new EnemigoBasico(EnemigoBasico.ROBOT1, poderAncho+poderAncho+1, 0, 1,EnemigoBasico.VIDA_ENEMIGOS,EnemigoBasico.MOVER_ABAJO_Y);
		Poder copia = new Poder("",0,0,false,Poderes.DANIO_ROBOT);
		evaluado.setPoder(copia);
		juego.setEnemigos(new ArrayList<Personaje>());
		juego.getEnemigos().add(evaluado);
	}
	
	/**
	 * Prueba del metodo getActual<br>
	 */
	@Test
	public void testGetActual() {
		setupEscenario();
		assertNull(juego.getActual());
	}
	
	/**
	 * Prueba del metodo setActual<br>
	 */
	@Test
	public void testSetActual() {
		setupEscenario();
		Jugador actual = new Jugador("Pepito");
		juego.setActual(actual);
		assertFalse(juego.getActual()==null);
	}
	
	/**
	 * Prueba del metodo agregarJugador<br>
	 */
	@Test
	public void testAgregarJugador() {
		setupEscenario();
		int size1 = juego.tamanioListaPersonajes()+1;
		juego.agregarJugador("Juan");
		int size2 = juego.tamanioListaPersonajes();
		assertEquals(size1,size2);
	}
	
	/**
	 * Prueba del metodo crearFondo<br>
	 */
	@Test
	public void testCrearFondo() {
		setupEscenario();
		juego.crearFondo();
		assertTrue(juego.getFondo()!=null);
	}
	
	@Test
	public void testSetEnemigos() {
		setupEscenario();
		ArrayList<Personaje> enemigos = new ArrayList<Personaje>();
		Random r = new Random();
		int n = r.nextInt(123);
		for (int i = 0; i < n; i++) {			
			enemigos.add(new EnemigoBasico("Imagen", 0, 0, 0, 0,EnemigoBasico.MOVER_ARRIBA_Y));
		}
		juego.setEnemigos(enemigos);
		assertEquals(n,juego.getEnemigos().size());
	}
	
	/**
	 * Prueba del metodo crearGoku<br>
	 */
	@Test
	public void testCrearGoku() {
		setupEscenario();
		juego.crearGoku();
		assertTrue(juego.getPrincipal()!=null);
	}
	
	/**
	 * Prueba del metodo crearEnemigosRobots<br>
	 */
	@Test
	public void testCrearEnemigosRobots() {
		setupEscenario();
		int n = 50;
		int size1 = juego.getEnemigos().size()+n;
		for (int i = 0; i < n; i++) {			
			juego.crearEnemigosRobots();
		}
		int size2 = juego.getEnemigos().size();
		assertEquals(size1,size2);
	}
	
	/**
	 * Prueba del metodo crearEnemigosDemonios<br>
	 */
	@Test
	public void testCrearEnemigosDemonios() {
		setupEscenario();
		Random random = new Random(System.nanoTime());
		int n = random.nextInt(100);
		int size1 = juego.getEnemigos().size()+n;
		for (int i = 0; i < n; i++) {
			juego.crearEnemigosDemonios();
		}
		int size2 = juego.getEnemigos().size();
		assertEquals(size1,size2);
	}
	
	/**
	 * Prueba del metodo crearPoderPersonajePrincipal<br>
	 */
	@Test
	public void testCrearPoderPersonajePrincipal() {
		setupEscenario();
		boolean evaluar = false;
		if ( juego.getPrincipal().getPoder()!=null ) {
			evaluar = true;
		} else {
			juego.crearPoderPersonajePrincipal();
			if ( juego.getPrincipal().getPoder()==null )
				evaluar = false;
		}
		assertTrue(evaluar);
	}
	
	/**
	 * Prueba del metodo creaEnemigosRandomBasicos<br>
	 */
	@Test
	public void testCreaEnemigosRandomBasicos() {
		setupEscenario();
		int val = 5;
		Random random = new Random(System.nanoTime());
		int n = random.nextInt(100);
		for (int i = 0; i < n; i++) {
			juego.creaEnemigosRandomBasicos();
		}
		assertTrue(juego.getEnemigos().size()>val);
	}
	
	/**
	 * Prueba el metodo agregarItems<br>
	 */
	@Test
	public void testAgregarItems() {
		setupEscenario();
		assertTrue(true); //No esta implementado bien todavia
	}
	
	/**
	 * Prueba del metodo tamanioListaPersonajes, los dos<br>
	 */
	@Test
	public void testTamanioListaPersonajes() {
		setupEscenario();
		int n = 100;
		int size1 = juego.tamanioListaPersonajes()+n;
		for (int i = 0; i < n; i++) {			
			juego.agregarJugador("Juan"+i);
		}
		int size2 = juego.tamanioListaPersonajes();
		assertEquals(size1,size2);
	}
	
	/**
	 * Prueba el metodo aumentarPoderGoku<br>
	 */
	@Test
	public void testAumentarPoderGoku() {
		setupEscenario();
		juego.getPrincipal().getPoder().setPoder(Personaje.PODER_GOKU_2);
		juego.getPrincipal().setAumentarPoder(600);
		juego.aumentarPoderGoku();
		boolean condicion = false;
		if ( juego.getPrincipal().getPoder().getPoder().equals(Personaje.PODER_GOKU_1) )
			condicion = true;
		assertTrue(condicion);
	}
	
	/**
	 * Prueba el metodo getPrincipal<br>
	 */
	@Test
	public void testGetPrincipal() {
		setupEscenario();
		assertTrue(juego.getPrincipal()!=null);
	}
	
	/**
	 * Prueba el metdo getFondo<br>
	 */
	@Test
	public void testGetFondo() {
		setupEscenario();
		assertFalse(juego.getFondo()==null);
	}
	
	/**
	 * Prueba el metdo getAuxiliar<br>
	 */
	@Test
	public void testGetAuxiliar() {
		setupEscenario();
		assertTrue(juego.getAuxiliar()!=null);
	}
	
	/**
	 * Prueba el metdo getEnemigos<br>
	 */
	@Test
	public void testGetEnemigos() {
		setupEscenario();
		assertTrue(juego.getEnemigos().size()>=3 && juego.getEnemigos().size()<=6);
	}
	
	/**
	 * Prueba el metodo hacerDanioGoku<br>
	 */
	@Test
	public void testHacerDanioGoku() {
		setupEscenarioConEnemigoBasicoDemonio();
		juego.hacerDanioGoku((EnemigoBasico)juego.getEnemigos().get(0),0);
		assertEquals(Poderes.PODER_GOKU_0,juego.getPrincipal().getPoder().getPoder());
	}
	
	/**
	 * Prueba el metodo modificarPerimetroPoderGoku<br>
	 */
	@Test
	public void testModificarPerimetroPoderGoku() {
		setupEscenario();
		int altoA = juego.getPrincipal().getPoder().getAlto();
		int anchoA = juego.getPrincipal().getPoder().getAncho();
		int alto = 10+altoA;
		int ancho = 50+anchoA;
		juego.modificarPerimetroPoderGoku(ancho, alto);
		int altoD = juego.getPrincipal().getPoder().getAlto();
		int anchoD = juego.getPrincipal().getPoder().getAncho();
		boolean cambio = false;
		if ( altoD==alto && anchoD==ancho ) {
			cambio = true;
		}
		assertTrue(cambio);
	}
	
	/**
	 * Prueba el metodo modificarPerimetroPoderes<br>
	 */
	@Test
	public void testModificarPerimetroPoderes() {
		setupEscenario();
		Poder modificar = new Poder("Poder",0,0,false,0);
		int ancho = 5;
		int alto = 1;
		juego.modificarPerimetroPoderes(modificar, ancho, alto);
		assertEquals(ancho,modificar.getAncho());
		assertTrue(alto==modificar.getAlto());
	}
	
	/**
	 * Prueba el metodo modificarPerimetroEnemigos<br>
	 */
	@Test
	public void testModificarPerimetroEnemigos() {
		setupEscenarioConEnemigoBasicoDemonio();
		int alto = 20;
		int ancho = 100;
		EnemigoBasico enemigo = (EnemigoBasico)juego.getEnemigos().get(0);
		juego.modificarPerimetroEnemigos(ancho, alto, enemigo);
		assertEquals(alto,enemigo.getAlto());
		assertEquals(ancho,enemigo.getAncho());
	}
	
	/**
	 * Prueba el metodo modificarPerimetroGoku<br>
	 */
	@Test
	public void testModificarPerimetroGoku() {
		setupEscenario();
		Random r = new Random();
		int ancho = r.nextInt(10);
		int alto = r.nextInt(12);
		juego.modificarPerimetroGoku(ancho, alto);
		boolean igual = (ancho==juego.getPrincipal().getAncho()) && (alto==juego.getPrincipal().getAlto());
		assertTrue(igual);
	}
	
	/**
	 * Prueba el metodo porcentajeBarraVidaGoku que sera 650 al no haber jugado<br>
	 */
	@Test
	public void testPorcentajeBarraVidaGoku() {
		setupEscenario();
		int x = juego.porcentajeBarraVidaGoku();
		System.out.println(x);
		assertTrue(x==650);
	}
	
	@Test
	public void testVerificarDanioEnemigos() {
		
	}
	
}
