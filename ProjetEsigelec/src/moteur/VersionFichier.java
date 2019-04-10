package moteur;

/**
 * la classe VersionFichier
 * 
 * @author Le Roux Gael et Ronan Le Viennesse Version :
 *
 */
public class VersionFichier {

	// declaration des variables de la classe VersionFichier
private int  id_version ;
	private int numéro_min;
	private int numéro_maj;
	private String contenu_version;
	private String contenu_description;
	private  int id_fichier_version ;

	// le constructeur de la classe VersionFichier
	/**
	 * Constructeur de la classe VersionFichier
	 * 
	 * @param mineur
	 * @param majeur
	 * @param contenu_v
	 */
	public VersionFichier(int id_v ,int mineur, int majeur, String contenu_v, String contenu_d , int id_fichier_v) {
		this.id_version = id_v ;
		this.numéro_min = mineur;
		this.numéro_maj = majeur;
		this.contenu_version = contenu_v;
		this.contenu_description = contenu_d;
		this.id_fichier_version = id_fichier_v ;

	}

	// getter de la classe VersionFichier
	/**
	 * getter de l'id  d'une version
	 * 
	 * @return id_version
	 */
	public int getIdVersion() {
		return id_version ;
	}
	/**
	 * getter du numero mineur d'une version
	 * 
	 * @return numéro_min
	 */
	public int getNumeroMin() {
		return numéro_min;
	}

	/**
	 * getter du numéro majeur d'une version
	 * 
	 * @return numéro_maj
	 */
	public int getNumeroMaj() {
		return numéro_maj;
	}

	/**
	 * getter du contenu d'une version
	 * 
	 * @return contenu_version
	 */
	public String getContenuVersion() {
		return contenu_version;
	}

	/**
	 * getter du contenu d'une description
	 * 
	 * @return contenu_version
	 */
	public String getContenuDescription() {
		return contenu_description;
	}
	/**
	 * getter de la reference fichier de la version
	 * 
	 * @return id_fichier_version 
	 */
	public int getIdFichierVersion() {
		return id_fichier_version;
	}

	// setter de la classe VersionFichier
	/**
	 * Setter de l'id  d'une version
	 * 
	 * @param id_v
	 */
	public void setIdVersion(int id_v) {
		this.id_version = id_v;
	}
	/**
	 * Setter du numéro mineur d'une version
	 * 
	 * @param mineur
	 */
	public void setNumeroMin(int mineur) {
		this.numéro_min = mineur;
	}

	/**
	 * Setter du numéro majeur d'une version
	 * 
	 * @param majeur
	 */
	public void setNumeroMaj(int majeur) {
		this.numéro_maj = majeur;
	}

	/**
	 * Setter du contenu d'une version
	 * 
	 * @param contenu_v
	 */
	public void setContenuVersion(String contenu_v) {
		this.contenu_version = contenu_v;
	}

	/**
	 * Setter du contenu d'une description
	 * 
	 * @param contenu_v
	 */
	public void setContenuDescription(String contenu_d) {
		this.contenu_description = contenu_d;

	}
	/**
	 * Setter de l'id fichier de la version 
	 * 
	 * @param id_fichier_v
	 */
	public void setIdFichierVersion(int id_fichier_v) {
		this.id_fichier_version = id_fichier_v;

	}
}
