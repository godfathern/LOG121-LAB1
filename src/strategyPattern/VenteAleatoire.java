/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: VenteAleatoire.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/

package strategyPattern;

import java.util.concurrent.ThreadLocalRandom;

import modele.usine.Entrepot;

// Classe représentant une stratégie de vente aléatoire implémentant l'interface StrategyVente
public class VenteAleatoire implements StrategyVente {

    // Méthode pour exécuter la stratégie de vente aléatoire
    @Override
    public void execute() {
        // Vérifier si l'entrepôt a au moins 3 avions en stock
        if (Entrepot.getInstance().getNombreAvion() >= 3) {
            int nombreAvion = Entrepot.getInstance().getNombreAvion();
            // Générer un nombre aléatoire entre 0 et le nombre total d'avions en stock
            int nombreAvionVendu = ThreadLocalRandom.current().nextInt(0, nombreAvion + 1);
            // Mettre à jour le nombre d'avions en stock après la vente aléatoire
            Entrepot.getInstance().setNombreAvion(nombreAvion - nombreAvionVendu);
        }
    }
}