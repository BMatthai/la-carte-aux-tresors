package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {

	public static void readMap(String path) {
		
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
	}

	private static void parseLine(String line) {
		if (line.isEmpty()) {
			System.out.println("empty line");
		}
		
		
		
		
		System.out.println(line);
		
	}
	
//	private boolean doFileExists(String path) {
//		
//	}
	
}
