package main.java.data;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import main.java.business.Settings;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.File;
import java.io.IOException;

public class SettingsReader {

    private File file;

    public void read() {
        try {
            File file = new File("src/main/java/data/sets.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("settings");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    Settings.setInterval(Integer.parseInt(eElement.getElementsByTagName("amount").item(0).getTextContent()));
                    Settings.setAmount(Integer.parseInt(eElement.getElementsByTagName("interval").item(0).getTextContent()));
                    System.out.println("Interval: " + eElement.getElementsByTagName("amount").item(0).getTextContent());
                    System.out.println("Interval: " + eElement.getElementsByTagName("interval").item(0).getTextContent());

                }
            }


        } catch (Exception e) {
            System.out.println("wrong");
            e.printStackTrace();
        }
    }


}
