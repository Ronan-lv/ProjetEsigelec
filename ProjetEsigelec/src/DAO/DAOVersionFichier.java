package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moteur.VersionFichier;

/**
 * Classe DAO VersionFichier ,permet de faire le lien avec la table Version
 * (BDD)
 * 
 * @author Gael Le Roux et Ronan Le Viennesse version
 */
public class DAOVersionFichier {
	/**
	 * Param�tres de connexion � la base de donn�es oracle URL, LOGIN et PASS sont
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
		// chargement du pilote de bases de donn�es
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas "
					+ "oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter une dans la table version Le mode est auto-commit par d�faut
	 * : chaque insertion est valid�e
	 *
	 * @param versionfichier la version � ajouter
	 * @return retourne le nombre de lignes ajout�es dans la table
	 */
	public int ajouter(VersionFichier version) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		// connexion � la base de donn�es
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr�paration de l'instruction SQL, chaque ? repr�sente une valeur
			// � communiquer dans l'insertion
			// les getters permettent de r�cup�rer les valeurs des attributs
			// souhait�s
			ps = con.prepareStatement(
					"INSERT INTO version (num_maj,num_min,contenu,description,id_fichier_version) VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, version.getNumeroMaj());
			ps.setInt(2, version.getNumeroMin());
			ps.setString(3, version.getContenuVersion());
			ps.setString(4, version.getContenuDescription());
			ps.setInt(5, version.getIdFichierVersion());
			// Ex�cution de la requ�te
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
	 * Permet de r�cup�rer une version java � partir de sa r�f�rence
	 *
	 * @param reference la r�f�rence de la version
	 * @return version trouv�; null si aucune version ne correspond � cette
	 *         r�f�rence
	 */
	public VersionFichier getVersionFichier(int reference) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		VersionFichier retour = null;
		// connexion � la base de donn�es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM version WHERE id =?");
			ps.setInt(1, reference);
			// on ex�cute la requ�te
			// rs contient un pointeur situ� jusute avant la premi�re ligne
			// retourn�e
			rs = ps.executeQuery();
			// passe � la premi�re (et unique) ligne retourn�e
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
	 * Permet de r�cup�rer tous les versions stock�s dans la table version
	 * 
	 * @param idProjetJava l'id du projet
	 * @return une ArrayList de version
	 */
	public ArrayList<VersionFichier> getListeVersion(int idProjetJava) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<VersionFichier> retour = new ArrayList<VersionFichier>();
		// connexion � la base de donn�es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM version WHERE id_fichier_version= ? ORDER BY  id DESC ");
			ps.setInt(1, idProjetJava);
			// on ex�cute la requ�te
			rs = ps.executeQuery();
			// on parcourt les lignes du r�sultat
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

	/**
	 * M�thode qui permet de r�cup�rer la derni�re version d'un Projet selon son id
	 * 
	 * @param idProjetJava , l'id du projet
	 * @return VersionFichier la derni�re version du projet
	 */
	public VersionFichier getDerniereVersionFichierDuProjet(int idProjetJava) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		VersionFichier retour = null;

		// connexion � la base de donn�es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println(idProjetJava);
			ps = con.prepareStatement("SELECT * FROM version "
					+ "WHERE id_fichier_version = ? AND num_min = (SELECT MAX(num_min) FROM version WHERE id_fichier_version = ?) "
					+ "ORDER BY num_maj DESC");
			ps.setInt(1, idProjetJava);
			ps.setInt(2, idProjetJava);
			// on ex�cute la requ�te
			// rs contient un pointeur situ� jusute avant la premi�re ligne
			// retourn�e
			rs = ps.executeQuery();

			// passe � la premi�re (et unique) ligne retourn�e
			if (rs.next()) {
				retour = new VersionFichier(rs.getInt("id"), rs.getInt("num_maj"), rs.getInt("num_min"),
						rs.getString("contenu"), rs.getString("description"), rs.getInt("id_fichier_version"));

			} else {
				System.out.println("Le fichier non trouv�  !");
				// Permet d'�viter le plantage en cas d'erreur
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

	// -----------------------------------------TEST DE LA DAO VERSIONFICHIER
	// ---------------------------------------

	/**
	 * // main permettant de tester la classe public static void main(String[] args)
	 * throws SQLException { DAOVersionFichier DAOversion = new DAOVersionFichier();
	 * // test de la m�thode ajouter VersionFichier v1 = new
	 * VersionFichier(1,1,0,"contenu1","description1" , 1);
	 * 
	 * int retour = DAOversion.ajouter(v1); System.out.println(retour + " lignes
	 * ajout�es"); // test de la m�thode getArticle VersionFichier v2 =
	 * DAOversion.getVersionFichier(1); System.out.println(v2); // test de la
	 * m�thode getListeArticles ArrayList<VersionFichier> liste =
	 * DAOversion.getListeVersion(); // affichage des articles for (VersionFichier v
	 * : liste) { System.out.println(v.toString()); } }
	 */

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
