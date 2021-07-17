package model;

public class Adventurer extends Entity {
	
	private String name;
	private int orientation;
	private String sequence;
	private int cur_index_sequence;
	
	public Adventurer(String name, Position position, int orientation, String sequence) {
		super(position);
		this.name = name;
		this.orientation = orientation;
		this.sequence = sequence;
		this.cur_index_sequence = 0;
	}

	@Override
	public String toString() {
		int pos_x = position.getX();
		int pos_y = position.getY();
		
		String string = String.format("A - %s - %d - %d - %d - %s", name, pos_x, pos_y, orientation, sequence);
		
		return string;
	}
	
}
