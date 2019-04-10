import java.sql.SQLException;

import DAO.DAOProjetJava;
import moteur.ProjetJava;
import oracle.sql.DATE;

import java.sql.Date ;
public class Main {

	
	 // main permettant de tester la classe 
	 public static void main(String[] args)throws SQLException {
	   DAOProjetJava daoprojet = new DAOProjetJava(); 
	  // test de la méthode ajouter 
	   ProjetJava p1 = new ProjetJava(1,"test1","destination1",Date.valueOf("2013-10-25"),1);
	  		int retour = daoprojet.ajouter(p1);
	  System.out.println(retour + " lignes ajoutées"); 
	/**  // test de la méthode getArticle 
	  Article a2 = DAO.getArticle(1); 
	  System.out.println(a2); 
	  // test de la méthode getListeArticles 
	  List<Article> liste = articleDAO.getListeArticles(); 
	  // affichage des articles 
	  for (Article art :liste) { 
		  System.out.println(art.toString());
	  }*/
	  }
	 
		
}
