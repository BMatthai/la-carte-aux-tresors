package model;

public class Adventurer extends Entity {
	
	private String name;
	private int orientation;
	private String sequence;
	private int cur_index_sequence;
	
	public Adventurer(String name, int pos_x, int pos_y, int orientation, String sequence) {
		super(pos_x, pos_y);
		this.name = name;
		this.orientation = orientation;
		this.sequence = sequence;
		this.cur_index_sequence = 0;
	}

	@Override
	public String textualRepresentation() {
		String string = String.format("A - %s - %d - %d - %d - %s", name, pos_x, pos_y, orientation, sequence);
		return string;
	}

	@Override
	public String defaultRepresentation() {
		String string = String.format("A(%s)\t", name);
		return string;
	}
	
}
