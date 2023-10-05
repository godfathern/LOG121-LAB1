package simulation.usine;

import simulation.matiere.Metal;

public interface Usine {
    public void setPosition();
    public void receiveComposant(Metal metal);
    public void sendProduct();
    public void startProduction();
    public void stopProduction();
}
