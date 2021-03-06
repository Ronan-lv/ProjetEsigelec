package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moteur.Utilisateur;

/**
 * Classe DAOUtilisateur ,permet de faire le lien avec la table Utilisateur
 * (BDD)
 * 
 * @author Gael Le Roux et Ronan Le Viennesse
 */
public class DAOUtilisateur {
	/**
	 * Param�tres de connexion � la base de donn�es oracle URL, LOGIN et PASS sont
	 * des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "C##GAEL"; // exemple BDD8 ou C##GAEL
	final static String PASS = "digitalx76"; // exemple BDD8 ou digitalx76

	/**
	 * Constructeur de la classe
	 */
	public DAOUtilisateur() {

		// chargement du pilote de bases de donn�es
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas "
					+ "oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un utilisateur dans la table utilisateur Le mode est
	 * auto-commit par d�faut : chaque insertion est valid�e
	 *
	 * @param utilisateur l'utilisateur � ajouter
	 * @return retourne le nombre de lignes ajout�es dans la table
	 */
	public int ajouter(Utilisateur uti) {
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
			ps = con.prepareStatement("INSERT INTO utilisateur (identifiant,mdp,type) VALUES (?, ?, ?)");
			ps.setString(1, uti.getIdentifiant());
			ps.setString(2, uti.getMotDePasse());
			ps.setInt(3, uti.getIsGestionnaire() ? 1 : 0);
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
	 * Permet de r�cup�rer un utilisateur � partir de sa r�f�rence
	 *
	 * @param reference la r�f�rence de l'utilisateur � r�cup�rer
	 * @return l'utilisateur trouv�; null si aucun utilisateur ne correspond � cette
	 *         r�f�rence
	 */
	public Utilisateur getUtilisateur(String reference) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Utilisateur retour = null;
		// connexion � la base de donn�es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM utilisateur WHERE identifiant = ?");
			ps.setString(1, reference);
			// on ex�cute la requ�te
			// rs contient un pointeur situ� jusute avant la premi�re ligne
			// retourn�e
			rs = ps.executeQuery();
			// passe � la premi�re (et unique) ligne retourn�e
			if (rs.next())
				retour = new Utilisateur(rs.getInt("id"), rs.getString("identifiant"), rs.getString("mdp"),
						rs.getInt("type") == 1 ? true : false);
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
	 * Permet de r�cup�rer tous les utilisateurs stock�s dans la table utilisateur
	 *
	 * @return une ArrayList d'utilisateur
	 */
	public ArrayList<Utilisateur> getListeUtilisateurs() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Utilisateur> retour = new ArrayList<Utilisateur>();
		// connexion � la base de donn�es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM utilisateur ORDER BY id ASC");
			// on ex�cute la requ�te
			rs = ps.executeQuery();
			// on parcourt les lignes du r�sultat
			while (rs.next())
				retour.add(new Utilisateur(rs.getInt("id"), rs.getString("identifiant"), rs.getString("mdp"),
						rs.getInt("type") == 1 ? true : false));
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
	 * M�thode qui permet de r�cup�rer tout les identfiaint dans la BDD
	 * 
	 * @return ArrayList String identifiant
	 */
	public ArrayList<String> getListeIdentifiant() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> retour = new ArrayList<String>();
		// connexion � la base de donn�es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT identifiant FROM utilisateur ORDER BY id ASC");
			// on ex�cute la requ�te
			rs = ps.executeQuery();
			// on parcourt les lignes du r�sultat
			while (rs.next())
				retour.add(rs.getString("identifiant"));
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
	 * Permet de supprimer un utilisateur dans la table utilisateur Le mode est
	 * auto-commit par d�faut : chaque suppression est valid�e
	 *
	 * @param identfiant l'identifiant de l'utilisateur � ajouter
	 * @return retourne le nombre de lignes supprim�s dans la table
	 */
	public int supprimer(String identifiant) {
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
			ps = con.prepareStatement("DELETE FROM  utilisateur WHERE identifiant = ?");
			ps.setString(1, identifiant);
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

//---------------------------------------------TEST DE LA DAO-------------------------------------------------	
	/**
	 * // main permettant de tester la classe utilisateur et DAO Utilisateur public
	 * static void main(String[] args) throws SQLException { DAOUtilisateur
	 * daoutilisateur = new DAOUtilisateur();
	 * 
	 * // test de la m�thode ajouter Utilisateur Utilisateur u1 = new Utilisateur(3,
	 * "jack","digitalx76",true) ; int retour = daoutilisateur.ajouter(u1);
	 * System.out.println(retour + " lignes ajout�es");
	 * 
	 * // test de la m�thode r�cup�rer un utilisateur Utilisateur u2 =
	 * daoutilisateur.getUtilisateur(1); System.out.println(u2); // test de la
	 * m�thode getListeUtilisateur ArrayList<Utilisateur> listeutilisateur =
	 * daoutilisateur.getListeUtilisateurs() ; // affichage des articles for
	 * (Utilisateur uti : listeutilisateur) { System.out.println(uti.toString()); }
	 * }
	 */

}
