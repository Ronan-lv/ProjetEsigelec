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

	private Utilisateur UtilisateurActif; // cr�ation d'un utilisateur actif

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
		 * On commence � charger les donn�es depuis la BDD uniquement apr�s avoir
		 * afficher la fen�tre. Cela permet non seulement d'�viter � l'utilisateur de
		 * devoir patienter sans rien affich� � l'�cran, mais �galement cela laisse la
		 * possibilit� dans un d�veloppement futur, d'impl�menter une interface
		 * graphique destin�e � le faire patentier durant le chargement.
		 */
		this.daoUtilisateur = new DAOUtilisateur();
		this.daoProjetJava = new DAOProjetJava();
		this.daoVersionFichier = new DAOVersionFichier();
	}

	// LES GETTERS :
	/**
	 * M�thode qui permet de r�cup�rer un objet de type DAOUtilisateur
	 * 
	 * @return DAOUtilisateur
	 */
	public DAOUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}

	/**
	 * M�thode qui permet de r�cup�rer un objet de type DAOProjetJava
	 * 
	 * @return DAOProjetJava
	 */
	public DAOProjetJava getDaoProjetJava() {
		return daoProjetJava;
	}

	/**
	 * M�thode qui permet de r�cup�rer un objet de type DAOVersionFichier
	 * 
	 * @return DAOVersionFichier
	 */
	public DAOVersionFichier getDaoVersionFichier() {
		return daoVersionFichier;
	}

	/**
	 * M�thode qui permet de r�cup�rer un objet de type UtilisateurActif
	 * 
	 * @return UtilisateurActif
	 */
	public Utilisateur getUtilisateurActif() {
		return UtilisateurActif;
	}

	/**
	 * M�thode qui permet de r�cup�rer l'entier test enregistr�
	 * 
	 * @return intdeTest
	 */
	public int getIntDeTest() {
		return intDeTest;
	}

	/**
	 * M�thode qui permet de r�cup�rer le String de test
	 * 
	 * @return stringdeTest
	 */
	public String getStringDeTest() {
		return stringDeTest;
	}

	//LES SETTERS :
	/**
	 * M�thode qui permet de saisir ou remplacer un objet de type DAOUtilisateur
	 * 
	 * @param daoUtilisateur
	 */
	public void setDaoUtilisateur(DAOUtilisateur daoUtilisateur) {
		this.daoUtilisateur = daoUtilisateur;
	}

	/**
	 * M�thode qui permet de saisir ou remplacer un objet de type DAOProjetJava
	 * 
	 * @param DAOProjetJava
	 */
	public void setDaoProjetJava(DAOProjetJava daoProjetJava) {
		this.daoProjetJava = daoProjetJava;
	}

	/**
	 * M�thode qui permet de saisir ou remplacer un objet de type DAOVersionFichier
	 * 
	 * @param DAOVersionFichier
	 */
	public void setDaoVersionFichier(DAOVersionFichier daoVersionFichier) {
		this.daoVersionFichier = daoVersionFichier;
	}

	/**
	 * M�thode qui permet de saisir ou remplacer un objet de type UtilisateurActif
	 * 
	 * @param UtilisateurActif
	 */
	public void setUtilisateurActif(Utilisateur utilisateurActif) {
		UtilisateurActif = utilisateurActif;
	}

	/**
	 * m�thode qui permet de saisir ou remplacer l'entier de test
	 * 
	 * @param intDeTest
	 */
	public void setIntDeTest(int intDeTest) {
		this.intDeTest = intDeTest;
	}

	/**
	 * M�thode qui permet de saisir ou remplacer le String de test
	 * 
	 * @param stringDeTest
	 */
	public void setStringDeTest(String stringDeTest) {
		this.stringDeTest = stringDeTest;
	}

}
