package main;

import model.LCATMap;

public class DefaultMapDisplayer implements IMapDisplayer {

	@Override
	public void displayMap(LCATMap map) {
		int width = map.getWidth();
		int height = map.getHeight();
		
		int i;
		int j;
		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				System.out.print(".\t");
						
			}
			System.out.println("");
		}
	}

}
