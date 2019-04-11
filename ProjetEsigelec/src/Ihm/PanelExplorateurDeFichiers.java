package Ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelExplorateurDeFichiers extends PanelGenerique implements ActionListener{

	
	private JPanel panelHaut;
	private JPanel panelBas;
	
	private JButton boutonMenu;
	private JButton boutonLogOut;
	
	private JLabel titrePanel;
	
	private JFileChooser jfc;
	
    public PanelExplorateurDeFichiers(Fenetre fen)  {
		
    	super(fen);
    	
		//Création & configuration des composants
		
		this.boutonMenu = new JButton("Menu");
		this.boutonMenu.addActionListener(this);
		this.boutonLogOut = new JButton("LogOut");
		this.boutonLogOut.addActionListener(this);
		
		this.titrePanel = new JLabel("Explorateur de Fichiers");
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);
		
		this.jfc = new JFileChooser();
	
		
		//Création & configuration des panels
		
		this.panelHaut = new JPanel();
		this.panelHaut.setLayout(new BoxLayout(this.panelHaut, BoxLayout.LINE_AXIS));
		this.panelHaut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		this.panelBas = new JPanel();
		this.panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK));


		
		//Ajouts des composants dans les panels
		
		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createHorizontalGlue());
		
		this.panelBas.add(this.jfc);
		
		//Configuration du panel général
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 50));
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(this.panelHaut);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(this.titrePanel);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(this.panelBas);
		this.add(Box.createRigidArea(new Dimension(0, 100)));
		
		



		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.boutonMenu) {
			this.fen.setContentPane(new PanelMenu(this.fen));
			this.fen.revalidate();
		}
		
		if(e.getSource() == this.boutonLogOut) {
			this.fen.setContentPane(new PanelConnexion(this.fen));
			this.fen.revalidate();
		}
		
	}
	

}
