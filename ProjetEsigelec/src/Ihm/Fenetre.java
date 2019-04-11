package Ihm;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	private String titreFenetre = "GÏT";
	private Dimension dimensionFenetre = new Dimension(750,600);
	private JPanel lePanel = new PanelExplorateurDeFichiers();
	
	public Fenetre(){
		
		this.setTitle(titreFenetre);
		this.setSize(dimensionFenetre);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setContentPane(lePanel);
		
		this.setVisible(true);
	}
		
}
