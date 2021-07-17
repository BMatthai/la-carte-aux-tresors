package main;

import java.util.List;

import model.Entity;
import model.LCATMap;

public class DefaultMapDisplayer implements IMapDisplayer {

	@Override
	public void displayMap(LCATMap map) {
		int width = map.getWidth();
		int height = map.getHeight();
		List<Entity> entities = map.getEntities();
		Entity cur_entity;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
				for (int k = 0; k < entities.size(); k++) {
					cur_entity = entities.get(k);
					if (cur_entity.getPos_x() == j && cur_entity.getPos_y() == i) {
						System.out.print(cur_entity.defaultRepresentation());
						break;
					}
					else if (k == entities.size() - 1) {
						System.out.print(".\t");	
					}
				}	
			
			}
			System.out.println("");
		}
	}

}
