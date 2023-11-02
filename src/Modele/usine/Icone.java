/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: Icone.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/  
package modele.usine;
 public class Icone {
        private String type;
        private String path;
    
        public Icone(String type, String path) {
            this.type = type;
            this.path = path;
        }
    
        public String getType() {
            return this.type;
        }
    
        public String getPath() {
            return this.path;
        }
    }

