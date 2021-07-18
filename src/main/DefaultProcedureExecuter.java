package main;


import model.Adventurer;
import model.LCATMap;

import java.util.List;

import misc.Constants;


public class DefaultProcedureExecuter {

	public void executeProcedure(LCATMap map) {
		LCATMap outMap = new LCATMap(map);
	
		List<Adventurer> adventurers = outMap.getAdventurers();
		
		//move(adventurers.get(0));
	}
	
	public void adventurerAction(Adventurer adventurer, LCATMap map) {
		int index = adventurer.getCurIndexInSequence();
		char action = adventurer.getSequence().charAt(index);
		
		switch(action) {
			case Constants.ACTION_ROTATE_LEFT:
				adventurer.rotate(Constants.ROTATION_LEFT);
				break;
			case Constants.ACTION_ROTATE_RIGHT:
				adventurer.rotate(Constants.ROTATION_RIGHT);
				break;
			case Constants.ACTION_MOVE_FORWARD:
				goForward(adventurer, map);
				break;
		}
		adventurer.incrementIndexInSequence();
	}
	
	public void goForward(Adventurer adventurer, LCATMap map) {
		int orientation = adventurer.getOrientation();
		int cur_pos_x = adventurer.getPos_x();
		int cur_pos_y = adventurer.getPos_y();
				
		switch(orientation) {
			case Constants.ORIENTATION_WEST:
				if (map.isPositionFree(cur_pos_x - 1, cur_pos_y));
				break;
			case Constants.ORIENTATION_EAST:
				if (map.isPositionFree(cur_pos_x + 1, cur_pos_y));
				break;
			case Constants.ORIENTATION_NORTH:
				if (map.isPositionFree(cur_pos_x, cur_pos_y - 1));
				break;	    
			case Constants.ORIENTATION_SOUTH:
				if (map.isPositionFree(cur_pos_x, cur_pos_y + 1));
				break;
			default:   
		}
	}
}
