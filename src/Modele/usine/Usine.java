package modele.usine;

import java.awt.Point;

import composants.Metal;

public class Usine {
    private String type;
    private Icone icone;
    private String path;
    private String id;
    private String x;
    private String y;
    private Point position;

    /**
     * @param type
     * @param id
     * @param x2
     * @param y2
     */
    public Usine(String type, String id, String x2, String y2) {
        this.type = type;
        this.id = id;
        this.x = x2;
        this.y = y2;
        
    }

    public Usine(String type, Icone icone) {
        this.type = type;
        this.icone = icone;
    }


    public String getPath() {
        return this.path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getX() {
        return this.x;
    }

    public void setX(String x) {
        this.x = x;
    }

    

    public String getY() {
        return this.y;
    }

    public void setY(String y) {
        this.y = y;
    }


    public Point getPosition(){
        return this.position;
    }
    
}
