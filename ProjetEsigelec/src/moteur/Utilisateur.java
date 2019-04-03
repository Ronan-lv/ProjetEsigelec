package moteur;

import java.util.ArrayList;

/**
 * 
 * @author Gael Leroux et Ronan Le Viennesse version : La classe utilisateur du
 *         logiciel
 */
public class Utilisateur {

// déclarations des variables de la classe Utilisateur  :
	private int reference  ;
	private String identifiant;
	private String mot_de_passe;
	private boolean isGestionnaire;
	
	
	private ArrayList<ProjetJava> listeprojet;
	private Historique historique_utilisateur;

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

// les getters de Utilisateur :	
	/**
	 * getter identifiant permet de récupérer la reférence d'un utilisateur
	 * 
	 * @return référence 
	 */
	public int GetReference () {
		return reference ;
	}
	
	public String GetIdentifiant () {
		return identifiant;
	}


	/**
	 * getter mot_de_passe permet de récupérer le mot_de_passe d'un utilisateur
	 * 
	 * @return mot_de_passe
	 */
	public String GetMotDePasse() {
		return mot_de_passe;
	}

	/**
	 * getter isGestionnaire permet de récupérer le type d'utilisation
	 * 
	 * @return isGestionnaire
	 */
	public boolean GetIsGestionnaire() {
		return isGestionnaire;
	}
	/**
	 * getter pour récupérer l'historique d'un utilisateur 
	 * @return historique_utilisateur
	 */
    public Historique GetHistoriqueUtilisateur () {
    	return historique_utilisateur ;
    }
    /**
     * getter pour récupérer la liste des projet d'un utilisateur 
     * @return listeprojet
     */
    public ArrayList<ProjetJava> GetListeProjet ()
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
	public void SetIdentifiant(String id) {
		this.identifiant = id;
	}

	/**
	 * setter mot_de_passe permet de remplacer ou saisir le mot_de_passe d'un
	 * utilisateur
	 * 
	 * @param mot_de_passe
	 */
	public void SetMotDePasse(String mdp) {
		this.mot_de_passe = mdp;
	}

	/**
	 * setter isGestionnaire permet de remplacer ou saisir le type d'utilisation
	 * 
	 * @param isGestionnaire
	 */
	public void SetIsGestionnaire(boolean g) {
		this.isGestionnaire = g;
	}
	

	
	
}
