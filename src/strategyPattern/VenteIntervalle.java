/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: VenteIntervalle.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/

package strategyPattern;

import modele.usine.Entrepot;

// Classe représentant une stratégie de vente par intervalle implémentant l'interface StrategyVente
public class VenteIntervalle implements StrategyVente {

    private int nombreAvionVendu = 1; // Nombre d'avions à vendre à chaque intervalle

    // Méthode pour exécuter la stratégie de vente par intervalle
    @Override
    public void execute() {
        int nombreAvion = Entrepot.getInstance().getNombreAvion();
        // Vérifier si l'entrepôt a au moins un avion en stock
        if (nombreAvion >= this.nombreAvionVendu) {
            // Mettre à jour le nombre d'avions en stock après la vente par intervalle
            Entrepot.getInstance().setNombreAvion(nombreAvion - this.nombreAvionVendu);
        }
    }
}