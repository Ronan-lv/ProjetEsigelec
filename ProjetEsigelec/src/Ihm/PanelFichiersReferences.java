package Ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import moteur.ProjetJava;

/**
 * Classe qui permet l'affichages des fichiers r�f�renc�s
 * 
 * @author Gael Le Roux et Ronan Le Viennesse
 */
public class PanelFichiersReferences extends PanelGenerique implements ActionListener {

	private JPanel panelHaut;
	private JPanel panelMilieu;
	private JPanel panelBas;

	private JButton boutonMenu;
	private JButton boutonLogOut;

	private JLabel titrePanel;

	private JScrollPane jsp;

	private JButton boutonAfficher;
	private JButton boutonSupprimer;
	private JButton boutonAfficherLesVersions;

	private ArrayList<JButton> listeDeBoutons = new ArrayList<JButton>();
	private int indexDernierBoutonSelectionne;

	ArrayList<ProjetJava> listeProjetJava = this.fen.getDaoProjetJava()
			.getListeProjetJavaUtilisateur(this.fen.getUtilisateurActif().getReference());

	/**
	 * Constructzeur de la Classe PanelFichierR�ferences
	 * 
	 * @param fen
	 */
	public PanelFichiersReferences(Fenetre fen) {

		super(fen);

		this.indexDernierBoutonSelectionne = -1;

		// Cr�ation & configuration des panels

		this.panelHaut = new JPanel();
		this.panelHaut.setLayout(new BoxLayout(this.panelHaut, BoxLayout.LINE_AXIS));
		this.panelHaut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		this.panelMilieu = new JPanel();
		this.panelMilieu.setLayout(new GridLayout(0, 1, 10, 10));
		this.panelMilieu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.jsp = new JScrollPane(this.panelMilieu, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

		this.panelBas = new JPanel();
		this.panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		// this.panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// Cr�ation & configuration des composants

		this.boutonMenu = new JButton("Menu");
		this.boutonMenu.addActionListener(this);
		this.boutonLogOut = new JButton("LogOut");
		this.boutonLogOut.addActionListener(this);

		this.titrePanel = new JLabel("Fichiers r�f�renc�s");
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);

		this.boutonAfficher = new JButton("Afficher");
		this.boutonAfficher.addActionListener(this);
		this.boutonSupprimer = new JButton("Supprimer");
		this.boutonSupprimer.addActionListener(this);
		this.boutonAfficherLesVersions = new JButton("Afficher Versions");
		this.boutonAfficherLesVersions.addActionListener(this);

		// Ajouts des composants dans les panels

		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createHorizontalGlue());

		this.remplissageDuPanelMilieuAvecDesLignesGraphiques();

		this.panelBas.add(this.boutonAfficher);
		this.panelBas.add(this.boutonSupprimer);
		this.panelBas.add(this.boutonAfficherLesVersions);

		// Configuration du panel g�n�ral

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
	 * M�thode qui permet le remplissage du panelMilieu avec des lignes graphiques
	 */
	private void remplissageDuPanelMilieuAvecDesLignesGraphiques() {

		for (int i = 0; i < listeProjetJava.size(); i++) {

			JButton uneLigneAffichage = new JButton();

			uneLigneAffichage.addActionListener(this);

			uneLigneAffichage.setLayout(new BoxLayout(uneLigneAffichage, BoxLayout.LINE_AXIS));
			uneLigneAffichage.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
					BorderFactory.createEmptyBorder(3, 3, 3, 3)));

			uneLigneAffichage.add(new JLabel(listeProjetJava.get(i).getDateProjet().toLocaleString()));
			uneLigneAffichage.add(Box.createHorizontalStrut(90));

			uneLigneAffichage.add(new JLabel(listeProjetJava.get(i).getNomProjet()));
			uneLigneAffichage.add(Box.createHorizontalStrut(90));

			uneLigneAffichage.add(new JLabel("v"+Integer.toString(
					this.fen.getDaoProjetJava().recupererMajeurVersionProjetJava(listeProjetJava.get(i).getIdProjet()))
					+ "." + Integer.toString(this.fen.getDaoProjetJava()
							.recupererMineurVersionProjetJava(listeProjetJava.get(i).getIdProjet()))));
			uneLigneAffichage.add(Box.createHorizontalStrut(90));

			uneLigneAffichage.add(new JLabel("ligne n� " + (i + 1)));

			this.panelMilieu.add(uneLigneAffichage);

			this.listeDeBoutons.add(uneLigneAffichage);

		}

	}

	/**
	 * M�thode qui permet de g�rer les �venement d'un utilisateur sur le
	 * PanelFichierReferences , souris ,clavier ...
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
		
		
		

		for (int i = 0; i < this.panelMilieu.getComponents().length; i++) {

			if (e.getSource() == this.panelMilieu.getComponents()[i]) {

				JButton btn = (JButton) this.panelMilieu.getComponents()[i];
				JLabel label = (JLabel) btn.getComponent(2);

				for (int j = 0; j < this.listeProjetJava.size(); j++) {

					if (this.listeProjetJava.get(j).getNomProjet().equals(label.getText())) {

						btn.setBorder(BorderFactory.createLineBorder(Color.black, 3));

						if (this.indexDernierBoutonSelectionne != -1 && this.indexDernierBoutonSelectionne != j) {

							this.listeDeBoutons.get(this.indexDernierBoutonSelectionne)
									.setBorder(BorderFactory.createLineBorder(Color.black, 1));
							;
						}

						this.indexDernierBoutonSelectionne = j;

						this.fen.setIntDeTest(this.listeProjetJava.get(j).getIdProjet());
					}

				}

				this.fen.revalidate();
			}

		}

		if (e.getSource() == this.boutonAfficher) {
			this.fen.setContentPane(new PanelAfficherFichier(this.fen));
			this.fen.revalidate();
		}

		if (e.getSource() == this.boutonSupprimer) {

			if (JOptionPane.showConfirmDialog(this, "�tes-vous s�r de vouloir supprimer le projet ?", "Suppresion",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {

				this.fen.getDaoProjetJava().supprimerProjetJava(
						this.listeProjetJava.get(this.indexDernierBoutonSelectionne).getIdProjet());

				this.listeProjetJava.remove(this.indexDernierBoutonSelectionne);

				this.listeDeBoutons.remove(this.indexDernierBoutonSelectionne);

				this.fen.setContentPane(new PanelFichiersReferences(this.fen));
				this.fen.revalidate();
			}
		}
		
		if(e.getSource() == this.boutonAfficherLesVersions) {
			this.fen.setContentPane(new PanelAfficherVersions(this.fen));
			this.fen.revalidate();
			
		}
		
		
		
		
		
		
		
	}

}
