package view;

import javax.swing.SwingWorker;

public class Environnement extends SwingWorker<Object, String> {
	private boolean actif = true;
	private static final int DELAI = 10; //initial : 100
	
	@Override
	protected Object doInBackground() throws Exception {
		while(!this.actif) {
			Thread.sleep(DELAI);
			/**
			 * C'est ici que vous aurez � faire la gestion de la notion de tour.
			 */

			 
			this.firePropertyChange("TEST", null, "Ceci est un test");
		}
		return null;
	}

}