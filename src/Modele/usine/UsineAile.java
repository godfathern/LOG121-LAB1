package modele.usine;

import java.util.List;

import javax.swing.ImageIcon;

import composants.Metal;
import observerPattern.Observer;

import java.awt.Point;
import java.util.ArrayList;

public class UsineAile extends Usine implements Observer {

    private List<Metal> metals = new ArrayList<>();
    private ImageIcon image;
    private int nombreMetal;
    private int nombreAile;
    private Point position;
    private Point positionAile;
    private int levelProduction; // % temps nécessaire à la production a été écoulé

    public UsineAile(String type, String id, String x2, String y2) {
        super(type, id, x2, y2);
        this.levelProduction = 0;
        this.image = new ImageIcon(this.getClass().getResource("/ressources/UT0%.png"));
        this.nombreMetal = 0;
        this.position = new Point(320, 32);
    }

    public void updateImage() {
        if (this.nombreMetal == 2) {
            switch (this.levelProduction) {
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
                    this.levelProduction = -1;
            }
            

        }
        this.levelProduction++;

    }

    public ImageIcon getImage() {
        return this.image;
    }

    public void produceAile() {
        if (this.nombreMetal == 2) {
            this.positionAile = this.position;
            this.nombreMetal = 0;
        }
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

    @Override
    public void update() {
        this.nombreMetal++;
        System.out.println("Number of metal : " + this.nombreMetal);
    }

}
