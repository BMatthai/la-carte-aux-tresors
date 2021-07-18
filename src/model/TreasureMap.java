package model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.mapdisplayer.IRepresentableAsText;

public class TreasureMap implements IRepresentableAsText {

	private int width;
	private int height;
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

	// TODO Factor the following methods
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
				.filter(l -> l.isBlockingCase() && l.getPositionX() == x && l.getPositionY() == y)
				.count() < 1;	
	}
	
	public boolean isPositionATreasure(int x ,int y) {
		return getTreasures()
				.stream()
				.filter(l -> l.getPositionX() == x && l.getPositionY() == y)
				.count() > 0;
	}

	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
	
	@Override
	public String textualRepresentation() {
		return String.format("C - %d - %d", width, height);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<Entity> getEntities() {
		return entities;
	}
}
