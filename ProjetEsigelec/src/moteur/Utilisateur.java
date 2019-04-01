package moteur;

/**
 * 
 * @author Gael Leroux et Ronan Le Viennesse version : La classe utilisateur du
 *         logiciel
 */
public class Utilisateur {

// déclarations des variables de la classe Utilisateur  :	
	private String identifiant;
	private String mot_de_passe;
	private boolean isGestionnaire;
//(rajouter liste projet et historique )
	
	// le constructeur de Utilisateur
	/**
	 * Constructeur de la classe Utilisateur
	 * 
	 * @param identifiaznt , mot_de_passe ,type
	 */
	public Utilisateur(String id, String mdp, boolean g) {
		this.identifiant = id;
		this.mot_de_passe = mdp;
		this.isGestionnaire = g;
	}

// les getters de Utilisateur :	
	/**
	 * getter identifiant permet de récupérer l'identifiaznt d'un utilisateur
	 * 
	 * @return identifiant
	 */
	public String GetIdentifiant() {
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
