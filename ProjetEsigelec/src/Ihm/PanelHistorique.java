package Ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import moteur.ProjetJava;
import moteur.VersionFichier;

/**
 * Classe PanelHistorique , elle permet l'affichage de l'historique d'un
 * utilisateur
 * 
 * @author Le Roux Gael et Ronan Le Viennesse
 *
 */
public class PanelHistorique extends PanelGenerique implements ActionListener {

	private JPanel panelHaut;
	private JPanel panelMilieu;
	private JPanel panelBas;

	private JButton boutonMenu;
	private JButton boutonLogOut;

	private JLabel titrePanel;

	private JTextArea zoneAffichageCode;
	private JScrollPane jsp;

	private JButton boutonRetour;

	/**
	 * Constructeur de la Classe PanelHistorique
	 * 
	 * @param fen
	 */
	public PanelHistorique(Fenetre fen) {
		super(fen);

		// Création & configuration des panels

		this.panelHaut = new JPanel();
		this.panelHaut.setLayout(new BoxLayout(this.panelHaut, BoxLayout.LINE_AXIS));
		this.panelHaut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		this.panelMilieu = new JPanel();
		this.panelMilieu.setLayout(new BoxLayout(this.panelMilieu, BoxLayout.PAGE_AXIS));
		this.panelMilieu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.jsp = new JScrollPane(this.panelMilieu, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

		this.panelBas = new JPanel();
		this.panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		// this.panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// Création & configuration des composants

		this.boutonMenu = new JButton("Menu");
		this.boutonMenu.addActionListener(this);
		this.boutonLogOut = new JButton("LogOut");
		this.boutonLogOut.addActionListener(this);

		this.titrePanel = new JLabel("Utilisateur:"
				+ this.fen.getDaoUtilisateur().getUtilisateur(this.fen.getStringDeTest()).getIdentifiant());
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);

		this.zoneAffichageCode = new JTextArea();

		this.remplissageZoneAffichageCode();

		this.boutonRetour = new JButton("Retour");
		this.boutonRetour.addActionListener(this);

		// Ajouts des composants dans les panels

		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createHorizontalGlue());

		this.panelMilieu.add(zoneAffichageCode);

		this.panelBas.add(this.boutonRetour);

		// Configuration du panel général

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

	}

	/**
	 * Méthode qui permet de rempolir la zone d'affichage du texte pour l'historique
	 */
	private void remplissageZoneAffichageCode() {
		this.zoneAffichageCode.setEditable(false);
		ArrayList<ProjetJava> listeProjetJava = this.fen.getDaoProjetJava()
				.getListeProjetJavaUtilisateurHistorique(this.fen.getStringDeTest());
		// Penser à afficher la description
		this.zoneAffichageCode.append("\t\t VOICI L'HISTORIQUE DE L'UTILISATEUR :\n");
		this.zoneAffichageCode.append("\t\t ----------------------------------------------------------\n");
		for (int i = 0; i < listeProjetJava.size(); i++) {
			this.zoneAffichageCode.append("PROJET N°" + (i + 1) + ":\n");
			this.zoneAffichageCode.append("-------------------------\n");
			this.zoneAffichageCode.append("NOM:	" + listeProjetJava.get(i).getNomProjet() + "\n");
			this.zoneAffichageCode.append("DESTINATION:	" + listeProjetJava.get(i).getDestinationProjet() + "\n");
			this.zoneAffichageCode.append("DATE:	" + listeProjetJava.get(i).getDateProjet() + "\n\n");

			ArrayList<VersionFichier> listeVersionFichier = this.fen.getDaoVersionFichier()
					.getListeVersion(listeProjetJava.get(i).getIdProjet());
			System.out.println(listeProjetJava.get(i).getIdProjet());
			for (int j = 0; j < listeVersionFichier.size(); j++) {
				this.zoneAffichageCode.append("(VERSION N°:" + listeVersionFichier.get(j).getNumeroMaj() + "."
						+ listeVersionFichier.get(j).getNumeroMin() + "):\n");
				this.zoneAffichageCode
						.append("DESCRIPTION:" + listeVersionFichier.get(j).getContenuDescription() + "\n\n");
			}
		}
	}

	/**
	 * Méthode qui permet de gérer les évenement d'un utilisateur sur le
	 * PanelHistorique , souris ,clavier ...
	 * 
	 * @param e , la source d'un evenement
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.boutonMenu) {
			this.fen.setContentPane(new PanelMenu(this.fen));
			this.fen.revalidate();
		}

		if (e.getSource() == this.boutonLogOut) {
			this.fen.setContentPane(new PanelConnexion(this.fen));
			this.fen.revalidate();
		}

		if (e.getSource() == this.boutonRetour) {
			this.fen.setContentPane(new PanelGestionDesComptes(this.fen));
			this.fen.revalidate();
		}
	}

}
