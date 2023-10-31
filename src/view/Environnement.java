package view;

import java.awt.Point;

import javax.swing.SwingWorker;

import composants.Metal;
import modele.usine.UsineMatiere1;
import modele.usine.UsineMatiere2;
import modele.usine.UsineMatiere3;

public class Environnement extends SwingWorker<Object, String> {
	private boolean actif = true;
	private static final int DELAI = 100; //initial : 100
	
	@Override
	protected Object doInBackground() throws Exception {
		while(this.actif) {
			Thread.sleep(DELAI);
			/**
			 * C'est ici que vous aurez � faire la gestion de la notion de tour.
			 */




			UsineMatiere2.getInstance().usineMatiere2Compteur +=50;
			UsineMatiere3.getInstance().usineMatiere3Compteur +=1;

			if (UsineMatiere2.getInstance().usineMatiere2Compteur >= 
			UsineMatiere2.getInstance().usineMatiere2Interval){
				UsineMatiere2.getInstance().updateImage();
				UsineMatiere2.getInstance().usineMatiere2Compteur = 0;
			}

			if (UsineMatiere3.getInstance().usineMatiere3Compteur >= 
			UsineMatiere3.getInstance().usineMatiere2Interval){
				UsineMatiere3.getInstance().updateImage();
				UsineMatiere3.getInstance().usineMatiere3Compteur = 0;
				UsineMatiere1.produiceMetal();
			}



			UsineMatiere2.getInstance().updateImage();
		
	
			this.firePropertyChange("TEST", null, "T");
			
		}
		return null;
	}

}