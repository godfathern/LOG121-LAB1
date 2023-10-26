package observerPattern;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Subject {
    /**
     *
     */
    private List <Observer> observers = new ArrayList<>();

    public void addObserver (Observer observer){
        this.observers.add (observer);
    }

      public void removeObersver (Observer observer){
        this.observers.remove (observer);
    }
    
        public void notifyObservers (){
            for (Observer observer : this.observers){
                observer.update();
            }
        }









}