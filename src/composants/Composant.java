package composants;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Composant {
    private Point position;
    private Point vitesse = new Point (1,1);
    ImageIcon composant;

    public Composant (Point position, String path){
        this.position = position;
        this.composant = new ImageIcon(this.getClass().getResource(path));
    }

    public void setPosition(Point position) {
        this.position = position;
    }


    public Point getPosition (){
        return this.position;
    }

    public ImageIcon getComposant(){
        return this.composant;
    }






}
