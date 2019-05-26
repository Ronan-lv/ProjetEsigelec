package Ihm;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DAO.DAOProjetJava;
import DAO.DAOUtilisateur;
import DAO.DAOVersionFichier;
import moteur.Utilisateur;

/**
 * Classe fenetre , permet l'affichage d'une fenetre pour notre logiciel
 * 
 * @author Gael Le Roux et Ronan Le Viennesse
 *
 */
public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private String titreFenetre = "Logiciel De Gestion Java";
	private Dimension dimensionFenetre = new Dimension(750, 600);
	private JPanel lePanel = new PanelConnexion(this);

	private DAOUtilisateur daoUtilisateur; // importation des DAO
	private DAOProjetJava daoProjetJava;
	private DAOVersionFichier daoVersionFichier;

	private Utilisateur UtilisateurActif; // création d'un utilisateur actif

	private int intDeTest; // variables tampons
	private String stringDeTest;

	/**
	 * constructeur de la Classe fenetre
	 */
	public Fenetre() {

		this.setTitle(titreFenetre);
		this.setSize(dimensionFenetre);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setContentPane(lePanel);

		this.setVisible(true);

		/*
		 * On commence à charger les données depuis la BDD uniquement après avoir
		 * afficher la fenêtre. Cela permet non seulement d'éviter à l'utilisateur de
		 * devoir patienter sans rien affiché à l'écran, mais également cela laisse la
		 * possibilité dans un développement futur, d'implémenter une interface
		 * graphique destinée à le faire patentier durant le chargement.
		 */
		this.daoUtilisateur = new DAOUtilisateur();
		this.daoProjetJava = new DAOProjetJava();
		this.daoVersionFichier = new DAOVersionFichier();
	}

	// LES GETTERS :
	/**
	 * Méthode qui permet de récupérer un objet de type DAOUtilisateur
	 * 
	 * @return DAOUtilisateur
	 */
	public DAOUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}

	/**
	 * Méthode qui permet de récupérer un objet de type DAOProjetJava
	 * 
	 * @return DAOProjetJava
	 */
	public DAOProjetJava getDaoProjetJava() {
		return daoProjetJava;
	}

	/**
	 * Méthode qui permet de récupérer un objet de type DAOVersionFichier
	 * 
	 * @return DAOVersionFichier
	 */
	public DAOVersionFichier getDaoVersionFichier() {
		return daoVersionFichier;
	}

	/**
	 * Méthode qui permet de récupérer un objet de type UtilisateurActif
	 * 
	 * @return UtilisateurActif
	 */
	public Utilisateur getUtilisateurActif() {
		return UtilisateurActif;
	}

	/**
	 * Méthode qui permet de récupérer l'entier test enregistré
	 * 
	 * @return intdeTest
	 */
	public int getIntDeTest() {
		return intDeTest;
	}

	/**
	 * Méthode qui permet de récupérer le String de test
	 * 
	 * @return stringdeTest
	 */
	public String getStringDeTest() {
		return stringDeTest;
	}

	//LES SETTERS :
	/**
	 * Méthode qui permet de saisir ou remplacer un objet de type DAOUtilisateur
	 * 
	 * @param daoUtilisateur
	 */
	public void setDaoUtilisateur(DAOUtilisateur daoUtilisateur) {
		this.daoUtilisateur = daoUtilisateur;
	}

	/**
	 * Méthode qui permet de saisir ou remplacer un objet de type DAOProjetJava
	 * 
	 * @param DAOProjetJava
	 */
	public void setDaoProjetJava(DAOProjetJava daoProjetJava) {
		this.daoProjetJava = daoProjetJava;
	}

	/**
	 * Méthode qui permet de saisir ou remplacer un objet de type DAOVersionFichier
	 * 
	 * @param DAOVersionFichier
	 */
	public void setDaoVersionFichier(DAOVersionFichier daoVersionFichier) {
		this.daoVersionFichier = daoVersionFichier;
	}

	/**
	 * Méthode qui permet de saisir ou remplacer un objet de type UtilisateurActif
	 * 
	 * @param UtilisateurActif
	 */
	public void setUtilisateurActif(Utilisateur utilisateurActif) {
		UtilisateurActif = utilisateurActif;
	}

	/**
	 * méthode qui permet de saisir ou remplacer l'entier de test
	 * 
	 * @param intDeTest
	 */
	public void setIntDeTest(int intDeTest) {
		this.intDeTest = intDeTest;
	}

	/**
	 * Méthode qui permet de saisir ou remplacer le String de test
	 * 
	 * @param stringDeTest
	 */
	public void setStringDeTest(String stringDeTest) {
		this.stringDeTest = stringDeTest;
	}

}
