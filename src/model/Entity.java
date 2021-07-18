package model;

import main.mapdisplayer.IRepresentableAsMap;
import main.mapdisplayer.IRepresentableAsText;

public abstract class Entity implements IRepresentableAsText, IRepresentableAsMap {

	protected int pos_x;
	protected int pos_y;
	protected boolean isBlockingCase;
	
	public Entity(int pos_x, int pos_y) {
		super();
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}
	

	public boolean isBlockingCase() {
		return isBlockingCase;
	}

	public void setBlockingCase(boolean isBlockingCase) {
		this.isBlockingCase = isBlockingCase;
	}

}
