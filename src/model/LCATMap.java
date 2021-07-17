package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCATMap {

	int width;
	int height;
	private Map<Position, List<Entity>> entities;
	
	public LCATMap(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.entities = new HashMap<Position, List<Entity>>();
	}

	public void addEntity(Position position, Entity entity) {
		this.entities.get(position).add(entity);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() {
		String string = String.format("C - %d - %d", width, height);
		
		return string;
	}

	public Map<Position, List<Entity>> getEntities() {
		return entities;
	}

	public void setEntities(Map<Position, List<Entity>> entities) {
		this.entities = entities;
	}
	
}
