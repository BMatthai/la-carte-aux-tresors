package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import misc.Constants;
import model.Adventurer;
import model.Entity;
import model.TreasureMap;
import model.Mountain;
import model.Treasures;

class TreasureMapTest {

	@Test
	void testIsPositionFree() {
		
		TreasureMap treasureMap = new TreasureMap(5, 5);
		
		Entity entity1 = new Treasures(1, 1, 3);
		Entity entity2 = new Mountain(2, 1);
		Entity entity3 = new Adventurer("José", 3, 1, Constants.ORIENTATION_NORTH, "AA");

		treasureMap.getEntities().add(entity1);
		treasureMap.getEntities().add(entity2);
		treasureMap.getEntities().add(entity3);
		
		assertEquals(treasureMap.isPositionFree(-3,0), false);
		assertEquals(treasureMap.isPositionFree(4,12), false);
		assertEquals(treasureMap.isPositionFree(1, 1), true);
		assertEquals(treasureMap.isPositionFree(2,1), false);
		assertEquals(treasureMap.isPositionFree(3,1), false);	
		assertEquals(treasureMap.isPositionFree(4,4), true);
	}

}
