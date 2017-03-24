package me.willjake.hamlet.level;

import me.willjake.hamlet.game.Tile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/21/17.
 */
public class LevelParser {
	
	private Element levelElement;
	
	public LevelParser(String filename) {
		this.setup(filename);
	}
	
	public int getWidth() {
		return Integer.parseInt(this.levelElement.getAttribute("width"));
	}
	
	public int getHeight() {
		return Integer.parseInt(this.levelElement.getAttribute("height"));
	}
	
	public ArrayList<Tile> getTiles() {
		Element tileMapElement = (Element) this.levelElement.getElementsByTagName("tile_map").item(0);
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		NodeList tileNodes = tileMapElement.getElementsByTagName("tile");
		for (int i = 0; i < tileNodes.getLength(); i++) {
			int x = Integer.parseInt(((Element) tileNodes.item(i)).getAttribute("x"));
			int y = Integer.parseInt(((Element) tileNodes.item(i)).getAttribute("y"));
			int spritesheetNumber = Integer.parseInt(tileNodes.item(i).getTextContent());
			
			tiles.add(new Tile(x, y, spritesheetNumber));
		}
		
		return tiles;
	}
	
	private void setup(String filename) {
		File file = new File("resources/levels/" + filename);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			
			this.levelElement = (Element) document.getElementsByTagName("level").item(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
