package main.mapdisplayer;

import model.Entity;
import model.TreasureMap;

public class TextualMapDisplayer implements IMapDisplayer {

	public String displayMap(TreasureMap map) {
		String mapAsString = "";
		mapAsString += String.format("%s\n", map.textualRepresentation());
		
		for (Entity entity : map.getEntities()) 
			mapAsString += String.format("%s\n", entity.textualRepresentation());

		System.out.println(mapAsString);
		return mapAsString;
	}
}
