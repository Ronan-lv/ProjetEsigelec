package Ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelExplorateurDeFichiers extends PanelGenerique{
	
	private JPanel panelHaut;
	private JPanel panelBas;

	
	private JButton boutonMenu;
	private JButton boutonLogOut;
	
	private JLabel titrePanel;
	
	private JFileChooser jfc;
	
	public PanelExplorateurDeFichiers() {

		//Cr�ation & configuration des composants
		
		this.boutonMenu = new JButton("Menu");
		this.boutonLogOut = new JButton("LogOut");
				
		this.titrePanel = new JLabel("Explorateur de fichiers");
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setHorizontalAlignment(JLabel.CENTER);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);
		
		this.jfc = new JFileChooser();
		this.jfc.setFileFilter(new FileNameExtensionFilter("Text files", "java"));
		
		//Cr�ation & configuration des panels
		
		this.panelHaut = new JPanel();
		this.panelHaut.setLayout(new BoxLayout(this.panelHaut, BoxLayout.LINE_AXIS));
		this.panelHaut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		this.panelBas = new JPanel();
		this.panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Ajouts des composants dans les panels
				
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createHorizontalGlue());
		
		this.panelBas.add(jfc);
		
		//Configuration du panel g�n�ral
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 50));
				
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(this.panelHaut);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(this.titrePanel);
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		this.add(this.panelBas);
		this.add(Box.createRigidArea(new Dimension(0, 100)));

	
	
	}
}
