package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moteur.VersionFichier;

/**
 * Classe DAO VersionFichier ,permet de faire le lien avec la table version
 * (BDD)
 * 
 * @author Gael Le Roux et Ronan Le Viennesse version :
 */
public class DAOVersionFichier {
	/**
	 * Paramètres de connexion à la base de données oracle URL, LOGIN et PASS sont
	 * des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "C##GAEL"; // exemple BDD8 ou C##GAEL
	final static String PASS = "digitalx76"; // exemple BDD8 ou digitalx76

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
	 * Permet d'ajouter une dans la table version Le mode est auto-commit par défaut
	 * : chaque insertion est validée
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
			ps = con.prepareStatement("INSERT INTO version (num_maj,num_min,contenu,description,id_fichier_version) VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, version.getNumeroMaj());
			ps.setInt(2, version.getNumeroMin());
			ps.setString(3, version.getContenuVersion());
			ps.setString(4, version.getContenuDescription());
			ps.setInt(5, version.getIdFichierVersion());
			// Exécution de la requête
			retour = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;
	}

	/**
	 * Permet de récupérer une version java à partir de sa référence
	 *
	 * @param reference la référence de la version
	 * @return version trouvé; null si aucune version ne correspond à cette
	 *         référence
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
				retour = new VersionFichier(rs.getInt("id"), rs.getInt("num_maj"), rs.getInt("num_min"),
						rs.getString("contenu"), rs.getString("description"), rs.getInt("id_fichier_version"));
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;
	}

	/**
	 * Permet de récupérer tous les versions stockés dans la table version
	 *
	 * @return une ArrayList de version
	 */
	public ArrayList<VersionFichier> getListeVersion(int idProjetJava) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<VersionFichier> retour = new ArrayList<VersionFichier>();
		// connexion à la base de données
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM version WHERE id_fichier_version= ?");
			ps.setInt(1, idProjetJava);
			// on exécute la requête
			rs = ps.executeQuery();
			// on parcourt les lignes du résultat
			while (rs.next())
				retour.add(new VersionFichier(rs.getInt("id"), rs.getInt("num_maj"), rs.getInt("num_min"),
						rs.getString("contenu"), rs.getString("description"), rs.getInt("id_fichier_version")));
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;
	}
	// -----------------------------------------TEST DE LA DAO VERSIONFICHIER
	// ---------------------------------------

	/**
	 * // main permettant de tester la classe public static void main(String[] args)
	 * throws SQLException { DAOVersionFichier DAOversion = new DAOVersionFichier();
	 * // test de la méthode ajouter VersionFichier v1 = new
	 * VersionFichier(1,1,0,"contenu1","description1" , 1);
	 * 
	 * int retour = DAOversion.ajouter(v1); System.out.println(retour + " lignes
	 * ajoutées"); // test de la méthode getArticle VersionFichier v2 =
	 * DAOversion.getVersionFichier(1); System.out.println(v2); // test de la
	 * méthode getListeArticles ArrayList<VersionFichier> liste =
	 * DAOversion.getListeVersion(); // affichage des articles for (VersionFichier v
	 * : liste) { System.out.println(v.toString()); } }
	 */


	public VersionFichier getDerniereVersionFichierDuProjet(int idProjetJava) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		VersionFichier retour = null;

		
		// connexion à la base de données
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println(idProjetJava);
			ps = con.prepareStatement("SELECT * FROM version WHERE id_fichier_version = ? ORDER BY num_maj DESC");
			ps.setInt(1, idProjetJava);
			// on exécute la requête
			// rs contient un pointeur situé jusute avant la première ligne
			// retournée
			rs = ps.executeQuery();
			
			// passe à la première (et unique) ligne retournée
			if (rs.next()) {
				retour = new VersionFichier(rs.getInt("id"), rs.getInt("num_maj"), rs.getInt("num_min"),
						rs.getString("contenu"), rs.getString("description"), rs.getInt("id_fichier_version"));
				
			}
			else {
				System.out.println("Le fichier non trouvé  !");
				//Permet d'éviter le plantage en cas d'erreur
				retour = new VersionFichier(0, 0, 0, "Le fichier n'existe pas", "erreur du fichier", 0);
			}
				

			
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;
	}



	public void supprimerVersionFichier(int idVersion) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM version WHERE id = ?");
			ps.setInt(1, idVersion);
			rs = ps.executeQuery();
			
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
	}
















}
