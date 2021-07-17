package model;

public abstract class Entity {

	protected Position position;
	
	public Entity(Position position) {
		super();
		this.position = position;
	}
	
	public abstract String toString();

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
