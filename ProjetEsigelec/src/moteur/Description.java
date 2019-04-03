package moteur;
/**
 * Classe description pour le logiciel 
 * @author Le Roux Gael et Ronan Le Viennesse 
 * version :
 *
 */
public class Description {

	// declaration des variables :
	private int id_description  ;
	private String contenu_description ;
	
	// constructeur de la classe Description 
/**
 * Constructeur de la classe Description 
 * @param id
 * @param d
 */
	public Description (int id , String d ) {
		this.id_description = id ;
		this.contenu_description = d ;
	}
	// getter de la classe Description :
	/**
	 * getter de l'id de la description
	 * @return id_description
	 */
	public int GetIdDescription() {
		return id_description ;
	}
	/**
	 * getter du contenu de la description 
	 * @return contenu_description
	 */
	public String GetContenuDescription () {
		return contenu_description ;
	}
	// setter de la classe Description :
	/**
	 * Setter de l'id de la description 
	 * @param id
	 */
	public void SetIdDescription(int id ) {
		this.id_description = id ;
	}
	/**
	 * setter du contenu de la description 
	 * @param d
	 */
	public void SetContenuDescription (String d) {
		this.contenu_description = d ;
	}
}
