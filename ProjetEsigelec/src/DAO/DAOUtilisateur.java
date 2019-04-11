package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moteur.Utilisateur;

public class DAOUtilisateur {
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
	public DAOUtilisateur() {
	// chargement du pilote de bases de données
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
	System.err.println("Impossible de charger le pilote de BDD, ne pas "
			+ "oublier d'importer le fichier .jar dans le projet");
	}
	
	}
	/**
	* Permet d'ajouter un utilisateur dans la table utilisateur Le mode est auto-commit
	* par défaut : chaque insertion est validée
	*
	* @param utilisateur l'utilisateur à ajouter
	* @return retourne le nombre de lignes ajoutées dans la table
	*/
	public int ajouter(Utilisateur uti) {
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
	ps = con.prepareStatement("INSERT INTO utilisateur (id,"
			+ "identifiant,mdp,type) VALUES (?, ?, ?, ?)");
	ps.setInt(1, uti.getReference() );
	ps.setString(2, uti.getIdentifiant());
	ps.setString(3, uti.getMotDePasse());
	ps.setInt(4, uti.getIsGestionnaire()?1:0);
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
	* Permet de récupérer un utilisateur à partir de sa référence
	*
	* @param reference la référence de l'utilisateur à récupérer
	* @return l'utilisateur trouvé;
	null si aucun utilisateur ne correspond à cette référence
	*/
	public Utilisateur getUtilisateur(int reference) {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Utilisateur retour = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT * FROM utilisateur WHERE id = ?");
	ps.setInt(1, reference);
	// on exécute la requête
	// rs contient un pointeur situé jusute avant la première ligne
	// retournée
	rs = ps.executeQuery();
	// passe à la première (et unique) ligne retournée
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
	* Permet de récupérer tous les utilisateurs stockés dans la table utilisateur
	*
	* @return une ArrayList d'utilisateur
	*/
	public ArrayList<Utilisateur> getListeUtilisateurs() {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<Utilisateur> retour = new ArrayList<Utilisateur>();
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT * FROM utilisateur ORDER BY id ASC");
	// on exécute la requête
	rs = ps.executeQuery();
	// on parcourt les lignes du résultat
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
	
//---------------------------------------------TEST DE LA DAO-------------------------------------------------	
	/**	// main permettant de tester la classe utilisateur et DAO Utilisateur 
	public static void main(String[] args) throws SQLException {
	DAOUtilisateur daoutilisateur = new DAOUtilisateur();
	
	// test de la méthode ajouter Utilisateur 
	Utilisateur u1 = new Utilisateur(3, "jack","digitalx76",true) ;
	int retour = daoutilisateur.ajouter(u1);
	System.out.println(retour + " lignes ajoutées"); 
	
	// test de la méthode récupérer un utilisateur
	Utilisateur u2 = daoutilisateur.getUtilisateur(1);
	System.out.println(u2);
	// test de la méthode getListeArticles
	ArrayList<Utilisateur> listeutilisateur = daoutilisateur.getListeUtilisateurs() ;
	// affichage des articles
	for (Utilisateur uti : listeutilisateur) {
	System.out.println(uti.toString());
	}
	}	*/	
	
}
