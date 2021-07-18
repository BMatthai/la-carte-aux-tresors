package main;

import main.mapdisplayer.DefaultMapDisplayer;
import main.mapdisplayer.IMapDisplayer;
import main.mapdisplayer.TextualMapDisplayer;
import main.mapreader.DefaultMapReader;
import main.mapreader.IMapReader;
import main.procedurer.DefaultProcedureExecuter;
import main.procedurer.IProcedureExecuter;
import model.TreasureMap;

public class Application {

	public static void main(String[] args) {
				
		IMapReader mapReader = new DefaultMapReader();
		IMapDisplayer textualMapDisplayer = new TextualMapDisplayer();
		IMapDisplayer defaultMapDisplayer = new DefaultMapDisplayer();
		
		TreasureMap map;
		
		map = mapReader.readMap("SAMPLES/map1.lcat");
//		textualMapDisplayer.displayMap(map);
//		defaultMapDisplayer.displayMap(map);
		
		IProcedureExecuter defaultProcedureExecuter = new DefaultProcedureExecuter();
		TreasureMap newMap = defaultProcedureExecuter.executeProcedure(map);
		
		defaultMapDisplayer.displayMap(newMap);
	}

}
