/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: Metal.java
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
import modele.usine.UsineAile1;
import modele.usine.UsineMoteur;
import observerPattern.Subject;

// Déclaration de la classe Metal implémentant l'interface Composant et étendant Subject
public class Metal extends Subject implements Composant {
    private Point position; // Position du métal sur l'écran
    private Point vitesse = new Point(1, 1); // Vitesse de déplacement du métal
    private ImageIcon image; // Image représentant le métal

    // Constructeur de la classe prenant en paramètre la position initiale du métal
    public Metal(Point position) {
        this.position = position;
        // Chargement de l'image du métal depuis le dossier de ressources
        this.image = new ImageIcon(this.getClass().getResource("/ressources/metal.png"));
    }

    // Méthode pour définir la position du métal
    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    // Méthode pour obtenir la position actuelle du métal
    @Override
    public Point getPosition() {
        return this.position;
    }

    // Méthode pour obtenir l'image représentant le métal
    @Override
    public ImageIcon getImage() {
        return this.image;
    }

    // Méthode pour vérifier si le métal atteint la position de l'usine d'aile
    public void checkPosition(UsineAile1 usine) {
        // Si la position du métal correspond à la position de l'usine d'aile
        if (this.getPosition().x == usine.getPosition().x && this.getPosition().y == usine.getPosition().y) {
            // Mettre à jour l'usine d'aile
            UsineAile1.getInstance().update();
        }
    }

    // Méthode pour vérifier si le métal atteint la position de l'usine de moteur
    public void checkPosition(UsineMoteur usine) {
        // Si la position du métal correspond à la position de l'usine de moteur
        if (this.getPosition().x == usine.getPosition().x && this.getPosition().y == usine.getPosition().y) {
            // Mettre à jour l'usine de moteur
            UsineMoteur.getInstance().update();
        }
    }
}