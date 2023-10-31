package modele.usine;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import observerPattern.Observer;

public class UsineMatiere3 implements Observer {
    private static UsineMatiere3 instance;
    public static int usineMatiere3Compteur = 0;
    public static final int usineMatiere2Interval = 100;
    
    
    int levelProduction;
    ImageIcon image;
    ImageIcon Vide = new ImageIcon(this.getClass().getResource("/ressources/UMP0%.png"));
    ImageIcon UnTiers = new ImageIcon(this.getClass().getResource("/ressources/UMP33%.png"));
    ImageIcon DeuxTiers = new ImageIcon(this.getClass().getResource("/ressources/UMP66%.png"));
    ImageIcon Plein = new ImageIcon(this.getClass().getResource("/ressources/UMP100%.png"));

    ArrayList<ImageIcon> images = new ArrayList<>();

    public static UsineMatiere3 getInstance() {
        if (instance == null) {
            instance = new UsineMatiere3();
        }
        return instance; // Return the one and only instance
    }

    private UsineMatiere3() {
        this.images.add(this.Vide);
        this.images.add(this.UnTiers);
        this.images.add(this.DeuxTiers);
        this.images.add(this.Plein);
        this.image = this.Vide;
        this.levelProduction = 0;
    }

    public ImageIcon getImage(){
        return this.image;
    }



    public void updateImage() {
        this.image = this.images.get(this.levelProduction);
        this.levelProduction++;
        if (this.levelProduction > 3){
            this.levelProduction = 0;
        }
        
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}