/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: Avion.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/

// Importation des classes nécessaires
package composants;

import java.awt.Point;
import javax.swing.ImageIcon;
import modele.usine.Entrepot;
import observerPattern.Subject;

// Déclaration de la classe Avion implémentant l'interface Composant et étendant Subject
public class Avion extends Subject implements Composant {
    private Point position; // Position de l'avion sur l'écran
    private Point vitesse = new Point(1, 1); // Vitesse de déplacement de l'avion
    private ImageIcon image; // Image représentant l'avion

    // Constructeur de la classe prenant en paramètre la position initiale de l'avion
    public Avion(Point position) {
        this.position = position;
        // Chargement de l'image de l'avion depuis le dossier de ressources
        this.image = new ImageIcon(this.getClass().getResource("/ressources/avion.png"));
    }

    // Méthode pour définir la position de l'avion
    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    // Méthode pour obtenir la position actuelle de l'avion
    @Override
    public Point getPosition() {
        return this.position;
    }

    // Méthode pour obtenir l'image représentant l'avion
    @Override
    public ImageIcon getImage() {
        return this.image;
    }

    // Méthode pour vérifier si l'avion atteint la position de l'entrepôt
    public void checkPosition(Entrepot entrepot) {
        // Si la position de l'avion atteint la position de l'entrepôt
        if (this.getPosition().x == 640) {
            // Mettre à jour l'entrepôt
            entrepot.getInstance().update();
        }
    }
}