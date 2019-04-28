package Ihm;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DAO.DAOProjetJava;
import DAO.DAOUtilisateur;
import DAO.DAOVersionFichier;
import moteur.Utilisateur;

public class Fenetre extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titreFenetre = "Gï¿½T";
	private Dimension dimensionFenetre = new Dimension(750,600);
	private JPanel lePanel = new PanelConnexion(this);
	
	private DAOUtilisateur daoUtilisateur;
	private DAOProjetJava daoProjetJava;
	private DAOVersionFichier daoVersionFichier;
	
	private Utilisateur UtilisateurActif;
	
	private String stringDeTest;
	

	public Fenetre(){
		
		this.setTitle(titreFenetre);
		this.setSize(dimensionFenetre);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setContentPane(lePanel);
		
		this.setVisible(true);
		
		/* On commence à charger les données depuis la BDD uniquement après avoir afficher la fenêtre.
		 * Cela permet non seulement d'éviter à l'utilisateur de devoir patienter sans rien affiché à l'écran, 
		 * mais également cela laisse la possibilité dans un développement futur, d'implémenter une interface graphique
		 * destinée à le faire patentier durant le chargement. 
		 */
		this.daoUtilisateur = new DAOUtilisateur();
		this.daoProjetJava = new DAOProjetJava();
		this.daoVersionFichier = new DAOVersionFichier();
	}
	
	
	
	public DAOUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}

	public void setDaoUtilisateur(DAOUtilisateur daoUtilisateur) {
		this.daoUtilisateur = daoUtilisateur;
	}
	
	
	public DAOProjetJava getDaoProjetJava() {
		return daoProjetJava;
	}

	public void setDaoProjetJava(DAOProjetJava daoProjetJava) {
		this.daoProjetJava = daoProjetJava;
	}
	

	public DAOVersionFichier getDaoVersionFichier() {
		return daoVersionFichier;
	}


	public void setDaoVersionFichier(DAOVersionFichier daoVersionFichier) {
		this.daoVersionFichier = daoVersionFichier;
	}



	
	
	
	
	public Utilisateur getUtilisateurActif() {
		return UtilisateurActif;
	}

	public void setUtilisateurActif(Utilisateur utilisateurActif) {
		UtilisateurActif = utilisateurActif;
	}

	
	
	
	//test
	public String getStringDeTest() {
		return stringDeTest;
	}
	public void setStringDeTest(String stringDeTest) {
		this.stringDeTest = stringDeTest;
	}
	
	
	//test
	
	
	

		
}
