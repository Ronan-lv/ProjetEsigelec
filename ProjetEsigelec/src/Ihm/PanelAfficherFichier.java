package Ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelAfficherFichier extends PanelGenerique implements ActionListener{

	private JPanel panelHaut;
	private JPanel panelMilieu;
	private JPanel panelBas;
	
	private JButton boutonMenu;
	private JButton boutonLogOut;
	
	private JLabel titrePanel;
	
	private JTextArea zoneAffichageCode;
	private JScrollPane jsp;
	
	private JButton boutonAfficherAutresVersions;
	private JButton boutonSpecial;
	private JButton boutonRetour;
	
	public PanelAfficherFichier(Fenetre fen) {
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
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
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
		
		this.titrePanel = new JLabel(this.fen.getDaoProjetJava().getProjetJava(Integer.valueOf(this.fen.getStringDeTest())).getNomProjet()
									+ "  v"
									+ this.fen.getDaoProjetJava().recupererMajeurVersionProjetJava(Integer.valueOf(this.fen.getStringDeTest()))
									);
		this.titrePanel.setFont(policeTaille2);
		this.titrePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titrePanel.setFont(this.policeTaille2);	
		
		this.zoneAffichageCode = new JTextArea();
		 
		this.remplissageZoneAffichageCode();
		
		this.boutonAfficherAutresVersions = new JButton("Versions antérieurs");
		this.boutonAfficherAutresVersions.addActionListener(this);
		this.boutonSpecial = new JButton("Bouton Spécial");
		this.boutonSpecial.addActionListener(this);
		this.boutonRetour = new JButton("Retour");
		this.boutonRetour.addActionListener(this);
		
	
		//Ajouts des composants dans les panels
		
		this.panelHaut.add(this.boutonLogOut);
		this.panelHaut.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelHaut.add(this.boutonMenu);
		this.panelHaut.add(Box.createHorizontalGlue());
				
		this.panelMilieu.add(zoneAffichageCode);
		
		this.panelBas.add(this.boutonAfficherAutresVersions);
		this.panelBas.add(this.boutonSpecial);
		this.panelBas.add(this.boutonRetour);
		
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

	private void remplissageZoneAffichageCode() {
		this.zoneAffichageCode.setEditable(false);
		//Penser à afficher la description
		this.zoneAffichageCode.setText(this.fen.getDaoVersionFichier().getDerniereVersionFichierDuProjet(
				Integer.parseInt(this.fen.getStringDeTest()) ).getContenuVersion());
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
		
		
		if(e.getSource() == this.boutonRetour) {
			this.fen.setContentPane(new PanelFichiersReferences(this.fen));
			this.fen.revalidate();
		}
	}

}
