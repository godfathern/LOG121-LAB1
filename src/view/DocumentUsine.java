/******************************************************
Cours:   LOG121
Session: A2023
Groupe:  04
Projet: Laboratoire #1
Étudiant(e)s: Phan Tung, Bui
              
              
Professeur : Bilal Alchalabi
Nom du fichier: DocumentUsine.java
Date créé: 2023-10-01
Date dern. modif. 2023-10-01
*******************************************************
Historique des modifications
*******************************************************
2023-10-01 Version initiale (et1)
2023-10-26 Ajout de la fonction (et2)
*******************************************************/
package view;

import javax.xml.parsers.DocumentBuilderFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import modele.usine.Icone;
import modele.usine.Usine;

import org.w3c.dom.Node;
import java.awt.Point;

public class DocumentUsine {
    private Map<String, Point> usineCoordinates = new HashMap<>();
    private Map<String, Usine> usines;
    private Map<String, Usine> usineInfoMap;

    public DocumentUsine() {
        this.parseSimulation("src/ressources/configuration.xml");
        this.parseMetadonne("src/ressources/configuration.xml");
    }

    public Usine getUsineByIdAndIconType(String id, String iconType) {
        // Retrieve UsineInfo based on id and iconType
        String key = id + "-" + iconType;
        return this.usineInfoMap.get(key);
    }

    private void parseXML1(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            Element root = document.getDocumentElement();
            NodeList usineNodes = root.getElementsByTagName("usine");

            for (int i = 0; i < usineNodes.getLength(); i++) {
                Element usineElement = (Element) usineNodes.item(i);
                String type = usineElement.getAttribute("type");
                String id = usineElement.getAttribute("id");
                int x = Integer.parseInt(usineElement.getAttribute("x"));
                int y = Integer.parseInt(usineElement.getAttribute("y"));

                // Get icon information
                NodeList iconeNodes = usineElement.getElementsByTagName("icone");
                for (int j = 0; j < iconeNodes.getLength(); j++) {
                    Element iconeElement = (Element) iconeNodes.item(j);
                    String iconType = iconeElement.getAttribute("type");
                    String path = iconeElement.getAttribute("path");

                    // Usine usine = new Usine(type, iconType, path, id, x, y);
                    // this.usines.add(usine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseSimulation(String filePath) {
        try {
            // Load and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            // Get the root element
            Element root = document.getDocumentElement();

            // Find the <simulation> element
            NodeList simulationNodes = root.getElementsByTagName("simulation");
            if (simulationNodes.getLength() > 0) {
                Element simulationElement = (Element) simulationNodes.item(0);

                // Get NodeList for <usine> elements under <simulation>
                NodeList usineNodes = simulationElement.getElementsByTagName("usine");

                // Iterate through <usine> nodes
                for (int i = 0; i < usineNodes.getLength(); i++) {
                    Node usineNode = usineNodes.item(i);
                    if (usineNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element usineElement = (Element) usineNode;

                        // Get attributes of the <usine> element under <simulation>
                        String type = usineElement.getAttribute("type");
                        String id = usineElement.getAttribute("id");
                        int x = Integer.parseInt(usineElement.getAttribute("x"));
                        int y = Integer.parseInt(usineElement.getAttribute("y"));

                        // Store coordiantes in map
                        Point coordinates = new Point(x, y);
                        this.usineCoordinates.put(id, coordinates);
                        System.out.println("id: " + id + ", Type: " + coordinates);

                    }
                }
            } else {
                System.out.println("<simulation> element not found in the XML.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get coordiantes based on ID
    public Point getCoordinatesForUsineID(String usineID) {
        return this.usineCoordinates.get(usineID);
    }

    private void parseMetadonne(String filePath) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            NodeList usineNodes = document.getElementsByTagName("usine");

            for (int i = 0; i < usineNodes.getLength(); i++) {
                Element usineElement = (Element) usineNodes.item(i);
                String type = usineElement.getAttribute("type");

                Element iconeElement = (Element) usineElement.getElementsByTagName("icone").item(0);
                String iconeType = iconeElement.getAttribute("type");
                String iconePath = iconeElement.getAttribute("path");

                Icone icone = new Icone(iconeType, iconePath);
                System.out.println(type + "-" + iconeType + "-" + iconePath);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
