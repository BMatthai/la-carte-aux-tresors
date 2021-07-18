package main.mapreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.TreasureMap;
import model.Mountain;
import model.Treasures;
import model.Adventurer;

import misc.Constants;

public class DefaultMapReader implements IMapReader {

	private TreasureMap map;
	
	public TreasureMap readMap(String path) {
				
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String curLine = bufferedReader.readLine();
			while (curLine != null) {				
				parseLine(curLine);
				curLine = bufferedReader.readLine();
			}
		} catch (IOException e) {
			throw new MapReadException(e);
		}	
		
		return map;
	}

	private void parseLine(String line) {
		char lineHeader = line.charAt(0);
		switch(lineHeader) {
		  case 'C':
			this.map = parseMap(line);
		    break;
		  case 'M':
		    this.map.addEntity(parseMountain(line));
			  break;
		  case 'T':	  
			  this.map.addEntity(parseTreasure(line));
			  break;
		  case 'A':
			  this.map.addEntity(parseAdventurer(line));
			  break;
		  default:
		}				
	}
	
	private TreasureMap parseMap(String mapLine) {		
		String[] parts = mapLine.split(" - ");
		int width = Integer.parseInt(parts[1]);
		int height = Integer.parseInt(parts[2]);

		return new TreasureMap(width, height);
	}
	
	private Mountain parseMountain(String mapLine) {
		String[] parts = mapLine.split(" - ");
		int positionX = Integer.parseInt(parts[1]);
		int positionY = Integer.parseInt(parts[2]);
		
		return new Mountain(positionX, positionY);
	}
	
	private Treasures parseTreasure(String mapLine) {
		String[] parts = mapLine.split(" - ");

		int positionX = Integer.parseInt(parts[1]);
		int positionY = Integer.parseInt(parts[2]);
		int number = Integer.parseInt(parts[3]);
		return new Treasures(positionX, positionY, number);
	}
	
	private int orientationAsIntFromString(String orientation) {
		int orientationAsInt;
		switch(orientation) {
		  case "N":
			  orientationAsInt = Constants.ORIENTATION_NORTH;
			  break;
		  case "S":
			  orientationAsInt = Constants.ORIENTATION_SOUTH;
			  break;
		  case "E":	  
			  orientationAsInt = Constants.ORIENTATION_EAST;
			  break;
		  case "O":
			  orientationAsInt = Constants.ORIENTATION_WEST;
			  break;
		  default:
			  orientationAsInt = Constants.ORIENTATION_SOUTH;
		}
		return orientationAsInt;
	}
	
	private Adventurer parseAdventurer(String mapLine) {
		String[] parts = mapLine.split(" - ");

		String name = parts[1];
		int positionX = Integer.parseInt(parts[2]);
		int positionY = Integer.parseInt(parts[3]);
		String orientation = parts[4];
		String sequence = parts[5];
		
		int orientationAsInt = orientationAsIntFromString(orientation);
		return new Adventurer(name, positionX, positionY, orientationAsInt, sequence);
	}	
}
