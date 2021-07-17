package main;

import model.LCATMap;

public class TextualMapDisplayer implements IMapDisplayer {

	public void displayMap(LCATMap map) {
		System.out.println(map);
		
		map.getEntities().forEach(l -> System.out.println(l));
	}
	
	
	
}
