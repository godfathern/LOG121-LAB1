package modele.usine;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.text.Position;

import composants.Metal;
import composants.Moteur;
import observerPattern.Observer;

public class UsineMoteur implements Observer {
    private static boolean startProduction;
    private static UsineMoteur instance;
    public static int usineMoteurCompteur = 0;
    public static final int usineMoteurInterval = 375;
    private ArrayList<Moteur> moteurs = new ArrayList<>();
    private static int nombreMetal;




    private Point position;
    
    


    int levelProduction;
    ImageIcon image;
    ImageIcon Vide = new ImageIcon(this.getClass().getResource("/ressources/UM0%.png"));
    ImageIcon UnTiers = new ImageIcon(this.getClass().getResource("/ressources/UM33%.png"));
    ImageIcon DeuxTiers = new ImageIcon(this.getClass().getResource("/ressources/UM66%.png"));
    ImageIcon Plein = new ImageIcon(this.getClass().getResource("/ressources/UM100%.png"));

    ArrayList<ImageIcon> images = new ArrayList<>();

    public static UsineMoteur getInstance() {
        if (instance == null) {
            instance = new UsineMoteur();
        }
        return instance; // Return the one and only instance
    }

    private UsineMoteur() {
        this.images.add(this.Vide);
        this.images.add(this.UnTiers);
        this.images.add(this.DeuxTiers);
        this.images.add(this.Plein);
        this.image = this.Vide;
        this.levelProduction = 0;
        this.startProduction = true;
        this.position = new Point (320,352);
        this.nombreMetal = 0;
    }

    public static void produiceMoteur(){
        if (nombreMetal >=4 && startProduction == true){
            instance.moteurs.add (new Moteur (new Point(320,352)));
        }
        }
    
        
    

    public ArrayList<Moteur> getMoteurs(){
        return this.moteurs;
    }

        public static int getNombreMetal() {
        return nombreMetal;
    }

    public static void setNombreMetal(int nombreMetal) {
        UsineMoteur.nombreMetal = nombreMetal;
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
       this.nombreMetal++;
    }

}