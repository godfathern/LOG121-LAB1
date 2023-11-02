package strategyPattern;

import modele.usine.Entrepot;

public class VenteIntervalle implements StrategyVente{

    int nombreAvionVendu = 2;
    @Override
    public void execute() {
       int nombreAvion = Entrepot.getInstance().getNombreAvion();
      if (nombreAvion>=2){
        Entrepot.getInstance().setNombreAvion(nombreAvion-this.nombreAvionVendu);
      }
    }
    
}
