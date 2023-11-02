package view;

import java.awt.Point;

import javax.swing.SwingWorker;

import composants.Metal;
import modele.usine.UsineAile1;
import modele.usine.UsineAssemblage;
import modele.usine.UsineMatiere1;
import modele.usine.UsineMatiere2;
import modele.usine.UsineMatiere3;
import modele.usine.UsineMoteur;

public class Environnement extends SwingWorker<Object, String> {
	private boolean actif = true;
	private static final int DELAI = 1; //initial : 100
	int compteur = 0;
	int intervalle = 3000;
	
	@Override
	protected Object doInBackground() throws Exception {
		while(this.actif) {
			Thread.sleep(DELAI);
			/**
			 * C'est ici que vous aurez � faire la gestion de la notion de tour.
			 */
			//this.compteur++;
			if (this.compteur == this.intervalle){
				UsineMatiere1.getInstance().update();
			}

			/**
			 * Gestion de tour pour les usines ailes
			 */

			if (UsineAile1.getInstance().getNombreMetal()%2!=0){
				UsineAile1.getInstance().updateImage(0);

			}

			if (UsineAile1.getInstance().getNombreMetal()>=2){
				UsineAile1.usineAileCompteur +=1;

				if(UsineAile1.usineAileCompteur >=60){
					UsineAile1.getInstance().updateImage(0);
				}

					if(UsineAile1.usineAileCompteur >=120){
					UsineAile1.getInstance().updateImage(1);
				}

					if(UsineAile1.usineAileCompteur >=180){
					UsineAile1.getInstance().updateImage(2);
				}

					if(UsineAile1.usineAileCompteur >=UsineAile1.usineAileInterval){
					UsineAile1.getInstance().updateImage(3);
					UsineAile1.getInstance().produceAile();
					UsineAile1.usineAileCompteur = 0 ;
				}



			}
			
			if (UsineMoteur.getInstance().getNombreMetal()%2!=0){
				UsineMoteur.getInstance().updateImage(0);

			}

			if (UsineMoteur.getInstance().getNombreMetal()>=4){
				UsineMoteur.usineMoteurCompteur +=1;

				if(UsineMoteur.usineMoteurCompteur >=100){
					UsineMoteur.getInstance().updateImage(0);
				}

					if(UsineMoteur.usineMoteurCompteur >=200){
					UsineMoteur.getInstance().updateImage(1);
				}

					if(UsineMoteur.usineMoteurCompteur >=300){
					UsineMoteur.getInstance().updateImage(2);
				}

					if(UsineMoteur.usineMoteurCompteur >=UsineMoteur.usineMoteurInterval){
					UsineMoteur.getInstance().updateImage(3);
					UsineMoteur.getInstance().produiceMoteur();
					UsineMoteur.usineMoteurCompteur = 0 ;
				}



			}


						
			if (UsineAssemblage.getInstance().getNombreMoteur()%4!=0 &&
			UsineAssemblage.getInstance().getNombreAile()%2!=0){
				UsineAssemblage.getInstance().updateImage(0);

			}

			if (UsineAssemblage.getInstance().getNombreMoteur()>=4 && 
			UsineAssemblage.getInstance().getNombreAile() >=2){
				UsineAssemblage.usineAssemblageCompteur +=1;

				if(UsineAssemblage.usineAssemblageCompteur >=100){
					UsineAssemblage.getInstance().updateImage(0);
				}

					if(UsineAssemblage.usineAssemblageCompteur >=200){
					UsineAssemblage.getInstance().updateImage(1);
				}

					if(UsineAssemblage.usineAssemblageCompteur >=350){
					UsineAssemblage.getInstance().updateImage(2);
				}

					if(UsineAssemblage.usineAssemblageCompteur >=UsineAssemblage.usineAssemblageInterval){
					UsineAssemblage.getInstance().updateImage(3);
					UsineAssemblage.getInstance().produceAvion();
					UsineAssemblage.usineAssemblageCompteur = 0 ;
				}



			}




			/**
			 * Gestion de tour pour les UsineMatieres
			 */




			UsineMatiere1.getInstance().usineMatiereCompteur +=1;
			
				if (UsineMatiere1.usineMatiereCompteur >= 125){
				UsineMatiere1.getInstance().updateImage(0);
				UsineMatiere2.getInstance().updateImage(0);
				UsineMatiere3.getInstance().updateImage(0);
			}

				if (UsineMatiere1.usineMatiereCompteur >= 250){
				UsineMatiere1.getInstance().updateImage(1);
				UsineMatiere2.getInstance().updateImage(1);
				UsineMatiere3.getInstance().updateImage(1);
			}

				if (UsineMatiere1.usineMatiereCompteur >= 375){
				UsineMatiere1.getInstance().updateImage(2);
				UsineMatiere2.getInstance().updateImage(2);
				UsineMatiere3.getInstance().updateImage(2);
			}
			
			if (UsineMatiere1.usineMatiereCompteur >= 
			UsineMatiere1.usineMatiereInterval){
				UsineMatiere1.produiceMetal();
				UsineMatiere2.produiceMetal();
				UsineMatiere3.produiceMetal();
				UsineMatiere1.getInstance().updateImage(3);
				UsineMatiere2.getInstance().updateImage(3);
				UsineMatiere3.getInstance().updateImage(3);
				UsineMatiere1.usineMatiereCompteur = 0;
			}

			
			
		
	
			this.firePropertyChange("TEST", null, "");
			
		}
		return null;
	}

}