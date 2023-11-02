/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: FenetreStrategie.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/  
package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import strategyPattern.StrategyVente;

public class FenetreStrategie extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "S�lectionnez votre strat�gie de vente";
	private static final Dimension DIMENSION = new Dimension(250, 100);
	private PanneauStrategie panneauStrategie = new PanneauStrategie();

	public FenetreStrategie() {
		this.add(this.panneauStrategie);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle(TITRE_FENETRE);
		this.setSize(DIMENSION);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

	}

	
}
