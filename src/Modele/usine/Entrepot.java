/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: Entrepot.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/  
package modele.usine;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import observerPattern.Observer;
import observerPattern.Subject;
import strategyPattern.StrategyVente;

public class Entrepot extends Subject implements StrategyVente, Observer {
    ImageIcon Vide = new ImageIcon(this.getClass().getResource("/ressources/E0%.png"));
    ImageIcon UnTiers = new ImageIcon(this.getClass().getResource("/ressources/E33%.png"));
    ImageIcon DeuxTiers = new ImageIcon(this.getClass().getResource("/ressources/E66%.png"));
    ImageIcon Plein = new ImageIcon(this.getClass().getResource("/ressources/E100%.png"));
    ArrayList<ImageIcon> images = new ArrayList<>();
    private Point position;
    private ImageIcon image;
    private static Entrepot instance = new Entrepot();
    public static final int usineAssemblageInterval = 550;
    public static int usineAssemblageCompteur = 0;
    private int nombreAvion;
    StrategyVente strategyVente;
    private boolean entrepotFull;
    public static int speedProduction;



    private Entrepot() {
        this.images.add(this.Vide);
        this.images.add(this.UnTiers);
        this.images.add(this.DeuxTiers);
        this.images.add(this.Plein);
        this.nombreAvion = 0;
        this.entrepotFull = false;
        this.image = new ImageIcon(this.getClass().getResource("/ressources/E0%.png"));
        this.position = new Point(160, 192);
        this.speedProduction = 1;
        this.addObserver(UsineMatiere1.getInstance());
        this.addObserver(UsineMatiere2.getInstance());
        this.addObserver(UsineMatiere3.getInstance());
        this.addObserver(UsineAssemblage.getInstance());
    }

    public void setStrategyVente(StrategyVente strategyVente) {
        this.strategyVente = strategyVente;
    }

        public StrategyVente getStrategyVente() {
        return this.strategyVente;
    }

    public void stopProduction(){
     if (this.nombreAvion == 5){
            this.entrepotFull = true;
        } 
        else 
        this.entrepotFull = false;
    }
        public boolean isEntrepotFull() {
        return this.entrepotFull;
    }


    public void changeProductivity(){
        if (this.nombreAvion >=3){
            speedProduction = 2;
        }
        else {
            speedProduction = 1;
        }
    }


    public void vendAvion() {
        if (this.strategyVente != null){
            this.strategyVente.execute();
        }
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public static Entrepot getInstance() {
        return instance;
    }

    public ImageIcon getImage() {
        return this.image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void updateImage(){
        switch (this.nombreAvion) {
            case 1 : 
                this.setImage(this.images.get(this.nombreAvion));
                break;
            
             case 2 : 
                this.setImage(this.images.get(this.nombreAvion-1));
                break;           
            case 3 : 
                this.setImage(this.images.get(this.nombreAvion-1));
                break;
            case 4 : 
                this.setImage(this.images.get(this.nombreAvion-2));
                break;
            case 5 : 
                this.setImage(this.images.get(this.nombreAvion-2));
                break;
            default:
                 this.setImage(this.images.get(0));
                break;
        } 
    }

    public int getNombreAvion() {
        return this.nombreAvion;
    }

    public void setNombreAvion(int nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public void update() {
        this.nombreAvion++;
    }

    public void notifier(){
            this.notifyObservers();
    }

}
