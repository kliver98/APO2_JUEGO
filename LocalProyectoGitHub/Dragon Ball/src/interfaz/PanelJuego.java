package interfaz;

import modelo.*;
import javax.swing.*;

import org.omg.CORBA.portable.ValueBase;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase que representa el panel en el que se visualiza el juego.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class PanelJuego extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	/**
	 * Constante que representa el ancho del panel<br>
	 */
	public static final int WIDTH = 1200;
	/**
	 * Constante que representa el alto del panel<br>
	 */
	public static final int HEIGHT = 500;
	
	/**
	 * Atributo que representa la relación con la clase principal de la interfaz.<br>
	 */
	private VentanaPrincipal ventana;
	
	/**
	 * Constructor de la clase PanelJuego.
	 */
	public PanelJuego(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		ventana.addKeyListener(this);
	}
	
	/**
	 * Método encargado de pintar todo lo relacionado con el juego. 
	 */
	public void paintComponent(Graphics g) {
		ImageIcon imageFondo = new ImageIcon(ventana.getFondo().getImagen());
		ImageIcon imageFondoAuxiliar = new ImageIcon(ventana.getFondoAuxiliar().getImagen());
		g.drawImage(imageFondo.getImage(), ventana.getFondo().getX(), 0, this.getWidth(), this.getHeight(), null);
		g.drawImage(imageFondoAuxiliar.getImage(), ventana.getFondoAuxiliar().getX(), 0, this.getWidth(), this.getHeight(), null);
		
		pintarGoku(g);
		pintarPoderGoku(g);
		pintarEnemigos(g);
		pintarPoderEnemigos(g);
		pintarOzaru(g);
		pintarPoderOzaru(g);
		
		if (!ventana.getJuego().isGokuVivo()) 
			pintarGameOver(g);
	}
	
	/**
	 * Método encargado de pintar los primeros personajes enemigos del juego.<br>
	 * @param g - pinta los personajes.<br>
	 */
	public void pintarEnemigos(Graphics g) {
		for (int i = 0; i <ventana.enemigos().size(); i++) {
			EnemigoBasico temp = (EnemigoBasico) ventana.enemigos().get(i);
			ImageIcon image = new ImageIcon(temp.getImagen());
			g.drawImage(image.getImage(), temp.getPosX(), temp.getPosY(), image.getIconWidth(), image.getIconHeight(), null);
			int ancho = image.getIconWidth();
			int alto = image.getIconHeight();
			ventana.modificarPerimetroEnemigoBasico(ancho, alto, temp);
		}
	}
	
	/**
	 * Método que pinta el personaje principal.
	 * @param g - pinta el personaje
	 */
	public void pintarGoku(Graphics g) {
		ImageIcon image;
		int ancho = 0;
		int alto = 0;
		if(ventana.getPrincipal().isPoderActivado() == false) {
			ventana.getPrincipal().setImagen(Goku.GOKU);
			image = new ImageIcon(ventana.getPrincipal().getImagen());
			ancho = image.getIconWidth();
			alto = image.getIconHeight();
			g.drawImage(image.getImage(), ventana.getPrincipal().getPosX(), ventana.getPrincipal().getPosY(), image.getIconWidth(), image.getIconHeight(), null);
		}
		else {
			ventana.getPrincipal().setImagen(Goku.GOKU1);
			image = new ImageIcon(ventana.getPrincipal().getImagen());
			ancho = image.getIconWidth();
			alto = image.getIconHeight();
			g.drawImage(image.getImage(), ventana.getPrincipal().getPosX(), ventana.getPrincipal().getPosY(), image.getIconWidth(), image.getIconHeight(), null);
		}
		ventana.modificarPerimetroGoku(ancho, alto);			
	}

	/**
	 * Método encargado de pintar el poder de goku.<br>
	 * @param g - pinta el poder de goku.<br>
	 */
	public void pintarPoderGoku(Graphics g) {
		if(ventana.poderGoku().isActivado()) {
			ImageIcon image = new ImageIcon(ventana.imagenPoderGoku());
			g.drawImage(image.getImage(), ventana.poderGoku().getPosX(), ventana.poderGoku().getPosY(), image.getIconWidth(), image.getIconHeight(), null);
			int ancho = image.getIconWidth();
			int alto = image.getIconHeight();
			ventana.modificarPerimetroPoderGoku(ancho, alto);
		}
	}
	
	/**
	 * Método encargado de pintar el poder de goku.<br>
	 * @param g - pinta el poder de goku.<br>
	 */
	public void pintarPoderEnemigos(Graphics g) {
		for (int i = 0; i <ventana.enemigos().size(); i++) {
			EnemigoBasico enemigoBasico = (EnemigoBasico) ventana.enemigos().get(i);
			for (int j = 0; j < enemigoBasico.getPoderes().size(); j++) {
				Poder temp = enemigoBasico.getPoderes().get(j);
				
				ImageIcon image = new ImageIcon(temp.getPoder());
				g.drawImage(image.getImage(), temp.getPosX(), temp.getPosY(), image.getIconWidth(), image.getIconHeight(), null);
				
				int ancho = image.getIconWidth();
				int alto = image.getIconHeight();
				ventana.modificarPerimetroPoderes(temp, ancho, alto);
			}
		}
	}
	
	public void pintarGameOver(Graphics g) {
		String aux = "./datos/auxiliares/Game_Over.jpg";
		ImageIcon imageIcon = new ImageIcon(aux);
		
		g.drawImage(imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public void pintarOzaru(Graphics g) {
		if(ventana.getJuego().isCreado()&&ventana.getOzaru()!=null) {
			Ozaru temp = ventana.getOzaru();
			ImageIcon imagen = new ImageIcon(temp.getImagen());
			g.drawImage(imagen.getImage(), temp.getPosX(), temp.getPosY(), imagen.getIconWidth(), imagen.getIconHeight(), null);
			
			int ancho = imagen.getIconWidth();
			int alto = imagen.getIconHeight();
			ventana.getJuego().modificarPerimetroOzaru(ancho, alto);
		}
	}
	
	public void pintarPoderOzaru(Graphics g) {
		Ozaru t = ventana.getOzaru();
		
		if (t!=null) {
			if (t.getPoder()!=null) {
				ImageIcon imagen = new ImageIcon(t.getPoder().getPoder());
				g.drawImage(imagen.getImage(), t.getPoder().getPosX(), t.getPoder().getPosY(), imagen.getIconWidth(), imagen.getIconHeight(), null);
			}
			
			for (int i = 0; i < t.getPoderes().size(); i++) {
				Poder temp = t.getPoderes().get(i);
				
				ImageIcon image = new ImageIcon(temp.getPoder());
				g.drawImage(image.getImage(), temp.getPosX(), temp.getPosY(), image.getIconWidth(), image.getIconHeight(), null);
				
				int ancho = image.getIconWidth();
				int alto = image.getIconHeight();
				ventana.modificarPerimetroPoderes(temp, ancho, alto);
			}
		}
	}
	/**
	 * Metdo sobreescrito que captura cuando se presiono una tecla<br>
	 * @param e con el evento generado<br>
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		ventana.modificarIsMovimiento(true);

		if(e.getKeyCode() == KeyEvent.VK_W) {
			ventana.startHiloGokuY(Goku.MOVER_ARRIBA_Y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			ventana.startHiloGokuY(Goku.MOVER_ABAJO_Y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			ventana.startHiloGokuX(Goku.MOVER_IZQ_X);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			ventana.startHiloGokuX(Goku.MOVER_DER_X);
		}
		else if(ventana.poderGoku().isActivado()==false && e.getKeyCode() == KeyEvent.VK_SPACE) {			
				ventana.crearPoderPersonajePrincipal();
				ventana.getPrincipal().setPoderActivado(true);
				ventana.modificarPoderActivadoGoku(true);
				ventana.startHiloPoderGoku(Goku.AVANCE_PODER);
		}
	}

	/**
	 * Metodo sobreescrito que captura cuando una tecla fue soltada<br>
	 * @param e con el evento ocurrido<br>
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			ventana.modificarIsMovimiento(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			ventana.modificarIsMovimiento(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			ventana.modificarIsMovimiento(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			ventana.modificarIsMovimiento(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			ventana.getPrincipal().setPoderActivado(false);
		}
	}

	/**
	 * Metodo sobreescrito que captura cuando una tecla ha sido presionada<br>
	 * @param e con el evento generado<br>
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
