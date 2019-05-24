package moteur;

import java.util.ArrayList;

/**
 * 
 * @author Gael Leroux et Ronan Le Viennesse version : La classe utilisateur du
 *         logiciel
 */
public class Utilisateur {

// déclarations des variables de la classe Utilisateur  :
	private int reference ;
	private String identifiant;
	private String mot_de_passe;
	private boolean isGestionnaire;
	
	
	private ArrayList<ProjetJava> listeprojet;

	// le constructeur de Utilisateur
	/**
	 * Constructeur de la classe Utilisateur
	 * 
	 * @param identifiaznt , mot_de_passe ,type
	 */
	public Utilisateur(int ref ,String id, String mdp, boolean g) {
		this.reference = ref ;
		this.identifiant = id;
		this.mot_de_passe = mdp;
		this.isGestionnaire = g;
	}
	
	// constructeur pour l'ajout d'un utilisateur
	public Utilisateur(String id, String mdp, boolean g) {
		this.identifiant = id;
		this.mot_de_passe = mdp;
		this.isGestionnaire = g;
	}

// les getters de Utilisateur :	
	/**
	 * getter identifiant permet de récupérer la reférence d'un utilisateur
	 * 
	 * @return référence 
	 */
	public int getReference () {
		return reference ;
	}
	
	public String getIdentifiant () {
		return identifiant;
	}


	/**
	 * getter mot_de_passe permet de récupérer le mot_de_passe d'un utilisateur
	 * 
	 * @return mot_de_passe
	 */
	public String getMotDePasse() {
		return mot_de_passe;
	}

	/**
	 * getter isGestionnaire permet de récupérer le type d'utilisation
	 * 
	 * @return isGestionnaire
	 */
	public boolean getIsGestionnaire() {
		return isGestionnaire;
	}

    /**
     * getter pour récupérer la liste des projet d'un utilisateur 
     * @return listeprojet
     */
    public ArrayList<ProjetJava> getListeProjet ()
    {
    	return listeprojet ;
    }

// les setters de Utilisateur 
	/**
	 * setter identifiant permet de remplacer ou saisir l'identifiant d'un
	 * utilisateur
	 * 
	 * @param identifiant
	 */
	public void setIdentifiant(String id) {
		this.identifiant = id;
	}

	/**
	 * setter mot_de_passe permet de remplacer ou saisir le mot_de_passe d'un
	 * utilisateur
	 * 
	 * @param mot_de_passe
	 */
	public void setMotDePasse(String mdp) {
		this.mot_de_passe = mdp;
	}

	/**
	 * setter isGestionnaire permet de remplacer ou saisir le type d'utilisation
	 * 
	 * @param isGestionnaire
	 */
	public void setIsGestionnaire(boolean g) {
		this.isGestionnaire = g;
	}
	// méthode de la classe utilisateur  :
	/**
	* Redéfinition de la méthode toString permettant de définir la traduction de
	l'objet en String
	* pour l'affichage par exemple
	*/
	public String toString() {
	return "Utilisateur["+ reference +"]| Identifiant:" + identifiant
	+ "| Mot_de_passe: " + mot_de_passe + "| Type:" + isGestionnaire + "]";
	}
	
	
}
