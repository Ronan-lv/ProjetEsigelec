package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moteur.Utilisateur;

public class DAOUtilisateur {
	/**
	* Param�tres de connexion � la base de donn�es oracle URL, LOGIN et PASS
	* sont des constantes
	*/
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "BDD8"; //exemple BDD8
	final static String PASS = "BDD8"; //exemple BDD8
	/**
	* Constructeur de la classe
	*
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
	* Permet d'ajouter un utilisateur dans la tableutilisateur Le mode est auto-commit
	* par d�faut : chaque insertion est valid�e
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
	ps = con.prepareStatement("INSERT INTO utilisateur (id,"
			+ "identifiant,mdp,type) VALUES (?, ?, ?, ?)");
	ps.setInt(1, uti.GetReference() );
	ps.setString(2, uti.GetIdentifiant());
	ps.setString(3, uti.GetMotDePasse());
	ps.setInt(4, uti.GetIsGestionnaire()?1:0);
	// Ex�cution de la requ�te
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
	* Permet de r�cup�rer un utilisateur � partir de sa r�f�rence
	*
	* @param reference la r�f�rence de l'utilisateur � r�cup�rer
	* @return l'utilisateur trouv�;
	null si aucun utilisateur ne correspond � cette r�f�rence
	*/
	public Utilisateur getUtilisateur(int reference) {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Utilisateur retour = null;
	// connexion � la base de donn�es
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT * FROM utlisateur WHERE id = ?");
	ps.setInt(1, reference);
	// on ex�cute la requ�te
	// rs contient un pointeur situ� jusute avant la premi�re ligne
	// retourn�e
	rs = ps.executeQuery();
	// passe � la premi�re (et unique) ligne retourn�e
	if (rs.next())
	retour = new Utilisateur(rs.getInt("id"),rs.getString("identifiant"),rs.getString("mdp"),rs.getInt("type")== 1 ? true:false);
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
	ps = con.prepareStatement("SELECT * FROM utilisateur");
	// on ex�cute la requ�te
	rs = ps.executeQuery();
	// on parcourt les lignes du r�sultat
	while (rs.next())
	retour.add(new Utilisateur(rs.getInt("id"),
	rs.getString("identifiant"), rs.getString("mdp"),
	rs.getInt("type")== 1 ? true:false));
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
	// test de la m�thode ajouter
	Article a1 = new Article(1, "Set de 2 raquettes de ping-pong", 149.9,
	10);
	2017-2018 Surveillance de la qualit� de l�air en Normandie p 13/15
	int retour = articleDAO.ajouter(a1);
	System.out.println(retour + " lignes ajout�es");
	// test de la m�thode getArticle
	Article a2 = articleDAO.getArticle(1);
	System.out.println(a2);
	// test de la m�thode getListeArticles
	List<Article> liste = articleDAO.getListeArticles();
	// affichage des articles
	for (Article art : liste) {
	System.out.println(art.toString());
	}
	}
	*/
}
