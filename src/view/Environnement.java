/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: Environnement.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/
package view;

import java.awt.Point;

import javax.swing.SwingWorker;

import composants.Metal;
import modele.usine.Entrepot;
import modele.usine.UsineAile1;
import modele.usine.UsineAssemblage;
import modele.usine.UsineMatiere1;
import modele.usine.UsineMatiere2;
import modele.usine.UsineMatiere3;
import modele.usine.UsineMoteur;
import strategyPattern.VenteAleatoire;
import strategyPattern.VenteIntervalle;

public class Environnement extends SwingWorker<Object, String> {
	private boolean actif = true;
	private static final int DELAI = 1; // initial : 100
	private int compteurVente = 0;
	private int intervalleVente = 100;

	@Override
	protected Object doInBackground() throws Exception {
		while (this.actif) {
			Thread.sleep(DELAI);
			/**
			 * C'est ici que vous aurez � faire la gestion de la notion de tour.
			 */

			this.compteurVente++;

			// Logique pour UsineAile1

			if (UsineAile1.getInstance().getNombreMetal() % 2 != 0) {
				UsineAile1.getInstance().updateImage(0);

			}

			if (UsineAile1.getInstance().getNombreMetal() >= 2) {
				UsineAile1.usineAileCompteur += 1;

				if (UsineAile1.usineAileCompteur >= 60 * Entrepot.speedProduction) {
					UsineAile1.getInstance().updateImage(0);
				}

				if (UsineAile1.usineAileCompteur >= 120 * Entrepot.speedProduction) {
					UsineAile1.getInstance().updateImage(1);
				}

				if (UsineAile1.usineAileCompteur >= 180 * Entrepot.speedProduction) {
					UsineAile1.getInstance().updateImage(2);
				}

				if (UsineAile1.usineAileCompteur >= UsineAile1.usineAileInterval * Entrepot.speedProduction) {
					UsineAile1.getInstance().updateImage(3);
					UsineAile1.getInstance().produceAile();
					UsineAile1.usineAileCompteur = 0;
				}

			}

			// Logique pour UsineMoteur

			if (UsineMoteur.getInstance().getNombreMetal() % 2 != 0) {
				UsineMoteur.getInstance().updateImage(0);

			}

			if (UsineMoteur.getInstance().getNombreMetal() >= 4) {
				UsineMoteur.usineMoteurCompteur += 1;

				if (UsineMoteur.usineMoteurCompteur >= 100 * Entrepot.speedProduction) {
					UsineMoteur.getInstance().updateImage(0);
				}

				if (UsineMoteur.usineMoteurCompteur >= 200 * Entrepot.speedProduction) {
					UsineMoteur.getInstance().updateImage(1);
				}

				if (UsineMoteur.usineMoteurCompteur >= 300 * Entrepot.speedProduction) {
					UsineMoteur.getInstance().updateImage(2);
				}

				if (UsineMoteur.usineMoteurCompteur >= UsineMoteur.usineMoteurInterval * Entrepot.speedProduction) {
					UsineMoteur.getInstance().updateImage(3);
					UsineMoteur.getInstance().produiceMoteur();
					UsineMoteur.usineMoteurCompteur = 0;
				}

			}

			// Logique pour UsineAssemblage :

			if (UsineAssemblage.getInstance().getNombreMoteur() % 4 != 0 &&
					UsineAssemblage.getInstance().getNombreAile() % 2 != 0) {
				UsineAssemblage.getInstance().updateImage(0);

			}

			if (UsineAssemblage.getInstance().getNombreMoteur() >= 4 &&
					UsineAssemblage.getInstance().getNombreAile() >= 2) {
				UsineAssemblage.usineAssemblageCompteur += 1;

				if (UsineAssemblage.usineAssemblageCompteur >= 100 * Entrepot.speedProduction) {
					UsineAssemblage.getInstance().updateImage(0);
				}

				if (UsineAssemblage.usineAssemblageCompteur >= 200 * Entrepot.speedProduction) {
					UsineAssemblage.getInstance().updateImage(1);
				}

				if (UsineAssemblage.usineAssemblageCompteur >= 350 * Entrepot.speedProduction) {
					UsineAssemblage.getInstance().updateImage(2);
				}

				if (UsineAssemblage.usineAssemblageCompteur >= UsineAssemblage.usineAssemblageInterval
						* Entrepot.speedProduction) {
					UsineAssemblage.getInstance().updateImage(3);
					UsineAssemblage.getInstance().produceAvion();
					UsineAssemblage.usineAssemblageCompteur = 0;
				}

			}

			/**
			 * Gestion de tour pour les UsineMatieres
			 */

			// Logique pour UsineMatiere1, UsineMatiere2 et UsineMatiere3

			UsineMatiere1.getInstance().usineMatiereCompteur += 1;

			if (UsineMatiere1.usineMatiereCompteur >= 125 * Entrepot.speedProduction) {
				UsineMatiere1.getInstance().updateImage(0);
				UsineMatiere2.getInstance().updateImage(0);
				UsineMatiere3.getInstance().updateImage(0);
			}

			if (UsineMatiere1.usineMatiereCompteur >= 250 * Entrepot.speedProduction) {
				UsineMatiere1.getInstance().updateImage(1);
				UsineMatiere2.getInstance().updateImage(1);
				UsineMatiere3.getInstance().updateImage(1);
			}

			if (UsineMatiere1.usineMatiereCompteur >= 375 * Entrepot.speedProduction) {
				UsineMatiere1.getInstance().updateImage(2);
				UsineMatiere2.getInstance().updateImage(2);
				UsineMatiere3.getInstance().updateImage(2);
			}

			if (UsineMatiere1.usineMatiereCompteur >= UsineMatiere1.usineMatiereInterval * Entrepot.speedProduction) {
				UsineMatiere1.produiceMetal();
				UsineMatiere2.produiceMetal();
				UsineMatiere3.produiceMetal();
				UsineMatiere1.getInstance().updateImage(3);
				UsineMatiere2.getInstance().updateImage(3);
				UsineMatiere3.getInstance().updateImage(3);
				UsineMatiere1.usineMatiereCompteur = 0;
			}

			// Gestion des ventes et mise à jour de l'entrepôt
			Entrepot.getInstance().changeProductivity();

			if (this.compteurVente >= this.intervalleVente) {
				Entrepot.getInstance().vendAvion();
				this.compteurVente = 0;
			}

			Entrepot.getInstance().stopProduction();
			// Notification des observateurs et mise à jour de l'image
			Entrepot.getInstance().notifier();
			Entrepot.getInstance().updateImage();

			this.firePropertyChange("TEST", null, "");

		}
		return null;
	}

}