package main;

import model.LCATMap;

public class Application {

	public static void main(String[] args) {
		
		IMapReader mapReader = new DefaultMapReader();
		IMapDisplayer textualMapDisplayer = new TextualMapDisplayer();
		IMapDisplayer defaultMapDisplayer = new DefaultMapDisplayer();
		
		LCATMap map;
		
		map = mapReader.readMap("SAMPLES/map1.lcat");
		textualMapDisplayer.displayMap(map);
		defaultMapDisplayer.displayMap(map);
	}

}
