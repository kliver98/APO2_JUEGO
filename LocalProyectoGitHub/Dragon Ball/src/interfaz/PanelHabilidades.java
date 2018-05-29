package interfaz;

import javax.swing.*;

import modelo.Juego;
import java.awt.*;

/**
 * Clase que representa el panel de habilidades.<br>
 * @author Christian Alberto Tamayo Robayo, Joe Stephen Hernandes Meneses, Kliver Daniel Giron.
 *
 */
public class PanelHabilidades extends JPanel {

	/**
	 * Relacion con la ventana principal<br>
	 */
	private VentanaPrincipal vent;
	/**
	 * Atributo que representa el label de la imagen de goku<br>
	 */
	private JLabel jLimagenGoku;
	
	/**
	 * Construye un PanelHabilidades<br>
	 * @param m - Clase principal de la interfaz de usuario.<br>
	 */
	public PanelHabilidades(VentanaPrincipal m) {
		vent = m;
		jLimagenGoku = new JLabel();
		ImageIcon image = new ImageIcon("datos/personajes/ImageGoku.png");
		ImageIcon image2 = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		jLimagenGoku.setIcon(image2);
		setPreferredSize(new Dimension(1200, 150));
		setLayout(new BorderLayout());
		add(jLimagenGoku, BorderLayout.WEST);
	}
	
	/**
	 * Metodo que pinta sobre el panel<br>
	 */
	public void paintComponent(Graphics g) {
		ImageIcon fondo = new ImageIcon("datos/auxiliares/ColorTierra.jpg");
		g.drawImage(fondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		paintVidaGoku(g);
		pintarDatosJugador(g);
	}
	
	/**
	 * Metodo que pinta la barra de la vida de goku<br>
	 * @param g con el Graphics que pinta<br>
	 */
	public void paintVidaGoku(Graphics g) {
		ImageIcon nombre = new ImageIcon("datos/auxiliares/NombreSonGoku.png");
		g.drawImage(nombre.getImage(), 150, 10, 150, 80, null);
		
		g.setColor(Color.RED);
		g.fillRect(150, 100, Juego.BARRA_VIDA, 25);
		
		g.setColor(Color.GREEN);
		g.fillRect(150, 100, vent.barraVida(), 25);
		
		g.setColor(Color.BLACK);
		g.drawRect(150, 100, Juego.BARRA_VIDA, 25);
	}
	
	
	public void pintarDatosJugador(Graphics g) {
		g.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		g.setColor(Color.blue);
		g.drawString("Puntos:", 850, 115);

		g.setColor(Color.yellow);
		String puntos = vent.jugadorActual().getPuntaje()+"";
		g.drawString(puntos, 920, 115);

		g.setColor(Color.blue);
		g.drawString("Nick:", 850, 85);
		
		g.setColor(Color.yellow);
		String nombre = vent.jugadorActual().getNickName();
		g.drawString(nombre, 920, 85);
	}
	
	
}
