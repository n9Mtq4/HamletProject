package me.willjake.hamlet.cutscene;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class CutsceneParser {

    private static final String XML_FOLDER = "assets/cutscenes";

    private Document document;

    public CutsceneParser(String sceneName) {
        this.setupParsing(sceneName);
    }

    public ArrayList<Frame> getFrames() {
        NodeList rawFrames = this.document.getElementsByTagName("frame");

        ArrayList<Frame> frames = new ArrayList<Frame>();
        for (int i = 0; i < rawFrames.getLength(); i++) {
            frames.add(new Frame(rawFrames.item(i)));
        }

        return new ArrayList<Frame>();
    }

    private void setupParsing(String sceneName) {
        File file = new File(this.getPathToXML(sceneName));

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            this.document = documentBuilder.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPathToXML(String sceneName) {
        return ClassLoader.getSystemClassLoader().getResource(XML_FOLDER + "/" + sceneName + ".xml").getFile();
    }
}
