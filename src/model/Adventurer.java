package model;

public class Adventurer extends Entity {
	
	private final String name;
	private int orientation;
	private String sequence;
	private int curIndexInSequence;
	
	public Adventurer(String name, int positionX, int positionY, int orientation, String sequence) {
		super(positionX, positionY);
		this.name = name;
		this.orientation = orientation;
		this.sequence = sequence;
		this.curIndexInSequence = 0;
		this.isBlockingCase = true;
	}

	@Override
	public String textualRepresentation() {
		String string = String.format("A - %s - %d - %d - %d - %s", name, positionX, positionY, orientation, sequence);
		return string;
	}

	@Override
	public String defaultRepresentation() {
		String string = String.format("A(%s)\t", name);
		return string;
	}
	
	public void rotate(int rotation) {
		orientation += orientation;
		orientation %= 4;
	}
	
	public void incrementIndexInSequence() {
		curIndexInSequence += 1;
	}
	
	public void setPosition(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getOrientation() {
		return orientation;
	}

	public String getSequence() {
		return sequence;
	}

	public int getCurIndexInSequence() {
		return curIndexInSequence;
	}
}
