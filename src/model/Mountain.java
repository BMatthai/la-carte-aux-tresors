package model;

public class Mountain extends Entity {

	public Mountain(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}

	@Override
	public String textualRepresentation() {
		String string = String.format("M - %d - %d", pos_x, pos_y);
		return string;
	}

	@Override
	public String defaultRepresentation() {
		String string = String.format("M\t");
		return string;
	}
}
