import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAOProjetJava;
import DAO.DAOUtilisateur;
import DAO.DAOVersionFichier;
import Ihm.Fenetre;
import moteur.Utilisateur;
import moteur.VersionFichier;
import moteur.ProjetJava;
import java.sql.*;
public class Main {
	 public static void main(String[] args) throws SQLException {
		   DAOProjetJava DAOprojet = new DAOProjetJava(); 
	 ArrayList<ProjetJava> liste_projet_utilisateur = DAOprojet.getListeProjetJavaUtilisateur(1);
		     // affichage des projets 
	  for (ProjetJava proj :liste_projet_utilisateur) { 
		  System.out.println(proj.toString());
	  }
}
}
