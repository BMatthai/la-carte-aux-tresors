package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DefaultMapReader;
import main.IMapReader;
import model.LCATMap;

class DefaultMapReaderTest {

	@Test
	void testReadMap() {
		
		IMapReader mapReader = new DefaultMapReader();
		
		LCATMap map = mapReader.readMap("SAMPLES/map2.lcat");

		assertEquals(map.getWidth(), 15);
		assertEquals(map.getHeight(), 14);
		
		assertEquals(map.getMountains().stream().filter(l -> l.getPos_x() == 5 && l.getPos_y() == 5).count(), 1);
		assertEquals(map.getMountains().stream().filter(l -> l.getPos_x() == 6 && l.getPos_y() == 4).count(), 1);
		assertEquals(map.getMountains().stream().filter(l -> l.getPos_x() == 8 && l.getPos_y() == 8).count(), 0);

		assertEquals(map.getAdventurers().stream().filter(l -> l.getPos_x() == 7 && l.getPos_y() == 7).count(), 1);
		assertEquals(map.getAdventurers().stream().filter(l -> l.getPos_x() == 12 && l.getPos_y() == 13).count(), 1);
		assertEquals(map.getAdventurers().stream().filter(l -> l.getPos_x() == 2 && l.getPos_y() == 9).count(), 0);

	}


}
