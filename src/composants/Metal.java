package composants;

import java.awt.Point;

import javax.swing.ImageIcon;

import modele.usine.Usine;
import modele.usine.UsineAile;
import observerPattern.Observer;
import observerPattern.Subject;

public class Metal extends Subject implements Composant {
    private Point position;
    private Point vitesse = new Point (1,1);
    ImageIcon image;


    public Metal(Point position) {
    this.position = position;
    this.image = new ImageIcon(this.getClass().getResource("/ressources/metal.png"));
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
    
    
    public void checkPosition(UsineAile usine){
       if (this.getPosition().equals(usine.getPosition())){
        this.notifyObservers();
       }
    }


}