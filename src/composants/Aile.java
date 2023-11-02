/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: Aile.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/
package composants;

import java.awt.Point;

import javax.swing.ImageIcon;

import modele.usine.UsineAile1;
import modele.usine.UsineAssemblage;
import modele.usine.UsineMoteur;
import observerPattern.Subject;

// Déclaration de la classe Aile implémentant l'interface Composant et étendant Subject
public class Aile extends Subject implements Composant {
  private Point position;
  private ImageIcon image;

  // Constructeur de la classe prenant en paramètre la position initiale de l'aile
  public Aile(Point position) {
    this.position = position;
    this.image = new ImageIcon(this.getClass().getResource("/ressources/aile.png"));

  }

  // Méthode pour définir la position de l'aile
  public void setPosition(Point position) {
    this.position = position;
  }

  // Méthode pour obtenir la position actuelle de l'aile
  public Point getPosition() {
    return this.position;
  }

  // Méthode pour obtenir l'image représentant l'aile
  public ImageIcon getImage() {
    return this.image;
  }

  // Méthode pour vérifier si l'aile est à la même position que l'usine
  // d'assemblage
  public void checkPosition(UsineAssemblage usine) {
    // Si la position de l'aile correspond à la position de l'usine d'assemblage
    if (this.getPosition().x == usine.getPosition().x && this.getPosition().y == usine.getPosition().y) {
      // Mettre à jour l'assemblage dans l'usine d'assemblage
      UsineAssemblage.getInstance().updateA();
    }
  }

}