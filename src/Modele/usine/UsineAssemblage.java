/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: UsineAssemblage.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/  
package modele.usine;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.text.Position;

import composants.Aile;
import composants.Avion;
import composants.Metal;
import observerPattern.Observer;
import view.Environnement;

import java.awt.Point;
import java.util.ArrayList;

public class UsineAssemblage implements Observer {

    private List<Metal> metals = new ArrayList<>();
    public ArrayList<Avion> avions = new ArrayList<>();
    private ImageIcon image;
    private int nombreMoteur;
    private int nombreAile;
    private Point position;
    private static UsineAssemblage instance = new UsineAssemblage();
    public static final int usineAssemblageInterval = 550;
    public static int usineAssemblageCompteur = 0;
    private boolean startProduction;

    private int levelProduction; // % temps nécessaire à la production a été écoulé

    private UsineAssemblage() {
        this.levelProduction = 0;
        this.image = new ImageIcon(this.getClass().getResource("/ressources/UA0%.png"));
        this.nombreMoteur = 0;
        this.nombreAile = 0;
        this.position = new Point(160, 192);
        this.startProduction = true;
    }

    public static  UsineAssemblage getInstance() {
        return instance; // Return the one and only instance
    }

    public void updateImage(int level) {
            switch (level) {
                case 0:
                    this.image = new ImageIcon(this.getClass().getResource("/ressources/UA0%.png"));
                    break;
                case 1:
                    this.image = new ImageIcon(this.getClass().getResource("/ressources/UA33%.png"));
                    break;
                case 2:
                    this.image = new ImageIcon(this.getClass().getResource("/ressources/UA66%.png"));
                    break;
                case 3:
                    this.image = new ImageIcon(this.getClass().getResource("/ressources/UA100%.png"));
                    break;
            }
        }

    

    public ImageIcon getImage() {
        return this.image;
    }

    public void produceAvion() {
        if (this.nombreMoteur >= 4 && this.nombreAile >=2 && this.startProduction) {
            this.avions.add(new Avion(new Point(160,192)));
            this.setNombreMoteur(this.nombreMoteur-4);
            this.setNombreAile(this.nombreAile-2);
            System.out.println("AAAAAAAAAAAAAA"+this.nombreAile);
            System.out.println("AAAAAAAAAAAAAA"+this.nombreAile);
            System.out.println("BBBBBBBBBBBBB" +this.nombreMoteur);
        }
    }

    public ArrayList <Avion> getAvions(){
        return this.avions;
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

    public int getNombreAile() {
        return this.nombreAile;
    }

    public void setNombreAile(int nombreAile) {
        this.nombreAile = nombreAile;
    }

    public int getNombreMoteur() {
        return this.nombreMoteur;
    }

    public void setNombreMoteur(int nombreMoteur) {
        this.nombreMoteur = nombreMoteur;
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

    public void updateA() {
        this.nombreAile++;
    }

        public void updateMoteur() {
        this.nombreMoteur++;
    }

        @Override
        public void update() {
            if (Entrepot.getInstance().isEntrepotFull()){
                this.startProduction = false;
            }
               if (!Entrepot.getInstance().isEntrepotFull()){
                this.startProduction = true;
            }
        }

}
