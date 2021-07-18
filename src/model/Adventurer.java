package model;

public class Adventurer extends Entity {
	
	private String name;
	private int orientation;
	private String sequence;
	private int curIndexInSequence;
	
	public Adventurer(String name, int pos_x, int pos_y, int orientation, String sequence) {
		super(pos_x, pos_y);
		this.name = name;
		this.orientation = orientation;
		this.sequence = sequence;
		this.curIndexInSequence = 0;
		this.isBlockingCase = true;
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
	
	public void rotate(int rotation) {
		orientation += 1;
		orientation %= 4;
	}
	
	public void incrementIndexInSequence() {
		curIndexInSequence += 1;
	}
	
	public void setPosition(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public int getCurIndexInSequence() {
		return curIndexInSequence;
	}

	public void setCurIndexInSequence(int curIndexInSequence) {
		this.curIndexInSequence = curIndexInSequence;
	}
}
