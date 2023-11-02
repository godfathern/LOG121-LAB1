/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: Subject.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/  
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