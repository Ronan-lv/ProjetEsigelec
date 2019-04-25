package Ihm;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titreFenetre = "G�T";
	private Dimension dimensionFenetre = new Dimension(750,600);
	private JPanel lePanel = new PanelConnexion(this);
	
	public Fenetre(){
		
		this.setTitle(titreFenetre);
		this.setSize(dimensionFenetre);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setContentPane(lePanel);
		
		this.setVisible(true);
	}
	

		
}
