package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moteur.VersionFichier;

/**
 * Classe DAO VersionFichier ,permet de faire le lien avec la table version  (BDD)
 * @author Gael Le Roux et Ronan Le Viennesse 
 * version :
 */
public class DAOVersionFichier {
	/**
	* Paramètres de connexion à la base de données oracle URL, LOGIN et PASS
	* sont des constantes
	*/
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "C##GAEL"; //exemple BDD8 ou C##GAEL
	final static String PASS = "digitalx76"; //exemple BDD8 ou digitalx76
	/**
	* Constructeur de la classe
	*
	*/
	public DAOVersionFichier() {
	// chargement du pilote de bases de données
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
	System.err.println("Impossible de charger le pilote de BDD, ne pas "
			+ "oublier d'importer le fichier .jar dans le projet");
	}
	
	}
	/**
	* Permet d'ajouter une dans la table version Le mode est auto-commit
	* par défaut : chaque insertion est validée
	*
	* @param versionfichier la version à ajouter
	* @return retourne le nombre de lignes ajoutées dans la table
	*/
	public int ajouter(VersionFichier version) {
	Connection con = null;
	PreparedStatement ps = null;
	int retour = 0;
	// connexion à la base de données
	try {
	// tentative de connexion
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	// préparation de l'instruction SQL, chaque ? représente une valeur
	// à communiquer dans l'insertion
	// les getters permettent de récupérer les valeurs des attributs
	// souhaités
	ps = con.prepareStatement("INSERT INTO version (id,"
			+ "num_maj,num_min,contenu,description,id_fichier_version) VALUES (?, ?, ?, ?, ?, ?)");
	ps.setInt(1, version.getIdVersion() );
	ps.setInt(2,version.getNumeroMaj());
	ps.setInt(3, version.getNumeroMin());
	ps.setString(4, version.getContenuVersion());
	ps.setString(5, version.getContenuDescription());
	ps.setInt(6, version.getIdFichierVersion());
	// Exécution de la requête
	retour = ps.executeUpdate();
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	// fermeture du preparedStatement et de la connexion
	try {if (ps != null) ps.close();} catch (Exception ignore) {}
	try {if (con != null) con.close();} catch (Exception ignore) {}
	}
	return retour;
	}
	/**
	* Permet de récupérer une version java à partir de sa référence 
	*
	* @param reference la référence de la version
	* @return version  trouvé;
	null si aucune version ne correspond à cette référence
	*/
	public VersionFichier getVersionFichier(int reference) {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	VersionFichier retour = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT * FROM version WHERE id =?");
	ps.setInt(1, reference);
	// on exécute la requête
	// rs contient un pointeur situé jusute avant la première ligne
	// retournée
	rs = ps.executeQuery();
	// passe à la première (et unique) ligne retournée
	if (rs.next())
	retour = new VersionFichier(rs.getInt("id"),rs.getInt("num_maj"),rs.getInt("num_min"),rs.getString("contenu"),rs.getString("description"),rs.getInt("id_fichier_version"));
	} catch (Exception ee) {
	ee.printStackTrace();
	} finally {
	// fermeture du ResultSet, du PreparedStatement et de la Connexion
	try { if (rs != null) rs.close();} catch (Exception ignore) {}
	try { if (ps != null) ps.close();} catch (Exception ignore) {}
	try { if (con != null) con.close();} catch (Exception ignore) {}
	}
	return retour;
	}
	/**
	* Permet de récupérer tous les versions stockés dans la table version
	*
	* @return une ArrayList de version
	*/
	public ArrayList<VersionFichier> getListeVersion() {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<VersionFichier> retour = new ArrayList<VersionFichier>();
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT * FROM version");
	// on exécute la requête
	rs = ps.executeQuery();
	// on parcourt les lignes du résultat
	while (rs.next())
	retour.add(new VersionFichier(rs.getInt("id"),
	rs.getInt("num_maj"), rs.getInt("num_min"),
	rs.getString("contenu") ,rs.getString("description"),rs.getInt("id_fichier_version")));
	} catch (Exception ee) {
	ee.printStackTrace();
	} finally {
	// fermeture du rs, du preparedStatement et de la connexion
	try { if (rs != null) rs.close();} catch (Exception ignore) {}
	try { if (ps != null) ps.close();} catch (Exception ignore) {}
	try { if (con != null) con.close();} catch (Exception ignore) {}
	}
	return retour;
	}
	
/**	
	// main permettant de tester la classe
	public static void main(String[] args) throws SQLException {
	ArticleDAO articleDAO = new ArticleDAO();
	// test de la méthode ajouter
	Article a1 = new Article(1, "Set de 2 raquettes de ping-pong", 149.9,
	10);
	2017-2018 Surveillance de la qualité de l’air en Normandie p 13/15
	int retour = articleDAO.ajouter(a1);
	System.out.println(retour + " lignes ajoutées");
	// test de la méthode getArticle
	Article a2 = articleDAO.getArticle(1);
	System.out.println(a2);
	// test de la méthode getListeArticles
	List<Article> liste = articleDAO.getListeArticles();
	// affichage des articles
	for (Article art : liste) {
	System.out.println(art.toString());
	}
	}
	*/
}
