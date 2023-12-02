package wumpus.view.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wumpus.model.Map;
import wumpus.view.exception.MapReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapHelp {
    private static Logger logger = LoggerFactory.getLogger(MapHelp.class);

    public Map readMap(InputStream inputStream) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            MapReader mapReader = new MapReader(bufferedReader);
            return mapReader.readMap();
        } catch (MapReaderException exc) {
            logger.error("A pálya beolvasás közben hiba történt!", exc);
            return null;
        } catch (IOException e) {
            logger.error("IO hiba történt a bemeneti adatok olvasása során!", e);
            return null;
        }
    }

    public void printMap(Map map) {
        if (map != null) {
            MapRowAndColumn.mapPrinter(map);
        } else {
            System.out.println("A pálya beolvasás közben hiba történt!");
        }
    }
}
