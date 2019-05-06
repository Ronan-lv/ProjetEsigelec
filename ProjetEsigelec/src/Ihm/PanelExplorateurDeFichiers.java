package Ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import moteur.ProjetJava;
import moteur.VersionFichier;

public class PanelExplorateurDeFichiers extends PanelGenerique implements ActionListener{

	
	private JPanel panelHaut;
	private JPanel panelBas;
	
	private JButton boutonMenu;
	private JButton boutonLogOut;
	
	private JLabel titrePanel;
	
	private JFileChooser jfc;
	
    public PanelExplorateurDeFichiers(Fenetre fen)  {
		
    	super(fen);
    	
		//Crï¿½ation & configuration des composants
		
		this.boutonMenu = new JButton("Menu");
		this.boutonMenu.addActionListener(this);
		this.boutonLogOut = new JButton("LogOut");
		this.boutonLogOut.addActionListener(this);
		
		this.titrePanel = new JLabel("Explorateur de Fichiers");
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);
		
		this.jfc = new JFileChooser();
		this.jfc.addActionListener(this);
	
		
		//Crï¿½ation & configuration des panels
		
		this.panelHaut = new JPanel();
		this.panelHaut.setLayout(new BoxLayout(this.panelHaut, BoxLayout.LINE_AXIS));
		this.panelHaut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		this.panelBas = new JPanel();
		this.panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK));


		
		//Ajouts des composants dans les panels
		
		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createHorizontalGlue());
		
		this.panelBas.add(this.jfc);
		
		//Configuration du panel gï¿½nï¿½ral
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 50));
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(this.panelHaut);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(this.titrePanel);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(this.panelBas);
		this.add(Box.createRigidArea(new Dimension(0, 100)));
		
		



		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.boutonMenu) {
			this.fen.setContentPane(new PanelMenu(this.fen));
			this.fen.revalidate();
		}
		
		if(e.getSource() == this.boutonLogOut) {
			this.fen.setContentPane(new PanelConnexion(this.fen));
			this.fen.revalidate();
		}
		
		if(e.getSource() == this.jfc) {
			
			ArrayList<ProjetJava> listeProjetJava = this.fen.getDaoProjetJava().getListeProjetJava();
			
			Boolean fichierDejaReference = false;
			
			for(int i = 0; i < listeProjetJava.size(); i++) {
				if(listeProjetJava.get(i).getDestinationProjet().equals(this.jfc.getSelectedFile().getAbsolutePath())) {
					
					JOptionPane.showMessageDialog(null, "Le fichier à déja été référencé !");
					fichierDejaReference = true;
				}
			}
			
			if(fichierDejaReference == false) {
				
				String nomProjet = JOptionPane.showInputDialog(this, "Nom du projet :", "Référencer un nouveau projet", JOptionPane.NO_OPTION);
				
				if(nomProjet != null) {
					
					//ATTENTION => listeProjetJava.size() ne marche plus pour la création de l'id à partir du moment ou l'on supprime une ligne
					
					this.fen.getDaoProjetJava().ajouter(new ProjetJava(listeProjetJava.size() + 1,
																		nomProjet,
																		this.jfc.getSelectedFile().getAbsolutePath(),
																		new Date(System.currentTimeMillis()), //(modification de l'heure d'affichage en temps réel)
																		this.fen.getUtilisateurActif().getReference()));
					
					this.fen.getDaoVersionFichier().ajouter(new VersionFichier(listeProjetJava.size() + 1,
																		0,
																		1,
																		recupererContenuFichier(this.jfc.getSelectedFile()),
																		"La première description",
																		listeProjetJava.size() + 1));

					JOptionPane.showMessageDialog(null, "Le fichier a bien été référencé");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Fichier non référencé");

				}
				
				
			
			
			}
			
		}		
		
	}
	
	
	private String recupererContenuFichier(File f) {
		
		String contenuFichier = "";
		String ligne;
		
		try {
			FileReader fileReader = new FileReader(f.getAbsolutePath());
			BufferedReader reader = new BufferedReader(fileReader);
			
			while((ligne = reader.readLine()) != null) {
				contenuFichier = contenuFichier + "\n" + ligne;
			}
						
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return contenuFichier;
	}
	

}
 