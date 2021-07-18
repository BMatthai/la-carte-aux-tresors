package main;


import model.Adventurer;
import model.LCATMap;

import java.util.List;

import misc.Constants;


public class DefaultProcedureExecuter implements IProcedureExecuter {

	public LCATMap executeProcedure(LCATMap map) {
		LCATMap outMap = new LCATMap(map);
	
		List<Adventurer> adventurers = outMap.getAdventurers();
		int selectedAdventurer;
		
		selectedAdventurer = 0;
		while(!isProcedureFinished(adventurers)) {
			adventurerAction(adventurers.get(selectedAdventurer), outMap);

			selectedAdventurer += 1;
			selectedAdventurer %= adventurers.size();
		}
		
		return outMap;
	}
	
	private void adventurerAction(Adventurer adventurer, LCATMap map) {
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
	
	private void goForward(Adventurer adventurer, LCATMap map) {
		int orientation = adventurer.getOrientation();
		int cur_pos_x = adventurer.getPos_x();
		int cur_pos_y = adventurer.getPos_y();
				
		int new_pos_x = cur_pos_x;
		int new_pos_y = cur_pos_y;
		switch(orientation) {
			case Constants.ORIENTATION_WEST:
				new_pos_x = cur_pos_x - 1;
				break;
			case Constants.ORIENTATION_EAST:
				new_pos_x = cur_pos_x + 1;
				break;
			case Constants.ORIENTATION_NORTH:
				new_pos_y = cur_pos_y - 1;
				break;	    
			case Constants.ORIENTATION_SOUTH:
				new_pos_y = cur_pos_y + 1;
				break;
			default:
		}
		if (map.isPositionFree(new_pos_x, new_pos_y)) adventurer.setPosition(new_pos_x, new_pos_y);
		
	}
	
	private boolean isProcedureFinished(List<Adventurer> adventurers) {
		int index_sum = adventurers.stream().mapToInt(l -> l.getCurIndexInSequence()).sum();
		int sequence_length_sum = adventurers.stream().mapToInt(l -> l.getSequence().length()).sum();
		
		return index_sum == sequence_length_sum;		
	}	
}
