package Ihm;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

/**
 * Classe PanelGénérique , permet d'avoir le meme fond et les memes couleurs
 * ,sur chaque panel
 * 
 * @author Le Roux Gael et Le Viennesse Ronan
 *
 */
public class PanelGenerique extends JPanel {

	protected final Color couleurDeFond = new Color(245, 245, 245); // blanc
	protected final Color couleurPrimaire = new Color(234, 235, 233);
	protected final Color couleurSecondaire = new Color(234, 235, 233);

	protected final Font policeTaille1 = new Font("Arial", Font.PLAIN, 15);
	protected final Font policeTaille2 = new Font("Arial", Font.BOLD, 20);

	protected Fenetre fen;

	/**
	 * Constructeur du panelGenerique
	 * 
	 * @param fen
	 */
	public PanelGenerique(Fenetre fen) {
		this.fen = fen;
	}
}
