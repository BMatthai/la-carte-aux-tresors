package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.mapdisplayer.DefaultMapDisplayer;
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
		
		String str1 = "C - 3 - 4\n"
				+ "M - 1 - 0\n"
				+ "M - 2 - 1\n"
				+ "T - 0 - 3 - 2\n"
				+ "T - 1 - 3 - 3\n"
				+ "A - Lara - 1 - 1 - 0 - AADADAGGA";
		
		String str2 = mapDisplayer.displayMap(map);
		
		assertEquals(str1, str2);
		
	}

}
