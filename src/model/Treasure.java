package model;

public class Treasure extends Entity {

	public Treasure(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	
	public String toString() {
		String string = String.format("T - %d - %d", pos_x, pos_y);
		
		return string;
	}

}
