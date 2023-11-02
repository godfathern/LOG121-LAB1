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



    private Entrepot() {
        this.images.add(this.Vide);
        this.images.add(this.UnTiers);
        this.images.add(this.DeuxTiers);
        this.images.add(this.Plein);
        this.nombreAvion = 0;
        this.image = new ImageIcon(this.getClass().getResource("/ressources/E0%.png"));
        this.position = new Point(160, 192);
    }

        public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public static  Entrepot getInstance() {
        return instance; 
    }
        public ImageIcon getImage() {
        return this.image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
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
    
}
