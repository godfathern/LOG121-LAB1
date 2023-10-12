package modele.usine;

import java.util.List;

import javax.swing.ImageIcon;

import observerPattern.Observer;
import view.matiere.Metal;

import java.awt.Point;
import java.util.ArrayList;

public class UsineAile extends Usine implements Observer {
   
    private List <Metal> metals = new ArrayList <>();
    private ImageIcon image;
    private int nombreMetal;
    private int nombreAile;
    private Point position;
    private int levelProduction; //% temps nécessaire à la production a été écoulé
    

  public UsineAile(String type, String id, String x2, String y2) {
        super(type, id, x2, y2);
        //TODO Auto-generated constructor stub
    }

    public void updateImage(){
         if (this.levelProduction == 0){
            this.image = new ImageIcon(this.getClass().getResource("/ressources/UT0%.png"));//violet;
        }else {
        this.levelProduction ++;
        if (this.levelProduction == 1){
            this.image = new ImageIcon(this.getClass().getResource("/ressources/UT33%.png"));//violet;
        }

        if (this.levelProduction == 2){
            this.image = new ImageIcon(this.getClass().getResource("/ressources/UT66%.png"));//violet;
        }
        
        if (this.levelProduction == 3){
            this.levelProduction = 0;
            this.image = new ImageIcon(this.getClass().getResource("/ressources/UT100%.png"));//violet;
        }
        }
    }



    public ImageIcon getImage(){
        return this.image;
    }


    public void produceAile(){
        if (this.nombreMetal == 2){
            this.nombreAile ++;
        }
    }


    public boolean comparePosition(){

        
        return false;
    }

    public List<Metal> getMetals() {
        return this.metals;
    }

    public void setMetals(List<Metal> metals) {
        this.metals = metals;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public int getNombreMetal() {
        return this.nombreMetal;
    }

    public void setNombreMetal(int nombreMetal) {
        this.nombreMetal = nombreMetal;
    }

    public int getNombreAile() {
        return this.nombreAile;
    }

    public void setNombreAile(int nombreAile) {
        this.nombreAile = nombreAile;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getLevelProduction() {
        return this.levelProduction;
    }

    public void setLevelProduction(int levelProduction) {
        this.levelProduction = levelProduction;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
   

}


