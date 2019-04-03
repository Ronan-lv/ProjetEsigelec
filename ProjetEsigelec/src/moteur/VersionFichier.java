package moteur;
/**
 * la classe VersionFichier 
 * @author Le Roux Gael et Ronan Le Viennesse
 *Version :
 *
 */
public class VersionFichier {

	// declaration des variables de la classe VersionFichier 
	
	private int numéro_min ;
	private int numéro_maj ;
	private String contenu_version ;
	
	// le constructeur de la classe VersionFichier 
	/**
	 * Constructeur de la classe VersionFichier 
	 * @param mineur
	 * @param majeur
	 * @param contenu_v
	 */
	public VersionFichier (int mineur ,int  majeur ,String contenu_v) {
		this.numéro_min = mineur ;
		this.numéro_maj = majeur ;
		this.contenu_version = contenu_v ;
		
	}
	// getter de la classe VersionFichier 
	/**
	 * getter du numero mineur d'une version
	 * @return numéro_min
	 */
	public int GetNumeroMin ()
	{
		return numéro_min ;
	}
	/**
	 * getter du numéro majeur d'une version
	 * @return numéro_maj
	 */
	public int GetNumeroMaj ()
	{
		return numéro_maj ;
	}
	/**
	 *  getter du contenu d'une version 
	 * @return contenu_version
	 */
	public String GetContenuVersion() {
		return contenu_version ;
	}
	// setter de la classe VersionFichier 
	/**
	 * Setter du numéro mineur d'une version
	 * @param mineur
	 */
	public void SetNumeroMin(int mineur) {
		this.numéro_min =mineur;
	}
	/**
	 * Setter du numéro majeur d'une version
	 * @param majeur
	 */
	public void SetNumeroMaj(int majeur) {
		this.numéro_maj =majeur;
	}
	/**
	 * Setter du contenu d'une version 
	 * @param contenu_v
	 */
	public void SetContenuVersion(String contenu_v) {
		this.contenu_version = contenu_v;
	}
}
