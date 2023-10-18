package modele.usine;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import observerPattern.Observer;

public class UsineMatiere extends Usine implements Observer {

    ImageIcon Vide =new ImageIcon(this.getClass().getResource("src/ressources/UMP0%.png"));
    ImageIcon UnTiers =new ImageIcon(this.getClass().getResource("src/ressources/UMP33%.png"));
    ImageIcon DeuxTiers =new ImageIcon(this.getClass().getResource("src/ressources/UMP66%.png"));
    ImageIcon Plein =new ImageIcon(this.getClass().getResource("src/ressources/UMP100%.png"));

    ArrayList<ImageIcon> imageIconsList = new ArrayList<>();


    public UsineMatiere(String type, String id, String x2, String y2) {
        super(type, id, x2, y2);
        this.imageIconsList.add(this.Vide);
        this.imageIconsList.add(this.UnTiers);
        this.imageIconsList.add(this.DeuxTiers);
        this.imageIconsList.add(this.Plein);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

  
    
}
