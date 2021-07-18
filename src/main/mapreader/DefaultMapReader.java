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
		
		BufferedReader bufferedReader;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(path));
			String curLine = bufferedReader.readLine();
			while (curLine != null) {				
				parseLine(curLine);
				
				curLine = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		return map;
	}

	private void parseLine(String line) {

		if (line.isEmpty()) {
			System.out.println("empty line");
		}
		
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
		TreasureMap map;
		
		String[] parts = mapLine.split(" - ");
		int width = Integer.parseInt(parts[1]);
		int height = Integer.parseInt(parts[2]);
		map = new TreasureMap(width, height);

		return map;
	}
	
	private Mountain parseMountain(String mapLine) {
		String[] parts = mapLine.split(" - ");
		int pos_x = Integer.parseInt(parts[1]);
		int pos_y = Integer.parseInt(parts[2]);
		
		return new Mountain(pos_x, pos_y);
	}
	
	private Treasures parseTreasure(String mapLine) {
		String[] parts = mapLine.split(" - ");

		int pos_x = Integer.parseInt(parts[1]);
		int pos_y = Integer.parseInt(parts[2]);
		int number = Integer.parseInt(parts[3]);
		return new Treasures(pos_x, pos_y, number);
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
		int pos_x = Integer.parseInt(parts[2]);
		int pos_y = Integer.parseInt(parts[3]);
		String orientation = parts[4];
		String sequence = parts[5];
		
		int orientationAsInt = orientationAsIntFromString(orientation);
		return new Adventurer(name, pos_x, pos_y, orientationAsInt, sequence);
	}	
}
