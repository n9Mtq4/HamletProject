package me.willjake.hamlet.game.hud;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/26/17.
 */
public class ChoiceParser {

    private static final String XML_FOLDER = "assets/choices";

    private Element element;

    public ChoiceParser(String choiceName) {
        this.setupParser(choiceName);
    }

    public String getChoicePrompt() {
        return this.element.getFirstChild().getTextContent();
    }

    public ArrayList<ChoiceOption> getOptions() {
        NodeList rawOptions = this.element.getElementsByTagName("option");

        ArrayList<ChoiceOption> options = new ArrayList<ChoiceOption>();
        for (int i = 0; i < rawOptions.getLength(); i++) {
            options.add(new ChoiceOption((Element) rawOptions.item(i)));
        }

        return options;
    }

    private void setupParser(String choiceName) {
        File file = new File(this.getPathToXML(choiceName));

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            this.element = (Element) document.getElementsByTagName("choice").item(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPathToXML(String sceneName) {
        return ClassLoader.getSystemClassLoader().getResource(XML_FOLDER + "/" + sceneName + ".xml").getFile();
    }
}
