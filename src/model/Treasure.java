package model;

public class Treasure extends Entity {

	public Treasure(Position position) {
		super(position);
	}
	
	public String toString() {
		int pos_x = position.getX();
		int pos_y = position.getY();
		
		String string = String.format("T - %d - %d", pos_x, pos_y);
		
		return string;
	}

}
