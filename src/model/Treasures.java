package model;

public class Treasures extends Entity {

	int number;
	
	public Treasures(int positionX, int positionY, int number) {
		super(positionX, positionY);
		this.number = number;
		this.isBlockingCase = false;
	}
	
	@Override
	public String textualRepresentation() {
		String string = String.format("T - %d - %d - %d", positionX, positionY, number);
		return string;
	}

	@Override
	public String defaultRepresentation() {
		String string = String.format("T(%d)\t", number);
		return string;
	}
}
