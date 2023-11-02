package modele.usine;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import composants.Metal;
import observerPattern.Observer;

public class UsineMatiere2 implements Observer {
    private static boolean startProduction;
    private static UsineMatiere2 instance;
    public static int usineMatiereCompteur = 0;
    public static final int usineMatiereInterval = 500;
    private ArrayList<Metal> metals = new ArrayList<>();
    
    
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
        this.startProduction = true;
    }

    public static void produiceMetal(){
        if (startProduction == true){
            instance.metals.add (new Metal (new Point(96,352)));
        }
        

    }

    public ArrayList<Metal> getMetals(){
        return this.metals;
    }


    public ImageIcon getImage(){
        return this.image;
    }



    public void updateImage(int level) {
        if (startProduction == true){
            this.image = this.images.get(level);
        }
    }

    @Override
    public void update() {
       //this.startProduction = false;
    }

}