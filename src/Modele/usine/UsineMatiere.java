package modele.usine;

import observerPattern.Observer;

public class UsineMatiere extends Usine implements Observer {

    public UsineMatiere(String type, String id, String x2, String y2) {
        super(type, id, x2, y2);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

  
    
}
