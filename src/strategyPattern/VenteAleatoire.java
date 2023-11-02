package strategyPattern;

import java.util.concurrent.ThreadLocalRandom;

import modele.usine.Entrepot;

public class VenteAleatoire implements StrategyVente {

    @Override
    public void execute() {
        int nombreAvion = Entrepot.getInstance().getNombreAvion();
       int nombreAvionVendu = ThreadLocalRandom.current().nextInt(0, nombreAvion+1);
       Entrepot.getInstance().setNombreAvion(nombreAvion-nombreAvionVendu);
    }

    
}
