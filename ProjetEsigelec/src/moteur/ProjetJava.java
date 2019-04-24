package moteur;

import java.util.ArrayList;
import java.sql.Date;

/**
 * 
 * @author Gael Le Roux et Ronan Le Viennesse version : La classe ProjetJava du
 *         logiciel
 */
public class ProjetJava {
// déclaration des variables de la classe ProjetJava
	private int id_projet;
	private String nom_projet;
	private String destination_projet;
	private Date date_projet;
	private int id_fichier_utilisateur ;

	private ArrayList<VersionFichier> listeversion;

	// constructeur
	/**
	 * Constructeur de la classe ProjetJava
	 * 
	 * @param nom_projet, destination_projet
	 */
	public ProjetJava(int id, String nom, String destination, Date date , int id_fichier_u) {
		this.id_projet = id;
		this.nom_projet = nom;
		this.destination_projet = destination;
		this.date_projet = date;
		this.id_fichier_utilisateur = id_fichier_u ;

	}

	// les getters de la classe ProjetJava
	/**
	 * getter id_projet permet de récupérer la référence du projet
	 * 
	 * @return id_projet
	 */
	public int getIdProjet() {
		return id_projet;
	}

	/**
	 * getter nom_projet permet de récupérer le nom du projet
	 * 
	 * @return nom_projet
	 */
	public String getNomProjet() {
		return nom_projet;
	}

	/**
	 * getter destination_projet permet de récupérer la destination du projet
	 * 
	 * @return destination_projet
	 */
	public String getDestinationProjet() {
		return destination_projet;
	}

	/**
	 * getter date_projet permet de récupérer la date du projet
	 * 
	 * @return date_projet
	 */
	public Date getDateProjet() {
		return date_projet;
	}

	/**
	 * getter pour récupérer la liste des version d'un fichier
	 * 
	 * @return listeversion
	 */
	public ArrayList<VersionFichier> getListeVersion() {
		return listeversion;
	}
	/**
	 * getter id_utilisateur_fichier permet de récupérer la id de lutilisateur du fichier 
	 * 
	 * @return  id_fichier_utilisateur
	 */
	public int getIdFichierUtilisateur() {
		return id_fichier_utilisateur;
	}

	// les setters de la classe ProjetJava
	/**
	 * setter id_projet permet de remplacer ou saisir la reference du projet
	 * 
	 * @param id_projet
	 */
	public void setIdProjet(int id) {
		this.id_projet = id;
	}

	/**
	 * setter nom_projet permet de remplacer ou saisir le nom du projet
	 * 
	 * @param nom_projet
	 */
	public void setNomProjet(String nom) {
		this.nom_projet = nom;
	}

	/**
	 * setter destination_projet permet de remplacer ou saisir la destination du
	 * projet
	 * 
	 * @param destination_projet
	 */
	public void setDestinationProjet(String destination) {
		this.destination_projet = destination;
	}

	/**
	 * setter date_projet permet de remplacer ou saisir la date du projet
	 * 
	 * @param date_projet
	 */
	public void setDateProjet(Date date) {
		this.date_projet = date;
	}
	/**
	 * setter id_fichier_utilisateur permet de remplacer ou saisir le nouvelle utilisateur du fichier
	 * 
	 * @param date_projet
	 */
	public void setIdFichierUtilisateur(int id_fichier_u) {
		this.id_fichier_utilisateur = id_fichier_u;
	}
	// méthode de la classe ProjetJava 
	/**
	* Redéfinition de la méthode toString permettant de définir la traduction de
	l'objet en String
	* pour l'affichage par exemple
	*/
	public String toString() {
	return "["+id_projet+"]| Nom:"+nom_projet+"| destination:" +destination_projet+ "| Date:" +date_projet+"|Utilisateur:"+id_fichier_utilisateur;
	}
}
