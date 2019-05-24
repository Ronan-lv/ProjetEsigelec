package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moteur.ProjetJava;

public class DAOProjetJava {
	/**
	 * Param�tres de connexion � la base de donn�es oracle URL, LOGIN et PASS sont
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
		// chargement du pilote de bases de donn�es
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas "
					+ "oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un ProjetJava dans la table ProjetJava Le mode est
	 * auto-commit par d�faut : chaque insertion est valid�e
	 *
	 * @param projetjava le projet � ajouter
	 * @return retourne le nombre de lignes ajout�es dans la table
	 */
	public int ajouter(ProjetJava projet) {
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
					"INSERT INTO fichier (nom,destination,date_fichier,id_fichier_uti) VALUES (?, ?, ? ,?)");
			ps.setString(1, projet.getNomProjet());
			ps.setString(2, projet.getDestinationProjet());
			ps.setDate(3, projet.getDateProjet());
			ps.setInt(4, projet.getIdFichierUtilisateur());
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
	 * Permet de r�cup�rer un projet java � partir de sa r�f�rence utilisateur
	 *
	 * @param reference la r�f�rence de l'utilisateur
	 * @return projet trouv� trouv�; null si aucun projetjava ne correspond � cette
	 *         r�f�rence
	 */
	public ProjetJava getProjetJava(int reference) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProjetJava retour = null;
		// connexion � la base de donn�es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM fichier WHERE id = ?");
			ps.setInt(1, reference);
			// on ex�cute la requ�te
			// rs contient un pointeur situ� jusute avant la premi�re ligne
			// retourn�e
			rs = ps.executeQuery();
			// passe � la premi�re (et unique) ligne retourn�e
			if (rs.next()) {
				retour = new ProjetJava(rs.getInt("id"), rs.getString("nom"),
						rs.getString("destination"), rs.getDate("date_fichier"),
						rs.getInt("id_fichier_uti"));
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

	/**
	 * Permet de r�cup�rer tous les projets stock�s dans la table projetjava
	 *
	 * @return une ArrayList de projet
	 */
	public ArrayList<ProjetJava> getListeProjetJava() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProjetJava> retour = new ArrayList<ProjetJava>();
		// connexion � la base de donn�es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM fichier");
			// on ex�cute la requ�te
			rs = ps.executeQuery();
			// on parcourt les lignes du r�sultat
			while (rs.next())
				retour.add(new ProjetJava(rs.getInt("id"), rs.getString("nom"),
						rs.getString("destination"), rs.getDate("date_fichier") , rs.getInt("id_fichier_uti")));
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
		 * Permet de r�cup�rer tous les projets stock�s dans la table projetjava pour un utilisateur donn� 
		 *
		 * @return une ArrayList de projet
		 */
		public ArrayList<ProjetJava> getListeProjetJavaUtilisateur( int reference) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<ProjetJava> retour = new ArrayList<ProjetJava>();
			// connexion � la base de donn�es
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * "
						+ "FROM fichier INNER JOIN utilisateur ON (utilisateur.id = id_fichier_uti)"
						+ " WHERE utilisateur.id = ? ORDER BY date_fichier DESC");
				ps.setInt(1, reference);
				
				// on ex�cute la requ�te
				rs = ps.executeQuery();
				// on parcourt les lignes du r�sultat
				while (rs.next())
					retour.add(new ProjetJava(rs.getInt("id"), rs.getString("nom"),
							rs.getString("destination"), rs.getDate("date_fichier") , rs.getInt("id_fichier_uti")));
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
		public ArrayList<ProjetJava> getListeProjetJavaUtilisateurHistorique( String reference) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<ProjetJava> retour = new ArrayList<ProjetJava>();
			// connexion � la base de donn�es
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * "
						+ "FROM fichier INNER JOIN utilisateur ON (utilisateur.id = id_fichier_uti)"
						+ " WHERE utilisateur.identifiant = ? ORDER BY date_fichier DESC");
				ps.setString(1, reference);
				
				// on ex�cute la requ�te
				rs = ps.executeQuery();
				// on parcourt les lignes du r�sultat
				while (rs.next())
					retour.add(new ProjetJava(rs.getInt("id"), rs.getString("nom"),
							rs.getString("destination"), rs.getDate("date_fichier") , rs.getInt("id_fichier_uti")));
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
		
	public int recupererDernierProjetJavaAjoute() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;


		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT MAX(id) FROM fichier");		
			rs = ps.executeQuery();

			while (rs.next()) {
				retour = rs.getInt("MAX(id)");
			}
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
	
	
	public void supprimerProjetJava(int idProjetASupprime) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM fichier WHERE id = ?");
			ps.setInt(1, idProjetASupprime);
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
	
	public int recupererMajeurVersionProjetJava(int idProjetJava) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT num_maj FROM version WHERE id_fichier_version = ?");
			ps.setInt(1, idProjetJava);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				retour = rs.getInt("num_maj");
			}

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
	
	public int recupererMineurVersionProjetJava(int idProjetJava) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT num_min FROM version WHERE id_fichier_version = ?");
			ps.setInt(1, idProjetJava);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				retour = rs.getInt("num_min");
			}

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
		
    //------------------------------------TEST DAO PROJETJAVA---------------------------------------------- 
	/**
	// main permettant de tester la classe 
		 public static void main(String[] args) throws SQLException {
		   DAOProjetJava DAOprojet = new DAOProjetJava(); 
		   
		  // test de la m�thode ajouter 

		   ProjetJava p1 = new ProjetJava(1, "projet_test","destination 1", new Date(System.currentTimeMillis()) , 1);
	      int retour = DAOprojet.ajouter(p1);
		  System.out.println(retour + " lignes ajout�es"); 
		 // test de la m�thode getArticle 
		  ProjetJava p2 = DAOprojet.getProjetJava(1);
		  System.out.println(p2); 
		  
		  // test de la m�thode getListeProjet 
		  ArrayList<ProjetJava> liste = DAOprojet.getListeProjetJava(); 
		  // affichage des projets 
		  for (ProjetJava proj :liste) { 
			  System.out.println(proj.toString());  
			  } 
			  
			  // test de la m�thode getListeProjetJavaUtilisateur
			   ArrayList<ProjetJava> liste_projet_utilisateur = DAOprojet.gestListeProjetJavaUtilisateur(1)
			     // affichage des projets 
		  for (ProjetJava proj :liste_projet_utilisateur) { 
			  System.out.println(proj.toString());
		  }
	 */
}
