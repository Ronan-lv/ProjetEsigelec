package Ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import moteur.Utilisateur;

/**
 * Classe PanelGestionDesComptes , permet l'affichage pour g�rer les comptes du
 * logiciel
 * 
 * @author Le Roux Gael , Le Viennesse Ronan
 *
 */
public class PanelGestionDesComptes extends PanelGenerique implements ActionListener {

	private JPanel panelHaut;
	private JPanel panelBas;
	private JPanel panelDroite;
	private JPanel panelGauche;

	private JButton boutonMenu;
	private JButton boutonLogOut;

	private JLabel titrePanel;

	private JLabel titrePanelGauche;
	private JTextArea champLogin;
	private JPasswordField champPassword;
	private JButton boutonAjouter;

	private JLabel titrePanelDroite;
	private JTextArea champDeRecherche;
	private JButton boutonAfficherHistorique;
	private JButton boutonSupprimer;

	/**
	 * Constructeur de la classe PanelGestionDesComptes
	 * 
	 * @param fen
	 */
	public PanelGestionDesComptes(Fenetre fen) {

		super(fen);

		// Cr�ation & configuration des composants

		this.boutonMenu = new JButton("Menu");
		this.boutonMenu.addActionListener(this);
		this.boutonLogOut = new JButton("LogOut");
		this.boutonLogOut.addActionListener(this);

		this.titrePanel = new JLabel("Gestion des comptes");
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setHorizontalAlignment(JLabel.CENTER);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);

		this.titrePanelGauche = new JLabel("Ajouter un utilisateur");
		this.titrePanelGauche.setFont(policeTaille2);
		this.titrePanelGauche.setHorizontalAlignment(JLabel.CENTER);
		this.titrePanelGauche.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.champLogin = new JTextArea("Login");
		this.champLogin.setFont(policeTaille2);
		this.champPassword = new JPasswordField("");
		this.champPassword.setFont(policeTaille2);
		this.boutonAjouter = new JButton("Ajouter");
		this.boutonAjouter.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.boutonAjouter.setFont(policeTaille2);
		this.boutonAjouter.addActionListener(this);

		this.titrePanelDroite = new JLabel("Trouver un utilisateur");
		this.titrePanelDroite.setFont(policeTaille2);
		this.titrePanelDroite.setHorizontalAlignment(JLabel.CENTER);
		this.champDeRecherche = new JTextArea("Nom d'utilisateur");
		this.champDeRecherche.setFont(policeTaille2);
		this.boutonAfficherHistorique = new JButton("Historique");
		this.boutonAfficherHistorique.setFont(policeTaille2);
		this.boutonAfficherHistorique.addActionListener(this);
		this.boutonSupprimer = new JButton("Supprimer");
		this.boutonSupprimer.setFont(policeTaille2);
		this.boutonSupprimer.addActionListener(this);

		// Cr�ation & configuration des panels

