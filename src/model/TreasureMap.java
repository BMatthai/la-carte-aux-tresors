package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TreasureMap {

	int width;
	int height;
	private List<Entity> entities;
	
	public TreasureMap(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.entities = new ArrayList<Entity>();
	}
	
	public TreasureMap(TreasureMap originalMap) {
		super();
		this.width = originalMap.width;
		this.height = originalMap.height;
		this.entities = originalMap.entities;	
	}

	public List<Adventurer> getAdventurers() {
		return this.entities
				.stream()
				.filter(l -> l instanceof Adventurer)
				.map(m -> (Adventurer) m)
				.collect(Collectors.toList());
	}
	
	public List<Mountain> getMountains() {
		return this.entities
				.stream()
				.filter(l -> l instanceof Mountain)
				.map(m -> (Mountain) m)
				.collect(Collectors.toList());
	}
	
	public List<Treasures> getTreasures() {
		return this.entities
				.stream()
				.filter(l -> l instanceof Treasures)
				.map(m -> (Treasures) m)
				.collect(Collectors.toList());
	}
		
	public boolean isPositionFree(int x, int y) {
		if (x < 0) return false;
		if (x >= width) return false;
		if (y < 0) return false;
		if (y >= height) return false;
		
		return entities
				.stream()
				.filter(l -> l.isBlockingCase() && l.getPos_x() == x && l.getPos_y() == y)
				.count() < 1;	
	}
	
	public boolean isPositionATreasure(int x ,int y) {
		return getTreasures()
				.stream()
				.filter(l -> l.getPos_x() == x && l.getPos_y() == y)
				.count() > 0;
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
	
//	public String toString() {
//		String string = String.format("C - %d - %d", width, height);
//		
//		return string;
//	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
}
