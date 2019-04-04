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
	private int  id_projet ;
	private String nom_projet;
	private String destination_projet;
	private Date date_projet ;
	
	private ArrayList<VersionFichier> listeversion;

	// constructeur
	/**
	 * Constructeur de la classe ProjetJava
	 * 
	 * @param nom_projet, destination_projet
	 */
	public ProjetJava(int id ,String nom, String destination, Date date ) {
		this.id_projet = id ;
		this.nom_projet = nom;
		this.destination_projet = destination;
		this.date_projet =date ;
		
	}

	// les getters de la classe ProjetJava
	/**
	 * getter id_projet 
	 * permet de récupérer la référence du projet
	 * @return id_projet
	 */
	public int GetIdProjet() {
		return id_projet;
	}
	/**
	 * getter nom_projet permet de récupérer le nom du projet
	 * 
	 * @return nom_projet
	 */
	public String GetNomProjet() {
		return nom_projet;
	}

	/**
	 * getter destination_projet permet de récupérer la destination du projet
	 * 
	 * @return destination_projet
	 */
	public String GetDestinationProjet() {
		return destination_projet;
	}

	/**
	 * getter date_projet permet de récupérer la date du projet
	 * 
	 * @return date_projet
	 */
	public Date GetDateProjet() {
		return date_projet;
	}

	/**
	 * getter pour récupérer la liste des version d'un fichier
	 * 
	 * @return listeversion
	 */
	public ArrayList<VersionFichier> GetListeVersion() {
		return listeversion;
	}

	// les setters de la classe ProjetJava
	/**
	 * setter id_projet permet de remplacer ou saisir la reference du projet
	 * 
	 * @param id_projet
	 */
	public void SetIdProjet(int id) {
		this.id_projet = id;
	}

	/**
	 * setter nom_projet permet de remplacer ou saisir le nom du projet
	 * 
	 * @param nom_projet
	 */
	public void SetNomProjet(String nom) {
		this.nom_projet = nom;
	}

	/**
	 * setter destination_projet permet de remplacer ou saisir la destination du
	 * projet
	 * 
	 * @param destination_projet
	 */
	public void SetDestinationProjet(String destination) {
		this.destination_projet = destination;
	}
	/**
	 * setter date_projet permet de remplacer ou saisir la date du
	 * projet
	 * 
	 * @param date_projet
	 */
	public void SetDateProjet(Date date) {
		this.date_projet = date;
	}
}
