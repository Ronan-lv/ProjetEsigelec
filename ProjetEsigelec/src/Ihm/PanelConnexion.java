package Ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelConnexion extends PanelGenerique {

		private JLabel texteTitre;
		private JTextField champLogin;
		private JTextField champPassword;
		
		private JButton bouttonValider;
		
		
		
		public PanelConnexion() {
			
			this.texteTitre = new JLabel("Identification");
			this.texteTitre.setFont(policeTaille2);
			this.texteTitre.setHorizontalAlignment(this.texteTitre.CENTER);
			
			this.champLogin = new JTextField("Login");
			this.champLogin.setFont(policeTaille2);
			
			this.champPassword = new JTextField("Password");
			this.champPassword.setFont(policeTaille2);
			
			this.bouttonValider = new JButton("Valider");
			this.bouttonValider.setFont(policeTaille2);
			
			
			this.setLayout(new GridLayout(5,0,0,20)); //Les 2 dernières valeurs correspondent respectivement à l'espacement entre les lignes et les colonnes
			
			this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(120, 200, 120, 200), //Empty border => top, left, bottom, right
															  BorderFactory.createCompoundBorder(
																	  BorderFactory.createLineBorder(Color.BLACK, 3), 
																	  BorderFactory.createEmptyBorder(20, 20, 20, 20)
																	  )));
					
			
			
			this.add(texteTitre);
			this.add(champLogin);
			this.add(champPassword);
			this.add(bouttonValider);
			
		}
}
