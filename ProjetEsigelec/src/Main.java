import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAOUtilisateur;
import Ihm.Fenetre;
import moteur.Utilisateur;
import moteur.ProjetJava;
public class Main {
	
		
			// main permettant de tester la classe utilisateur et DAO Utilisateur 
		
	public static void main(String[]  args) throws SQLException  {
		DAOUtilisateur daoutilisateur = new DAOUtilisateur();
		// test de la méthode getListeArticles
		ArrayList<Utilisateur> listeutilisateur = daoutilisateur.getListeUtilisateurs() ;
		// affichage des articles
		for (Utilisateur uti : listeutilisateur) {
		System.out.println(uti.toString());
}
	}
}
