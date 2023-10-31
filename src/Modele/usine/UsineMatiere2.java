package modele.usine;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import observerPattern.Observer;

public class UsineMatiere2 implements Observer {
    private static UsineMatiere2 instance;
    public static int usineMatiere2Compteur = 0;
    public static final int usineMatiere2Interval = 50;
    
    
    int levelProduction;
    ImageIcon image;
    ImageIcon Vide = new ImageIcon(this.getClass().getResource("/ressources/UMP0%.png"));
    ImageIcon UnTiers = new ImageIcon(this.getClass().getResource("/ressources/UMP33%.png"));
    ImageIcon DeuxTiers = new ImageIcon(this.getClass().getResource("/ressources/UMP66%.png"));
    ImageIcon Plein = new ImageIcon(this.getClass().getResource("/ressources/UMP100%.png"));

    ArrayList<ImageIcon> images = new ArrayList<>();

    public static UsineMatiere2 getInstance() {
        if (instance == null) {
            instance = new UsineMatiere2();
        }
        return instance; // Return the one and only instance
    }

    private UsineMatiere2() {
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