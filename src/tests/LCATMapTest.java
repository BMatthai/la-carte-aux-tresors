package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import misc.Constants;
import model.Adventurer;
import model.Entity;
import model.LCATMap;
import model.Mountain;
import model.Treasures;

class LCATMapTest {

	@Test
	void testIsPositionFree() {
		
		LCATMap map = new LCATMap(5, 5);
		
		Entity entity1 = new Treasures(1, 1, 3);
		Entity entity2 = new Mountain(2, 1);
		Entity entity3 = new Adventurer("José", 3, 1, Constants.ORIENTATION_NORTH, "AA");

		map.getEntities().add(entity1);
		map.getEntities().add(entity2);
		map.getEntities().add(entity3);
		
		assertEquals(map.isPositionFree(-3,0), false);
		assertEquals(map.isPositionFree(4,12), false);
		assertEquals(map.isPositionFree(1, 1), true);
		assertEquals(map.isPositionFree(2,1), false);
		assertEquals(map.isPositionFree(3,1), false);	
		assertEquals(map.isPositionFree(4,4), true);
	}

}
