package Ihm;

import java.awt.Color;

import javax.swing.JPanel;

public class PanelGenerique extends JPanel{
	
	protected final Color couleurDeFond = new Color(245, 245, 245); //blanc
	protected final Color couleurPrimaire = new Color(234, 235, 233); 
	protected final Color couleurSecondaire = new Color(234, 235, 233);
		
	public PanelGenerique() {
		this.setBackground(couleurDeFond);
	}
}
