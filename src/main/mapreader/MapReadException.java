package main.mapreader;

public class MapReadException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1013784571804341575L;

	public MapReadException(Throwable cause) {
        super("Invalid file", cause);
    }
}