package composants;

import java.awt.Point;

import javax.swing.ImageIcon;

import modele.usine.UsineAile1;
import modele.usine.UsineAssemblage;
import modele.usine.UsineMoteur;
import observerPattern.Subject;

public class Aile extends Subject implements Composant {
    private Point position;
    private ImageIcon image;
    public Aile(Point position) {
        this.position = position;
        this.image = new ImageIcon(this.getClass().getResource("/ressources/aile.png"));
        
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
       if (this.getPosition().x == usine.getPosition().x && this.getPosition().y == usine.getPosition().y){
        UsineAssemblage.getInstance().update();
       }
    }





}