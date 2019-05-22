package Ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelMenu extends PanelGenerique implements ActionListener{

	private JButton boutonLogOut;
	private JLabel encartTexte;
	private JButton boutonDocumentsReferences;
	private JButton boutonExplorateurDeFichier;
	private JButton boutonGestionUtilisateur;
	
	private JPanel panelHaut;
	private JPanel panelBas;
	
	
	public PanelMenu(Fenetre fen) {
		
		super(fen);
		
		this.boutonLogOut = new JButton("Log out");
		this.boutonLogOut.addActionListener(this);
		this.encartTexte = new JLabel("Menu");
		this.encartTexte.setHorizontalAlignment(this.encartTexte.CENTER);
		this.encartTexte.setVerticalAlignment(this.encartTexte.TOP);
		this.encartTexte.setFont(policeTaille2);
		
		this.boutonDocumentsReferences = new JButton("Documents référencés");
		this.boutonDocumentsReferences.addActionListener(this);
		this.boutonExplorateurDeFichier = new JButton("Explorateur de fichier");
		this.boutonExplorateurDeFichier.addActionListener(this);
		this.boutonGestionUtilisateur = new JButton("Gestion des utilisateurs");
		this.boutonGestionUtilisateur.addActionListener(this);
		
		this.panelHaut = new JPanel();
		this.panelHaut.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 10));
		this.panelHaut.setLayout(new BorderLayout());
		
		this.panelBas = new JPanel();
		this.panelBas.setLayout(new GridLayout(0, 3, 10, 0));
		this.panelBas.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

	
		if (this.fen.getUtilisateurActif().getIsGestionnaire()==true) {
			this.panelBas.setLayout(new GridLayout(0, 3, 10, 0));
			this.panelBas.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
			this.panelHaut.add(this.boutonLogOut, BorderLayout.EAST);
			this.panelBas.add(this.boutonDocumentsReferences);
			this.panelBas.add(this.boutonExplorateurDeFichier);
			this.panelBas.add(this.boutonGestionUtilisateur);
		}		
		if (this.fen.getUtilisateurActif().getIsGestionnaire()==false) {
			this.panelBas.setLayout(new GridLayout(2, 0, 10, 0));
			this.panelBas.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
			this.panelHaut.add(this.boutonLogOut, BorderLayout.EAST);
			this.panelBas.add(this.boutonDocumentsReferences);
			this.panelBas.add(this.boutonExplorateurDeFichier);
		}
		
		
		this.setLayout(new GridLayout(6, 0));
		this.add(this.panelHaut);
		this.add(this.encartTexte);
		this.add(this.panelBas);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.boutonLogOut) {
			this.fen.setContentPane(new PanelConnexion(this.fen));
			this.fen.revalidate();
		}

		if(e.getSource() == this.boutonDocumentsReferences) {
			this.fen.setContentPane(new PanelFichiersReferences(this.fen));
			this.fen.revalidate();
		}
		if(e.getSource() == this.boutonExplorateurDeFichier) {
			this.fen.setContentPane(new PanelExplorateurDeFichiers(this.fen));
			this.fen.revalidate();
		}
		if(e.getSource() == this.boutonGestionUtilisateur) {
			this.fen.setContentPane(new PanelGestionDesComptes(this.fen));
			this.fen.revalidate();
		}
		
	}
	
}
