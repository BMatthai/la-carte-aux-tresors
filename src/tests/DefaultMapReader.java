package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.mapreader.DefaultMapReader;
import main.mapreader.IMapReader;
import model.TreasureMap;

class DefaultMapReaderTest {

	@Test
	void testReadMap() {
		
		IMapReader mapReader = new DefaultMapReader();
		
		TreasureMap map = mapReader.readMap("SAMPLES/map2.lcat");

		assertEquals(map.getWidth(), 15);
		assertEquals(map.getHeight(), 14);
		
		assertEquals(map.getMountains().stream().filter(l -> l.getPositionX() == 5 && l.getPositionY() == 5).count(), 1);
		assertEquals(map.getMountains().stream().filter(l -> l.getPositionX() == 6 && l.getPositionY() == 4).count(), 1);
		assertEquals(map.getMountains().stream().filter(l -> l.getPositionX() == 8 && l.getPositionY() == 8).count(), 0);

		assertEquals(map.getAdventurers().stream().filter(l -> l.getPositionX() == 7 && l.getPositionY() == 7).count(), 1);
		assertEquals(map.getAdventurers().stream().filter(l -> l.getPositionX() == 12 && l.getPositionY() == 13).count(), 1);
		assertEquals(map.getAdventurers().stream().filter(l -> l.getPositionX() == 2 && l.getPositionY() == 9).count(), 0);

	}
}
