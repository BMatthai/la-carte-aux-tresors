package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCATMap {

	int width;
	int height;
	private List<Entity> entities;
	
	public LCATMap(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.entities = new ArrayList<Entity>();
	}

	public void addEntity(Entity entity) {
		this.entities.add(entity);
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

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
}
