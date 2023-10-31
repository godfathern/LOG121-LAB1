// package modele.usine;

// import java.util.ArrayList;

// import javax.swing.ImageIcon;

// import observerPattern.Observer;

// public class UsineMatiere extends Usine implements Observer {
//     int levelProduction;
//     ImageIcon image;
//     ImageIcon Vide = new ImageIcon(this.getClass().getResource("/ressources/UMP0%.png"));
//     ImageIcon UnTiers = new ImageIcon(this.getClass().getResource("/ressources/UMP33%.png"));
//     ImageIcon DeuxTiers = new ImageIcon(this.getClass().getResource("/ressources/UMP66%.png"));
//     ImageIcon Plein = new ImageIcon(this.getClass().getResource("/ressources/UMP100%.png"));

//     ArrayList<ImageIcon> imageIconsList = new ArrayList<>();

//     public UsineMatiere(String type, String id, String x2, String y2) {
//         super(type, id, x2, y2);
//         this.imageIconsList.add(this.Vide);
//         this.imageIconsList.add(this.UnTiers);
//         this.imageIconsList.add(this.DeuxTiers);
//         this.imageIconsList.add(this.Plein);
//         this.image = this.image = this.imageIconsList.get(this.levelProduction);
//         this.levelProduction = 0;
//     }

//     public ImageIcon getImage(){
//         return this.image;
//     }


//     public void updateImage() {
//         this.image = this.imageIconsList.get(this.levelProduction);
//         this.levelProduction++;
//         if (this.levelProduction > 3){
//             this.levelProduction = 0;
//         }
        
//     }

//     @Override
//     public void update() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'update'");
//     }

// }



package modele.usine;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import composants.Metal;
import observerPattern.Observer;

public class UsineMatiere1 implements Observer {
    private static UsineMatiere1 instance;
    public static int usineMatiere2Compteur = 0;
    public static final int usineMatiereInterval = 50;
    private ArrayList<Metal> metals = new ArrayList<>();
    
    
    int levelProduction;
    ImageIcon image;
    ImageIcon Vide = new ImageIcon(this.getClass().getResource("/ressources/UMP0%.png"));
    ImageIcon UnTiers = new ImageIcon(this.getClass().getResource("/ressources/UMP33%.png"));
    ImageIcon DeuxTiers = new ImageIcon(this.getClass().getResource("/ressources/UMP66%.png"));
    ImageIcon Plein = new ImageIcon(this.getClass().getResource("/ressources/UMP100%.png"));

    ArrayList<ImageIcon> images = new ArrayList<>();

    public static UsineMatiere1 getInstance() {
        if (instance == null) {
            instance = new UsineMatiere1();
        }
        return instance; // Return the one and only instance
    }

    private UsineMatiere1() {
        this.images.add(this.Vide);
        this.images.add(this.UnTiers);
        this.images.add(this.DeuxTiers);
        this.images.add(this.Plein);
        this.image = this.Vide;
        this.levelProduction = 0;
        this.metals.add(new Metal(new Point (32,32)));
    }

    public static void produiceMetal(){
        instance.metals.add (new Metal (new Point(32,32)));

    }

    public ArrayList<Metal> getMetals(){
        return this.metals;
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