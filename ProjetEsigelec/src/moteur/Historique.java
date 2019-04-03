package moteur;
/**
 * La classe Historique du logiciel
 * @author Le Roux Gael et Ronan Le Viennesse
 *version :
 *
 */
public class Historique {

	private String contenu_hist ;
	
	
	// constructeur de la classe Historique 
	/**
	 * Constructeur de la classe Historique 
	 * @param h
	 */
	public Historique (String h ) {
		
		this.contenu_hist = h ;
	}
	// getter de la classe Historique
	
	/**
	 * Getter contenu_hist 
	 * Permet de récupérer le contenu d'un historique 
	 * @return contenu_hist 
	 */
	public String GetContenuHistorique() {
		return contenu_hist ;
	}
	// setter de la classe Historique 
	/**
	 * Setter contenu_hist
	 * Permet de saisir ou modifier un historique d'un utilisateur 
	 * @param h
	 */
	public void SetContenuHistorique (String h) {
		this.contenu_hist = h ;
	}
}
