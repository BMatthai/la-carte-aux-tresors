package main.mapreader;

import model.TreasureMap;

public interface IMapReader {

	TreasureMap readMap(String path);

}
