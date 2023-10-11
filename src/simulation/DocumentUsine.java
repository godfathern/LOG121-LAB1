package simulation;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.awt.Point;



public class DocumentUsine {
    private Map<String, Point> usineCoordinates = new HashMap<>();


    public void parseXML(String filePath) {
        try {
            // Load and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
    
            // Get the root element
            Element root = document.getDocumentElement();
    
            // NodeList for <usine> 
            NodeList usineNodes = root.getElementsByTagName("usine");
    
            // Iterate through <usine> nodes
            for (int i = 0; i < usineNodes.getLength(); i++) {
                Node usineNode = usineNodes.item(i);
                if (usineNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element usineElement = (Element) usineNode;
                    
                    // Get attribute values
                    String type = usineElement.getAttribute("type");
                    String id = usineElement.getAttribute("id");
                    int x = Integer.parseInt(usineElement.getAttribute("x"));
                    int y = Integer.parseInt(usineElement.getAttribute("y"));
                    
                    //Store coordiante in map
                    Point coordinate = new Point (x,y);
                    // Print
                    System.out.println("Usine Type: " + type);
                    System.out.println("ID: " + id);
                    System.out.println("X: " + x);
                    System.out.println("Y: " + y);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getCoordiante(String filePath) {
        try {
            // Load and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
    
            // Get the root element
            Element root = document.getDocumentElement();
    
            // Get NodeList for <usine> elements under <metadonnees>
            NodeList usineNodes = root.getElementsByTagName("usine type");
    
            // Iterate through <usine> nodes
            for (int i = 0; i < usineNodes.getLength(); i++) {
                Node usineNode = usineNodes.item(i);
                if (usineNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element usineElement = (Element) usineNode;
                    
                    // Get attribute values
                    String type = usineElement.getAttribute("type");
                    String id = usineElement.getAttribute("id");
                    String x = usineElement.getAttribute("x");
                    String y = usineElement.getAttribute("y");
                    
                    // Print or process the attributes as needed
                    System.out.println("Usine Type: " + type);
                    System.out.println("ID: " + id);
                    System.out.println("X: " + x);
                    System.out.println("Y: " + y);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}
