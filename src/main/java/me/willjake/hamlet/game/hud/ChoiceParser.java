package me.willjake.hamlet.game.hud;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/26/17.
 */
public class ChoiceParser {

    private static final String XML_FOLDER = "/assets/choices";

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
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(this.getPathToXML(choiceName));
            this.element = (Element) document.getElementsByTagName("choice").item(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InputStream getPathToXML(String sceneName) {
        return getClass().getResourceAsStream(XML_FOLDER + "/" + sceneName + ".xml");
    }
}
