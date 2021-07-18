package model;

public class Mountain extends Entity {

	public Mountain(int positionX, int positionY) {
		super(positionX, positionY);
		this.isBlockingCase = true;
	}

	@Override
	public String textualRepresentation() {
		String string = String.format("M - %d - %d", positionX, positionY);
		return string;
	}

	@Override
	public String defaultRepresentation() {
		String string = String.format("M\t");
		return string;
	}
}
