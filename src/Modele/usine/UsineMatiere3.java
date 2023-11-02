package modele.usine;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import composants.Metal;
import observerPattern.Observer;

public class UsineMatiere3 implements Observer {
    private static boolean startProduction;
    private static UsineMatiere3 instance;
    public static int usineMatiereCompteur = 0;
    public static final int usineMatiereInterval = 500;
    private ArrayList<Metal> metals = new ArrayList<>();
    Point position;
    


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
        this.startProduction = true;
        this.position = new Point (544,576);
    }

    public static void produiceMetal(){
        if (startProduction == true){
            instance.metals.add (new Metal (new Point(544,576)));
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

        public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void update() {
       this.startProduction = false;
    }

}