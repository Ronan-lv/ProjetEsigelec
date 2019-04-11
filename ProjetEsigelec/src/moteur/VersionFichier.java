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
	private int num�ro_min;
	private int num�ro_maj;
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
		this.num�ro_min = mineur;
		this.num�ro_maj = majeur;
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
	 * @return num�ro_min
	 */
	public int getNumeroMin() {
		return num�ro_min;
	}

	/**
	 * getter du num�ro majeur d'une version
	 * 
	 * @return num�ro_maj
	 */
	public int getNumeroMaj() {
		return num�ro_maj;
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
	 * Setter du num�ro mineur d'une version
	 * 
	 * @param mineur
	 */
	public void setNumeroMin(int mineur) {
		this.num�ro_min = mineur;
	}

	/**
	 * Setter du num�ro majeur d'une version
	 * 
	 * @param majeur
	 */
	public void setNumeroMaj(int majeur) {
		this.num�ro_maj = majeur;
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
