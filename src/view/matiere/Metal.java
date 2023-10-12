package view.matiere;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Metal {
    private Point position;
    private Point vitesse = new Point (1,1);
    ImageIcon metal;

    public Metal (Point position){
        this.position = position;
        this.metal = new ImageIcon(this.getClass().getResource("/ressources/metal.png"));
    }

    public void setPosition(Point position) {
        this.position = position;
    }


    public Point getPosition (){
        return this.position;
    }

    public ImageIcon getMetal(){
        return this.metal;
    }






}
