package Ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.DAOUtilisateur;
import moteur.Utilisateur;

public class PanelConnexion extends PanelGenerique implements ActionListener  {
	
		private JLabel texteTitre;
		private JTextField champLogin;
		private JTextField champPassword;
		
		private JButton bouttonValider;
		
		
		public PanelConnexion(Fenetre fen) {
			
			super(fen);
			
			this.texteTitre = new JLabel("Identification");
			this.texteTitre.setFont(policeTaille2);
			this.texteTitre.setHorizontalAlignment(this.texteTitre.CENTER);
			
			this.champLogin = new JTextField("test1");
			this.champLogin.setFont(policeTaille2);
			
			this.champPassword = new JPasswordField("test1");
			this.champPassword.setFont(policeTaille2);
			
			this.bouttonValider = new JButton("Valider");
			this.bouttonValider.setFont(policeTaille2);
			this.bouttonValider.addActionListener(this);
			
			
			this.setLayout(new GridLayout(5,0,0,20)); //Les 2 dernières valeurs correspondent respectivement à l'espacement entre les lignes et les colonnes
			
			this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(120, 200, 120, 200), //Empty border => top, left, bottom, right
															  BorderFactory.createCompoundBorder(
																	  BorderFactory.createLineBorder(Color.BLACK, 3, true), 
																	  BorderFactory.createEmptyBorder(20, 20, 20, 20)
																	  )));
					
			
			
			this.add(texteTitre);
			this.add(champLogin);
			this.add(champPassword);
			this.add(bouttonValider);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			System.out.println("1");
			
			ArrayList<Utilisateur> listeUtilisateurs = this.fen.getDaoUtilisateur().getListeUtilisateurs();
			
			Boolean utilisateurTrouve = false;
			
			for(int i = 0; i < listeUtilisateurs.size(); i++) {
				
				if(this.champLogin.getText().equals(listeUtilisateurs.get(i).getIdentifiant())) {
					
					System.out.println("Utilisateur trouvé !");
					utilisateurTrouve = true;
					
					if(listeUtilisateurs.get(i).getMotDePasse().equals(this.champPassword.getText())) {
						
						System.out.println("Le mot de passe correspond ! Vous êtes authentifié ");
						
						this.fen.setUtilisateurActif(listeUtilisateurs.get(i));
						this.fen.setContentPane(new PanelMenu(this.fen));
						this.fen.revalidate(); //Obligation de passage en paramètre de la fenêtre pour revalider
					}
					else {
						JOptionPane.showMessageDialog(null, "Mot de passe erroné");
					}
				}	
				
				System.out.println("dans la boucle");

			}
			
			if(utilisateurTrouve == false)
				JOptionPane.showMessageDialog(null, "Identifiant incorrect");

			
		}
}
