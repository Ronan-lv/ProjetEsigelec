package Ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelFichiersReferences extends PanelGenerique implements ActionListener {


	private JPanel panelHaut;
	private JPanel panelMilieu;
	private JPanel panelBas;
	
	private JButton boutonMenu;
	private JButton boutonLogOut;
	
	private JLabel titrePanel;
	
	private JScrollPane jsp;
	
	private JButton boutonAfficher;
	private JButton boutonSupprimer;
	private JButton boutonAfficherLesVersions;
	

	

	
    public PanelFichiersReferences(Fenetre fen) {
    	
    	super(fen);
		
		
		//Création & configuration des panels
		
		this.panelHaut = new JPanel();
		this.panelHaut.setLayout(new BoxLayout(this.panelHaut, BoxLayout.LINE_AXIS));
		this.panelHaut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		this.panelMilieu = new JPanel();
		this.panelMilieu.setLayout(new BoxLayout(this.panelMilieu, BoxLayout.PAGE_AXIS));
		this.panelMilieu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.jsp = new JScrollPane(this.panelMilieu, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
				);
		this.jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

		
		this.panelBas = new JPanel();
		this.panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		//this.panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	
        	
		//Création & configuration des composants
		
		this.boutonMenu = new JButton("Menu");
		this.boutonMenu.addActionListener(this);
		this.boutonLogOut = new JButton("LogOut");
		this.boutonLogOut.addActionListener(this);
		
		this.titrePanel = new JLabel("Fichiers référencés");
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);	
		
		this.boutonAfficher = new JButton("Afficher");
		this.boutonSupprimer = new JButton("Supprimer");
		this.boutonAfficherLesVersions = new JButton("Afficher Versions");
		
	
		//Ajouts des composants dans les panels
		
		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createHorizontalGlue());
		
		this.remplissageDuPanelMilieuAvecDesLignesGraphiques();
		
		this.panelBas.add(this.boutonAfficher);
		this.panelBas.add(this.boutonSupprimer);
		this.panelBas.add(this.boutonAfficherLesVersions);
		
		//Configuration du panel général
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 50));
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(this.panelHaut);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(this.titrePanel);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(this.jsp);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(this.panelBas);
		this.add(Box.createRigidArea(new Dimension(0, 70)));
		
	}	
    
    
    private void remplissageDuPanelMilieuAvecDesLignesGraphiques() {
 
    	for(int i = 0; i < 100; i++) {
    		
    		JPanel uneLigneAffichage = new JPanel();    
    		
    		uneLigneAffichage.setLayout(new BoxLayout(uneLigneAffichage, BoxLayout.LINE_AXIS));
    		uneLigneAffichage.setBorder(BorderFactory.createCompoundBorder(
    										BorderFactory.createLineBorder(Color.BLACK),
    										BorderFactory.createEmptyBorder(3, 3, 3, 3)
    									));
    		

    		uneLigneAffichage.add(new JLabel("date_fichier"));
    		uneLigneAffichage.add(Box.createHorizontalStrut(90));
    		
    		uneLigneAffichage.add(new JLabel("nom_fichier"));
    		uneLigneAffichage.add(Box.createHorizontalStrut(90));
    		
    		uneLigneAffichage.add(new JLabel("version_fichier"));
    		uneLigneAffichage.add(Box.createHorizontalStrut(90));
    		
    		uneLigneAffichage.add(new JLabel("ligne n° " + i));
    		
  
    		this.panelMilieu.add(uneLigneAffichage);
    		
    		this.panelMilieu.add(Box.createVerticalStrut(10));
    	
    	}
    	
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
