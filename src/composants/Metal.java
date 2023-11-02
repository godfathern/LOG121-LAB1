package composants;

import java.awt.Point;

import javax.swing.ImageIcon;

import modele.usine.Usine;
import modele.usine.UsineAile;
import modele.usine.UsineAile1;
import modele.usine.UsineMoteur;
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
    
    
    public void checkPosition(UsineAile1 usine){
       if (this.getPosition().x == usine.getPosition().x && this.getPosition().y == usine.getPosition().y){
        UsineAile1.getInstance().update();
       }
    }

        public void checkPosition(UsineMoteur usine){
       if (this.getPosition().x == usine.getPosition().x && this.getPosition().y == usine.getPosition().y){
        UsineMoteur.getInstance().update();
       }
    }

}