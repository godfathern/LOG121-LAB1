/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: PanneauStrategie.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/  
package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import modele.usine.Entrepot;
import strategyPattern.StrategyVente;
import strategyPattern.VenteAleatoire;
import strategyPattern.VenteIntervalle;

public class PanneauStrategie extends JPanel implements StrategyVente {

	private static final long serialVersionUID = 1L;

	public PanneauStrategie() {

		ButtonGroup groupeBoutons = new ButtonGroup();
		JRadioButton strategie1 = new JRadioButton("VenteAleatoire");
		JRadioButton strategie2 = new JRadioButton("VenteIntervalle");	
		
		JButton boutonConfirmer = new JButton("Confirmer");

		boutonConfirmer.addActionListener((ActionEvent e) -> {
			// TODO - Appeler la bonne strat�gie
			if(this.getSelectedButtonText(groupeBoutons).equals("VenteAleatoire")){
				Entrepot.getInstance().setStrategyVente(new VenteAleatoire());
				System.out.println(Entrepot.getInstance().getStrategyVente());
			}

			if(this.getSelectedButtonText(groupeBoutons).equals("VenteIntervalle")){
				Entrepot.getInstance().setStrategyVente(new VenteIntervalle());
				System.out.println(Entrepot.getInstance().getStrategyVente());
			}

			// Fermer la fen�tre du composant
			SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
		});

		JButton boutonAnnuler = new JButton("Annuler");

		boutonAnnuler.addActionListener((ActionEvent e) -> {
			// Fermer la fen�tre du composant
			SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
		});

		groupeBoutons.add(strategie1);
		groupeBoutons.add(strategie2);		
		this.add(strategie1);
		this.add(strategie2);		
		this.add(boutonConfirmer);
		this.add(boutonAnnuler);

	}

	/**
	 * Retourne le bouton s�lectionn� dans un groupe de boutons.
	 * @param groupeBoutons
	 * @return
	 */
	public String getSelectedButtonText(ButtonGroup groupeBoutons) {
		for (Enumeration<AbstractButton> boutons = groupeBoutons.getElements(); boutons.hasMoreElements();) {
			AbstractButton bouton = boutons.nextElement();
			if (bouton.isSelected()) {
				return bouton.getText();
			}
		}

		return null;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'execute'");
	}

}
