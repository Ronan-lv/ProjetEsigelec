package Ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends PanelGenerique{

	private JButton boutonLogOut;
	private JLabel encartTexte;
	private JButton boutonDocumentsReferences;
	private JButton boutonExplorateurDeFichier;
	private JButton boutonGestionUtilisateur;
	
	private JPanel panelHaut;
	private JPanel panelBas;
	
	
	public PanelMenu() {
		
		this.boutonLogOut = new JButton("Log out");
		this.encartTexte = new JLabel("Menu");
		this.encartTexte.setHorizontalAlignment(this.encartTexte.CENTER);
		this.encartTexte.setVerticalAlignment(this.encartTexte.TOP);
		this.encartTexte.setFont(policeTaille2);
		
		this.boutonDocumentsReferences = new JButton("Documents référencés");
		this.boutonExplorateurDeFichier = new JButton("Explorateur de fichier");
		this.boutonGestionUtilisateur = new JButton("Gestion des utilisateurs");
		
		this.panelHaut = new JPanel();
		this.panelHaut.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 10));
		this.panelHaut.setLayout(new BorderLayout());
		
		this.panelBas = new JPanel();
		this.panelBas.setLayout(new GridLayout(0, 3, 10, 0));
		this.panelBas.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

		
		this.panelHaut.add(this.boutonLogOut, BorderLayout.EAST);
		this.panelBas.add(this.boutonDocumentsReferences);
		this.panelBas.add(this.boutonExplorateurDeFichier);
		this.panelBas.add(this.boutonGestionUtilisateur);
		
		this.setLayout(new GridLayout(6, 0));
		this.add(this.panelHaut);
		this.add(this.encartTexte);
		this.add(this.panelBas);
		
		
		
		
		
	}
	
}
