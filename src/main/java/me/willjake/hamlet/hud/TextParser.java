package me.willjake.hamlet.hud;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;

/**
 * Created by jakekinsella on 3/26/17.
 */
public class TextParser {

    private static final String XML_FOLDER = "/assets/text";

    private Element element;

    public TextParser(String textName) {
        this.setupParser(textName);
    }

    public String getSpeaker() {
        return element.getElementsByTagName("speaker").item(0).getTextContent();
    }

    public String getText() {
        return element.getElementsByTagName("text").item(0).getTextContent();
    }

    private void setupParser(String textName) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(this.getPathToXML(textName));
            this.element = (Element) document.getElementsByTagName("textbox").item(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InputStream getPathToXML(String sceneName) {
        return getClass().getResourceAsStream(XML_FOLDER + "/" + sceneName + ".xml");
    }
}
