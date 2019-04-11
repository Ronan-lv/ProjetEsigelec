package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moteur.ProjetJava;

public class DAOProjetJava {
	/**
	 * Paramètres de connexion à la base de données oracle URL, LOGIN et PASS sont
	 * des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "C##GAEL"; // exemple BDD8 C##GAEL
	final static String PASS = "digitalx76"; // exemple BDD8 digitalx76

	/**
	 * Constructeur de la classe
	 *
	 */
	public DAOProjetJava() {
		// chargement du pilote de bases de données
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas "
					+ "oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un ProjetJava dans la table ProjetJava Le mode est
	 * auto-commit par défaut : chaque insertion est validée
	 *
	 * @param projetjava le projet à ajouter
	 * @return retourne le nombre de lignes ajoutées dans la table
	 */
	public int ajouter(ProjetJava projet) {
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
			ps = con.prepareStatement(
					"INSERT INTO fichier (id,nom,destination,datefichier,id_fichier_uti) VALUES (?, ?, ?, ? ,?)");
			ps.setInt(1, projet.getIdProjet());
			ps.setString(2, projet.getNomProjet());
			ps.setString(3, projet.getDestinationProjet());
			ps.setDate(4, projet.getDateProjet());
			ps.setInt(5, projet.getIdFichierUtilisateur());
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
	 * Permet de récupérer un projet java à partir de sa référence utilisateur
	 *
	 * @param reference la référence de l'utilisateur
	 * @return projet trouvé trouvé; null si aucun projetjava ne correspond à cette
	 *         référence
	 */
	public ProjetJava getProjetJava(int reference) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProjetJava retour = null;
		// connexion à la base de données
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT fichier.id ,fichier.nom ,fichier.destination,fichier.date "
					+ "FROM fichier inner join utlisateur ON (fichier.id_fichier_util =utilisateur.id)"
					+ " WHERE utlisateur.id = ?");
			ps.setInt(1, reference);
			// on exécute la requête
			// rs contient un pointeur situé jusute avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = new ProjetJava(rs.getInt("fichier.id"), rs.getString("fichier.nom"),
						rs.getString("fichier.destination"), rs.getDate("fichier.date"),
						rs.getInt("fichier.id_fichier_utilisateur)"));
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
	 * Permet de récupérer tous les projets stockés dans la table projetjava
	 *
	 * @return une ArrayList de projet
	 */
	public ArrayList<ProjetJava> getListeProjetJava() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProjetJava> retour = new ArrayList<ProjetJava>();
		// connexion à la base de données
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM fichier");
			// on exécute la requête
			rs = ps.executeQuery();
			// on parcourt les lignes du résultat
			while (rs.next())
				retour.add(new ProjetJava(rs.getInt("fichier.id"), rs.getString("fichier.nom"),
						rs.getString("fichier.destination"), rs.getDate("fichier.date") , rs.getInt("fichier.id_fichier_utilisateur")));
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
	 * // main permettant de tester la classe public static void main(String[] args)
	 * throws SQLException {
	 *  ArticleDAO articleDAO = new ArticleDAO(); 
	 * // test de la
 méthode ajouter Article a1 = new Article(1, "Set de 2 raquettes de
	 * ping-pong", 149.9, 10); 2017-2018 Surveillance de la qualité de l’air en
	 * Normandie p 13/15 int retour = articleDAO.ajouter(a1);
	 * System.out.println(retour + " lignes ajoutées"); // test de la méthode
	 * getArticle Article a2 = articleDAO.getArticle(1); System.out.println(a2); //
	 * test de la méthode getListeArticles List<Article> liste =
	 * articleDAO.getListeArticles(); // affichage des articles for (Article art :
	 * liste) { System.out.println(art.toString()); } }
	 */
}
