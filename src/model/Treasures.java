package model;

public class Treasures extends Entity {

	int number;
	
	public Treasures(int pos_x, int pos_y, int number) {
		super(pos_x, pos_y);
		this.number = number;
		this.isBlockingCase = false;
	}
	
	@Override
	public String textualRepresentation() {
		String string = String.format("T - %d - %d - %d", pos_x, pos_y, number);
		return string;
	}

	@Override
	public String defaultRepresentation() {
		String string = String.format("T(%d)\t", number);
		return string;
	}
}
