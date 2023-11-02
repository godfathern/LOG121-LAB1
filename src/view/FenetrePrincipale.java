/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: FenetrePrincipale.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/  
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 1 : LOG121 - Simulation";
	private static final Dimension DIMENSION = new Dimension(700, 700);

	public FenetrePrincipale() {
		PanneauPrincipal panneauPrincipal = new PanneauPrincipal();
		MenuFenetre menuFenetre = new MenuFenetre();
		this.add(panneauPrincipal);
		this.add(menuFenetre, BorderLayout.NORTH);
		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(TITRE_FENETRE);
		this.setSize(DIMENSION);
		// Rendre la fen�tre visible
		this.setVisible(true);
		// Mettre la fen�tre au centre de l'�cran
		this.setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		this.setResizable(false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("TEST")) {
			this.repaint();
			System.out.println(evt.getNewValue());
		}
	}
}
