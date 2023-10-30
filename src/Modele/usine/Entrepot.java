package modele.usine;

import observerPattern.Subject;
import strategyPattern.StrategyVente;

public class Entrepot extends Subject implements StrategyVente {
    private static Entrepot instance;
    public static boolean isFull;
    private Entrepot (){};
    public Entrepot getInstance(){
        if (instance == null) {
            instance = new Entrepot();
        }
        return instance;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
