/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: Moteur.java
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

import modele.usine.Usine;
import modele.usine.UsineAile;
import modele.usine.UsineAile1;
import modele.usine.UsineAssemblage;
import modele.usine.UsineMoteur;
import observerPattern.Observer;
import observerPattern.Subject;

public class Moteur extends Subject implements Composant {
    private Point position;
    private Point vitesse = new Point (1,1);
    ImageIcon image;


    public Moteur(Point position) {
    this.position = position;
    this.image = new ImageIcon(this.getClass().getResource("/ressources/moteur.png"));
    }


    @Override
    public void setPosition(Point position) {
        this.position = position;
    }


    @Override
    public Point getPosition() {
       return this.position;
    }


    @Override
    public ImageIcon getImage() {
        return this.image;
    }
    
    
    public void checkPosition(UsineAssemblage usine){
       if (this.getPosition().x == 160 ){
        UsineAssemblage.getInstance().updateMoteur();
       }
    }


}