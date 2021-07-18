package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.mapdisplayer.IMapDisplayer;
import main.mapdisplayer.TextualMapDisplayer;
import main.mapreader.DefaultMapReader;
import main.mapreader.IMapReader;
import model.TreasureMap;

class DefaultMapDisplayerTest {

	@Test
	void testDisplayMap() {
		
		IMapReader mapReader = new DefaultMapReader();
		
		TreasureMap map = mapReader.readMap("SAMPLES/map1.lcat");
		
		IMapDisplayer mapDisplayer = new TextualMapDisplayer();
		
		String readString = mapDisplayer.displayMap(map);
		String expectedString = String.join("\n", "C - 3 - 4", "M - 1 - 0", "M - 2 - 1", "T - 0 - 3 - 2","T - 1 - 3 - 3","A - Lara - 1 - 1 - 0 - AADADAGGA\n");
		
		assertEquals(readString, expectedString);
		
	}

}
