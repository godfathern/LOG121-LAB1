package simulation;

public class Simulation {

	/**
	 * Cette classe repr�sente l'application dans son ensemble.
	 */
	public static void main(String[] args) {
		//Environnement environnement = new Environnement();
		//FenetrePrincipale fenetre = new FenetrePrincipale();
		//environnement.addPropertyChangeListener(fenetre);
		//environnement.execute();
		new DocumentUsine().parseXML("src/ressources/configuration.xml");
		
	}

}
