package main;

import model.LCATMap;

public class TextualMapDisplayer implements IMapDisplayer {

	public void displayMap(LCATMap map) {
		System.out.println(map);
		
		map.getEntities()
		.values()
		.forEach(l -> System.out.println(l));
	}
	
	
	
}
