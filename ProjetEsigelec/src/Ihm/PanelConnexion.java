package Ihm;

import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelConnexion extends PanelGenerique {

		private JLabel texteTitre;
		private JTextField champLogin;
		private JTextField champPassword;
		
		private Button bouttonValider;
		
		public PanelConnexion() {

			this.texteTitre = new JLabel("Salut");
			this.champLogin = new JTextField("Login");
			this.champPassword = new JTextField("Password");
			
			this.add(texteTitre);
			this.add(champLogin);
			this.add(champPassword);
			
		}
}
