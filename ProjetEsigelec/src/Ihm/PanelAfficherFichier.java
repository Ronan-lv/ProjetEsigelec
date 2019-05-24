package Ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import moteur.VersionFichier;

public class PanelAfficherFichier extends PanelGenerique implements ActionListener{

	private JPanel panelHaut;
	private JPanel panelMilieu;
	private JPanel panelBas;
	
	private JButton boutonMenu;
	private JButton boutonLogOut;
	
	private JLabel titrePanel;
	
	private JTextArea zoneAffichageCode;
	private JScrollPane jsp;
	
	private JButton boutonAfficherAutresVersions;
	private JButton boutonUpdateVersion;
	private JButton boutonRetour;
	
	//Cette variable permet de ne lire qu'une seule fois le fichier
	private String contenuVersionChargeViaLectureFichier;
	
	public PanelAfficherFichier(Fenetre fen) {
		super(fen);
		
		//Création & configuration des panels
		
		this.panelHaut = new JPanel();
		this.panelHaut.setLayout(new BoxLayout(this.panelHaut, BoxLayout.LINE_AXIS));
		this.panelHaut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		this.panelMilieu = new JPanel();
		this.panelMilieu.setLayout(new BoxLayout(this.panelMilieu, BoxLayout.PAGE_AXIS));
		this.panelMilieu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.jsp = new JScrollPane(this.panelMilieu, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
				);
		this.jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

		
		this.panelBas = new JPanel();
		this.panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		//this.panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	
        	
		//Création & configuration des composants
		
		this.boutonMenu = new JButton("Menu");
		this.boutonMenu.addActionListener(this);
		this.boutonLogOut = new JButton("LogOut");
		this.boutonLogOut.addActionListener(this);
		
		this.titrePanel = new JLabel(this.fen.getDaoProjetJava().getProjetJava(this.fen.getIntDeTest()).getNomProjet()
									+ "  v"
									+ this.fen.getDaoProjetJava().recupererMajeurVersionProjetJava(this.fen.getIntDeTest())
									);
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);	
		
		this.zoneAffichageCode = new JTextArea();
		 
		this.remplissageZoneAffichageCode();
		
		this.boutonAfficherAutresVersions = new JButton("Versions antérieurs");
		this.boutonAfficherAutresVersions.addActionListener(this);
		this.boutonUpdateVersion = new JButton("Update Version");
		this.boutonUpdateVersion.addActionListener(this);
		
		if(verifierSiVersionEstAJour() == true) {
			this.boutonUpdateVersion.setEnabled(false);
		}
		
		this.boutonRetour = new JButton("Retour");
		this.boutonRetour.addActionListener(this);
		
	
		//Ajouts des composants dans les panels
		
		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createHorizontalGlue());
				
		this.panelMilieu.add(zoneAffichageCode);
		
		this.panelBas.add(this.boutonAfficherAutresVersions);
		this.panelBas.add(this.boutonUpdateVersion);
		this.panelBas.add(this.boutonRetour);
		
		//Configuration du panel général
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 50));
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(this.panelHaut);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(this.titrePanel);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(this.jsp);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(this.panelBas);
		this.add(Box.createRigidArea(new Dimension(0, 70)));
		
		verifierSiVersionEstAJour();
	
	
	}

	private void remplissageZoneAffichageCode() {
		this.zoneAffichageCode.setEditable(false);
		//Penser à afficher la description
		this.zoneAffichageCode.setText(this.fen.getDaoVersionFichier().getDerniereVersionFichierDuProjet(
				this.fen.getIntDeTest()).getContenuVersion());
	}
	
	
	private Boolean verifierSiVersionEstAJour() {
		
		String contenuFichier = "";
		String ligne;
		
		System.out.println("Coucou" + this.fen.getIntDeTest());
		
		try {
			
			FileReader fileReader = new FileReader(this.fen.getDaoProjetJava().getProjetJava(this.fen.getIntDeTest()).getDestinationProjet());

			BufferedReader reader = new BufferedReader(fileReader);
			
			while((ligne = reader.readLine()) != null) {
				contenuFichier = contenuFichier + "\n" + ligne;
			}
			
			this.contenuVersionChargeViaLectureFichier = contenuFichier;
						
			System.out.println(this.contenuVersionChargeViaLectureFichier);


		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		if(!contenuFichier.equals(this.fen.getDaoVersionFichier().getDerniereVersionFichierDuProjet(this.fen.getIntDeTest() ).getContenuVersion()))
		{
			System.out.println("Il faut mettre le fichier à jour");
			return false;
		}
		else {
			System.out.println("Le fichier est à jour");
			return true;
		}
		
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
		
		
		if(e.getSource() == this.boutonUpdateVersion) {
			
			String descriptionNouvelleVersion;
			
			descriptionNouvelleVersion = JOptionPane.showInputDialog(this.fen,
										"Description de cette nouvelle version", 
										"Version " + this.fen.getDaoProjetJava().recupererMajeurVersionProjetJava(this.fen.getIntDeTest()) + 1, 
										JOptionPane.QUESTION_MESSAGE);
			
			if(descriptionNouvelleVersion != null) {
								
				this.fen.getDaoVersionFichier().ajouter(new VersionFichier(0, 
						this.fen.getDaoProjetJava().recupererMajeurVersionProjetJava(this.fen.getIntDeTest()) + 1,0, 
						this.contenuVersionChargeViaLectureFichier, 
						descriptionNouvelleVersion, 
						this.fen.getIntDeTest()));
			}
			
			this.fen.setContentPane(new PanelAfficherFichier(this.fen));
			this.fen.revalidate();
			
			JOptionPane.showMessageDialog(this.fen, 
					"Vos modifications ont bien été enregistrés et le fichier est à jour",
					"Update réussit", 
					JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		if(e.getSource() == this.boutonRetour) {
			this.fen.setContentPane(new PanelFichiersReferences(this.fen));
			this.fen.revalidate();
		}
	}

}
 