		this.panelHaut = new JPanel();
		this.panelHaut.setLayout(new BoxLayout(this.panelHaut, BoxLayout.LINE_AXIS));
		this.panelHaut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// this.panelHaut.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.panelBas = new JPanel();
		this.panelBas.setLayout(new GridLayout(0, 2, 50, 0));
		// this.panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.panelGauche = new JPanel();
		this.panelGauche.setLayout(new BoxLayout(this.panelGauche, BoxLayout.PAGE_AXIS));
		this.panelGauche.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		this.panelDroite = new JPanel();
		this.panelDroite.setLayout(new GridLayout(6, 0, 0, 10));
		this.panelDroite.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
				BorderFactory.createEmptyBorder(0, 10, 10, 10)));

		// Ajouts des composants dans les panels

		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createHorizontalGlue());

		this.panelGauche.add(this.titrePanelGauche);
		this.panelGauche.add(Box.createRigidArea(new Dimension(0, 25)));
		this.panelGauche.add(this.champLogin);
		this.panelGauche.add(Box.createRigidArea(new Dimension(0, 10)));
		this.panelGauche.add(this.champPassword);
		this.panelGauche.add(Box.createRigidArea(new Dimension(0, 15)));
		this.panelGauche.add(this.boutonAjouter);
		this.panelGauche.add(Box.createRigidArea(new Dimension(0, 150)));

		this.panelDroite.add(this.titrePanelDroite);
		this.panelDroite.add(this.champDeRecherche);
		this.panelDroite.add(this.boutonAfficherHistorique);
		this.panelDroite.add(this.boutonSupprimer);

		this.panelBas.add(this.panelGauche);
		this.panelBas.add(this.panelDroite);

		// Configuration du panel g�n�ral

		this.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 50));

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(this.panelHaut);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(this.titrePanel);
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		this.add(this.panelBas);
		this.add(Box.createRigidArea(new Dimension(0, 100)));

	}

	/**
	 * M�thode qui permet de g�rer les �venement d'un utilisateur sur le
	 * PanelGestionDesComptes , souris ,clavier ...
	 * 
	 * @param e , la source d'un evenement
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		ArrayList<Utilisateur> listeUtilisateurs = this.fen.getDaoUtilisateur().getListeUtilisateurs();

		if (e.getSource() == this.boutonMenu) {
			this.fen.setContentPane(new PanelMenu(this.fen));
			this.fen.revalidate();
		}

		if (e.getSource() == this.boutonLogOut) {
			this.fen.setContentPane(new PanelConnexion(this.fen));
			this.fen.revalidate();
		}
		if (e.getSource() == this.boutonAjouter) {

			boolean utilisateurtrouver = false;

			for (int i = 0; i < listeUtilisateurs.size(); i++) {

				if (this.champLogin.getText().equals(listeUtilisateurs.get(i).getIdentifiant())) {

					utilisateurtrouver = true;
				} else {
					utilisateurtrouver = false;
				}
			}
			if (utilisateurtrouver == true) {
				JOptionPane.showMessageDialog(null, " L'identifiant existe d�j� ");
			}
			if (utilisateurtrouver == false) {
				if (this.champPassword.getPassword().length >= 3 && this.champLogin.getText() != "login") {
					this.fen.getDaoUtilisateur()
							.ajouter(new Utilisateur(this.champLogin.getText(), this.champPassword.getText(), false));
					JOptionPane.showMessageDialog(null, " l'utilisateur � �t� ajout� ");
				} else {
					JOptionPane.showMessageDialog(null,
							" mot de passe inf�rieur � 3 caract�res , ou identifiant incorrect ");
				}

			}
		}

		if (e.getSource() == this.boutonSupprimer) {
			boolean utilisateurtrouver = false;

			for (int i = 0; i < listeUtilisateurs.size(); i++) {

				if (this.champDeRecherche.getText().equals(listeUtilisateurs.get(i).getIdentifiant())) {

					utilisateurtrouver = true;
				}
			}
			if (utilisateurtrouver == false) {
				JOptionPane.showMessageDialog(null, " L'utilisateur n'existe pas ");
			}
			if (utilisateurtrouver == true) {
				if (JOptionPane.showConfirmDialog(this, "�tes-vous s�r de vouloir supprimer l'utilisateur ?", "Suppresion",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
				this.fen.getDaoUtilisateur().supprimer(this.champDeRecherche.getText());
				JOptionPane.showMessageDialog(null, " L'utilisateur a �t� supprim� ");
				}
			}
		}
		if (e.getSource() == this.boutonAfficherHistorique) {
			boolean utilisateurtrouver = false;

			for (int i = 0; i < listeUtilisateurs.size(); i++) {

				if (this.champDeRecherche.getText().equals(listeUtilisateurs.get(i).getIdentifiant())) {

					utilisateurtrouver = true;
				}
			}
			if (utilisateurtrouver == false) {
				JOptionPane.showMessageDialog(null, " L'utilisateur n'existe pas ");
			}
			if (utilisateurtrouver == true) {
				this.fen.setStringDeTest(this.champDeRecherche.getText());
				this.fen.setContentPane(new PanelHistorique(this.fen));
				this.fen.revalidate();
			}
		}

	}

}
