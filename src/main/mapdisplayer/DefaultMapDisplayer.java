package main.mapdisplayer;

import java.util.List;

import helper.TextHelper;
import model.Entity;
import model.TreasureMap;

public class DefaultMapDisplayer implements IMapDisplayer {

	@Override
	public String displayMap(TreasureMap map) {
		
		int width = map.getWidth();
		int height = map.getHeight();
		List<Entity> entities = map.getEntities();
		Entity curEntity;
		String mapAsString = "";
		
		// TODO Improve algorithm. Display adventurer on top of a treasure.
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
				for (int k = 0; k < entities.size(); k++) {
					curEntity = entities.get(k);
					if (curEntity.getPositionX() == j && curEntity.getPositionY() == i) {
						mapAsString += curEntity.defaultRepresentation();
						break;
					}
					else if (k == entities.size() - 1) {
						mapAsString += ".\t";
					}
				}	
			}
			mapAsString += "\n";
		}
		TextHelper.displayText(mapAsString);
		return mapAsString;
	}
}
