package me.willjake.hamlet.cutscene;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class CutsceneParser {
	
	private static final String XML_FOLDER = "/assets/cutscenes";
	
	private Element element;
	
	public CutsceneParser(String sceneName) {
		this.setupParsing(sceneName);
	}
	
	public ArrayList<Frame> getFrames() {
		NodeList rawFrames = this.element.getElementsByTagName("frame");

		ArrayList<Frame> frames = new ArrayList<Frame>();
		for (int i = 0; i < rawFrames.getLength(); i++) {
			frames.add(new Frame(rawFrames.item(i)));
		}
		
		return frames;
	}
	
	private void setupParsing(String sceneName) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(this.getPathToXML(sceneName));
			this.element = (Element) document.getElementsByTagName("scene").item(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private InputStream getPathToXML(String sceneName) {
	    return getClass().getResourceAsStream(XML_FOLDER + "/" + sceneName + ".xml");
	}
}
