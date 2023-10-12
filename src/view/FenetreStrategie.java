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
