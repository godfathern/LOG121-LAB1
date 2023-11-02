package modele.usine;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.text.Position;

import composants.Aile;
import composants.Metal;
import observerPattern.Observer;
import view.Environnement;

import java.awt.Point;
import java.util.ArrayList;

public class UsineAile1 {

    private List<Metal> metals = new ArrayList<>();
    public ArrayList<Aile> ailes = new ArrayList<>();
    private ImageIcon image;
    private int nombreMetal;
    private int nombreAile;
    private Point position;
    private static UsineAile1 instance = new UsineAile1();
    public static final int usineAileInterval = 250;
    public static int usineAileCompteur;

    private int levelProduction; // % temps nécessaire à la production a été écoulé

    private UsineAile1() {
        this.levelProduction = 0;
        this.image = new ImageIcon(this.getClass().getResource("/ressources/UT0%.png"));
        this.nombreMetal = 0;
        this.position = new Point(320, 32);
    }

    public static  UsineAile1 getInstance() {
        return instance; // Return the one and only instance
    }

    public void updateImage(int level) {
            switch (level) {
                case 0:
                    this.image = new ImageIcon(this.getClass().getResource("/ressources/UT0%.png"));
                    break;
                case 1:
                    this.image = new ImageIcon(this.getClass().getResource("/ressources/UT33%.png"));
                    break;
                case 2:
                    this.image = new ImageIcon(this.getClass().getResource("/ressources/UT66%.png"));
                    break;
                case 3:
                    this.image = new ImageIcon(this.getClass().getResource("/ressources/UT100%.png"));
                    break;
            }
        }

    

    public ImageIcon getImage() {
        return this.image;
    }

    public void produceAile() {
        if (this.nombreMetal >= 2) {
            this.ailes.add(new Aile(new Point(320,32)));
            this.setNombreMetal(this.nombreMetal-2);
        }
    }

    public ArrayList <Aile> getAiles(){
        return this.ailes;
    }


    public boolean comparePosition() {

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

    public void update() {
        this.nombreMetal++;
    }


}
