package modele.usine;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import composants.Metal;
import observerPattern.Observer;

public class UsineMatiere1 implements Observer {
    private static boolean startProduction;
    private static UsineMatiere1 instance;
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
        this.startProduction = true;
    }

    public static void produiceMetal(){
        if (startProduction == true){
            instance.metals.add (new Metal (new Point(32,32)));
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
       this.startProduction = false;
    }

}