package composants;

import java.awt.Point;

import javax.swing.ImageIcon;

import modele.usine.Usine;
import observerPattern.Observer;
import observerPattern.Subject;

public class Metal extends Subject implements Composant {
    private Point position;
    private Point vitesse = new Point (1,1);
    ImageIcon composant;


    public Metal(Point position, String path) {
    this.position = position;
    this.composant = new ImageIcon(this.getClass().getResource(path));
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
    public ImageIcon getComposant() {
        return this.composant;
    }
    
    
    public void checkPosition(Usine usine){
       if (this.getPosition().equals(usine.getPosition())){
        this.notifyObservers();
       }
    }


}