package model;

public class Mountain extends Entity {

	public Mountain(Position position) {
		super(position);
	}

	public String toString() {
		int pos_x = position.getX();
		int pos_y = position.getY();
		
		String string = String.format("M - %d - %d", pos_x, pos_y);
		
		return string;
	}
}
