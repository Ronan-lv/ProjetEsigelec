package moteur;
/**
 * 
 * @author Gael Le Roux et Ronan Le Viennesse
 * version :
 * La classe ProjetJava du logiciel 
 */
public class ProjetJava {
// déclaration des variables de la classe ProjetJava
	private String nom_projet ;
	private String destination_projet ;
	// (rajouter liste version ,date_projet  )
	
	// constructeur 
	/**
	 * Constructeur de la classe ProjetJava
	 * @param nom_projet, destination_projet
	 */
	public ProjetJava (String nom ,String destination) {
		this.nom_projet =nom ;
		this.destination_projet =destination ;
	}
	// les getters de la classe ProjetJava
	/**
	 * getter nom_projet
	 * permet de récupérer le nom du projet
	 * @return nom_projet
	 */
	public String GetNomProjet ()
	{
		return nom_projet ;
	}
	/**
	 * getter destination_projet
	 * permet de récupérer la destination du projet
	 * @return destination_projet
	 */
	public String GetDestinationProjet ()
	{
		return destination_projet ;
	}
	// les setters de la classe ProjetJava
	/**
	 * setter nom_projet
	 * permet de remplacer ou saisir le nom du projet
	 * @param nom_projet
	 */
	public void SetNomProjet(String nom) {
		this.nom_projet = nom ;
	}
	/**
	 * setter destination_projet
	 * permet de remplacer ou saisir la destination du projet
	 * @param destination_projet
	 */
	public void SetDestinationProjet(String destination) {
		this.destination_projet = destination ;
	}
	}
