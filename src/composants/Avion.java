package composants;

import java.awt.Point;

import javax.swing.ImageIcon;

import modele.usine.Entrepot;
import modele.usine.Usine;
import modele.usine.UsineAile;
import modele.usine.UsineAile1;
import observerPattern.Observer;
import observerPattern.Subject;

public class Avion extends Subject implements Composant {
    private Point position;
    private Point vitesse = new Point (1,1);
    ImageIcon image;


    public Avion(Point position) {
    this.position = position;
    this.image = new ImageIcon(this.getClass().getResource("/ressources/avion.png"));
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
    
    
    public void checkPosition(Entrepot entrepot){
       if (this.getPosition().x == entrepot.getPosition().x && this.getPosition().y == entrepot.getPosition().y){
        entrepot.getInstance().update();
       }
    }


}