package me.willjake.hamlet.cutscene;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
		
		return new ArrayList<Frame>();
	}
	
	private void setupParsing(String sceneName) {
		File file = new File(this.getPathToXML(sceneName));
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			this.element = (Element) document.getElementsByTagName("scene").item(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getPathToXML(String sceneName) {
		return ClassLoader.getSystemClassLoader().getResource(XML_FOLDER + "/" + sceneName + ".xml").getFile();
	}
}
