package wumpus.view.map;

import wumpus.model.Map;
import wumpus.view.exception.MapReaderException;

public interface MapReaderInterface {
    Map readMap() throws MapReaderException;
}
