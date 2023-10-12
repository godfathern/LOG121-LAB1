package Modele.usine;

import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Point;
import java.util.ArrayList;

import simulation.matiere.Metal;

public class UsineAile extends Usine {
   
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
   

}


