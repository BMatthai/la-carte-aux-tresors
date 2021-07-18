package main.mapdisplayer;

import helper.TextHelper;
import model.Entity;
import model.TreasureMap;

public class TextualMapDisplayer implements IMapDisplayer {

    public String displayMap(TreasureMap map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(format(map.textualRepresentation()));
        
        for (Entity entity : map.getEntities())
            stringBuilder.append(format(entity.textualRepresentation()));
        
        String s = stringBuilder.toString();
        
        TextHelper.displayText(s);
        return s;
    }

    private String format(String s) {
        return String.format("%s\n", s);
    }
}
