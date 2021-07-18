package model;

import main.mapdisplayer.IRepresentableAsMap;
import main.mapdisplayer.IRepresentableAsText;

public abstract class Entity implements IRepresentableAsText, IRepresentableAsMap {

	protected int positionX;
	protected int positionY;
	protected boolean isBlockingCase;
	
	public Entity(int positionX, int positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
	
	public boolean isBlockingCase() {
		return isBlockingCase;
	}
}
